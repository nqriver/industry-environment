
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO country (id, name, code, gdp)
VALUES ('e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Canada', 'CAN', 1640000000000),
       ('2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'France', 'FRA', 2710000000000),
       ('a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Germany', 'DEU', 3840000000000),
       ('6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Italy', 'ITA', 2000000000000),
       ('15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Japan', 'JPN', 5000000000000),
       ('f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'United Kingdom', 'GBR', 2820000000000),
       ('0a378e53-1b96-4c78-9e9a-3a9783f14938', 'United States', 'USA', 21400000000000);


-- France 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('6f6e7004-d9a7-4ed0-a3b9-1d1b7a1482e9', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Ile-de-France', 'Paris', 12100000, 57658, 48.86, 2.35),
    ('1b9b0f07-297f-4f49-96b3-c5b4ae5e9a3e', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Auvergne-Rhône-Alpes', 'Lyon', 8027000, 33222, 45.75, 4.85),
    ('6a7d3d4c-6ae1-44f0-8d20-986fe9b01f55', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Hauts-de-France', 'Lille', 6000000, 27198, 50.63, 3.06),
    ('a9b4d34d-3b5e-44b9-bf25-755ef00e7475', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Nouvelle-Aquitaine', 'Bordeaux', 6000000, 28850, 44.84, -0.58),
    ('ec5ae5b7-bd5c-4bfe-b499-98802c9a43d1', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Grand Est', 'Strasbourg', 5500000, 30017, 48.58, 7.75),
    ('7fc41ea0-969f-421c-a6d1-fd5e740d725e', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Occitanie', 'Toulouse', 5800000, 26901, 43.60, 1.44),
    ('9b36b8cc-0630-4d37-9dbb-d723cd53a8da', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Provence-Alpes-Côte Azur', 'Marseille', 5100000, 32026, 43.30, 5.37),
    ('8b2e7242-3e15-459e-8861-50447d35b48e', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Pays de la Loire', 'Nantes', 3700000, 29684, 47.21, -1.55),
    ('f4560344-8b8a-4dbd-a268-0f3f6717263d', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Brittany', 'Rennes', 3300000, 29514, 48.11, -1.67),
    ('2a6d198d-6bfe-4ff2-a42f-19baf2220d2b', '2fd4e1c6-7480-4c5e-95b4-81724e4395c3', 'Centre-Val de Loire', 'Orleans', 2600000, 27510, 47.90, 1.91);



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


-- Italy 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Lombardy', 'Milan', 10060000, 39900, 45.46, 9.19),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Lazio', 'Rome', 5879000, 34100, 41.89, 12.48),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Campania', 'Naples', 5802000, 18000, 40.85, 14.27),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Sicily', 'Palermo', 5000000, 17200, 38.11, 13.36),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Veneto', 'Venice', 4906000, 33300, 45.44, 12.32),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Emilia-Romagna', 'Bologna', 4459000, 34700, 44.49, 11.34),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Piedmont', 'Turin', 4356000, 33000, 45.07, 7.69),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Tuscany', 'Florence', 3726000, 30800, 43.77, 11.26),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Apulia', 'Bari', 4029000, 18000, 41.12, 16.86),
    (uuid_generate_v4(), '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Calabria', 'Catanzaro', 1947000, 16800, 38.91, 16.59);


-- Japan 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kanto', 'Tokyo', 42970000, 40500, 35.68, 139.77),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kansai', 'Osaka', 22640000, 35500, 34.70, 135.50),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Chubu', 'Nagoya', 21810000, 37500, 35.18, 136.91),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kyushu', 'Fukuoka', 13030000, 30500, 33.60, 130.41),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Hokkaido', 'Sapporo', 5251000, 31000, 43.06, 141.35),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Tohoku', 'Sendai', 8690000, 30000, 38.26, 140.87),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Chugoku', 'Hiroshima', 7400000, 31000, 34.39, 132.46),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Shikoku', 'Matsuyama', 3720000, 29000, 33.84, 132.77),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Okinawa', 'Naha', 1430000, 29500, 26.21, 127.68),
    (uuid_generate_v4(), '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Niigata', 'Niigata', 2227000, 29000, 37.91, 139.02);


-- Germany 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'North Rhine-Westphalia', 'Dusseldorf', 17947000, 42000, 51.22, 6.77),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Bavaria', 'Munich', 13125000, 47500, 48.14, 11.58),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Baden-Württemberg', 'Stuttgart', 11100000, 46000, 48.77, 9.18),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Lower Saxony', 'Hanover', 8000000, 35000, 52.37, 9.73),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Hesse', 'Frankfurt', 6300000, 47000, 50.11, 8.68),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Saxony', 'Dresden', 4100000, 30000, 51.05, 13.73),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Rhineland-Palatinate', 'Mainz', 4100000, 36000, 49.99, 8.27),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Berlin', 'Berlin', 3700000, 37000, 52.52, 13.41),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Schleswig-Holstein', 'Kiel', 2900000, 32000, 54.32, 10.14),
    (uuid_generate_v4(), 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Hamburg', 'Hamburg', 1800000, 62000, 53.55, 9.99);


-- United Kingdom 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Greater London', 'London', 8900000, 50000, 51.51, -0.13),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Greater Manchester', 'Manchester', 2800000, 34000, 53.48, -2.24),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'West Midlands', 'Birmingham', 2900000, 27000, 52.48, -1.90),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'West Yorkshire', 'Leeds', 2300000, 27000, 53.80, -1.55),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Glasgow City', 'Glasgow', 620000, 32000, 55.86, -4.26),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Liverpool City Region', 'Liverpool', 1500000, 27000, 53.41, -2.98),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'South Hampshire', 'Southampton', 1500000, 31000, 50.91, -1.40),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Tyneside', 'Newcastle', 1100000, 29000, 54.98, -1.61),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Nottingham-Derby', 'Nottingham', 1500000, 27000, 52.95, -1.15),
    (uuid_generate_v4(), 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Sheffield', 'Sheffield', 1300000, 26000, 53.38, -1.47);