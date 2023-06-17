package pl.pollub.integration.environment.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyTemperatureStatistics {

    private double latitude;
    private double longitude;
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;


    @JsonProperty("hourly")
    private HourlyTemperatureMeasurement hourlyMeasurements;

    public List<Double> getConsecutiveMeasurements() {
        return this.hourlyMeasurements.getTemperature2m();

    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public HourlyTemperatureMeasurement getHourlyMeasurements() {
        return hourlyMeasurements;
    }

    public void setHourlyMeasurements(HourlyTemperatureMeasurement hourlyMeasurements) {
        this.hourlyMeasurements = hourlyMeasurements;
    }
}
