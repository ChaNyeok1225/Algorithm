SELECT `CATEGORY`, sum(SALES) `TOTAL_SALES`

from BOOK A join BOOK_SALES B on A.BOOK_ID = B.BOOK_ID

where 1=1
and DATE_FORMAT(sales_date, "%Y-%m") = "2022-01"

group by `CATEGORY`

order by `CATEGORY`