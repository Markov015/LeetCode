SELECT s1.sale_date, s1.sold_num - s2.sold_num AS diff
FROM Sales s1 JOIN Sales s2
WHERE s1.sale_date = s2.sale_date
    AND s1.fruit = 'apples' AND s2.fruit = 'oranges'
ORDER BY s1.sale_date;
