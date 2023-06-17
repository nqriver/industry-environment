package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "industry_hub")
public class IndustryHub {
    @Id
    @GeneratedValue
    public UUID id;

    @Column(name = "hub_name")
    public String hubName;

    @Column(name = "main_city_nearby")
    public String mainCityNearby;

    public Integer population;

    @Column(name = "gdp_per_capita")
    public Double gdpPerCapita;

    public Double latitude;

    public Double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public IndustryHub() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndustryHub that = (IndustryHub) o;
        return Objects.equals(hubName, that.hubName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hubName, country);
    }
}
