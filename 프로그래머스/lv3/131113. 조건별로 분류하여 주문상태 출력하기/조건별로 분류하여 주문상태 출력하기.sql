-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,"%Y-%m-%d"), (
    CASE 
    WHEN (OUT_DATE IS NULL) THEN '출고미정'
    WHEN (DATEDIFF(OUT_DATE, '2022-05-01') <= 0) THEN '출고완료'
    ELSE '출고대기'
    END
)
FROM FOOD_ORDER
ORDER BY ORDER_ID;