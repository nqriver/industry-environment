
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO country (id, name, code, gdp)
VALUES ('e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Canada', 'CA', 1640000000000),
       ('2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'France', 'FR', 2710000000000),
       ('a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Germany', 'DE', 3840000000000),
       ('6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Italy', 'IT', 2000000000000),
       ('15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Japan', 'JP', 5000000000000),
       ('f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'United Kingdom', 'GB', 2820000000000),
       ('0a378e53-1b96-4c78-9e9a-3a9783f14938', 'United States', 'US', 21400000000000);


-- France 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Ile-de-France', 'Paris', 12100000, 57658, 48.86, 2.35),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Auvergne-Rhône-Alpes', 'Lyon', 8027000, 33222, 45.75, 4.85),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Hauts-de-France', 'Lille', 6000000, 27198, 50.63, 3.06),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Nouvelle-Aquitaine', 'Bordeaux', 6000000, 28850, 44.84, -0.58),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Grand Est', 'Strasbourg', 5500000, 30017, 48.58, 7.75),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Occitanie', 'Toulouse', 5800000, 26901, 43.60, 1.44),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Provence-Alpes-Côte Azur', 'Marseille', 5100000, 32026, 43.30, 5.37),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Pays de la Loire', 'Nantes', 3700000, 29684, 47.21, -1.55),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Brittany', 'Rennes', 3300000, 29514, 48.11, -1.67),
    (uuid_generate_v4(), '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Centre-Val de Loire', 'Orleans', 2600000, 27510, 47.90, 1.91);


-- Canada 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Ontario', 'Toronto', 14733119, 51000, 43.70, -79.42),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Quebec', 'Montreal', 8574571, 45000, 45.50, -73.57),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'British Columbia', 'Vancouver', 5147712, 44000, 49.28, -123.12),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Alberta', 'Calgary', 4413146, 62000, 51.04, -114.07),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Manitoba', 'Winnipeg', 1377517, 43000, 49.90, -97.13),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Saskatchewan', 'Saskatoon', 1181666, 60000, 52.13, -106.67),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Nova Scotia', 'Halifax', 971395, 40000, 44.65, -63.57),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'New Brunswick', 'Fredericton', 779993, 39000, 45.96, -66.64),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Newfoundland and Labrador', 'St. John''s', 522537, 57000, 47.56, -52.71),
    (uuid_generate_v4(), 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Prince Edward Island', 'Charlottetown', 158158, 39000, 46.23, -63.13);


-- USA 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'California', 'Los Angeles', 39538223, 74244, 34.05, -118.25),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Texas', 'Houston', 29145505, 59413, 29.76, -95.37),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'New York', 'New York City', 20201249, 89814, 40.71, -74.01),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Florida', 'Miami', 21538187, 50431, 25.76, -80.19),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Illinois', 'Chicago', 12812508, 65997, 41.88, -87.63),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Pennsylvania', 'Philadelphia', 13011844, 57658, 39.95, -75.16),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Ohio', 'Columbus', 11808848, 55295, 39.96, -82.99),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Georgia', 'Atlanta', 10736100, 55679, 33.74, -84.39),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'North Carolina', 'Charlotte', 10600823, 52118, 35.22, -80.84),
    (uuid_generate_v4(), '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Michigan', 'Detroit', 10045029, 48358, 42.33, -83.04);
