SELECT
USER_ID,	NICKNAME,	sum(Price) TOTAL_SALES

from
USED_GOODS_BOARD b
join 
USED_GOODS_USER u
on 
b.WRITER_ID = u.USER_ID

where 1=1
and STATUS = 'DONE'

group by
USER_ID

having
sum(Price) >= 700000

order by
TOTAL_SALES
