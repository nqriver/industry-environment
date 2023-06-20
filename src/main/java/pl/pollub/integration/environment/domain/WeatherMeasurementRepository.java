package pl.pollub.integration.environment.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class WeatherMeasurementRepository implements PanacheRepositoryBase<WeatherMeasurement, UUID> {

    public boolean existsByMeasurementType(MeasuredValueType measuredValueType) {
        return find("measuredValueType", measuredValueType).firstResultOptional().isPresent();
    }



}
