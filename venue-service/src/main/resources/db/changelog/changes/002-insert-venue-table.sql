-- liquibase formatted sql
-- changeset envars:004

INSERT INTO venues (id, name, capacity, address) VALUES
(1, 'Berlin Tech Arena', 1500, 'Alexanderplatz 1, Berlin'),
(2, 'Comedy Hall Mitte', 900, 'Friedrichstraße 45, Berlin'),
(3, 'Olympic Stadium', 60000, 'Olympischer Platz 3, Berlin'),
(4, 'City Food Park', 2000, 'Tempelhofer Feld, Berlin'),
(5, 'Grand Cinema Palace', 500, 'Kurfürstendamm 120, Berlin'),
(6, 'Modern Art Gallery', 400, 'Museuminsel 7, Berlin');
