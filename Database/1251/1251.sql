SELECT product_id, ROUND(SUM(units * price) / SUM(units), 2) AS average_price
FROM Prices JOIN UnitsSold USING (product_id)
WHERE purchase_date >= start_date AND purchase_date <= end_date
GROUP BY product_id;
