CREATE TABLE restaurant
(
    restaurant_id         SERIAL      NOT NULL,
    name            VARCHAR(32)       NOT NULL,
    PRIMARY KEY (restaurant_id),
    UNIQUE(name)
);
