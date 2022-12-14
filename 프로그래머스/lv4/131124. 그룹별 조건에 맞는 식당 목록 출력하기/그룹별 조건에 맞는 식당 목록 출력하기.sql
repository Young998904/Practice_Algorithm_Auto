# -- 코드를 입력하세요
# SELECT MP.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d")
# FROM MEMBER_PROFILE AS MP
# JOIN (
#     SELECT RR.MEMBER_ID, REVIEW_TEXT, REVIEW_DATE
#     FROM REST_REVIEW AS RR
#     JOIN (
#         SELECT MEMBER_ID
#         FROM REST_REVIEW
#         GROUP BY MEMBER_ID
#         ORDER BY COUNT(REVIEW_ID) DESC
#         LIMIT 1
#     ) AS RRR
#     ON RR.MEMBER_ID = RRR.MEMBER_ID
# ) AS R
# ON MP.MEMBER_ID = R.MEMBER_ID
# ORDER BY REVIEW_DATE, REVIEW_TEXT;

SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d')
FROM MEMBER_PROFILE AS MP
JOIN REST_REVIEW AS RR
ON MP.MEMBER_ID = RR.MEMBER_ID
WHERE MP.MEMBER_ID = (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(MEMBER_ID) DESC
    LIMIT 1
)
ORDER BY REVIEW_DATE, REVIEW_TEXT;