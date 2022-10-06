BEGIN TRANSACTION;

INSERT INTO users (name, phone_number) VALUES ('Seth Post', '3308073006');
INSERT INTO users (name, phone_number) VALUES ('John Doe', '1234567890');

COMMIT TRANSACTION;