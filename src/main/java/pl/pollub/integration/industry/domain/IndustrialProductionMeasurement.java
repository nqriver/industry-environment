package pl.pollub.integration.industry.domain;

import jakarta.persistence.*;
import pl.pollub.integration.industry.IndustrialProductionDataImporter.IndustryProductionIndexRecord;

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

    @Column(name = "year")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;


    public static IndustrialProductionMeasurement fromJsonRecord(IndustryProductionIndexRecord record, Country country) {
        IndustrialProductionMeasurement measurement = new IndustrialProductionMeasurement();
        measurement.indexValue = record.getValue();
        measurement.year = record.getTime();
        measurement.indexType = record.getIndicator();
        measurement.country = country;
        return measurement;
    }


    public IndustrialProductionMeasurement() {
    }
}