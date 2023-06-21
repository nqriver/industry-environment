package pl.pollub.integration.industry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pl.pollub.integration.industry.domain.CountryRepository;
import pl.pollub.integration.industry.domain.IndustrialProductionMeasurement;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class IndustrialProductionDataImporter {


    @Inject
    ObjectMapper objectMapper;

    @Inject
    CountryRepository countryRepository;

    @ConfigProperty(name = "import.data.industrial-production")
    String importFilename;


    @Inject
    Event<IndustrialDataImportedEvent> completionEventFirer;

    @Transactional
    void onStart(@Observes StartupEvent event) throws IOException {
        Log.info("<IMPORT BATCH JOB> Starting import of industrial production indices dataset from json to database");

        InputStream input = getClass().getResourceAsStream(importFilename);
        if (Objects.isNull(input)) {
            Log.errorf("Cannot import industrial production data, provided import file [%s] does not exist in resources dir", importFilename);
            return;
        }
        List<IndustryProductionIndexRecord> records = objectMapper.readValue(input, new TypeReference<>() {});

        Log.debugf("Fetched [%d] records from imported json", records.size());

        Map<String, List<IndustryProductionIndexRecord>> indexMeasurementsByCountry = records.stream()
                .collect(Collectors.groupingBy(IndustryProductionIndexRecord::getLocation));

        Log.debugf("Found measurements for countries of codes %s", indexMeasurementsByCountry.keySet());

        indexMeasurementsByCountry.forEach((countryCode, jsonMeasurements) -> countryRepository.findByCode(countryCode).ifPresent(
                country -> {
                    Log.infof("Processing records for country of code [%s]. Measurements to insert [%d]", countryCode, jsonMeasurements.size());
                    Set<IndustrialProductionMeasurement> measurements = country.getIndustrialProductionMeasurements();
                    if (measurements.isEmpty()) {
                        jsonMeasurements.forEach(jsonMeasurement -> {
                                    IndustrialProductionMeasurement measurement = IndustrialProductionMeasurement.fromJsonRecord(jsonMeasurement, country);
                                    country.addMeasurement(measurement);
                                }
                        );
                    }
                    countryRepository.persist(country);
                }
        ));

        Log.info("<IMPORT BATCH JOB> Finished import of industrial production indices dataset from json to database");
        completionEventFirer.fire(new IndustrialDataImportedEvent());
    }

    public record IndustrialDataImportedEvent() {}

    public static class IndustryProductionIndexRecord {

        @JsonProperty("LOCATION")
        private String location;

        @JsonProperty("INDICATOR")
        private String indicator;

        @JsonProperty("Value")
        private Double value;

        @JsonProperty("TIME")
        private int time;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getIndicator() {
            return indicator;
        }

        public void setIndicator(String indicator) {
            this.indicator = indicator;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }


}
