select
day as day,
count(*) as cntQy
from schedule_detail t1
where 
t1.SELECT_MONTH = /*selectMonth*/'12'
AND
t1.FIRST_FG = /*firstFg*/'1'
and t1.KAKUTEI_SCHEDULE_DV is not null
group by day
order by t1.day