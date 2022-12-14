-- 코드를 입력하세요
# SELECT P.ID, P.NAME, P.HOST_ID
# FROM PLACES AS P
# INNER JOIN (
#     SELECT HOST_ID
#     FROM PLACES
#     GROUP BY HOST_ID
#     HAVING COUNT(ID) >1
# ) AS SP
# ON P.HOST_ID = SP.HOST_ID
# ORDER BY P.ID;

# SELECT *
# FROM PLACES
# WHERE HOST_ID IN (
#     SELECT HOST_ID 
#     FROM PLACES
#     GROUP BY HOST_ID
#     HAVING COUNT(ID) > 1
# )
# ORDER BY ID;

SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES AS P
JOIN (
    SELECT HOST_ID, COUNT(ID) AS 'COUNT'
    FROM PLACES
    GROUP BY HOST_ID
) AS SP
ON P.HOST_ID = SP.HOST_ID
WHERE SP.COUNT > 1
ORDER BY P.ID;

# SELECT T1.ID, T1.NAME, T1.HOST_ID
# FROM PLACES T1 
# JOIN (
#     SELECT ID,HOST_ID,COUNT(*) AS 'COUNT' 
#     FROM PLACES 
#     GROUP BY HOST_ID
# ) T2 
# ON T1.HOST_ID = T2.HOST_ID 
# WHERE T2.COUNT > 1
# ORDER BY T1.ID