SELECT s1.parent_id AS post_id, DISTINCT s2.sub_id
FROM Submissions s1 LEFT JOIN Submissions s2
ON s1.parent_id = NULL
AND s1.sub_id = s2.parent_id
GROUP BY s1.parent_id
ORDER BY s1.parent_id;
