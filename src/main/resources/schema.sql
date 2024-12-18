CREATE TABLE IF NOT EXISTS products
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    price INT NOT NULL,
    color VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(50) NOT NULL,
    production_date DATE NOT NULL,
    country VARCHAR(50) NOT NULL,
    in_stock BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS exchanges
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    base_currency VARCHAR(5) NOT NULL,
    target_currency VARCHAR(5) NOT NULL,
    rate DECIMAL(6) NOT NULL
);
