-- SELECT s.product_id, SUM(quantity) AS total_quantity
-- FROM Sales s JOIN Product p USING (product_id)
-- GROUP BY s.product_id;

SELECT product_id, SUM(quantity) AS total_quantity
FROM Sales
GROUP BY product_id;
