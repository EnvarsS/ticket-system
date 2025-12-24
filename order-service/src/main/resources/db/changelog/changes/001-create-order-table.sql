-- liquibase formatted sql
-- changeset envars:001

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    total_price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    user_id BIGINT
)