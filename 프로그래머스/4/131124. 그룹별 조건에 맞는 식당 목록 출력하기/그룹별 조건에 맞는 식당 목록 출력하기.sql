select   
MEMBER_NAME,
REVIEW_TEXT,
DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from MEMBER_PROFILE join REST_REVIEW using(MEMBER_ID)
where MEMBER_ID = (
    SELECT MEMBER_ID
    from MEMBER_PROFILE
    join REST_REVIEW
    using (MEMBER_ID)
    group by MEMBER_ID
    order by count(*) desc
    limit 1
)
order by REVIEW_DATE, REVIEW_TEXT
