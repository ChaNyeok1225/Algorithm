SELECT
ANIMAL_ID,	NAME,
date_format(DATETIME, '%Y-%m-%d') 날짜
from ANIMAL_INS
order by ANIMAL_ID