CREATE TABLE weather_measurement (
                                     id UUID PRIMARY KEY,
                                     industry_hub_id UUID,
                                     measured_value_type TEXT,
                                     value DOUBLE PRECISION,
                                     year INTEGER
);
