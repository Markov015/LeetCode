-- SELECT buyer_id
-- FROM Product p Join Sales s USING (product_id)
-- GROUP BY buyer_id
-- HAVING COUNT(IF(product_name = 'S8', TRUE, NULL)) > 0
-- AND COUNT(IF(product_name = 'iPhone', TRUE, NULL)) = 0;

SELECT buyer_id
FROM Product p JOIN Sales s USING (product_id)
GROUP BY buyer_id
HAVING SUM(product_name = 'S8') > 0
AND SUM(product_name = 'iPhone') = 0;
