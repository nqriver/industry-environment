package pl.pollub.integration.industry.web.dto;

public record IndustryHubResponse(java.util.UUID id, String hubName, String mainCityNearby, Integer population,
                                  Double gdpPerCapita, Double latitude, Double longitude) {
}
