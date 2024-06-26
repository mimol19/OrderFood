CREATE TABLE food_order
(
    order_id            SERIAL     NOT NULL,
    order_number        VARCHAR(64)       NOT NULL,
    restaurant_id       INT         NOT NULL,
    customer_id         INT         NOT NULL,
    PRIMARY KEY (order_id),
    CONSTRAINT fk_order_restaurant
        FOREIGN KEY(restaurant_id)
            REFERENCES restaurant (restaurant_id),
    CONSTRAINT fk_order_customer
            FOREIGN KEY(customer_id)
                REFERENCES customer (customer_id)
);