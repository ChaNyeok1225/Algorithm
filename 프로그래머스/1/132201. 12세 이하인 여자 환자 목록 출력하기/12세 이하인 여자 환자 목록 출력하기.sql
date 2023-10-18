SELECT
PT_NAME,
PT_NO,
GEND_CD,
AGE,
ifnull(TLNO, 'NONE') TLNO


from
PATIENT 


where 1=1
and AGE <= 12
and GEND_CD = 'W'

order by
AGE desc, PT_NAME