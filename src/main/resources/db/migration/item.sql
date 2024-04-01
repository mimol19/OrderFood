CREATE TABLE item
(
    item_id         SERIAL      NOT NULL,
    quantity        INT         NOT NULL,
    order_id        INT         NOT NULL,
    meal_id         INT         NOT NULL,
    PRIMARY KEY (item_id),
    CONSTRAINT fk_item_order
            FOREIGN KEY(order_id)
                REFERENCES food_order (order_id),
    CONSTRAINT fk_order_meal
            FOREIGN KEY(meal_id)
                REFERENCES meal (meal_id)
);