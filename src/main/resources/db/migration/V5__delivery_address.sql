CREATE TABLE delivery_address
(
    delivery_address_id  SERIAL      NOT NULL,
    address_id           INT         NOT NULL,
    restaurant_id        INT         NOT NULL,
    PRIMARY KEY (delivery_address_id),
        CONSTRAINT fk_delivery_address_address
            FOREIGN KEY(address_id)
                REFERENCES address (address_id ),
        CONSTRAINT fk_delivery_address_restaurant
            FOREIGN KEY(restaurant_id)
                REFERENCES restaurant (restaurant_id)

);