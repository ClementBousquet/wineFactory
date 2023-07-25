INSERT INTO address
(street, city, state, postalcode, country)
VALUES('12 Chemin de la victoire', 'Toulouse', 'Occitanie', '31000', 'France');

INSERT INTO address
(street, city, state, postalcode, country)
VALUES('24 Rue du lila', 'Bordeaux', 'Nouvelle-Aquitaine', '33000', 'France');

INSERT INTO producer
("name", fk_id_address)
VALUES('Vins de Toulouse', 0);

INSERT INTO producer
("name", fk_id_address)
VALUES('Maison Bordeaux', 1);

INSERT INTO wine
("name", "year", volume, color)
VALUES('Chateau des jacobins 2019', '2019', 12.5, 'Rouge');

INSERT INTO wine
("name", "year", volume, color)
VALUES('Chateau des jacobins 2020', '2020', 12.5, 'Rouge');

INSERT INTO wine
("name", "year", volume, color)
VALUES('Chateau des jacobins 2021', '2021', 12.5, 'Rouge');

INSERT INTO wine
("name", "year", volume, color)
VALUES('Chateau TOLOSA', '2021', 10.0, 'Blanc');
