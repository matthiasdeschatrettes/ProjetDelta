DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

INSERT INTO users (username, email, password) VALUES
 ('bob', 'bobleponge@gmail.com', 'bob1'),
 ('mal', 'malodos@gmail.com', 'mal1'),
 ('sophie', 'sosolimperatrice@gmail.com', 'soso1');