package pl.pollub.integration.environment.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.Instant;
import java.util.List;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureMeasurements {

    private double latitude;
    private double longitude;
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;

    private Measurement hourly;

    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;

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

    public Measurement getHourly() {
        return hourly;
    }

    public void setHourly(Measurement hourly) {
        this.hourly = hourly;
    }

    public HourlyUnits getHourlyUnits() {
        return hourlyUnits;
    }

    public void setHourlyUnits(HourlyUnits hourlyUnits) {
        this.hourlyUnits = hourlyUnits;
    }

    @Override
    public String toString() {
        return "TemperatureMeasurements{" +
                "hourly=" + hourly +
                ", hourlyUnits=" + hourlyUnits +
                '}';
    }

    static class Measurement {

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "UTC")
        private List<Instant> time;

        @JsonProperty("temperature_2m")
        private List<Double> temperature2m;

        public List<Instant> getTime() {
            return time;
        }

        public void setTime(List<Instant> time) {
            this.time = time;
        }

        public List<Double> getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(List<Double> temperature2m) {
            this.temperature2m = temperature2m;
        }

        @Override
        public String toString() {
            return "Hourly{" +
                    "time=" + time +
                    ", temperature2m=" + temperature2m +
                    '}';
        }
    }

    static class HourlyUnits {

        @JsonProperty("temperature_2m")
        private String temperature2m;

        public String getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(String temperature2m) {
            this.temperature2m = temperature2m;
        }

        @Override
        public String toString() {
            return "HourlyUnits{" +
                    "temperature2m='" + temperature2m + '\'' +
                    '}';
        }
    }

}





