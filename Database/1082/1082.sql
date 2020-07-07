# MySQL临时表不能够自联结

SELECT seller_id
FROM Sales
GROUP BY seller_id
HAVING SUM(price) >= ALL(
    SELECT SUM(price)
    FROM Sales
    GROUP BY seller_id
);
