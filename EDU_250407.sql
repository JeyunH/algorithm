-- ���� �� �������� ����
SELECT OUTBOUND_DATE, INVOICE_NO, OUT_TYPE_DIV
  FROM LO_OUT_M
 WHERE INVOICE_NO = (
                     SELECT MAX(INVOICE_NO)
                       FROM LO_OUT_D
                      WHERE ITEM_NM LIKE '% ȣ����'
                        AND ORDER_QTY = 10
                    );

-- ���� �� �������� ����
SELECT OUTBOUND_DATE
          ,INVOICE_NO
          ,OUT_TYPE_DIV
      FROM LO_OUT_M
     WHERE INVOICE_NO IN (
                          SELECT INVOICE_NO
                            FROM LO_OUT_D
                           WHERE ITEM_NM   LIKE '% ȣ����'
                             AND ORDER_QTY = 10
                         );

-- ���� Į�� �������� ����
SELECT OUTBOUND_DATE, INVOICE_NO, OUT_TYPE_DIV
FROM LO_OUT_M
WHERE (INVOICE_NO, OUT_TYPE_DIV) IN (
                                     SELECT INVOICE_NO, OUT_TYPE_DIV_D
                                     FROM LO_OUT_D
                                     WHERE ITEM_NM LIKE '%ȣ����'
                                     AND ORDER_QTY > 100
                                     );

-- IN�� ����� ���� �������� ����
    SELECT OUTBOUND_DATE
          ,INVOICE_NO
          ,OUT_TYPE_DIV
      FROM LO_OUT_M M1
     WHERE M1.OUTBOUND_DATE = TO_DATE('20190903', 'YYYY-MM-DD')
       AND M1.INVOICE_NO IN (SELECT S1.INVOICE_NO
                             FROM LO_OUT_D S1
                             WHERE S1.INVOICE_NO = M1.INVOICE_NO
                             AND S1.ORDER_QTY  > 100
                            );

-- EXISTS�� ����� ���� �������� ����
SELECT OUTBOUND_DATE
          ,INVOICE_NO
          ,OUT_TYPE_DIV
      FROM LO_OUT_M M1
     WHERE M1.OUTBOUND_DATE = TO_DATE('20190903', 'YYYY-MM-DD')
       AND EXISTS (SELECT 1
                   FROM LO_OUT_D S1
                   WHERE S1.INVOICE_NO = M1.INVOICE_NO
                   AND S1.ORDER_QTY  > 100
                  );

-- ��Į�� ���� ����
SELECT M1.INVOICE_NO
      ,M1.ITEM_CD
      ,(
        SELECT S1.ITEM_NM
        FROM A_ITEM S1
        WHERE S1.BRAND_CD = '1001'
        AND S1.ITEM_CD = 'A'
        ) AS ITEM_NM
      , M1.ORDER_QTY
FROM A_OUT_D M1
WHERE M1.BRAND_CD = '1001';
-------------------------------------------------------------
--DAY.6 ��������/��Į������
--11������
--1�� ����
SELECT *
  FROM A_OUT_D
 WHERE (BRAND_CD, INVOICE_NO) IN (
                                SELECT BRAND_CD, INVOICE_NO
                                FROM A_OUT_M
                                WHERE OUTBOUND_DATE = '23/01/03'
                                );

--2�� ����
SELECT *
  FROM A_OUT_D
 WHERE (BRAND_CD, INVOICE_NO) IN (
                                SELECT BRAND_CD, INVOICE_NO
                                FROM A_OUT_M
                                WHERE OUT_TYPE_DIV LIKE 'M1%'
                                  AND BRAND_CD = '1001'
                                );

--3�� ����
SELECT *
  FROM A_OUT_M
 WHERE (BRAND_CD, INVOICE_NO) IN (
                                SELECT BRAND_CD, INVOICE_NO, ORDER_QTY
                                FROM A_OUT_D
                                WHERE ORDER_QTY>=3
                                GROUP BY BRAND_CD, INVOICE_NO
                                )
ORDER BY BRAND_CD, INVOICE_NO;

--12������
--1�� ����
SELECT BRAND_CD
      ,(
        SELECT ITEM_NM
          FROM A_ITEM A1
         WHERE A1.BRAND_CD = D1.BRAND_CD
           AND A1.INVOICE_NO = D1.INVOICE_NO
       )
      ,SUM(ORDER_QTY)
  FROM A_OUT_D D1
 GROUP BY BRAND_CD, ITEM_CD
 ORDER BY BRAND_CD, ITEM_CD;




