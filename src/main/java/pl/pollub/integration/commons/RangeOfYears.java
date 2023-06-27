package pl.pollub.integration.commons;

import java.time.Year;
import java.util.Objects;

public record RangeOfYears(Year start, Year end) {

    public static RangeOfYears of(Year start, Year end) {
        if (Objects.isNull(start) || Objects.isNull(end)) {
            throw new IllegalArgumentException("Both boundaries of years range should be specified");
        } else if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start year should be before end year");
        }
        return new RangeOfYears(start, end);
    }

}
