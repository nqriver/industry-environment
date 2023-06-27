package pl.pollub.integration.industry.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import pl.pollub.integration.commons.RangeOfYears;
import pl.pollub.integration.industry.IndustrialProductionFacade;
import pl.pollub.integration.industry.domain.IndustrialProductionMeasurement;

import java.time.Year;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
@Path("industrial-hubs")
public class IndustrialHubResource {

    @Inject
    IndustrialProductionFacade industrialProductionFacade;


    @GET
    @Path("{hubId}/production-index")
    public Map<Year, IndustrialProductionMeasurement> getDataset(@PathParam("hubId") UUID hubId,
                                                                 @QueryParam("begin") int beginYear,
                                                                 @QueryParam("end") int endYear) {

        return industrialProductionFacade.getAnnualProductionMeasurements(RangeOfYears.of(Year.of(beginYear), Year.of(endYear)), hubId);
    }

}
