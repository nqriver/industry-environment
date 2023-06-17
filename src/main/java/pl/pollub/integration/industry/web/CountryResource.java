package pl.pollub.integration.industry.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import pl.pollub.integration.industry.IndustrialProductionFacade;
import pl.pollub.integration.industry.web.dto.CountryResponse;
import pl.pollub.integration.industry.web.dto.IndustryHubResponse;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("countries")
public class CountryResource {

    @Inject
    IndustrialProductionFacade productionFacade;

    @GET
    public List<CountryResponse> getCountries() {
        return productionFacade.getCountriesOfG7();
    }

    @GET
    @Path("{countryId}")
    public CountryResponse getCountry(@PathParam("countryId") UUID countryId) {
        return productionFacade.getCountry(countryId);
    }

    @GET
    @Path("{countryId}/hubs")
    public List<IndustryHubResponse> getCountryIndustryHubs(@PathParam("countryId") UUID countryId) {
        return productionFacade.getIndustryHubsByCountry(countryId);
    }

}
