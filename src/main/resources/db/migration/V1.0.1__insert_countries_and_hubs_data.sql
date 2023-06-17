
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
    ('c249b4a4-89b4-4465-8a13-d96b110f4e6f', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Ontario', 'Toronto', 14733119, 51000, 43.70, -79.42),
    ('8ae4303c-5fc9-4b96-b2c2-9139d8e559df', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Quebec', 'Montreal', 8574571, 45000, 45.50, -73.57),
    ('f44530b4-dfe4-4091-a89c-6e3b47e18f20', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'British Columbia', 'Vancouver', 5147712, 44000, 49.28, -123.12),
    ('c5c73426-c8ab-4744-9af5-5a8438db6c45', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Alberta', 'Calgary', 4413146, 62000, 51.04, -114.07),
    ('9df8eb38-0a22-48b2-8db0-2d2b1e6d995e', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Manitoba', 'Winnipeg', 1377517, 43000, 49.90, -97.13),
    ('ae868a7d-7b97-4515-95e7-ead1d02ad4ed', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Saskatchewan', 'Saskatoon', 1181666, 60000, 52.13, -106.67),
    ('4e5f87f6-8cc5-41af-aad3-9b4da7b94782', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Nova Scotia', 'Halifax', 971395, 40000, 44.65, -63.57),
    ('98eae0b9-6746-4baf-b953-dfb50d8e75ea', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'New Brunswick', 'Fredericton', 779993, 39000, 45.96, -66.64),
    ('e94c3dcd-3a8a-4ccf-97db-b9f5f925df6e', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Newfoundland and Labrador', 'St. John''s', 522537, 57000, 47.56, -52.71),
    ('af3a803a-313b-46ff-b82d-2366e5a39494', 'e0a37794-5155-49c7-a8fe-30b8a9f75a6a', 'Prince Edward Island', 'Charlottetown', 158158, 39000, 46.23, -63.13);


-- USA 10 biggest industry hubs
INSERT INTO industry_hub (id, country_id, hub_name, main_city_nearby, population, gdp_per_capita, latitude, longitude)
VALUES
    ('3f6506e6-7f89-4912-b4b6-efb24b7cbb26', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'California', 'Los Angeles', 39538223, 74244, 34.05, -118.25),
    ('1ac64685-6439-4f18-8d36-5159c60a8de9', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Texas', 'Houston', 29145505, 64624, 29.76, -95.37),
    ('a1fc7842-9f11-4411-8ad7-20b9f19a4748', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Florida', 'Miami', 21538187, 48394, 25.76, -80.19),
    ('6e7f9ed7-b2a0-41e9-aa55-0f57c09ef9af', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'New York', 'New York City', 20201249, 93336, 40.71, -74.01),
    ('bb244ea0-8a13-4e3b-9cda-43c8c96ae57e', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Pennsylvania', 'Philadelphia', 13002700, 64656, 39.95, -75.16),
    ('d4ee2159-8a9a-40b0-bc5d-bf4a91d3b36e', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Illinois', 'Chicago', 12812508, 69344, 41.88, -87.63),
    ('b2f29739-7c84-45db-9856-61f811b7d669', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Ohio', 'Columbus', 11799448, 54533, 39.96, -82.99),
    ('4e5f6be5-2cb2-4f7b-b2c4-1c478fd6e13d', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Georgia', 'Atlanta', 10711908, 59126, 33.75, -84.39),
    ('44a8e2b2-5087-429d-a35d-0f97bc3f2bbd', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'North Carolina', 'Charlotte', 10687788, 53139, 35.23, -80.84),
    ('d39f5e0e-3e4f-4e8d-9e01-3584d60f9f7e', '0a378e53-1b96-4c78-9e9a-3a9783f14938', 'Michigan', 'Detroit', 10084442, 55430, 42.33, -83.04);
