# Self Join
SELECT e1.employee_id, COUNT(*) AS team_size
FROM Employee e1 JOIN Employee e2 USING (team_id)
GROUP BY e1.employee_id
ORDER BY e1.employee_id;

# Correlated Subquery 
SELECT employee_id, (
    SELECT COUNT(*)
    FROM employee e2
    WHERE e1.team_id = e2.team_id
) AS team_size
FROM Employee e1
ORDER BY e1.employee_id;

# Window Function
SELECT
    employee_id,
    COUNT(employee_id) OVER(PARTITION BY team_id) AS team_size
FROM Employee
ORDER BY employee_id;
