package pl.pollub.integration.commons;

import java.time.Year;
import java.util.stream.Stream;

public final class RangeOfYearsUtils {

    private RangeOfYearsUtils() {

    }

    public static Stream<Year> getYearsStream(RangeOfYears range) {
        return Stream.iterate(range.start(), value -> value.isBefore(range.end().plusYears(1)), e -> e.plusYears(1));
    }
}
