SELECT
f.FLAVOR


from
FIRST_HALF f
join
ICECREAM_INFO i
on
f.FLAVOR = i.FLAVOR
where 1=1
and INGREDIENT_TYPE = 'fruit_based'

group by
FLAVOR

having
sum(TOTAL_ORDER) >= 3000