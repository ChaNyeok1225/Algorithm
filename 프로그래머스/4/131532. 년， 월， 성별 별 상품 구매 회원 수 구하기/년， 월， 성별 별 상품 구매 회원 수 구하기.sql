SELECT
YEAR(sales_date) YEAR, MONTH(sales_date) MONTH, GENDER, count(distinct u.USER_ID) USERS

from USER_INFO u
join ONLINE_SALE o
on u.USER_ID = o.USER_ID

where GENDER is not null

GROUP BY
YEAR(sales_date), MONTH(sales_date), GENDER

order by
YEAR(sales_date), MONTH(sales_date), GENDER