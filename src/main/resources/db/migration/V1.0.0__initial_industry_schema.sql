create table country
(
    id   uuid not null,
    code text unique,
    gdp  double precision,
    name text unique,
    primary key (id)
);

create table industrial_production_measurement
(
    id          uuid not null,
    index_type  text,
    index_value double precision,
    year        integer,
    country_id  uuid,
    primary key (id)
);

create table industry_hub
(
    id               uuid not null,
    gdp_per_capita   double precision,
    hub_name         text,
    latitude         double precision,
    longitude        double precision,
    main_city_nearby text,
    population       integer,
    country_id       uuid,
    primary key (id)
);

create index idx_country_code
    on country (code);

alter table if exists industrial_production_measurement
    add constraint industrial_production_measurement_country_id_FKEY
    foreign key (country_id)
    references country;

alter table if exists industry_hub
    add constraint industry_hub_country_id_FKEY
    foreign key (country_id)
    references country;