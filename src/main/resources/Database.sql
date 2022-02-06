CREATE DATABASE IF NOT EXISTS temperaturestation;
CREATE TABLE IF NOT EXISTS temperaturestation.temperature (
	id INT NOT NULL,
    measure_timestamp TIMESTAMP NOT NULL,
    temperature DOUBLE,
    humidity DOUBLE,
    location varchar(50),
    PRIMARY KEY(id));