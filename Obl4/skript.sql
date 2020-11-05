DROP SCHEMA IF EXISTS obl4 CASCADE;
CREATE SCHEMA obl4;
SET search_path = obl4;

CREATE TABLE deltager (
	fornavn VARCHAR,
	etternavn VARCHAR,
	mobil VARCHAR,
	passord VARCHAR,
	kjonn VARCHAR
);
