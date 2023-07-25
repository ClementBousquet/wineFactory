CREATE SEQUENCE IF NOT EXISTS id_address_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS address
(
    id int4 NOT NULL DEFAULT nextval('id_address_seq'::regclass),
    street varchar NOT NULL,
    city varchar NOT NULL,
    state varchar NOT NULL,
    postalCode varchar NOT NULL,
    country varchar NOT NULL,
    CONSTRAINT pk_id_address PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS id_producer_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS producer
(
    id int4 NOT NULL DEFAULT nextval('id_producer_seq'::regclass),
    name varchar NOT NULL,
    fk_id_address int4 NOT NULL,
    CONSTRAINT pk_id_producer PRIMARY KEY(id)
);

ALTER TABLE producer
    ADD CONSTRAINT fk_producer_idaddress FOREIGN KEY (fk_id_address) REFERENCES address (id);

CREATE SEQUENCE IF NOT EXISTS id_wine_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS wine
(
    id int4 NOT NULL DEFAULT nextval('id_wine_seq'::regclass),
    name varchar NOT NULL,
    year varchar NULL,
    volume float NULL CHECK (volume > 0),
    color varchar NULL CHECK (color IN ('Rouge', 'Blanc', 'Rose')),
    CONSTRAINT pk_id_wine PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS id_site_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS site
(
    id int4 NOT NULL DEFAULT nextval('id_site_seq'::regclass),
    name varchar NOT NULL,
    url varchar NULL,
    CONSTRAINT pk_id_site PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS id_price_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS price
(
    id int4 NOT NULL DEFAULT nextval('id_price_seq'::regclass),
    amount float NOT NULL CHECK (amount > 0),
    date date NOT NULL,
    fk_id_wine int4 NOT NULL,
    fk_id_site int4 NOT NULL,
    CONSTRAINT pk_id_price PRIMARY KEY(id)
);

ALTER TABLE price
    ADD CONSTRAINT fk_price_idwine FOREIGN KEY (fk_id_wine) REFERENCES wine (id);
ALTER TABLE price
    ADD CONSTRAINT fk_price_idsite FOREIGN KEY (fk_id_site) REFERENCES site (id);

CREATE SEQUENCE IF NOT EXISTS id_client_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS client
(
    id int4 NOT NULL DEFAULT nextval('id_client_seq'::regclass),
    email varchar NULL,
    firstname varchar NULL,
    lastname varchar NULL,
    phone_number varchar NULL,
    CONSTRAINT pk_id_client PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS id_review_seq
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS review
(
    id int4 NOT NULL DEFAULT nextval('id_review_seq'::regclass),
    rating float NOT NULL CHECK (rating > 0),
    comment varchar NULL,
    fk_id_user int4 NOT NULL,
    fk_id_wine int4 NOT NULL,
    CONSTRAINT pk_id_review PRIMARY KEY(id)
);

ALTER TABLE review
    ADD CONSTRAINT fk_review_idclient FOREIGN KEY (fk_id_user) REFERENCES client (id);
ALTER TABLE review
    ADD CONSTRAINT fk_price_idwine FOREIGN KEY (fk_id_wine) REFERENCES wine (id);

