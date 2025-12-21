-- liquibase formatted sql
-- changeset envars:001

CREATE TABLE venues (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    address VARCHAR(255) NOT NULL
);
