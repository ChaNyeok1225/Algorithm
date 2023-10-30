SELECT CATEGORY, PRICE MAX_PRICE,	PRODUCT_NAME

from FOOD_PRODUCT 

where CATEGORY in ( '과자', '국', '김치', '식용유')
and (CATEGORY, PRICE) in (
    select CATEGORY, max(PRICE) PRICE
    from FOOD_PRODUCT
    group by CATEGORY
)
order by
MAX_PRICE desc