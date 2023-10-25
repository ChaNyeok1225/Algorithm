SELECT
NAME,	DATETIME

from
ANIMAL_INS 

where 1=1
and ANIMAL_ID not in (
    select ANIMAL_ID
    from ANIMAL_OUTS 
)

order by
DATETIME

limit 3