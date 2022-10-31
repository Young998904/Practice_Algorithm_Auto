-- 코드를 입력하세요
# SELECT *
# FROM ONLINE_SALE AS OS
# JOIN (
#     SELECT *
#     FROM OFFLINE_SALE
#     WHERE MONTH(SALES_DATE) = 3
# ) AS OFF
# ON OS.PRODUCT_ID = OFF.PRODUCT_ID 
# AND OS.SALES_DATE = OFF.SALES_DATE
# WHERE MONTH(OS.SALES_DATE) = 3
# ORDER BY OS.SALES_DATE;

# SELECT OS.SALES_DATE, OS.PRODUCT_ID, OS.USER_ID, OS.SALES_AMOUNT
# FROM ONLINE_SALE AS OS
# LEFT JOIN (
#     SELECT *
#     FROM OFFLINE_SALE
#     WHERE MONTH(SALES_DATE) = 3
# ) AS OFF
# ON OS.PRODUCT_ID = OFF.PRODUCT_ID
# AND OS.SALES_DATE = OFF.SALES_DATE
# WHERE MONTH(OS.SALES_DATE) = 3
# ORDER BY OS.SALES_DATE ASC, OS.PRODUCT_ID ASC, OS.USER_ID ASC;

# SELECT 
# DATE_FORMAT(OS.SALES_DATE, "%Y-%m-%d"), OS.PRODUCT_ID, OS.USER_ID, 
# (IF(OS.sales_amount IS NULL, 0, OS.sales_amount) + IF(OFF.sales_amount IS NULL, 0, OFF.sales_amount)) AS SALES_AMOUNT
# FROM ONLINE_SALE AS OS
# LEFT JOIN (
#     SELECT *
#     FROM OFFLINE_SALE
#     WHERE MONTH(SALES_DATE) = 3
# ) AS OFF
# ON OS.SALES_DATE = OFF.SALES_DATE
# AND OS.PRODUCT_ID = OFF.PRODUCT_ID
# WHERE MONTH(OS.SALES_DATE) = 3
# ORDER BY OS.SALES_DATE, OS.PRODUCT_ID, OS.USER_ID;

SELECT date_format(sales_date, "%Y-%m-%d") as sales_date, product_id, user_id, sales_amount
from online_sale
where MONTH(sales_date) = 3
union
select date_format(sales_date, "%Y-%m-%d") as sales_date, product_id, NULL as user_id, sales_amount
from offline_sale
where MONTH(sales_date) = 3
order by sales_date asc, product_id asc, user_id asc;