package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;
import pl.pollub.integration.industry.dto.CountryResponse;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "country",
        indexes = {@Index(name = "idx_country_code", columnList = "code")})
public class Country {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String name;

    private Double gdp;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IndustryHub> industryHubs = new HashSet<>();


    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Set<IndustrialProductionMeasurement> industrialProductionMeasurements = new HashSet<>();


    public Country() {
    }

    public Set<IndustryHub> getIndustryHubs() {
        return industryHubs;
    }

    public Set<IndustrialProductionMeasurement> getIndustrialProductionMeasurements() {
        return industrialProductionMeasurements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    public CountryResponse toResponse() {
        return new CountryResponse(id, name, gdp, code);
    }

    public void addMeasurement(IndustrialProductionMeasurement measurement) {
        this.industrialProductionMeasurements.add(measurement);
    }
}
