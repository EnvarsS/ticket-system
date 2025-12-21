-- liquibase formatted sql
-- changeset envars:003

ALTER TABLE events
ADD COLUMN price DECIMAL(10, 2) NOT NULL DEFAULT 0.00;