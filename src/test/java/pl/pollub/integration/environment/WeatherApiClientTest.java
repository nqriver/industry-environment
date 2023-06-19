package pl.pollub.integration.environment;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import pl.pollub.integration.environment.client.WeatherApiClient;

@QuarkusTest
class WeatherApiClientTest {

    @RestClient
    WeatherApiClient weatherApiClient;

    @Test
    void shouldGetHistoricalTemperatureRecords() {
        // given

        // when
        var historicalTemp = weatherApiClient.getHistoricalMinMaxTemperatureMeasurements(new String[]{"temperature_2m_max", "temperature_2m_min"}, "52.52", "13.41", "2023-05-28", "2023-05-29", "auto");

        // then
        Log.infof("Fetched temp: %s", historicalTemp.toString());

    }
}