CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N - 1;
    RETURN (
      SELECT Salary
      FROM Employee
      GROUP BY Salary
      ORDER BY Salary DESC
      -- LIMIT N, 1
      LIMIT 1 OFFSET N
    );
END

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT e1.Salary
        FROM Employee e1 JOIN Employee e2
        ON e1.Salary <= e2.Salary
        GROUP BY e1.Salary
        HAVING COUNT(DISTINCT e2.Salary) = N
    );
END
