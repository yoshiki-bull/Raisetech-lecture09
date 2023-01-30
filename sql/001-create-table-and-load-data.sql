DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
  id int unsigned AUTO_INCREMENT COMMENT "映画ID",
  name VARCHAR(20) NOT NULL COMMENT "映画名",
  published_year int COMMENT "公開年",
  series VARCHAR(20) NOT NULL COMMENT "シリーズ",
  PRIMARY KEY(id)
 ) COMMENT="映画一覧";

INSERT INTO movies (name, published_year, series) VALUES ("Iron Man", 2008, "Iron man");
INSERT INTO movies (name, published_year, series) VALUES ("Iron Man 2", 2010, "Iron man");
INSERT INTO movies (name, published_year, series) VALUES ("Iron Man 3", 2013, "Iron man");
INSERT INTO movies (name, published_year, series) VALUES ("Spider-Man", 2002, "Spider-Man");
INSERT INTO movies (name, published_year, series) VALUES ("Spider-Man 2 ", 2004, "Spider-Man");
INSERT INTO movies (name, published_year, series) VALUES ("Spider-Man 3", 2007, "Spider-Man");