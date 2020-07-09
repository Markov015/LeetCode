SELECT product_name, SUM(unit) AS unit
FROM Products JOIN Orders USING (product_id)
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
GROUP BY product_id
HAVING SUM(UNIT) >= 100
ORDER BY product_name;

SELECT product_name, SUM(unit) AS unit
FROM Products JOIN Orders USING (product_id)
WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY product_name
HAVING unit >= 100;

SELECT product_name, SUM(unit) AS unit
FROM Products JOIN Orders USING (product_id)
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
GROUP BY product_name
HAVING unit >= 100;

SELECT product_name, SUM(unit) AS unit
FROM Products JOIN Orders USING (product_id)
WHERE order_date LIKE '2020-02-%'
GROUP BY product_name
HAVING unit >= 100;

SELECT product_name, SUM(unit) AS unit
FROM Products JOIN Orders USING (product_id)
WHERE order_date REGEXP '^2020-02-[:digit:]{2}$'
GROUP BY product_name
HAVING unit >= 100;
