CREATE TABLE users (
	id			UUID			NOT NULL	PRIMARY KEY,
	cpf			VARCHAR(11)		NOT NULL	UNIQUE,
	name		VARCHAR(100)	NOT NULL
);

CREATE TABLE roles (
	id			INTEGER			NOT NULL	PRIMARY KEY	AUTO_INCREMENT,
	role		VARCHAR(20)		NOT NULL	UNIQUE
);

CREATE TABLE permissions (
	id			INTEGER			NOT NULL	PRIMARY KEY	AUTO_INCREMENT,
	permission	VARCHAR(30)		NOT NULL	UNIQUE
);

