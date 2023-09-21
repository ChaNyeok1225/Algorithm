SELECT A.`CAR_ID`,	A.`CAR_TYPE`,	
floor((daily_fee * (100-DISCOUNT_RATE)/100 * 30 )) `FEE`

from CAR_RENTAL_COMPANY_CAR A 
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN B
on A.`CAR_TYPE` = B.`CAR_TYPE`

where 1=1
and floor((daily_fee * (100-DISCOUNT_RATE)/100 * 30 )) between 500000 and 2000000
and (DURATION_TYPE = "30일 이상")
and (A.`CAR_TYPE` = "세단" or A.`CAR_TYPE` = "SUV")
and A.`CAR_ID` not in 
(
    SELECT 
    distinct `CAR_ID`
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where  start_date <= '2022-11-30'
        and end_date >= '2022-11-01'
)

order by `FEE` desc, `CAR_TYPE`, `CAR_ID` desc

# # select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# # where car_id = 27

    # SELECT 
    # distinct `CAR_ID`
    # from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    # where  start_date <= '2022-11-30'
    #     and end_date >= '2022-11-01'