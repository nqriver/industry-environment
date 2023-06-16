package pl.pollub.integration.environment;

import pl.pollub.integration.commons.Coordinates;

import java.time.Year;

public interface HistoricalWhetherFacade {
    Double getAnnualAverageTemperature(Year year, Coordinates coordinates);

    Double getAnnualAveragePrecipitation(Year year, Coordinates coordinates);
}
