CREATE SCHEMA IF NOT EXISTS Dagligvare_DB;

INSERT INTO delivery (delivery_date, from_warehouse, destination)
VALUES ('2020-01-01', 'Oslo', 'Bergen');

INSERT INTO product (name, price, weight)
VALUES ('Milk', 20, 1.0);

INSERT INTO product_order (product_id, delivery_id, quantity)
VALUES (1, 1, 10);

INSERT INTO van (brand, model, capacity)
VALUES ('Ford', 'Transit', 1000);