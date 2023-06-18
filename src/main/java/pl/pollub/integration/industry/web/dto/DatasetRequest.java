package pl.pollub.integration.industry.web.dto;

import java.time.Year;
import java.util.UUID;

public record DatasetRequest(Year start, Year end, DatasetType type, UUID hubId) {
}
