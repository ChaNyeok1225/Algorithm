SELECT
BOARD_ID,
WRITER_ID,
TITLE,
PRICE,
case
    when `STATUS` = 'SALE' then '판매중'
    when `STATUS` = 'RESERVED' then '예약중'
    when `STATUS` = 'DONE' then '거래완료'
end `STATUS`

from
USED_GOODS_BOARD 

where
1=1
and CREATED_DATE like "2022-10-05%"

order by
BOARD_ID desc