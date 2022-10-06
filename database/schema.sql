BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    phone_number CHARACTER(10) UNIQUE,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

COMMIT TRANSACTION;