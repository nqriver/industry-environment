package pl.pollub.integration.industry;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.ServiceErrorCode;
import pl.pollub.integration.commons.ServiceException;
import pl.pollub.integration.environment.HistoricalWhetherFacade;
import pl.pollub.integration.industry.domain.*;
import pl.pollub.integration.industry.web.Dataset;
import pl.pollub.integration.industry.web.dto.CountryResponse;
import pl.pollub.integration.industry.web.dto.IndustryHubResponse;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class IndustrialProductionFacade {

    @Inject
    IndustryHubRepository industryHubRepository;

    @Inject
    IndustrialProductionMeasurementRepository measurementRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    HistoricalWhetherFacade whetherFacade;


    public List<CountryResponse> getCountriesOfG7() {
        return countryRepository.findAll(Sort.by("name", Sort.Direction.Ascending))
                .stream()
                .map(Country::toResponse)
                .toList();

    }

    public CountryResponse getCountry(UUID countryId) {
        return findCountry(countryId).toResponse();
    }

    private Country findCountry(UUID countryId) {
        return countryRepository.findByIdOptional(countryId)
                .orElseThrow(() -> new ServiceException(ServiceErrorCode.COUNTRY_NOT_FOUND));
    }

    public List<IndustryHubResponse> getIndustryHubsByCountry(UUID countryId) {
        Country country = findCountry(countryId);
        return country.getIndustryHubs().stream().map(IndustryHub::toResponse).toList();
    }

    @Transactional
    public List<Dataset> getSummaryDatasetWithAvgTemperature(UUID industryHubId, Year begin, Year end) {
        IndustryHub industryHub = industryHubRepository.findByIdOptional(industryHubId)
                .orElseThrow(() -> new ServiceException(ServiceErrorCode.INDUSTRY_HUB_NOT_FOUND));

        Country country = industryHub.locationCountry();
        Map<Year, IndustrialProductionMeasurement> annualProductionMeasurements = measurementRepository
                .findMeasurementsByCountryForYearsInRange(country, begin, end)
                .stream()
                .collect(Collectors.toMap(IndustrialProductionMeasurement::year, measurement -> measurement));

        Map<Year, Double> annualAverageTemperatures = whetherFacade.getAnnualAverageTemperaturesForRangeOfYears(begin, end,
                new Coordinates(industryHub.getLatitude(), industryHub.getLongitude()));

        return getYearsStream(begin, end)
                .map(year -> {
                    Double avgTemp = null;
                    if (annualAverageTemperatures.containsKey(year)) {
                        avgTemp = annualAverageTemperatures.get(year);
                    }
                    Double industryIndex = null;
                    if (annualProductionMeasurements.containsKey(year)) {
                        industryIndex = annualProductionMeasurements.get(year).indexValue();
                    }
                    return new Dataset(year.getValue(), avgTemp, industryIndex);
                }).toList();
    }

    private Stream<Year> getYearsStream(Year begin, Year end) {
        return Stream.iterate(begin, value -> value.isBefore(end.plusYears(1)), e -> e.plusYears(1));
    }

}
