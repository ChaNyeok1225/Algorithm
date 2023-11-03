SELECT
DR_NAME,	DR_ID,	MCDP_CD	,
DATE_FORMAT(HIRE_YMD,'%Y-%m-%d') HIRE_YMD


from DOCTOR 

where 1=1
and MCDP_CD = 'CS' or MCDP_CD = 'GS'

order by HIRE_YMD desc, DR_NAME