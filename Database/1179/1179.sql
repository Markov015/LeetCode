SELECT
    id,
    SUM(CASE WHEN month = 'Jan' THEN revenue ELSE NULL END) AS Jan_Revenue,
    SUM(CASE WHEN month = 'Feb' THEN revenue ELSE NULL END) AS Feb_Revenue,
    SUM(CASE WHEN month = 'Mar' THEN revenue ELSE NULL END) AS Mar_Revenue,
    SUM(CASE WHEN month = 'Apr' THEN revenue ELSE NULL END) AS Apr_Revenue,
    SUM(CASE WHEN month = 'May' THEN revenue ELSE NULL END) AS May_Revenue,
    SUM(CASE WHEN month = 'Jun' THEN revenue ELSE NULL END) AS Jun_Revenue,
    SUM(CASE WHEN month = 'Jul' THEN revenue ELSE NULL END) AS Jul_Revenue,
    SUM(CASE WHEN month = 'Aug' THEN revenue ELSE NULL END) AS Aug_Revenue,
    SUM(CASE WHEN month = 'Sep' THEN revenue ELSE NULL END) AS Sep_Revenue,
    SUM(CASE WHEN month = 'Oct' THEN revenue ELSE NULL END) AS Oct_Revenue,
    SUM(CASE WHEN month = 'Nov' THEN revenue ELSE NULL END) AS Nov_Revenue,
    SUM(CASE WHEN month = 'Dec' THEN revenue ELSE NULL END) AS Dec_Revenue
FROM  Department
GROUP BY id;

SELECT
    id,
    SUM(CASE month WHEN 'Jan' THEN revenue ELSE NULL END) AS Jan_Revenue,
    SUM(CASE month WHEN 'Feb' THEN revenue ELSE NULL END) AS Feb_Revenue,
    SUM(CASE month WHEN 'Mar' THEN revenue ELSE NULL END) AS Mar_Revenue,
    SUM(CASE month WHEN 'Apr' THEN revenue ELSE NULL END) AS Apr_Revenue,
    SUM(CASE month WHEN 'May' THEN revenue ELSE NULL END) AS May_Revenue,
    SUM(CASE month WHEN 'Jun' THEN revenue ELSE NULL END) AS Jun_Revenue,
    SUM(CASE month WHEN 'Jul' THEN revenue ELSE NULL END) AS Jul_Revenue,
    SUM(CASE month WHEN 'Aug' THEN revenue ELSE NULL END) AS Aug_Revenue,
    SUM(CASE month WHEN 'Sep' THEN revenue ELSE NULL END) AS Sep_Revenue,
    SUM(CASE month WHEN 'Oct' THEN revenue ELSE NULL END) AS Oct_Revenue,
    SUM(CASE month WHEN 'Nov' THEN revenue ELSE NULL END) AS Nov_Revenue,
    SUM(CASE month WHEN 'Dec' THEN revenue ELSE NULL END) AS Dec_Revenue
FROM  Department
GROUP BY id;
