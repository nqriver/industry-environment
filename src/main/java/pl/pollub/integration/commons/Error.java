package pl.pollub.integration.commons;

public record Error(String cause) {
    public static Error ofCause(String cause) {
        return new Error(cause);
    }
}
