CREATE TABLE IF NOT EXISTS `PROFILE1`(
    `id`          INTEGER PRIMARY KEY,
    `profilename`       VARCHAR(100) NOT NULL,
    `drivername`      VARCHAR(100) NOT NULL,
    `url`      VARCHAR(100) NOT NULL,
    `username`      VARCHAR(100) NOT NULL,
    `password`      VARCHAR(100) NOT NULL
);

--
--CREATE SET TABLE PROFILE1 (
--   id INTEGER,
--   profilename VARCHAR(30),
--   drivername VARCHAR(30),
--   url VARCHAR(30),
--   username1 VARCHAR(30),
--   password1 VARCHAR(30)
--)
--UNIQUE PRIMARY INDEX ( id );