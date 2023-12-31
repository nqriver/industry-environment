package pl.pollub.integration.environment.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import pl.pollub.integration.environment.client.response.DailyTemperatureMeasurement;
import pl.pollub.integration.environment.client.response.HourlyTemperatureStatistics;

@RegisterRestClient(configKey = "weather-api")
public interface WeatherApiClient {


    @GET
    DailyTemperatureMeasurement getHistoricalMinMaxTemperatureMeasurements(@QueryParam("daily") String[] dailyParams,
                                                                           @QueryParam("latitude") String latitude,
                                                                           @QueryParam("longitude") String longitude,
                                                                           @QueryParam("start_date") String startDate,
                                                                           @QueryParam("end_date") String endDate,
                                                                           @QueryParam("timezone") String timezone
    );

    @GET
    HourlyTemperatureStatistics getHistoricalHourlyTemperatureMeasurements(@QueryParam("hourly") String hourlyParam,
                                                                           @QueryParam("latitude") String latitude,
                                                                           @QueryParam("longitude") String longitude,
                                                                           @QueryParam("start_date") String startDate,
                                                                           @QueryParam("end_date") String endDate
    );


}
