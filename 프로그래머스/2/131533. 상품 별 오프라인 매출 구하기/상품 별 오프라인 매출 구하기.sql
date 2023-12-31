SELECT 
PRODUCT_CODE,
(a.price * sum(b.SALES_AMOUNT)) SALES


from
PRODUCT a
join
OFFLINE_SALE b
on
a.PRODUCT_ID = b.PRODUCT_ID

group by
a.PRODUCT_CODE

order by
SALES desc, PRODUCT_CODE

