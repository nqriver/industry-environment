package pl.pollub.integration.dataset.api;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import pl.pollub.integration.commons.RangeOfYears;
import pl.pollub.integration.dataset.DatasetFacade;
import pl.pollub.integration.dataset.dto.Dataset;
import pl.pollub.integration.dataset.dto.DatasetRequest;
import pl.pollub.integration.dataset.dto.DatasetType;
import pl.pollub.integration.dataset.dto.jaxb.DatasetXml;

import java.time.Year;
import java.util.UUID;

import static jakarta.ws.rs.core.MediaType.APPLICATION_XML;

@ApplicationScoped
@Path("datasets")
public class DatasetResource {

    @Inject
    DatasetFacade datasetFacade;

    @GET
    @Path("{hubId}")
    @RolesAllowed({"ADMIN", "CONTENT_VIEWER", "CONTENT_MANAGER"})
    public Dataset getDataset(@PathParam("hubId") UUID hubId,
                              @QueryParam("type") DatasetType type,
                              @QueryParam("begin") int beginYear,
                              @QueryParam("end") int endYear) {

        RangeOfYears range = RangeOfYears.of(Year.of(beginYear), Year.of(endYear));
        DatasetRequest request = new DatasetRequest(range, type, hubId);
        return datasetFacade.getSummaryDataset(request);
    }


    @GET
    @Path("/{hubId}/xml")
    @RolesAllowed({"ADMIN", "CONTENT_DOWNLOADER", "CONTENT_MANAGER"})
    @Produces(APPLICATION_XML)
    public DatasetXml getDatasetXml(@PathParam("hubId") UUID hubId,
                                          @QueryParam("type") DatasetType type,
                                          @QueryParam("begin") int beginYear,
                                          @QueryParam("end") int endYear) {

        RangeOfYears range = RangeOfYears.of(Year.of(beginYear), Year.of(endYear));
        DatasetRequest request = new DatasetRequest(range, type, hubId);
        return DatasetXml.toJaxbModel(datasetFacade.getSummaryDataset(request));
    }
}
