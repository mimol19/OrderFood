CREATE TABLE restaurant
(
    restaurant_id         SERIAL      NOT NULL,
    name            VARCHAR(32)       NOT NULL,
    email           VARCHAR(32)       NOT NULL,
    owner_name        VARCHAR(32)     NOT NULL,
    owner_surname     VARCHAR(32)     NOT NULL,
    PRIMARY KEY (restaurant_id)
);