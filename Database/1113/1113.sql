SELECT extra AS report_reason, COUNT(DISTINCT post_id) AS report_count
FROM (
    SELECT action, extra, post_id
    FROM Actions
    WHERE action = 'report'
    AND DATEDIFF('2019-07-05', action_date) = 1
) AS t
GROUP BY report_reason;
