-- liquibase formatted sql
--changeset envars:002

INSERT INTO events (name, total_capacity, available_capacity, date, venue_id)
VALUES
('Rock Concert', 5000, 5000, '2026-03-15', 3),
('Tech Conference', 1200, 1200, '2026-04-20', 1),
('Art Exhibition', 300, 300, '2026-05-05', 6),
('Food Festival', 1500, 1500, '2026-06-10', 4),
('Comedy Show', 800, 800, '2026-07-01', 2),
('Movie Premiere', 400, 400, '2026-08-12', 5);
