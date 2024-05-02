-- 코드를 입력하세요
SELECT animal_id, name, 
CASE
when sex_upon_intake like '%Neutered%' or sex_upon_intake like '%Spayed%' then 'O'
else 'X'
END 
from animal_ins order by animal_id;