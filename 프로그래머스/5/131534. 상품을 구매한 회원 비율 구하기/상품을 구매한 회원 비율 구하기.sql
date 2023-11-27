select
YEAR(SALES_DATE) YEAR,
MONTH(SALES_DATE) MONTH,
count(distinct USER_ID) PUCHASED_USERS,
round(count(distinct USER_ID) / total ,1) PUCHASED_RATIO
from ONLINE_SALE o join (
    SELECT USER_ID, count(*) OVER() total 
    from USER_INFO
    where year(JOINED) = '2021') a using (USER_ID) 
group by YEAR(SALES_DATE), MONTH(SALES_DATE)
order by YEAR(SALES_DATE), MONTH(SALES_DATE)