-- 코드를 입력하세요
# SELECT * 
# FROM ( 
#    SELECT *, RANK() OVER (PARTITION BY M.CATEGORY ORDER BY M.TITLE DESC, M.ID DESC) AS RN  
#    FROM BOARD AS M 
# ) AS RANKING
# WHERE RANKING.RN <= 3

# SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
# FROM (
#     SELECT *, RANK() OVER (PARTITION BY RI.FOOD_TYPE ORDER BY RI.FAVORITES DESC) AS RRI
#     FROM REST_INFO AS RI
# ) AS RANKING
# WHERE RANKING.RRI <= 1
# ORDER BY FOOD_TYPE DESC;

# select ri.food_type, ri.rest_id, ri.rest_name, ri.favorites
# from rest_info as ri
# join (select food_type, max(favorites) as 'maxfavor'
#       from rest_info
#       group by food_type
#      ) as mr
# on ri.food_type = mr.food_type and ri.favorites = mr.maxfavor
# order by ri.food_type desc

# select food_type, max(favorites) as 'maxfavor'
# from rest_info
# group by food_type;

SELECT RI.FOOD_TYPE, RI.REST_ID, RI.REST_NAME, RI.FAVORITES
FROM REST_INFO AS RI
INNER JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS MAXLITE
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS RM
ON RI.FOOD_TYPE = RM.FOOD_TYPE AND RI.FAVORITES = RM.MAXLITE
ORDER BY FOOD_TYPE DESC;