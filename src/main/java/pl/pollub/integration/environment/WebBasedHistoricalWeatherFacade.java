package pl.pollub.integration.environment;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pl.pollub.integration.commons.*;
import pl.pollub.integration.environment.client.WeatherApiClient;
import pl.pollub.integration.environment.client.response.DailyTemperatureMeasurement;
import pl.pollub.integration.environment.client.response.HourlyTemperatureStatistics;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ApplicationScoped
@Named(WebBasedHistoricalWeatherFacade.QUALIFIER)
public class WebBasedHistoricalWeatherFacade implements HistoricalWeatherFacade {
    public static final String HOURLY_TEMPERATURE_QUERY = "temperature_2m";
    private static final int MEASURES_PER_DAY = 24;
    public static final String WEATHER_CLIENT_TIMEZONE = "auto";
    public static final String MAX_DAILY_TEMP_QUERY = "temperature_2m_max";
    public static final String MIN_DAILY_TEMP_QUERY = "temperature_2m_min";
    public static final String QUALIFIER = "api-based";
    @RestClient
    WeatherApiClient weatherApiClient;

    @Override
    public Double getAnnualAverageTemperature(Year year, Coordinates coordinates) {
        HourlyTemperatureStatistics statistics = weatherApiClient.getHistoricalHourlyTemperatureMeasurements(
                HOURLY_TEMPERATURE_QUERY,
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                getFormattedBeginDate(year),
                getFormattedEndDate(year));

        return statistics.getConsecutiveMeasurements()
                .stream().mapToDouble(val -> val).average().orElse(0.0);
    }


    @Override
    public Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        HourlyTemperatureStatistics statistics = weatherApiClient.getHistoricalHourlyTemperatureMeasurements(
                HOURLY_TEMPERATURE_QUERY,
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                getFormattedBeginDate(range.start()),
                getFormattedEndDate(range.end()));


        List<Double> consecutiveMeasurements = statistics.getConsecutiveMeasurements();

        List<Year> orderedYears = RangeOfYearsUtils.getYearsStream(range).toList();

        List<Integer> measurementsPerConsecutiveYears = orderedYears.stream()
                .map(Year::length)
                .map(days -> days * MEASURES_PER_DAY)
                .toList();

        Map<Year, Double> yearToAverageTemperature = findAveragesByYear(consecutiveMeasurements, orderedYears, measurementsPerConsecutiveYears);

        Log.infof("Finished generating avg temperature report for years of range %s-%s and coordinates %s", range.start(), range.end(), coordinates);
        return yearToAverageTemperature;
    }

    @Override
    public Map<Year, Double> getAnnualAverageMaxDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        DailyTemperatureMeasurement measurements = weatherApiClient.getHistoricalMinMaxTemperatureMeasurements(
                new String[]{MAX_DAILY_TEMP_QUERY},
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                getFormattedBeginDate(range.start()),
                getFormattedEndDate(range.end()),
                WEATHER_CLIENT_TIMEZONE);

        List<Year> orderedYears = RangeOfYearsUtils.getYearsStream(range).toList();
        List<Integer> measuresPerYear = orderedYears.stream().map(Year::length).toList();
        List<Double> consecutiveMaxTemperatures = measurements.getDailyMaxTemperatureMeasurements();

        return findAveragesByYear(consecutiveMaxTemperatures, orderedYears, measuresPerYear);
    }

    @Override
    public Map<Year, Double> getAnnualAverageMinDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        DailyTemperatureMeasurement measurements = weatherApiClient.getHistoricalMinMaxTemperatureMeasurements(
                new String[]{MIN_DAILY_TEMP_QUERY},
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                getFormattedBeginDate(range.start()),
                getFormattedEndDate(range.end()),
                WEATHER_CLIENT_TIMEZONE);

        List<Year> orderedYears = RangeOfYearsUtils.getYearsStream(range).toList();
        List<Integer> measuresPerYear = orderedYears.stream().map(Year::length).toList();
        List<Double> consecutiveMaxTemperatures = measurements.getDailyMinTemperatureMeasurements();
        return findAveragesByYear(consecutiveMaxTemperatures, orderedYears, measuresPerYear);
    }

    @Override
    public Map<Year, Double> getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        DailyTemperatureMeasurement measurements = weatherApiClient.getHistoricalMinMaxTemperatureMeasurements(
                new String[]{MAX_DAILY_TEMP_QUERY, MIN_DAILY_TEMP_QUERY},
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                getFormattedBeginDate(range.start()),
                getFormattedEndDate(range.end()),
                WEATHER_CLIENT_TIMEZONE);

        List<Year> orderedYears = RangeOfYearsUtils.getYearsStream(range).toList();
        List<Integer> measuresPerYear = orderedYears.stream().map(Year::length).toList();
        List<Double> consecutiveMaxTemperatures = measurements.getDailyMaxTemperatureMeasurements();
        List<Double> consecutiveMinTemperatures = measurements.getDailyMinTemperatureMeasurements();
        int measurementCount = consecutiveMinTemperatures.size();
        if (measurementCount != consecutiveMaxTemperatures.size()) {
            throw new ServiceException(ServiceErrorCode.INVALID_MIN_MAX_TEMP_MEASURES);
        }

        List<Double> consecutiveTemperatureAmplitudes = IntStream.range(0, measurementCount).boxed()
                .map(idx -> consecutiveMaxTemperatures.get(idx) - consecutiveMinTemperatures.get(idx))
                .toList();

        return findAveragesByYear(consecutiveTemperatureAmplitudes, orderedYears, measuresPerYear);

    }


    @Override
    public Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates) {
        return null;
    }


    @Override
    public Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates) {
        return null;
    }


    private Map<Year, Double> findAveragesByYear(List<Double> consecutiveMeasurements, List<Year> orderedYears, List<Integer> measurementsPerConsecutiveYears) {
        Map<Year, Double> yearToAverageTemperature = new HashMap<>();
        int start = 0;
        int idx = 0;
        for (Year year : orderedYears) {
            int measurementsPerYear = measurementsPerConsecutiveYears.get(idx++);
            int endOfSlice = start + measurementsPerYear;
            List<Double> measurementsForYear = consecutiveMeasurements.subList(start, endOfSlice);

            Log.infof("Number of measurements for year %s: [%d], expected: [%d]", year, measurementsForYear.size(), measurementsPerYear);
            double average = measurementsForYear.stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElseThrow(() -> new IllegalStateException("No measurements for year " + year));

            yearToAverageTemperature.put(year, average);
            start = endOfSlice;
        }
        return yearToAverageTemperature;
    }


    private String getFormattedBeginDate(Year year) {
        return getFormattedDate(LocalDate.of(year.getValue(), 1, 1));
    }

    private String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    private String getFormattedEndDate(Year year) {
        return getFormattedDate(LocalDate.of(year.getValue(), 12, 31));
    }
}
