-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, (SUM(SALES_AMOUNT) * P.PRICE) AS SALES
FROM PRODUCT AS P
LEFT JOIN OFFLINE_SALE AS O
ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE ASC;