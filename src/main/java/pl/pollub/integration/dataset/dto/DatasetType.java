package pl.pollub.integration.dataset.dto;

public enum DatasetType {
    PRODUCTION_IDX_AND_AVG_DAILY_TEMP("avg_daily_temp", "Zestawienie indeksu produkcji ze średnią temperaturą w zakresie lat"),
    PRODUCTION_IDX_AND_AVG_MAX_DAILY_TEMP("avg_max_daily_temp", "Zestawienie indeksu produkcji ze średnią dzienną maksymalną temperaturą w zakresie lat "),
    PRODUCTION_IDX_AND_AVG_MIN_DAILY_TEMP("avg_min_daily_temp", "Zestawienie indeksu produkcji ze średnią dzienną minimalną temperaturą w zakresie lat "),
    PRODUCTION_IDX_AND_AVG_DAILY_AMPLITUDE("avg_daily_amplitude", "Zestawienie indeksu produkcji ze średnią dzienną amplitudą temperatur w zakresie lat ");

    private final String measuredWeatherValue;
    private final String description;

    DatasetType(String measuredWeatherValue, String description) {
        this.measuredWeatherValue = measuredWeatherValue;
        this.description = description;
    }


    public String description() {
        return description;
    }

    public String measuredWeatherValue() {
        return measuredWeatherValue;
    }

}
