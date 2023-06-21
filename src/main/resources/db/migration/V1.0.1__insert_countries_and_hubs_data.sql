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
    ('76d2394d-7d5f-41ad-8935-22c0a13b0c90', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Ontario', 'Toronto', 14733119, 51000, 43.70, -79.42),
    ('bcefc400-d2cd-486e-bcaf-3ce4051dcab3', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Quebec', 'Montreal', 8574571, 45000, 45.50, -73.57),
    ('1f47cf6b-1140-4293-9625-27395a320608', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'British Columbia', 'Vancouver', 5147712, 44000, 49.28, -123.12),
    ('8910267e-e715-4d5f-afb8-6ff4ccb0a6b5', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Alberta', 'Calgary', 4413146, 62000, 51.04, -114.07),
    ('d581493b-08e3-4bf9-b111-b799bebfa321', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Manitoba', 'Winnipeg', 1377517, 43000, 49.90, -97.13),
    ('762a6c28-42ff-4a57-af6a-fe4a91bdf0a2', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Saskatchewan', 'Saskatoon', 1181666, 60000, 52.13, -106.67),
    ('e1fd9943-2916-4c29-9444-4573ff41bc5e', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Nova Scotia', 'Halifax', 971395, 40000, 44.65, -63.57),
    ('d9dda3e6-2336-424d-814e-f35b1bf3db2d', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'New Brunswick', 'Fredericton', 779993, 39000, 45.96, -66.64),
    ('7da190a2-2f5c-405a-a808-6fa01d34e35f', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Newfoundland and Labrador', 'St. John''s', 522537, 57000, 47.56, -52.71),
    ('f619ed70-24d4-4fae-812d-0399e0a28404', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Prince Edward Island', 'Charlottetown', 158158, 39000, 46.23, -63.13);


-- USA 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('f87189fe-79cb-427d-a246-69395c24f925', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'California', 'Los Angeles', 39538223, 74244, 34.05, -118.25),
    ('6e574d46-0c5c-4230-a42d-84bef2cb8b15', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Texas', 'Houston', 29145505, 59413, 29.76, -95.37),
    ('bdc7f1c8-680d-4c94-aa43-949764d14aba', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'New York', 'New York City', 20201249, 89814, 40.71, -74.01),
    ('6e853327-8984-4091-acd4-94e27ded1c85', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Florida', 'Miami', 21538187, 50431, 25.76, -80.19),
    ('a70381cd-9676-48d1-aa71-e24bea44ca5c', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Illinois', 'Chicago', 12812508, 65997, 41.88, -87.63),
    ('8464f673-94d7-49b6-817d-8ef9a55cba20', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Pennsylvania', 'Philadelphia', 13011844, 57658, 39.95, -75.16),
    ('9a55c83f-acfd-4c1c-9bb4-f8f3893e6998', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Ohio', 'Columbus', 11808848, 55295, 39.96, -82.99),
    ('9d0869c2-2180-479e-b788-a414a2c8ce7d', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Georgia', 'Atlanta', 10736100, 55679, 33.74, -84.39),
    ('e1100ac3-7001-4034-8787-d4bd891faaf3', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'North Carolina', 'Charlotte', 10600823, 52118, 35.22, -80.84),
    ('1d2229a8-f189-41d1-b7c0-2f66d9f162ba', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Michigan', 'Detroit', 10045029, 48358, 42.33, -83.04);


-- Italy 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('d24d7430-ef17-4559-a1e2-d410ae754bd8', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Lombardy', 'Milan', 10060000, 39900, 45.46, 9.19),
    ('93a25ffb-949a-4e06-95af-07a4aa566c00', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Lazio', 'Rome', 5879000, 34100, 41.89, 12.48),
    ('9319b936-bc3e-4dfe-8197-2862a9434b42', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Campania', 'Naples', 5802000, 18000, 40.85, 14.27),
    ('83ea52e0-49a5-4295-a9d6-175cf0b6cadd', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Sicily', 'Palermo', 5000000, 17200, 38.11, 13.36),
    ('4fa036eb-1271-47a5-9033-6e9d20f7136c', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Veneto', 'Venice', 4906000, 33300, 45.44, 12.32),
    ('69ddcd68-569b-42ba-a3b2-1b0a86ab4be1', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Emilia-Romagna', 'Bologna', 4459000, 34700, 44.49, 11.34),
    ('572bd4f1-04b9-45b1-8231-4bb23b57c33d', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Piedmont', 'Turin', 4356000, 33000, 45.07, 7.69),
    ('b66375d5-635d-436f-9c97-083f82cdf59c', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Tuscany', 'Florence', 3726000, 30800, 43.77, 11.26),
    ('c195c01e-33b2-4d21-b5f7-13baa5a1f105', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Apulia', 'Bari', 4029000, 18000, 41.12, 16.86),
    ('f39a3dc1-3741-4eb9-8a93-aa256212ed9a', '6f79ee8d-a5bb-4b40-85a9-2a9e538f3b69', 'Calabria', 'Catanzaro', 1947000, 16800, 38.91, 16.59);


-- Japan 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('b3791f01-1bd6-4a1f-a928-c31b6b7bf383', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kanto', 'Tokyo', 42970000, 40500, 35.68, 139.77),
    ('c9185011-d47b-4ed2-87e3-5564c2e9d34f', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kansai', 'Osaka', 22640000, 35500, 34.70, 135.50),
    ('763423d5-34b9-4e5c-9245-88e14f40df2c', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Chubu', 'Nagoya', 21810000, 37500, 35.18, 136.91),
    ('b3a151d5-ea66-4266-a631-357c1e85e416', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Kyushu', 'Fukuoka', 13030000, 30500, 33.60, 130.41),
    ('75e441f2-e007-478c-b923-8d4c62386d79', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Hokkaido', 'Sapporo', 5251000, 31000, 43.06, 141.35),
    ('3ab48c78-1dcf-4e57-8475-34a88f95e8c2', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Tohoku', 'Sendai', 8690000, 30000, 38.26, 140.87),
    ('93b7811c-6b01-4c47-96d9-b8ee87c11f58', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Chugoku', 'Hiroshima', 7400000, 31000, 34.39, 132.46),
    ('c75f0d21-91bc-457d-8fa5-d2f0e8343018', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Shikoku', 'Matsuyama', 3720000, 29000, 33.84, 132.77),
    ('103c0507-20a0-46ef-b25f-f92a968e2f64', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Okinawa', 'Naha', 1430000, 29500, 26.21, 127.68),
    ('d99d3ff4-2b72-4589-be2b-da2b6486eb04', '15dd15a7-95ed-4f69-ba9c-756c646ff4ff', 'Niigata', 'Niigata', 2227000, 29000, 37.91, 139.02);


-- Germany 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('b937912c-c7d8-4e36-9be6-e96efa6df788', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'North Rhine-Westphalia', 'Dusseldorf', 17947000, 42000, 51.22, 6.77),
    ('2556b8c9-195a-4901-bd17-0725b7c07716', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Bavaria', 'Munich', 13125000, 47500, 48.14, 11.58),
    ('ea004534-4b5b-43f0-b3ee-4e6414f5415d', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Baden-Württemberg', 'Stuttgart', 11100000, 46000, 48.77, 9.18),
    ('e612f2e1-a391-44a5-a15a-ac2a8be40513', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Lower Saxony', 'Hanover', 8000000, 35000, 52.37, 9.73),
    ('124f2483-f094-4552-9948-dd70037dc3db', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Hesse', 'Frankfurt', 6300000, 47000, 50.11, 8.68),
    ('62b0e912-06b4-4af4-8a2a-cd7dc8d5541c', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Saxony', 'Dresden', 4100000, 30000, 51.05, 13.73),
    ('7c8732bb-786a-43cf-b39e-e0a4b356cd32', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Rhineland-Palatinate', 'Mainz', 4100000, 36000, 49.99, 8.27),
    ('a85fbcec-49db-4217-9d66-303641ff6a43', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Berlin', 'Berlin', 3700000, 37000, 52.52, 13.41),
    ('d31715a8-9c3a-47e2-81d7-e1621500e2da', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Schleswig-Holstein', 'Kiel', 2900000, 32000, 54.32, 10.14),
    ('54172f37-5a32-4e3f-910a-e472a79ca202', 'a312b756-0d23-44a8-9b77-7a9fe0a40b4d', 'Hamburg', 'Hamburg', 1800000, 62000, 53.55, 9.99);


-- United Kingdom 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('461c1983-67cf-4311-9a7e-771118587ccd', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Greater London', 'London', 8900000, 50000, 51.51, -0.13),
    ('487a0b94-4a0f-42c0-9db8-ef031a715bbd', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Greater Manchester', 'Manchester', 2800000, 34000, 53.48, -2.24),
    ('24dba9c3-4316-4311-8049-8c30a911e612', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'West Midlands', 'Birmingham', 2900000, 27000, 52.48, -1.90),
    ('47802ea2-7eea-4cf7-8c2a-b2119b048aa0', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'West Yorkshire', 'Leeds', 2300000, 27000, 53.80, -1.55),
    ('078931a1-c5eb-42ec-8ff2-0a25c07d592f', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Glasgow City', 'Glasgow', 620000, 32000, 55.86, -4.26),
    ('1eadf618-0f09-40a9-a42f-d11c32c68b79', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Liverpool City Region', 'Liverpool', 1500000, 27000, 53.41, -2.98),
    ('52a54015-bd23-4065-bea0-12da3cd751ec', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'South Hampshire', 'Southampton', 1500000, 31000, 50.91, -1.40),
    ('e56849f0-1ca8-47d1-b499-583b1f4f2a41', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Tyneside', 'Newcastle', 1100000, 29000, 54.98, -1.61),
    ('7b8bf349-977d-4b3d-89f9-9898dc2edc40', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Nottingham-Derby', 'Nottingham', 1500000, 27000, 52.95, -1.15),
    ('8d7d8d6e-833d-486e-85a8-2d2d895a4bcf', 'f7ac26de-0bf4-47e1-b1c1-2c1f03d2bd9f', 'Bristol City Region', 'Bristol', 700000, 30000, 51.45, -2.58);
