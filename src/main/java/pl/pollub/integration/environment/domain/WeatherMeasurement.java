package pl.pollub.integration.environment.domain;


import jakarta.persistence.*;

import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "weather_measurement")
public class WeatherMeasurement {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "industry_hub_id")
    private UUID industryHubId;

    @Enumerated(EnumType.STRING)
    @Column(name = "measured_value_type")
    private MeasuredValueType measuredValueType;

    private Double value;

    private int year;

    public WeatherMeasurement() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private WeatherMeasurement(UUID industryHubId, MeasuredValueType measuredValueType, Double value, int year) {
        this.industryHubId = industryHubId;
        this.measuredValueType = measuredValueType;
        this.value = value;
        this.year = year;
    }
    public static WeatherMeasurement ofYearlyAvgTemperature(UUID hubId, Double value, Year year) {
        return new WeatherMeasurement(hubId, MeasuredValueType.YEARLY_AVG_TEMPERATURE, value, year.getValue());
    }
    public static WeatherMeasurement ofYearlyAvgMinDailyTemperature(UUID hubId, Double value, Year year) {
        return new WeatherMeasurement(hubId, MeasuredValueType.YEARLY_AVG_MIN_DAILY_TEMPERATURE, value, year.getValue());

    }
    public static WeatherMeasurement ofYearlyAvgMaxDailyTemperature(UUID hubId, Double value, Year year) {
        return new WeatherMeasurement(hubId, MeasuredValueType.YEARLY_AVG_MAX_DAILY_TEMPERATURE, value, year.getValue());

    }

    public Year year() {
        return Year.of(this.year);
    }

    public Double measurementValue() {
        return this.value;
    }
}
