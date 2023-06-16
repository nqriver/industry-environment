package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Double gdp;

    private String code;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IndustryHub> industryHubs = new HashSet<>();


    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<IndustrialProductionMeasurement> industrialProductionMeasurements = new HashSet<>();


    public Country() {
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
}
