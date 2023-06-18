package pl.pollub.integration.environment;

import pl.pollub.integration.commons.Coordinates;

import java.time.Year;
import java.util.Map;

public interface HistoricalWhetherFacade {
    Double getAnnualAverageTemperature(Year year, Coordinates coordinates);

    Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(Year begin, Year end, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageMaxDailyTemperatureForRangeOfYears(Year begin, Year end, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageMinDailyTemperatureForRangeOfYears(Year begin, Year end, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(Year begin, Year end, Coordinates coordinates);

    Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates);

    Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates);
}
