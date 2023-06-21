package pl.pollub.integration.dataset;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.ServiceErrorCode;
import pl.pollub.integration.commons.ServiceException;
import pl.pollub.integration.dataset.dto.Dataset;
import pl.pollub.integration.dataset.dto.DatasetRecord;
import pl.pollub.integration.dataset.dto.DatasetRequest;
import pl.pollub.integration.dataset.dto.DatasetType;
import pl.pollub.integration.environment.HistoricalWeatherFacade;
import pl.pollub.integration.environment.HistoricalWeatherFacadeDecorator;
import pl.pollub.integration.industry.IndustrialProductionFacade;
import pl.pollub.integration.industry.domain.Country;
import pl.pollub.integration.industry.domain.IndustrialProductionMeasurement;
import pl.pollub.integration.industry.domain.IndustryHub;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public class DatasetFacade {

    @Inject
    IndustrialProductionFacade industrialProductionFacade;


    @Inject
    @Named(HistoricalWeatherFacadeDecorator.QUALIFIER)
    HistoricalWeatherFacade historicalWeatherFacade;


    public Dataset getSummaryDataset(DatasetRequest request) {
        UUID industryHubId = request.hubId();
        Year begin = request.start();
        Year end = request.end();
        DatasetType type = request.type();
        IndustryHub industryHub = industrialProductionFacade.findIndustryHub(industryHubId);

        Country country = industryHub.locationCountry();
        Map<Year, IndustrialProductionMeasurement> annualProductionMeasurements = industrialProductionFacade
                .getAnnualProductionMeasurements(begin, end, country);

        Map<Year, Double> annualWeatherAttributes = resolveWeatherAttributes(begin, end, type, industryHub);

        List<DatasetRecord> records = getYearsStream(begin, end)
                .map(year -> assembleDatasetRecord(annualProductionMeasurements, annualWeatherAttributes, year)).toList();

        return new Dataset(type.description(), type.measuredWeatherValue(), records);
    }

    private Map<Year, Double> resolveWeatherAttributes(Year begin, Year end, DatasetType type, IndustryHub industryHub) {
        return switch (type) {
            case PRODUCTION_IDX_AND_AVG_DAILY_AMPLITUDE ->
                    historicalWeatherFacade.getAnnualAverageDailyTemperatureAmplitudeForRangeOfYears(begin, end,
                            new Coordinates(industryHub.getId(), industryHub.getLatitude(), industryHub.getLongitude()));

            case PRODUCTION_IDX_AND_AVG_DAILY_TEMP ->
                    historicalWeatherFacade.getAnnualAverageTemperaturesForRangeOfYears(begin, end,
                            new Coordinates(industryHub.getId(), industryHub.getLatitude(), industryHub.getLongitude()));

            case PRODUCTION_IDX_AND_AVG_MAX_DAILY_TEMP ->
                    historicalWeatherFacade.getAnnualAverageMaxDailyTemperatureForRangeOfYears(begin, end,
                            new Coordinates(industryHub.getId(), industryHub.getLatitude(), industryHub.getLongitude()));

            case PRODUCTION_IDX_AND_AVG_MIN_DAILY_TEMP ->
                    historicalWeatherFacade.getAnnualAverageMinDailyTemperatureForRangeOfYears(begin, end,
                            new Coordinates(industryHub.getId(), industryHub.getLatitude(), industryHub.getLongitude()));
            default -> throw new ServiceException(ServiceErrorCode.DATASET_OPTION_NOT_SUPPORTED);
        };
    }


    private DatasetRecord assembleDatasetRecord(Map<Year, IndustrialProductionMeasurement> annualProductionMeasurements, Map<Year, Double> annualAverageDailyTemperatureAmplitudes, Year year) {
        Double avgTemp = null;
        if (annualAverageDailyTemperatureAmplitudes.containsKey(year)) {
            avgTemp = annualAverageDailyTemperatureAmplitudes.get(year);
        }
        Double industryIndex = null;
        if (annualProductionMeasurements.containsKey(year)) {
            industryIndex = annualProductionMeasurements.get(year).indexValue();
        }
        return new DatasetRecord(year.getValue(), avgTemp, industryIndex);
    }

    private Stream<Year> getYearsStream(Year begin, Year end) {
        return Stream.iterate(begin, value -> value.isBefore(end.plusYears(1)), e -> e.plusYears(1));
    }
}
