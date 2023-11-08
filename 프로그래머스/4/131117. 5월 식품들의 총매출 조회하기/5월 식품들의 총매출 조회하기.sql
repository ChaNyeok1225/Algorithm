SELECT
f.PRODUCT_ID,	PRODUCT_NAME,
total * price TOTAL_SALES

from FOOD_PRODUCT f
join (
    select PRODUCT_ID, sum(AMOUNT) total
    from FOOD_ORDER 
    where PRODUCE_DATE like "2022-05%"
    group by PRODUCT_ID
) o
on f.PRODUCT_ID = o.PRODUCT_ID

order by TOTAL_SALES desc, PRODUCT_ID