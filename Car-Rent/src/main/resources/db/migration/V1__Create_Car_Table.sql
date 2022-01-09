CREATE TABLE car
(
     id                     INT(11)         NOT NULL AUTO_INCREMENT,
     car_model              VARCHAR(100)    NOT NULL,
     customer_name          VARCHAR(100)    DEFAULT NULL,
     rented_from            TIMESTAMP       DEFAULT NULL,
     rented_to              TIMESTAMP       DEFAULT NULL,
     created_date           TIMESTAMP       NOT NULL DEFAULT now(),
     modified_date          TIMESTAMP       NOT NULL DEFAULT now(),
     PRIMARY KEY (id)
)