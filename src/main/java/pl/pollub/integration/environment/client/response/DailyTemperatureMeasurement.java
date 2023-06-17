package pl.pollub.integration.environment.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyTemperatureMeasurement {

    private double latitude;
    private double longitude;
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;

    private DailyTemperatureStatistics daily;


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

    public DailyTemperatureStatistics getDaily() {
        return daily;
    }

    public void setDaily(DailyTemperatureStatistics daily) {
        this.daily = daily;
    }


    public List<Double> getDailyMaxTemperatureMeasurements() {
        return daily.getMaxTemperature();
    }

    public List<Double> getDailyMinTemperatureMeasurements() {
        return daily.getMinTemperature();
    }

    @Override
    public String toString() {
        return "TemperatureMeasurements{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", timezoneAbbreviation='" + timezoneAbbreviation + '\'' +
                ", daily=" + daily +
                '}';
    }

}





