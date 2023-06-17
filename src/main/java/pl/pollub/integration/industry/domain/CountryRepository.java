package pl.pollub.integration.industry.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class CountryRepository implements PanacheRepositoryBase<Country, UUID> {


    public Optional<Country> findByCode(String countryCode) {
        return find("code", countryCode).firstResultOptional();
    }

}
