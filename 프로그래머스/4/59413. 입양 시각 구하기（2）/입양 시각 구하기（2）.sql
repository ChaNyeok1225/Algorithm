WITH RECURSIVE tmp AS (
    SELECT 0 AS num
    UNION ALL
    SELECT num+1
    FROM tmp
    WHERE num < 23
)

SELECT tmp.num HOUR, IFNULL(a.COUNT, 0) COUNT
FROM tmp
LEFT JOIN (SELECT HOUR(datetime) HOUR, COUNT(*) COUNT
           FROM animal_outs
           GROUP BY HOUR(datetime)
           ORDER BY HOUR(datetime)) a
ON tmp.num = a.HOUR;