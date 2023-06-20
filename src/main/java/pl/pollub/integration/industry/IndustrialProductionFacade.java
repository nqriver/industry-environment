package pl.pollub.integration.industry;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.commons.ServiceErrorCode;
import pl.pollub.integration.commons.ServiceException;
import pl.pollub.integration.industry.domain.*;
import pl.pollub.integration.industry.dto.CountryResponse;
import pl.pollub.integration.industry.dto.IndustryHubResponse;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class IndustrialProductionFacade {

    @Inject
    IndustryHubRepository industryHubRepository;

    @Inject
    IndustrialProductionMeasurementRepository measurementRepository;

    @Inject
    CountryRepository countryRepository;


    public IndustryHub findIndustryHub(UUID industryHubId) {
        return industryHubRepository.findByIdOptional(industryHubId)
                .orElseThrow(() -> new ServiceException(ServiceErrorCode.INDUSTRY_HUB_NOT_FOUND));
    }

    public List<CountryResponse> getCountriesOfG7() {
        return countryRepository.findAll(Sort.by("name", Sort.Direction.Ascending))
                .stream()
                .map(Country::toResponse)
                .toList();

    }

    public List<Coordinates> getAllHubsCoordinates() {
        return industryHubRepository.findAll().stream()
                .map(hub -> new Coordinates(hub.getId(), hub.getLatitude(), hub.getLongitude()))
                .toList();
    }

    public CountryResponse getCountry(UUID countryId) {
        return findCountry(countryId).toResponse();
    }

    public List<IndustryHubResponse> getIndustryHubsByCountry(UUID countryId) {
        Country country = findCountry(countryId);
        return country.getIndustryHubs().stream().map(IndustryHub::toResponse).toList();
    }

    public Map<Year, IndustrialProductionMeasurement> getAnnualProductionMeasurements(Year begin, Year end, Country country) {
        return measurementRepository
                .findMeasurementsByCountryForYearsInRange(country, begin, end)
                .stream()
                .collect(Collectors.toMap(IndustrialProductionMeasurement::year, measurement -> measurement));
    }

    private Country findCountry(UUID countryId) {
        return countryRepository.findByIdOptional(countryId)
                .orElseThrow(() -> new ServiceException(ServiceErrorCode.COUNTRY_NOT_FOUND));
    }


    public Map<Year, IndustrialProductionMeasurement> getAnnualProductionMeasurements(Year start, Year end, UUID hubId) {
        IndustryHub industryHub = findIndustryHub(hubId);
        return getAnnualProductionMeasurements(start, end, industryHub.locationCountry());
    }
}
