-- 코드를 입력하세요
SELECT hour(datetime), count(*) from animal_outs where hour(datetime) between 9 and 20 group by hour(datetime) order by hour(datetime)