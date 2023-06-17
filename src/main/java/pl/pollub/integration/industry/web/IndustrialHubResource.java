package pl.pollub.integration.industry.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import pl.pollub.integration.commons.Coordinates;
import pl.pollub.integration.environment.HistoricalWhetherFacade;
import pl.pollub.integration.industry.IndustrialProductionFacade;
import pl.pollub.integration.industry.domain.IndustryHub;
import pl.pollub.integration.industry.domain.IndustryHubRepository;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
@Path("industrial-hubs")
public class IndustrialHubResource {


    @Inject
    IndustryHubRepository industryHubRepository;

    @Inject
    IndustrialProductionFacade industrialProductionFacade;

    @Inject
    HistoricalWhetherFacade historicalWhetherFacade;

    @GET
    @Path("{hubId}/avg-temperatures")
    public Map<Year, Double> getAverageTemperaturesForYearsRange(@PathParam("hubId") UUID hubId, @QueryParam("begin") int beginYear, @QueryParam("end") int endYear) {

        IndustryHub industryHub = industryHubRepository.findByIdOptional(hubId).orElseThrow(NotFoundException::new);
        return historicalWhetherFacade.getAnnualAverageTemperaturesForRangeOfYears(Year.of(beginYear), Year.of(endYear),
                new Coordinates(industryHub.getLatitude(), industryHub.getLongitude()));
    }

    @GET
    @Path("{hubId}/datasets/avg-temperature")
    public List<Dataset> getIndustryDevelopmentToAvgTemperatureReport(@PathParam("hubId") UUID hubId,
                                                                      @QueryParam("begin") int beginYear,
                                                                      @QueryParam("end") int endYear) {
        return industrialProductionFacade.getSummaryDatasetWithAvgTemperature(hubId, Year.of(beginYear), Year.of(endYear));
    }
}