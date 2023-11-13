SELECT
car_id,
if(sum(
    (
    case
        when start_date <= '2022-10-16' and end_date >= '2022-10-16' then 1
        else 0
    end
    )
) >= 1, '대여중', '대여 가능') AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc