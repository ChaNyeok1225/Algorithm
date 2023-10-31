SELECT
USER_ID,
NICKNAME,
concat(city,' ', STREET_ADDRESS1,' ', STREET_ADDRESS2) 전체주소,
concat(substr(TLNO,1,3), '-',substr(TLNO,4,4),'-', substr(TLNO,8) ) 전화번호

from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID

group by b.WRITER_ID
having count(*) >= 3

order by b.WRITER_ID desc