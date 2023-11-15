select MONTH(START_DATE) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    SELECT CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where date_format(START_DATE,'%Y-%m') between '2022-08' and '2022-10'
    group by CAR_ID
    having count(*) >= 5
    )
and date_format(START_DATE,'%Y-%m') between '2022-08' and '2022-10'
group by MONTH(START_DATE), CAR_ID
order by MONTH, CAR_ID desc
