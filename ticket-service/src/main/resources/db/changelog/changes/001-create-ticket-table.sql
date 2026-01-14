-- Liquibase formatted SQL
-- changeset envars:001

CREATE TABLE tickets (
    id BINARY(16) PRIMARY KEY,
    order_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL
);