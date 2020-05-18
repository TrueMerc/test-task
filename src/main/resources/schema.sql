CREATE TABLE CAR (
    id                IDENTITY PRIMARY KEY,
    brand             VARCHAR2(150),
    model             VARCHAR2(200),
    power             DOUBLE,
    year_of_issue     YEAR
);

CREATE TABLE AIRPLANE (
    id                IDENTITY PRIMARY KEY,
    brand             VARCHAR2(150),
    model             VARCHAR2(200),
    manufacturer      VARCHAR2(500),
    year_of_issue     YEAR,
    fuelCapacity      INT,
    seats             INT
);

CREATE TABLE ASSESSMENT (
    id                IDENTITY PRIMARY KEY,
    date_time         TIMESTAMP,
    value             DEC(20)
);

CREATE TABLE CARS_ASSESSMENTS(
    car_id            BIGINT,
    assessment_id     BIGINT,

    PRIMARY KEY (car_id, assessment_id),

    CONSTRAINT fk_car_id FOREIGN KEY (car_id)
    REFERENCES CAR (id)
    ON DELETE CASCADE ON UPDATE NO ACTION,

    CONSTRAINT  fk_assessment_id FOREIGN KEY (assessment_id)
    REFERENCES ASSESSMENT (id)
    ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE  PLAINS_ASSESSMENTS(
    airplane_id       BIGINT,
    assessment_id     BIGINT,

    PRIMARY KEY (airplane_id, assessment_id),

    CONSTRAINT fk_plane_id_01 FOREIGN KEY (airplane_id)
    REFERENCES AIRPLANE (id)
    ON DELETE CASCADE ON UPDATE NO ACTION
);