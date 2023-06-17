package pl.pollub.integration.environment.client.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDate;
import java.util.List;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class DailyTemperatureStatistics {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private List<LocalDate> time;

    @JsonProperty("temperature_2m_min")
    private List<Double> minTemperature;

    @JsonProperty("temperature_2m_max")
    private List<Double> maxTemperature;

    public List<LocalDate> getTime() {
        return time;
    }

    public void setTime(List<LocalDate> time) {
        this.time = time;
    }

    public List<Double> getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(List<Double> minTemperature) {
        this.minTemperature = minTemperature;
    }

    public List<Double> getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(List<Double> maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "time=" + time +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
