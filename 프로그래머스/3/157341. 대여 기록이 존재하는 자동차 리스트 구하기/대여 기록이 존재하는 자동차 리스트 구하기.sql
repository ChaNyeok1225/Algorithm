SELECT
distinct r.CAR_ID

from
CAR_RENTAL_COMPANY_CAR r
join
CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on r.CAR_ID = h.CAR_ID

where 1=1
and r.CAR_TYPE = '세단'
and h.START_DATE like "%-10-%"

order by
CAR_ID desc