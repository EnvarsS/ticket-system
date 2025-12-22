-- Liquibase formatted SQL
-- changeset envars:001
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('customer', 'admin', 'provider') NOT NULL DEFAULT 'customer'
)