package pl.pollub.integration.industry.api;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import pl.pollub.integration.industry.IndustrialProductionFacade;
import pl.pollub.integration.industry.dto.CountryResponse;
import pl.pollub.integration.industry.dto.IndustryHubResponse;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("countries")
public class CountryResource {

    @Inject
    IndustrialProductionFacade productionFacade;

    @GET
    @PermitAll
    public List<CountryResponse> getCountries() {
        return productionFacade.getCountriesOfG7();
    }

    @GET
    @Path("{countryId}")
    @PermitAll
    public CountryResponse getCountry(@PathParam("countryId") UUID countryId) {
        return productionFacade.getCountry(countryId);
    }

    @GET
    @Path("{countryId}/hubs")
    @PermitAll
    public List<IndustryHubResponse> getIndustryHubsByCountry(@PathParam("countryId") UUID countryId) {
        return productionFacade.getIndustryHubsByCountry(countryId);
    }

}
