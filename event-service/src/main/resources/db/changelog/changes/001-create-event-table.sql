-- Liquibase formatted sql
--changeset envars:001

CREATE TABLE events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_capacity BIGINT NOT NULL,
    available_capacity BIGINT NOT NULL,
    date DATE NOT NULL,
    venue_id BIGINT NOT NULL
);

