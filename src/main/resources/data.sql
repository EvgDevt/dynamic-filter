-- Insert 1: Smartphone
INSERT INTO products (name, price, color, manufacturer, production_date, country, in_stock)
VALUES ('iPhone 13', 799, 'Silver', 'Apple', '2022-03-15', 'USA', true),
       ('Dell XPS 15', 1499, 'Black', 'Dell', '2023-01-20', 'USA', true),
       ('Sony WH-1000XM4', 349, 'Navy Blue', 'Sony', '2022-11-05', 'Japan', true),
       ('Samsung Galaxy Watch 5', 279, 'Graphite', 'Samsung', '2022-08-10', 'South Korea', false),
       ('iPad Pro 12.9"', 1099, 'Space Gray', 'Apple', '2023-02-01', 'USA', true),
       ('PlayStation 5', 499, 'White', 'Sony', '2022-12-12', 'Japan', true),
       ('AirPods Pro', 249, 'White', 'Apple', '2023-04-05', 'USA', true),
       ('Amazon Echo Dot', 49, 'Charcoal', 'Amazon', '2022-09-18', 'USA', false),
       ('Canon EOS R6', 2499, 'Black', 'Canon', '2022-06-25', 'Japan', true),
       ('Anker PowerWave', 29, 'Black', 'Anker', '2023-05-12', 'China', true);

INSERT INTO exchanges (base_currency, target_currency, rate)
VALUES ('USD', 'EUR', 0.86),
       ('USD', 'RUB', 103.6),
       ('USD', 'KZT', 524.9);