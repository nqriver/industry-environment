package pl.pollub.integration.industry.dto;

public record IndustryHubResponse(java.util.UUID id, String hubName, String mainCityNearby, Integer population,
                                  Double gdpPerCapita, Double latitude, Double longitude) {
}
