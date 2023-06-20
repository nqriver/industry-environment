package pl.pollub.integration.environment.importer;

import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.environment.HistoricalWeatherFacade;
import pl.pollub.integration.environment.domain.MeasuredValueType;
import pl.pollub.integration.environment.domain.WeatherMeasurement;
import pl.pollub.integration.environment.domain.WeatherMeasurementRepository;
import pl.pollub.integration.industry.IndustrialProductionFacade;

import java.time.Year;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class HistoricalWeatherDataImporter {

    public static final Year UPPER_YEAR_LIMIT = Year.now().minusYears(1);
    public static final Year LOWER_YEAR_LIMIT = Year.of(1950);
    @Inject
    IndustrialProductionFacade industrialProductionFacade;
    @Inject
    HistoricalWeatherFacade weatherFacade;

    @Inject
    WeatherMeasurementRepository weatherMeasurementRepository;

    @ConfigProperty(name = "data-importer.historical-weather.enabled", defaultValue = "false")
    String importEnabled;

    void runWeatherMeasurementsImportOnStart(@Observes StartupEvent event) throws InterruptedException {
        if (!Boolean.parseBoolean(importEnabled)) {
            return;
        }
        Thread.sleep(3000);
//        importMinTemperaturesOnStart();
        importMaxTemperaturesOnStart();
//        importAvgTemperaturesOnStart();
    }


    void importMinTemperaturesOnStart() {
        if (weatherMeasurementRepository.existsByMeasurementType(MeasuredValueType.YEARLY_AVG_MIN_DAILY_TEMPERATURE)) {
            Log.infof("Terminating import. Found already existing data for measurements of type [%s]", MeasuredValueType.YEARLY_AVG_MIN_DAILY_TEMPERATURE);
            return;
        }
        Log.info("<IMPORT BATCH JOB> Starting import of yearly average min daily temperature for all registered industry-hubs for range of years [%d] - [%d]");
        List<Coordinates> allHubsCoordinates = industrialProductionFacade.getAllHubsCoordinates();

        allHubsCoordinates.forEach(
                this::importMinTemperatures
        );
        Log.info("<IMPORT BATCH JOB> Finished import of historical weather dataset from json to database");
    }

    void importAvgTemperaturesOnStart() {
        if (weatherMeasurementRepository.existsByMeasurementType(MeasuredValueType.YEARLY_AVG_TEMPERATURE)) {
            Log.infof("Terminating import. Found already existing data for measurements of type [%s]", MeasuredValueType.YEARLY_AVG_TEMPERATURE);
            return;
        }
        Log.info("<IMPORT BATCH JOB> Starting import of yearly average temperature for all registered industry-hubs for range of years [%d] - [%d]");
        List<Coordinates> allHubsCoordinates = industrialProductionFacade.getAllHubsCoordinates();

        allHubsCoordinates.forEach(
                this::importAvgTemperatures
        );
        Log.info("<IMPORT BATCH JOB> Finished import of historical weather dataset from json to database");
    }

    void importMaxTemperaturesOnStart() {
        if (weatherMeasurementRepository.existsByMeasurementType(MeasuredValueType.YEARLY_AVG_MAX_DAILY_TEMPERATURE)) {
            Log.infof("Terminating import. Found already existing data for measurements of type [%s]", MeasuredValueType.YEARLY_AVG_MAX_DAILY_TEMPERATURE);
            return;
        }
        Log.info("<IMPORT BATCH JOB> Starting import of yearly average max daily temperature for all registered industry-hubs for range of years [%d] - [%d]");
        List<Coordinates> allHubsCoordinates = industrialProductionFacade.getAllHubsCoordinates();

        allHubsCoordinates.forEach(
                this::importMaxTemperatures
        );
        Log.info("<IMPORT BATCH JOB> Finished import of historical weather dataset from json to database");
    }

    @Transactional
    public void importMaxTemperatures(Coordinates hub) {
        Map<Year, Double> dataset = weatherFacade.getAnnualAverageMaxDailyTemperatureForRangeOfYears(LOWER_YEAR_LIMIT, UPPER_YEAR_LIMIT, hub);
        dataset.forEach(
                (year, measurement) -> {
                    WeatherMeasurement entity = WeatherMeasurement.ofYearlyAvgMaxDailyTemperature(hub.hubId(), measurement, year);
                    weatherMeasurementRepository.persist(entity);
                }
        );
        Log.infof("<IMPORT BATCH JOB> Imported measurements for hub [%s]", hub.toString());
    }

    @Transactional
    public void importAvgTemperatures(Coordinates hub) {
        Map<Year, Double> dataset = weatherFacade.getAnnualAverageTemperaturesForRangeOfYears(LOWER_YEAR_LIMIT, UPPER_YEAR_LIMIT, hub);
        dataset.forEach(
                (year, measurement) -> {
                    WeatherMeasurement entity = WeatherMeasurement.ofYearlyAvgTemperature(hub.hubId(), measurement, year);
                    weatherMeasurementRepository.persist(entity);
                }
        );
        Log.infof("<IMPORT BATCH JOB> Imported measurements for hub [%s]", hub.toString());

    }


    @Transactional
    public void importMinTemperatures(Coordinates hub) {
        Map<Year, Double> dataset = weatherFacade.getAnnualAverageMinDailyTemperatureForRangeOfYears(LOWER_YEAR_LIMIT, UPPER_YEAR_LIMIT, hub);
        dataset.forEach(
                (year, measurement) -> {
                    WeatherMeasurement entity = WeatherMeasurement.ofYearlyAvgMinDailyTemperature(hub.hubId(), measurement, year);
                    weatherMeasurementRepository.persist(entity);
                }
        );
        Log.infof("<IMPORT BATCH JOB> Imported measurements for hub [%s]", hub.toString());
    }

}
