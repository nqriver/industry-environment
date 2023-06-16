package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "industrial_production_measurement")
public class IndustrialProductionMeasurement {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "index_value")
    private Double indexValue;

    @Column(name = "index_type")
    private String indexType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;


    public IndustrialProductionMeasurement() {
    }
}