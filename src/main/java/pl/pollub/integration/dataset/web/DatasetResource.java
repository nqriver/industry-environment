package pl.pollub.integration.dataset.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import pl.pollub.integration.dataset.DatasetFacade;
import pl.pollub.integration.dataset.dto.Dataset;
import pl.pollub.integration.dataset.dto.DatasetRequest;
import pl.pollub.integration.dataset.dto.DatasetType;
import pl.pollub.integration.dataset.dto.jaxb.DatasetRecordXml;
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
    public Dataset getDataset(@PathParam("hubId") UUID hubId,
                              @QueryParam("type") DatasetType type,
                              @QueryParam("begin") int beginYear,
                              @QueryParam("end") int endYear) {

        DatasetRequest request = new DatasetRequest(Year.of(beginYear), Year.of(endYear), type, hubId);
        return datasetFacade.getSummaryDataset(request);
    }


    @GET
    @Path("/{hubId}/xml")
    @Produces(APPLICATION_XML)
    public DatasetXml getDatasetXml(@PathParam("hubId") UUID hubId,
                                          @QueryParam("type") DatasetType type,
                                          @QueryParam("begin") int beginYear,
                                          @QueryParam("end") int endYear) {

        DatasetRequest request = new DatasetRequest(Year.of(beginYear), Year.of(endYear), type, hubId);
        return DatasetXml.toJaxbModel(datasetFacade.getSummaryDataset(request));
    }

}
