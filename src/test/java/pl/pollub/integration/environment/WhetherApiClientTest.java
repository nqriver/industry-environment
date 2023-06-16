package pl.pollub.integration.environment;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import pl.pollub.integration.environment.client.TemperatureMeasurements;
import pl.pollub.integration.environment.client.WhetherApiClient;

@QuarkusTest
class WhetherApiClientTest {

    @RestClient
    WhetherApiClient whetherApiClient;

    @Test
    void shouldGetHistoricalTemperatureRecords() {
        // given

        // when
        TemperatureMeasurements historicalTemp = whetherApiClient.getHistoricalTemperatureMeasurements("temperature_2m", "52.52", "13.41", "2023-05-28", "2023-05-29");

        // then
        Log.infof("Fetched temp: %s", historicalTemp.toString());

    }
}