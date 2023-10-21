SELECT
floor(Price / 10000) * 10000 PRICE_GROUP,
count(*) PRODUCTS

from Product

group by
floor(PRICE / 10000)

order by
PRICE_GROUP