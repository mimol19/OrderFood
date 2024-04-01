CREATE TABLE address
(
    address_id         SERIAL      NOT NULL,
    name            VARCHAR(64) NOT NULL,
    number          INT         NOT NULL,
    PRIMARY KEY (address_id)
);