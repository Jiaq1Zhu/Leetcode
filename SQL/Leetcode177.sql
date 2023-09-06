CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N-1;
    RETURN (
        SELECT DISTINCT(salary) FROM EMPLOYEE order by salary DESC
        LIMIT 1 OFFSETS N
    )
;
END