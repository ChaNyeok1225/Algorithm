select 
HISTORY_ID,
round(DAILY_FEE *
(DATEDIFF(end_date, start_date) + 1)
* (100 - 
case 
 when DATEDIFF(end_date, start_date) + 1>= 90 then 
 (select DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
where CAR_TYPE = '트럭' and duration_type = '90일 이상' )
 when DATEDIFF(end_date, start_date) + 1>= 30 then 
 (select DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
where CAR_TYPE = '트럭' and duration_type = '30일 이상' )
 when DATEDIFF(end_date, start_date) + 1>= 7 then 
 (select DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
where CAR_TYPE = '트럭' and duration_type = '7일 이상' )
 else 0
 end
)/100) FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY join (
    SELECT CAR_ID, DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE = '트럭'
) a
using (CAR_ID)
order by FEE desc, HISTORY_ID desc

