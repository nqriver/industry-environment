package pl.pollub.integration.environment;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.ServiceErrorCode;
import pl.pollub.integration.commons.ServiceException;
import pl.pollub.integration.environment.client.WhetherApiClient;
import pl.pollub.integration.environment.client.response.HourlyTemperatureStatistics;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ApplicationScoped
public class HistoricalWhetherAdapter implements HistoricalWhetherFacade {
    public static final String TEMPERATURE_QUERY = "temperature_2m";
    private static final int MEASURES_PER_DAY = 24;
    @RestClient
    WhetherApiClient whetherApiClient;

    @Override
    public Double getAnnualAverageTemperature(Year year, Coordinates coordinates) {
        LocalDate beginDate = getFirstDate(year);
        LocalDate endDate = getLastDate(year);

        Log.info("Request params are " + coordinates.latitude().toString());

        HourlyTemperatureStatistics statistics = whetherApiClient.getHistoricalHourlyTemperatureMeasurements(
                TEMPERATURE_QUERY,
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                beginDate.format(DateTimeFormatter.ISO_DATE),
                endDate.format(DateTimeFormatter.ISO_DATE));

        return statistics.getConsecutiveMeasurements()
                .stream().mapToDouble(val -> val).average().orElse(0.0);
    }


    @Override
    public Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(Year begin, Year end, Coordinates coordinates) {
        if (begin.isAfter(end)) {
            throw new ServiceException(ServiceErrorCode.INVALID_DATES_RANGE);
        }

        LocalDate beginDate = getFirstDate(begin);
        LocalDate endDate = getLastDate(end);

        HourlyTemperatureStatistics statistics = whetherApiClient.getHistoricalHourlyTemperatureMeasurements(
                TEMPERATURE_QUERY,
                coordinates.latitude().toString(),
                coordinates.longitude().toString(),
                beginDate.format(DateTimeFormatter.ISO_DATE),
                endDate.format(DateTimeFormatter.ISO_DATE));


        List<Double> consecutiveMeasurements = statistics.getConsecutiveMeasurements();

        List<Year> orderedYears = Stream.iterate(begin, value -> value.isBefore(end.plusYears(1)), e -> e.plusYears(1))
                .toList();

        List<Integer> measurementsPerConsecutiveYears = orderedYears.stream()
                .map(Year::length)
                .map(days -> days * MEASURES_PER_DAY)
                .toList();

        Map<Year, Double> yearToAverageTemperature = findAverageTemperaturesPerYear(consecutiveMeasurements, orderedYears, measurementsPerConsecutiveYears);

        Log.infof("Finished generating avg temperature report for years of range %s-%s and coordinates %s", begin, end, coordinates);
        return yearToAverageTemperature;
    }


    @Override
    public Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates) {
        return null;
    }

    @Override
    public Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates) {
        return null;
    }

    private Map<Year, Double> findAverageTemperaturesPerYear(List<Double> consecutiveMeasurements, List<Year> orderedYears, List<Integer> measurementsPerConsecutiveYears) {
        Map<Year, Double> yearToAverageTemperature = new HashMap<>();
        int start = 0;
        int idx = 0;
        for (Year year : orderedYears) {
            int endOfSlice = start + measurementsPerConsecutiveYears.get(idx++);
            List<Double> measurementsForYear = consecutiveMeasurements.subList(start, endOfSlice);

            Log.infof("Number of measurements for year %s: [%d], expected: [%d]", year, measurementsForYear.size(), year.length() * 24);
            double average = measurementsForYear.stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElseThrow(() -> new IllegalStateException("No measurements for year " + year));

            yearToAverageTemperature.put(year, average);
            start = endOfSlice;
        }
        return yearToAverageTemperature;
    }


    private LocalDate getFirstDate(Year year) {
        return LocalDate.of(year.getValue(), 1, 1);
    }

    private LocalDate getLastDate(Year year) {
        return LocalDate.of(year.getValue(), 12, 31);
    }
}
