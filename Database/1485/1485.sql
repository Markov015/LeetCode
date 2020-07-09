SELECT
    sell_date,
    COUNT(DISTINCT product) AS num_sold,
    GROUP_CONCAT(DISTINCT product ORDER BY product)
FROM Activities
GROUP BY sell_date
ORDER BY sell_date;
