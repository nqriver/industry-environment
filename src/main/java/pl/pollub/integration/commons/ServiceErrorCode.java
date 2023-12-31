package pl.pollub.integration.commons;

import jakarta.ws.rs.core.Response;

public enum ServiceErrorCode {
    EXTERNAL_WEB_SERVICE_4XX_ERROR("BMS01", "External web service responded with 4xx", Response.Status.BAD_REQUEST),
    EXTERNAL_WEB_SERVICE_5XX_ERROR("BMS02", "External web service responded with 5xx", Response.Status.SERVICE_UNAVAILABLE),
    INVALID_DATES_RANGE("BMS03", "The date range can start with a minimum of 1950 and the start date should be before the end date", Response.Status.BAD_REQUEST),
    COUNTRY_NOT_FOUND("BMS04", "Country cannot be found", Response.Status.NOT_FOUND),
    INDUSTRY_HUB_NOT_FOUND("BMS05", "Cannot find industry hub", Response.Status.NOT_FOUND),
    INVALID_MIN_MAX_TEMP_MEASURES("BSM05", "Weather API service returned inconsistent number of measurement of min and max temperature", Response.Status.INTERNAL_SERVER_ERROR),
    DATASET_OPTION_NOT_SUPPORTED("BSM07", "This dataset combination of attributes is unknown/disallowed", Response.Status.BAD_REQUEST),
    USER_EMAIL_TAKEN("BMS08", "User with chosen email already exists", Response.Status.CONFLICT),
    USER_LOGIN_TAKEN("BMS09", "User with chosen login already exists", Response.Status.CONFLICT),
    USER_NOT_FOUND("BMS10", "User cannot be found", Response.Status.NOT_FOUND);

    private final String code;
    private final String message;
    private final Response.Status status;

    ServiceErrorCode(String code, String message, Response.Status status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Response.Status getStatus() {
        return status;
    }
}
