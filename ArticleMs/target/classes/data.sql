DROP TABLE IF EXISTS article;

CREATE TABLE article (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  contenu VARCHAR(250) NOT NULL,
  date INT NOT NULL,
  idcate INT NOT NULL,
  idcom INT NOT NULL,
  iduser INT NOT NULL
);

INSERT INTO article (contenu, date, idcate, idcom, iduser) VALUES
 ('a_vendre', 2020, 1, 1, 3),
 ('revision', 2020, 2, 2, 2),
 ('moto', 2019, 3, 3, 1);