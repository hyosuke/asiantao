SELECT
t1.USER_NM AS USER_NM
FROM M_USER t1
WHERE NOT EXISTS(
SELECT
'X'
FROM SCHEDULE t2
WHERE
t2.SELECT_MONTH = /*selectMonth*/'12'
AND
t2.FIRST_FG = /*firstFg*/'1'
AND
t1.USER_ID = t2.USER_ID
)
AND
t1.USER_ID <> 'asiantao'
