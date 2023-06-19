package pl.pollub.integration.dataset.dto;

import java.util.List;

public record Dataset(String type, String measuredWhetherValue, List<DatasetRecord> records) {
}
