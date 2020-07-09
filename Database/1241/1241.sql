SELECT s1.sub_id AS post_id,  COUNT(DISTINCT s2.sub_id) AS number_of_comments
FROM Submissions s1 LEFT JOIN Submissions s2
ON s1.sub_id = s2.parent_id
GROUP BY s1.sub_id, s1.parent_id
HAVING s1.parent_id IS NULL
ORDER BY s1.sub_id;
