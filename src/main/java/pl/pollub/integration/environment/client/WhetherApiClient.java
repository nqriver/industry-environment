package pl.pollub.integration.environment.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "whether-api")
public interface WhetherApiClient {


    @GET
    TemperatureMeasurements getHistoricalTemperatureMeasurements(@QueryParam("hourly") String hourlyParam,
                                                                 @QueryParam("latitude") String latitude,
                                                                 @QueryParam("longitude") String longitude,
                                                                 @QueryParam("start_date") String startDate,
                                                                 @QueryParam("end_date") String endDate
    );


}
