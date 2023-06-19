package pl.pollub.integration.dataset.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import pl.pollub.integration.dataset.DatasetFacade;
import pl.pollub.integration.dataset.dto.Dataset;
import pl.pollub.integration.dataset.dto.DatasetRequest;
import pl.pollub.integration.dataset.dto.DatasetType;

import java.time.Year;
import java.util.UUID;

@ApplicationScoped
@Path("datasets")
public class DatasetResource {

    @Inject
    DatasetFacade datasetFacade;

    @GET
    @Path("{hubId}")
    public Dataset getDataset(@PathParam("hubId") UUID hubId,
                              @QueryParam("type") DatasetType type,
                              @QueryParam("begin") int beginYear,
                              @QueryParam("end") int endYear) {

        DatasetRequest request = new DatasetRequest(Year.of(beginYear), Year.of(endYear), type, hubId);
        return datasetFacade.getSummaryDataset(request);
    }
}
