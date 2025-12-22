--Liquibase formatted SQL
--changeset envars:002

INSERT INTO users (name, email, role) VALUES
('Alice Johnson', 'alice.johnson@example.com', 'customer'),
('Bob Smith', 'bob.smith@example.com', 'customer'),
('Charlie Brown', 'charlie.brown@example.com', 'customer'),
('Diana Miller', 'diana.miller@example.com', 'admin'),
('Edward Wilson', 'edward.wilson@example.com', 'admin'),
('Fiona Clark', 'fiona.clark@example.com', 'provider'),
('George Harris', 'george.harris@example.com', 'provider'),
('Helen Turner', 'helen.turner@example.com', 'customer'),
('Ivan Petrov', 'ivan.petrov@example.com', 'customer'),
('Julia Roberts', 'julia.roberts@example.com', 'provider');
