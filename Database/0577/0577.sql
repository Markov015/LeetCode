# Write your MySQL query statement below

# Outer Join
SELECT
    Employee.name, Bonus.Bonus
FROM
    Employee LEFT OUTER JOIN Bonus
    ON Employee.empId = Bonus.empId
WHERE
    Bonus.bonus IS NULL OR Bonus.bonus < 1000;

# Outer Join + Where
SELECT name, Bonus
FROM Employee LEFT JOIN bonus
ON Employee.empId = Bonus.empId
WHERE bonus IS NULL OR bonus < 1000;
