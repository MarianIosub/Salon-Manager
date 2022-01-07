DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;


CREATE TABLE CLIENTI
(
    ID            INT PRIMARY KEY NOT NULL,
    NUME          TEXT            NOT NULL,
    PRENUME       TEXT            NOT NULL,
    SEX           TEXT            NOT NULL,
    VARSTA        INT             NOT NULL,
    NUMAR_TELEFON INT             NOT NULL
);
CREATE TABLE FURNIZORI
(
    ID           INT PRIMARY KEY NOT NULL,
    NUME         TEXT            NOT NULL,
    ADRESA_SEDIU TEXT            NOT NULL
);
CREATE TABLE SERVICII
(
    ID         INT PRIMARY KEY NOT NULL,
    DENUMIRE   TEXT            NOT NULL,
    DURATA_ORE INT             NOT NULL
);
CREATE TABLE PRODUSE
(
    ID            INT PRIMARY KEY NOT NULL,
    DENUMIRE      TEXT            NOT NULL,
    FIRMA         TEXT            NOT NULL,
    STOC          INT             NOT NULL,
    DATA_EXPIRARE DATE             NOT NULL
);
CREATE TABLE CATEGORII_PRODUSE
(
    ID       INT PRIMARY KEY NOT NULL,
    DENUMIRE TEXT            NOT NULL
);
CREATE TABLE USTENSILE
(
    ID       INT PRIMARY KEY NOT NULL,
    DENUMIRE TEXT            NOT NULL,
    FIRMA    TEXT            NOT NULL,
    ELECTRIC BOOLEAN         NOT NULL
);
CREATE TABLE ANGAJATI
(
    ID            INT PRIMARY KEY NOT NULL,
    NUME          TEXT            NOT NULL,
    PRENUME       TEXT            NOT NULL,
    SEX           TEXT            NOT NULL,
    VARSTA        INT             NOT NULL,
    DATA_ANGAJARE DATE            NOT NULL
);
CREATE TABLE INCASARI
(
    ID            INT PRIMARY KEY NOT NULL,
    SUMA          INT             NOT NULL,
    DATA_INCASARE DATE            NOT NULL
);
CREATE TABLE SALARII
(
    ID           INT PRIMARY KEY NOT NULL,
    SUMA         INT             NOT NULL,
    DATA_SALARIU DATE            NOT NULL,
    TIP_PLATA    TEXT            NOT NULL
);
CREATE TABLE PROGRAMARI
(
    ID                   INT PRIMARY KEY NOT NULL,
    DATA_PROGRAMARE      DATE            NOT NULL,
    POSIBILITATE_ANULARE BOOLEAN         NOT NULL
);

