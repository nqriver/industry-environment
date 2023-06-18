package pl.pollub.integration.industry.web.dto;

import java.util.List;

public record Dataset(String type, String measuredWhetherValue, List<DatasetRecord> records) {
}
