-- 코드를 입력하세요
SELECT II.INGREDIENT_TYPE, SUM(FH.TOTAL_ORDER)
from ICECREAM_INFO II join FIRST_HALF FH on II.flavor = FH.flavor
group by II.INGREDIENT_TYPE
order by FH.TOTAL_ORDER ASC;
