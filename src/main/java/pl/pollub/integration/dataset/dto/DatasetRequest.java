package pl.pollub.integration.dataset.dto;

import pl.pollub.integration.commons.RangeOfYears;

import java.time.Year;
import java.util.UUID;

public record DatasetRequest(RangeOfYears range, DatasetType type, UUID hubId) {
    public Year start() {
        return range.start();
    }
    public Year end() {
        return range.end();
    }
}
