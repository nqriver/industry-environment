package pl.pollub.integration.environment.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.logging.Log;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.RangeOfYears;

import java.time.Year;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class WeatherMeasurementRepository implements PanacheRepositoryBase<WeatherMeasurement, UUID> {

    public boolean existsByMeasurementType(MeasuredValueType measuredValueType) {
        return find("measuredValueType", measuredValueType).firstResultOptional().isPresent();
    }


    public Map<Year, Double> getAnnualAverageTemperaturesForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        return find("measuredValueType =: valType and industryHubId = :hubId and year >= :begin and year <= :end",
                Parameters.with("valType", MeasuredValueType.YEARLY_AVG_TEMPERATURE)
                        .and("begin", range.start().getValue())
                        .and("end", range.end().getValue())
                        .and("hubId", coordinates.hubId()))
        .stream()
                .collect(Collectors.toMap(WeatherMeasurement::year, WeatherMeasurement::measurementValue));
    }
    public Map<Year, Double> getAnnualAverageMaxDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates){
        return find("measuredValueType =: valType and year >= :begin and year <= :end and industryHubId = :hubId",
                Parameters.with("valType", MeasuredValueType.YEARLY_AVG_MAX_DAILY_TEMPERATURE)
                        .and("begin", range.start().getValue())
                        .and("end", range.end().getValue())
                        .and("hubId", coordinates.hubId())).stream()
                .collect(Collectors.toMap(WeatherMeasurement::year, WeatherMeasurement::measurementValue));

    }
    public Map<Year, Double> getAnnualAverageMinDailyTemperatureForRangeOfYears(RangeOfYears range, Coordinates coordinates) {
        return find("measuredValueType =: valType and year >= :begin and year <= :end and industryHubId = :hubId",
                Parameters.with("valType", MeasuredValueType.YEARLY_AVG_MIN_DAILY_TEMPERATURE)
                        .and("begin", range.start().getValue())
                        .and("end", range.end().getValue())
                        .and("hubId", coordinates.hubId())).stream()
                .collect(Collectors.toMap(WeatherMeasurement::year, WeatherMeasurement::measurementValue));

    }
}
