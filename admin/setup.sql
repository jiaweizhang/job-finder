
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id       SERIAL PRIMARY KEY  NOT NULL,
  email         VARCHAR(255) UNIQUE NOT NULL,
  passhash      VARCHAR(255)        NOT NULL DEFAULT ''
);

