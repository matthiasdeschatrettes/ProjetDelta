DROP TABLE IF EXISTS commentaire;

CREATE TABLE commentaire (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  text VARCHAR(250) NOT NULL,
  date INT NOT NULL,
  iduser INT NOT NULL
);

INSERT INTO commentaire (text, date, iduser) VALUES
 ('j_adore_le_codage', 2019, 1),
 ('vive_les_exams', 2020, 2),
 ('j_adore_les_sushis', 2019, 3);