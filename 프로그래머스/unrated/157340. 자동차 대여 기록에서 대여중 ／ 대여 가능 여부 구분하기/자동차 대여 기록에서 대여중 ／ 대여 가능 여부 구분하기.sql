SELECT CAR_ID, if(sum(`AVAILABILITY`) = COUNT(*), "대여 가능", "대여중") `AVAILABILITY`

from
(
SELECT 
`CAR_ID`, 
case
when start_date <= '2022-10-16' and '2022-10-16' <= end_date then false
else true
end

`AVAILABILITY`
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
) a

group by CAR_ID
order by
`CAR_ID` desc;
