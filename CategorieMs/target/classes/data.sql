DROP TABLE IF EXISTS categorie;

CREATE TABLE categorie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL
);

INSERT INTO categorie (nom) VALUES
 ('manger'),
 ('dormir'),
 ('sport');