package pl.pollub.integration.environment;

import io.vavr.control.Either;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.Error;

import java.time.Year;
import java.util.Map;

public interface HistoricalWhetherFacade {
    Double getAnnualAverageTemperature(Year year, Coordinates coordinates);

    Either<Error, Map<Year, Double>> getAnnualAverageTemperaturesForRangeOfYears(Year begin, Year end, Coordinates coordinates);

    Double getAnnualAverageOfDailyTemperatureAmplitude(Year year, Coordinates coordinates);

    Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates);
}
