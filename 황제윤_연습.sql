
-- SQL ��ݱ� ��
-- 1�� ����
SELECT TO_CHAR(OUTBOUND_DATE,'YYYY-MM') AS OUT_DATE
      ,COUNT(*) AS INV_CNT
      ,SUM(SET_QTY) AS SET_QTY
  FROM LO_OUT_M
 WHERE OUTBOUND_DATE BETWEEN '19/06/01' AND '19/08/31'
 GROUP BY TO_CHAR(OUTBOUND_DATE,'YYYY-MM')
 ORDER BY OUT_DATE;

-- 2�� ����
SELECT *
FROM(
     SELECT M1.OUT_TYPE_DIV, SUM(D1.ORDER_QTY) AS SUM_QTY
     FROM LO_OUT_M M1
          JOIN LO_OUT_D D1 ON D1.INVOICE_NO = M1.INVOICE_NO
     WHERE M1.OUTBOUND_DATE = '19/09/03'
       AND M1.OUT_TYPE_DIV LIKE 'M1%'
     GROUP BY M1.OUT_TYPE_DIV
     HAVING SUM(D1.ORDER_QTY) >= 5000
     ORDER BY SUM_QTY
     )
UNION ALL
SELECT *
FROM(
     SELECT M1.OUT_TYPE_DIV, SUM(D1.ORDER_QTY) AS SUM_QTY
     FROM LO_OUT_M M1
          JOIN LO_OUT_D D1 ON D1.INVOICE_NO = M1.INVOICE_NO
     WHERE M1.OUTBOUND_DATE = '19/09/03'
       AND M1.OUT_TYPE_DIV LIKE 'M2%'
     GROUP BY M1.OUT_TYPE_DIV
     HAVING SUM(D1.ORDER_QTY) >= 5000
     ORDER BY SUM_QTY DESC
     );

-- �̰� ���� ����̳�
SELECT M1.OUT_TYPE_DIV, SUM(D1.ORDER_QTY) AS SUM_QTY
  FROM LO_OUT_M M1
       JOIN LO_OUT_D D1 ON D1.INVOICE_NO = M1.INVOICE_NO
 WHERE M1.OUTBOUND_DATE = '19/09/03'
   AND (M1.OUT_TYPE_DIV LIKE 'M1%'
    OR  M1.OUT_TYPE_DIV LIKE 'M2%')
 GROUP BY M1.OUT_TYPE_DIV
HAVING SUM(D1.ORDER_QTY) >= 5000
 ORDER BY CASE WHEN OUT_TYPE_DIV LIKE 'M1%' THEN SUM(D1.ORDER_QTY)
               WHEN OUT_TYPE_DIV LIKE 'M2%' THEN -SUM(D1.ORDER_QTY) END DESC;


-- 3�� ����
SELECT OUT_DATE, ITE_CD, ITEM_NM, SUM_QTY
FROM(
     SELECT E2.*, CASE WHEN ROWNUM >1 THEN ROWNUM ELSE 999 END AS NUM
     FROM (
           SELECT OUT_DATE, ITE_CD, ITEM_NM, SUM(SUM_QTY) AS SUM_QTY
           FROM (
                 SELECT CASE WHEN ROWNUM <= 10 THEN TO_CHAR(OUT_DATE)
                        ELSE 'ETC' END AS OUT_DATE,
                        CASE WHEN ROWNUM <= 10 THEN ITE_CD
                        ELSE NULL END AS ITE_CD,
                        CASE WHEN ROWNUM <= 10 THEN ITEM_NM
                        ELSE NULL END AS ITEM_NM
                        ,SUM_QTY
                   FROM(
                        SELECT M1.OUTBOUND_DATE AS OUT_DATE, D1.ITEM_CD AS ITE_CD, D1.ITEM_NM, SUM(D1.ORDER_QTY) AS SUM_QTY
                        FROM LO_OUT_D D1
                             JOIN LO_OUT_M M1 ON M1.INVOICE_NO = D1.INVOICE_NO
                        WHERE M1.OUTBOUND_DATE BETWEEN '19/06/01' AND '19/06/30'
                          AND D1.ITEM_NM LIKE '%��ġ%'
                        GROUP BY M1.OUTBOUND_DATE, D1.ITEM_CD, D1.ITEM_NM
                        ORDER BY SUM_QTY DESC
                       )
                  )
           GROUP BY OUT_DATE, ITE_CD, ITEM_NM
           ORDER BY SUM_QTY DESC
           ) E2
     )
ORDER BY NUM;


