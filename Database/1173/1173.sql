SELECT ROUND (
    (
        SELECT COUNT(*)
        FROM Delivery
        WHERE order_date = customer_pref_delivery_date
    )
    /
    COUNT(*) * 100,
    2
) AS immediate_percentage
FROM Delivery;

SELECT ROUND (
    SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END)
    /
    COUNT(*) * 100,
    2
) AS immediate_percentage
FROM Delivery;

# SUM(expr)
SELECT ROUND (
    SUM(order_date = customer_pref_delivery_date)
    /
    COUNT(*) * 100,
    2
) AS immediate_percentage
FROM Delivery;
