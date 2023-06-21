package pl.pollub.integration.environment;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.environment.domain.WeatherMeasurementRepository;

import java.time.Year;
import java.util.Map;


/**
 * This class decorates WebBasedHistoricalWeatherFacade for optimization purposes. It first checks if the requested data
 * is persistent in WeatherMeasurementRepository - if so it returns it, if not it calls external web api to fetch that data.
 * It also serves the purpose of data accessibility - it should try to fetch the requested data from two sources
 */
@ApplicationScoped
@Named(HistoricalWeatherFacadeDecorator.QUALIFIER)
public class HistoricalWeatherFacadeDecorator implements HistoricalWeatherFacade {

    public static final String QUALIFIER = "decorator";
    @Inject
    WebBasedHistoricalWeatherFacade webAdapter;

    @Inject
    WeatherMeasurementRepository measurementRepository;

    @Override
    public Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(Year begin, Year end, Coordinates coordinates) {
        Map<Year, Double> annualAverageTemperaturesForRangeOfYears = measurementRepository
                .getAnnualAverageTemperaturesForRangeOfYears(begin, end, coordinates);
        Log.infof("Fetched from db [%s]", annualAverageTemperaturesForRangeOfYears);
        if (!annualAverageTemperaturesForRangeOfYears.isEmpty()) {
            Log.info("Fetching annual avg temperature from db");
            return annualAverageTemperaturesForRangeOfYears;
        }
        Log.info("Fetching annual avg temperature from web client");
        return webAdapter.getAnnualAverageTemperaturesForRangeOfYears(begin, end, coordinates);
    }

    @Override
    public Map<Year, Double> getAnnualAverageMaxDailyTemperatureForRangeOfYears(Year begin, Year end, Coordinates coordinates) {
        Map<Year, Double> annualAverageMaxDailyTemperatureForRangeOfYears = measurementRepository
                .getAnnualAverageMaxDailyTemperatureForRangeOfYears(begin, end, coordinates);
        if (!annualAverageMaxDailyTemperatureForRangeOfYears.isEmpty()) {
            Log.info("Fetching annual avg max daily temperature from db");
            return annualAverageMaxDailyTemperatureForRangeOfYears;
        }
        Log.info("Fetching annual avg max daily temperature from web client");
        return webAdapter.getAnnualAverageMaxDailyTemperatureForRangeOfYears(begin, end, coordinates);
    }

    @Override
    public Map<Year, Double> getAnnualAverageMinDailyTemperatureForRangeOfYears(Year begin, Year end, Coordinates coordinates) {
        Map<Year, Double> annualAverageMaxDailyTemperatureForRangeOfYears = measurementRepository
                .getAnnualAverageMaxDailyTemperatureForRangeOfYears(begin, end, coordinates);
        if (!annualAverageMaxDailyTemperatureForRangeOfYears.isEmpty()) {
            Log.info("Fetching annual avg min daily temperature from db");
            return annualAverageMaxDailyTemperatureForRangeOfYears;
        }
        Log.info("Fetching annual avg min daily temperature from web client");
        return webAdapter.getAnnualAverageMaxDailyTemperatureForRangeOfYears(begin, end, coordinates);
    }

    @Override
    public Map<Year, Double> getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(Year begin, Year end, Coordinates coordinates) {
        return webAdapter.getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(begin, end, coordinates);
    }

    @Override
    public Double getAnnualAverageTemperature(Year year, Coordinates coordinates) {
        return webAdapter.getAnnualAverageTemperature(year, coordinates);
    }

    @Override
    public Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates) {
        return webAdapter.getAnnualAverageOfDailyTemperatureAmplitude(year, coordinates);
    }

    @Override
    public Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates) {
        return webAdapter.getAnnualAveragePrecipitation(year, coordinates);
    }
}
