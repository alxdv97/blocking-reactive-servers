CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, username VARCHAR(255), password VARCHAR(255));

DELETE FROM users;
INSERT INTO  users (username, password) VALUES ('testUsername', 'testPassword');