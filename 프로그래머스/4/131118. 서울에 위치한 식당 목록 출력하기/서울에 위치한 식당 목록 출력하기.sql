SELECT
i.REST_ID,
i.REST_NAME,
i.FOOD_TYPE,
i.FAVORITES,
ADDRESS,
round(SCORE,2) SCORE

from REST_INFO i
join (
    select REST_ID, avg(REVIEW_SCORE) SCORE
    from REST_REVIEW 
    group by REST_ID
) r
on i.REST_ID = r.REST_ID

where 1=1
and ADDRESS Like '서울%'

order by
SCORE desc, FAVORITES desc