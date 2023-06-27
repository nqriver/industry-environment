package pl.pollub.integration.environment;

import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.RangeOfYears;

import java.time.Year;
import java.util.Map;

public interface HistoricalWeatherFacade {
    Double getAnnualAverageTemperature(Year year, Coordinates coordinates);

    Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(RangeOfYears range, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageMaxDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageMinDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates);
    Map<Year, Double> getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(RangeOfYears range, Coordinates coordinates);

    Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates);

    Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates);
}
