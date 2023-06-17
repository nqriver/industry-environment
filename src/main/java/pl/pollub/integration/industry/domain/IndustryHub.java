package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;
import pl.pollub.integration.industry.web.dto.IndustryHubResponse;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "industry_hub")
public class IndustryHub {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "hub_name")
    private String hubName;

    @Column(name = "main_city_nearby")
    private String mainCityNearby;

    private Integer population;

    @Column(name = "gdp_per_capita")
    private Double gdpPerCapita;

    private Double latitude;

    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public IndustryHub() {
    }

    public Country locationCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
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

    public IndustryHubResponse toResponse() {
        return new IndustryHubResponse(id, hubName, mainCityNearby, population, gdpPerCapita, latitude, longitude);
    }
}
