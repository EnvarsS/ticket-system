-- liquibase formatted sql
-- changeset envars:004

UPDATE events SET price = 50.00 WHERE name = 'Rock Concert';
UPDATE events SET price = 100.00 WHERE name = 'Tech Conference';
UPDATE events SET price = 20.00 WHERE name = 'Art Exhibition';
UPDATE events SET price = 15.00 WHERE name = 'Food Festival';
UPDATE events SET price = 30.00 WHERE name = 'Comedy Show';
UPDATE events SET price = 25.00 WHERE name = 'Movie Premiere';