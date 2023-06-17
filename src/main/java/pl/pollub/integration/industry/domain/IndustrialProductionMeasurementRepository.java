package pl.pollub.integration.industry.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Year;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class IndustrialProductionMeasurementRepository implements PanacheRepositoryBase<IndustrialProductionMeasurement, UUID> {

    public List<IndustrialProductionMeasurement> findMeasurementsByCountryForYearsInRange(Country country, Year begin, Year end) {
        return list("country = :country and year >= :beginYear and year <= :endYear",
                Parameters.with("country", country)
                        .and("beginYear", begin.getValue())
                        .and("endYear", end.getValue()));
    }
}
