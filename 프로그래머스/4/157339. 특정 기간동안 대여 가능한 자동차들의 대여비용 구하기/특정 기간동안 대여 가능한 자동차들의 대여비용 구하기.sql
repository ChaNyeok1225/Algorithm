SELECT
t.CAR_ID,	t.CAR_TYPE,
round(t.daily_fee * 30 * ((100-d.DISCOUNT_RATE) / 100)) FEE
from (
    select *
    from CAR_RENTAL_COMPANY_CAR 
    where 1=1
    and CAR_TYPE in ('세단', 'SUV')
    and CAR_ID not in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where 1=1
        and START_DATE <= '2022-11-30'
        and END_DATE >= '2022-11-01'
    )
) t
join (
    select CAR_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where DURATION_TYPE like '30%'
) d
on t.CAR_TYPE = d.CAR_TYPE
where round(t.daily_fee * 30 * ((100-d.DISCOUNT_RATE) / 100)) between 500000 and 2000000
order by FEE desc, CAR_TYPE, CAR_ID desc