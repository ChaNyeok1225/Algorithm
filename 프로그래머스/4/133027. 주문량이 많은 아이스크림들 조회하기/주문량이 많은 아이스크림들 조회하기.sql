SELECT
f.FLAVOR
from FIRST_HALF f
join (
    select FLAVOR, sum(TOTAL_ORDER) t
    from july
    group by FLAVOR
) j
on f.FLAVOR = j.FLAVOR

order by 
f.TOTAL_ORDER + j.t desc

limit 3
