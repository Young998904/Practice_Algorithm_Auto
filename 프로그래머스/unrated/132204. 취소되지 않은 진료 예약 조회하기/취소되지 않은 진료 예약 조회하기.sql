# -- 코드를 입력하세요
# SELECT APNT_NO, PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, APNT_YMD
# FROM PATIENT AS P
# LEFT JOIN (
#     SELECT APNT_NO, APNT_YMD, MDDR_ID, PT_NO, MCDP_CD
#     FROM APPOINTMENT
#     WHERE MCDP_CD = 'CS'
#     AND DATE(APNT_YMD) = '2022-04-13'
#     AND APNT_CNCL_YN = 'N'
# ) AS A
# ON A.PT_NO = P.PT_NO
# LEFT JOIN DOCTOR AS D
# ON D.DR_ID = A.MDDR_ID
# WHERE APNT_NO IS NOT NULL
# ORDER BY APNT_NO;

# SELECT *
# FROM APPOINTMENT
# WHERE MCDP_CD = 'CS'
# AND APNT_CNCL_YN = 'N'
# APNT_NO, PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, APNT_YMD

SELECT APNT_NO, PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, APNT_YMD
FROM PATIENT AS P
JOIN (
    SELECT *
    FROM APPOINTMENT
    WHERE MCDP_CD = 'CS'
    AND DATE(APNT_YMD) = '2022-04-13'
    AND APNT_CNCL_YN = 'N'
) AS A
USING (PT_NO)
LEFT JOIN DOCTOR AS D
ON A.MDDR_ID = D.DR_ID
ORDER BY APNT_YMD;