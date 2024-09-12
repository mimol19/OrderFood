CREATE TABLE order_food_role
(
    role_id SERIAL      NOT NULL,
    role    VARCHAR(20) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE order_food_user
(
    user_id   SERIAL        NOT NULL,
    user_name VARCHAR(32)   NOT NULL,
    restaurant_id         INT     ,
    role_id      INT  NOT NULL,
    email     VARCHAR(32)   NOT NULL,
    password  VARCHAR(128)  NOT NULL,
    active    BOOLEAN       NOT NULL,
    PRIMARY KEY (user_id),
      UNIQUE (user_name),
      UNIQUE (email),
          CONSTRAINT fk_user_restaurant
            FOREIGN KEY (restaurant_id)
            REFERENCES restaurant (restaurant_id),
          CONSTRAINT fk_user_role
             FOREIGN KEY (role_id)
             REFERENCES order_food_role (role_id)
);

INSERT INTO order_food_role (role) VALUES ('RESTAURANT');
INSERT INTO order_food_role (role) VALUES ('CUSTOMER');

--CREATE TABLE users (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    username VARCHAR(50) NOT NULL,
--    password VARCHAR(100) NOT NULL,
--    enabled BOOLEAN NOT NULL,
--    restaurant_id INT,
--    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
--);

--CREATE TABLE order_food_role
--(
--    role_id SERIAL      NOT NULL,
--    role    VARCHAR(20) NOT NULL,
--    PRIMARY KEY (role_id)
--);
--
--CREATE TABLE order_food_user_role
--(
--    user_id   INT      NOT NULL,
--    role_id   INT      NOT NULL,
--    PRIMARY KEY (user_id, role_id),
--    CONSTRAINT fk_order_food_user_role_user
--        FOREIGN KEY (user_id)
--            REFERENCES order_food_user (user_id),
--    CONSTRAINT fk_order_food_user_role_role
--        FOREIGN KEY (role_id)
--            REFERENCES order_food_role (role_id)
--);
