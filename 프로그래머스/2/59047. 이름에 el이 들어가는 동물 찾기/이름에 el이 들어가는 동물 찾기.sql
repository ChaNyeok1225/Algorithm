SELECT
ANIMAL_ID,	NAME
from ANIMAL_INS

where 1=1
and ANIMAL_TYPE = 'Dog'
and NAME like '%el%'

order by NAME