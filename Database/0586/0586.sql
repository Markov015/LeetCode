# SubQuery
SELECT customer_number
FROM (
    SELECT customer_number, COUNT(order_number) AS order_count
    FROM orders
    GROUP BY customer_number
    ORDER BY order_count DESC
) AS t
LIMIT 1;

# Limit
SELECT customer_number
FROM orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;
