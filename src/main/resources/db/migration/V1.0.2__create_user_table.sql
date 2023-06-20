CREATE TABLE users
(
    id           UUID PRIMARY KEY,
    name         TEXT,
    login        TEXT UNIQUE,
    password     TEXT,
    email        TEXT UNIQUE,
    phone_number TEXT,
    user_role    TEXT
);

INSERT INTO users (id, name, login, password, email, phone_number, user_role)
VALUES ('14d1002b-c70b-45b9-9853-cad4996716d7', 'steve', 'steve',
        '$2a$10$qdfOjiTOgiDCQ3tQ1KEKIOKbRhOUt23g1yVQhog0boRsmkXfZ2iUS', 'steve@steve.pl', '123456789', 'ADMIN');
INSERT INTO users (id, name, login, password, email, phone_number, user_role)
VALUES ('17c81852-6adb-44c0-a23f-06853653ee03', 'rumcajs', 'rumcajs',
        '$2a$10$rHkVVSqfoPvpeY92RvGRNOvVuU3ob0XZc1qnF6D5.k00cUFbd/I9S', 'rumcajs@r.pl', '123456789', 'CONTENT_VIEWER');
INSERT INTO users (id, name, login, password, email, phone_number, user_role)
VALUES ('2546940a-d66a-4a76-aa0d-f95bed600335', 'kamil', 'kamil',
        '$2a$10$.m83syP.WmNl9A4IGXlZ7uVNIGj7knNPZxSS.GD6wuTuY8pn6sU/i', 'kamil@k.pl', '123456780', 'CONTENT_MANAGER');