SELECT OUT_DATE, ITEM_CD, ITEM_NM, SUM(SUM_QTY) AS SUM_QTY
FROM(
     SELECT CASE WHEN ROWNUM <= 10 THEN TO_CHAR(OUTBOUND_DATE) 
                 ELSE 'ETC' 
            END AS OUT_DATE
            ,CASE WHEN ROWNUM <= 10 THEN ITEM_CD 
                 ELSE ' '
            END AS ITEM_CD
            ,CASE WHEN ROWNUM <= 10 THEN ITEM_NM
                 ELSE ' '
            END AS ITEM_NM
            ,SUM_QTY
     FROM(
          SELECT M1.OUTBOUND_DATE, D1.ITEM_CD, D1.ITEM_NM, SUM(D1.ORDER_QTY) AS SUM_QTY
          
          FROM LO_OUT_D D1
               JOIN LO_OUT_M M1 ON M1.INVOICE_NO = D1.INVOICE_NO
                               AND M1.OUTBOUND_DATE BETWEEN '19/06/01' AND '19/06/30'
          WHERE ITEM_NM LIKE '%��ġ%'
          GROUP BY M1.OUTBOUND_DATE, D1.ITEM_CD, D1.ITEM_NM
          ORDER BY SUM_QTY DESC
          ) E1
    )
GROUP BY OUT_DATE, ITEM_CD, ITEM_NM
ORDER BY CASE WHEN OUT_DATE = 'ETC' THEN 0
              ELSE SUM_QTY
         END DESC
;

-- 4�� ����
-- 4-1
SELECT '2��' AS DANSU, '2x' || LEVEL || '=' || TO_CHAR(2*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '3��' AS DANSU, '3x' || LEVEL || '=' || TO_CHAR(3*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '4��' AS DANSU, '4x' || LEVEL || '=' || TO_CHAR(4*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '5��' AS DANSU, '5x' || LEVEL || '=' || TO_CHAR(5*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '6��' AS DANSU, '6x' || LEVEL || '=' || TO_CHAR(6*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '7��' AS DANSU, '7x' || LEVEL || '=' || TO_CHAR(7*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '8��' AS DANSU, '8x' || LEVEL || '=' || TO_CHAR(8*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9
UNION ALL
SELECT '9��' AS DANSU, '9x' || LEVEL || '=' || TO_CHAR(9*LEVEL) AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 9;

-- 4-2
SELECT  CASE WHEN TRUNC((LEVEL-1)/9) = 0 THEN '2��' 
             WHEN TRUNC((LEVEL-1)/9) = 1 THEN '3��'
             WHEN TRUNC((LEVEL-1)/9) = 2 THEN '4��'
             WHEN TRUNC((LEVEL-1)/9) = 3 THEN '5��'
             WHEN TRUNC((LEVEL-1)/9) = 4 THEN '6��'
             WHEN TRUNC((LEVEL-1)/9) = 5 THEN '7��'
             WHEN TRUNC((LEVEL-1)/9) = 6 THEN '8��'
             WHEN TRUNC((LEVEL-1)/9) = 7 THEN '9��'
        END AS DANSU
       ,CASE WHEN TRUNC((LEVEL-1)/9) = 0 THEN '2x' || MOD((LEVEL),10) || '=' || TO_CHAR(2*MOD((LEVEL),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 1 THEN '3x' || MOD((LEVEL+1),10) || '=' || TO_CHAR(3*MOD((LEVEL+1),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 2 THEN '4x' || MOD((LEVEL+2),10) || '=' || TO_CHAR(4*MOD((LEVEL+2),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 3 THEN '5x' || MOD((LEVEL+3),10) || '=' || TO_CHAR(5*MOD((LEVEL+3),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 4 THEN '6x' || MOD((LEVEL+4),10) || '=' || TO_CHAR(6*MOD((LEVEL+4),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 5 THEN '7x' || MOD((LEVEL+5),10) || '=' || TO_CHAR(7*MOD((LEVEL+5),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 6 THEN '8x' || MOD((LEVEL+6),10) || '=' || TO_CHAR(8*MOD((LEVEL+6),10)) 
             WHEN TRUNC((LEVEL-1)/9) = 7 THEN '9x' || MOD((LEVEL+7),10) || '=' || TO_CHAR(9*MOD((LEVEL+7),10)) 
        END AS CONTENTS
FROM DUAL
CONNECT BY LEVEL <= 72;

-- �̰� �����̳�
SELECT TO_CHAR(N1.NO) || '��' AS DANSU
      ,TO_CHAR(N1.NO)||'x'||TO_CHAR(N2.NO)||'='||TO_CHAR(N1.NO*N2.NO) AS CONTENTS
  FROM CS_NO N1
       JOIN CS_NO N2 ON N2.NO <10
 WHERE N1.NO BETWEEN 2 AND 9;


          
           
-- 5�� ����
SELECT CASE TO_NUMBER(:SCHOOL) 
            WHEN 1 THEN '�ʵ�' 
            WHEN 2 THEN '��'
            WHEN 3 THEN '���'
       END || '�б� ' || NO ||'�г�' AS SCHOOL
      ,TO_NUMBER(TO_CHAR(TO_DATE(:BIRTHDAY,'YYYY-MM-DD'),'YYYY')) 
       + NO 
       + CASE TO_NUMBER(:SCHOOL) 
              WHEN 1 THEN 6
              WHEN 2 THEN 12
              WHEN 3 THEN 15
         END AS YEAR
FROM CS_NO
WHERE NO <= CASE TO_NUMBER(:SCHOOL)
                 WHEN 1 THEN 6
                 ELSE 3
            END;
