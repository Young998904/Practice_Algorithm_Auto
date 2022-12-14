-- 코드를 입력하세요
SELECT AO.ANIMAL_ID, AO.ANIMAL_TYPE, AO.NAME
FROM ANIMAL_INS AS AI
RIGHT JOIN ANIMAL_OUTS AS AO
ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AO.SEX_UPON_OUTCOME NOT LIKE "Intact%"
AND AI.SEX_UPON_INTAKE LIKE "Intact%"
ORDER BY AO.ANIMAL_ID;