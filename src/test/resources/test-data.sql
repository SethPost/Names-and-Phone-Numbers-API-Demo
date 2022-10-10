BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(22) UNIQUE NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (name, phone_number) VALUES ('Seth Post', '3308073006');
INSERT INTO users (name, phone_number) VALUES ('John Doe', '1234567890');
insert into users (name, phone_number) values ('Fitz Stitcher', '2148997923');
insert into users (name, phone_number) values ('Darcy McInulty', '5992296329');
insert into users (name, phone_number) values ('Lenka Rathe', '1747607603');
insert into users (name, phone_number) values ('Nisse Fenix', '1672149430');
insert into users (name, phone_number) values ('Roddie Boram', '1639135476');
insert into users (name, phone_number) values ('Jo-anne Danher', '2052230194');
insert into users (name, phone_number) values ('Cilka Haddacks', '5583741538');
insert into users (name, phone_number) values ('Gordie Keer', '8676980371');
insert into users (name, phone_number) values ('Meridel Lisimore', '4593496211');
insert into users (name, phone_number) values ('Haleigh Glyde', '4849390042');
insert into users (name, phone_number) values ('Casi MacCole', '5726680400');
insert into users (name, phone_number) values ('Heidie Standbrooke', '2956751121');
insert into users (name, phone_number) values ('Deni Mengue', '6504430702');
insert into users (name, phone_number) values ('Daisi Pleasance', '4859276479');
insert into users (name, phone_number) values ('Kendal Grayne', '5975013292');
insert into users (name, phone_number) values ('Laural Gallaway', '5637845571');
insert into users (name, phone_number) values ('Lynett Ales0', '8707998856');
insert into users (name, phone_number) values ('Venus Greim', '7937725635');
insert into users (name, phone_number) values ('Janith Puddephatt', '7624979702');
insert into users (name, phone_number) values ('Tod Pidgeley', '1625930932');
insert into users (name, phone_number) values ('Maximilien Willbond', '8782211085');
insert into users (name, phone_number) values ('Luise McMennum', '4646623900');
insert into users (name, phone_number) values ('Ansel Pinilla', '6478438473');
insert into users (name, phone_number) values ('Pia Beagin', '6852209891');
insert into users (name, phone_number) values ('Bernice McFall', '6909421930');
insert into users (name, phone_number) values ('Sukey Oldroyde', '6568469842');
insert into users (name, phone_number) values ('Sibelle Klimentyonok', '7029454682');
insert into users (name, phone_number) values ('Christoph Bengough', '3059303778');
insert into users (name, phone_number) values ('Gillian Oger', '5481532153');
insert into users (name, phone_number) values ('Orin Bearblock', '1502526360');
insert into users (name, phone_number) values ('Lydie Lared', '3418824713');
insert into users (name, phone_number) values ('Willette Biasini', '6319469654');
insert into users (name, phone_number) values ('Chandal Debold', '5248075377');
insert into users (name, phone_number) values ('Willow Rosekilly', '9204978017');
insert into users (name, phone_number) values ('Emilio Yakunikov', '1392135743');
insert into users (name, phone_number) values ('Britt Adolf', '4872260688');
insert into users (name, phone_number) values ('Jerrilyn Brereton', '2911799019');
insert into users (name, phone_number) values ('Yorker Moxham', '8021860660');
insert into users (name, phone_number) values ('Eberhard Hasted', '5241875315');
insert into users (name, phone_number) values ('Cori Pocknell', '1988644436');
insert into users (name, phone_number) values ('Teodora Dullaghan', '7322440636');
insert into users (name, phone_number) values ('Veronica Hucker', '5741998195');
insert into users (name, phone_number) values ('Addy Littrik', '3899635231');
insert into users (name, phone_number) values ('Brenn McGaughie', '7173221114');
insert into users (name, phone_number) values ('Bastian Brosoli', '4374262524');
insert into users (name, phone_number) values ('Diann Krelle', '3195044558');
insert into users (name, phone_number) values ('Antony Darnbrook', '7271402866');
insert into users (name, phone_number) values ('Ellary Castlake', '3334853837');
insert into users (name, phone_number) values ('Allina Sayle', '2734922658');

COMMIT TRANSACTION;