SELECT 
a.APNT_NO,
p.PT_NAME,
a.PT_NO,
d.MCDP_CD,
d.DR_NAME,
a.APNT_YMD
from APPOINTMENT a
join PATIENT p on a.PT_NO = p.PT_NO
join  DOCTOR  d on d.DR_ID = a.MDDR_ID
where 1=1
and APNT_YMD like '2022-04-13%'
and a.MCDP_CD = 'CS'
and APNT_CNCL_YN = 'N'

order by APNT_YMD