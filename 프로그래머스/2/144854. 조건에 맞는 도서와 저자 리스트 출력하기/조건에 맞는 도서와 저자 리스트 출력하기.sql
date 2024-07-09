-- 코드를 입력하세요
SELECT B.book_id, A.author_name, date_format(B.PUBLISHED_DATE, '%Y-%m-%d') from book B, author A where B.author_id = A.author_id and B.category = '경제' order by B.published_date asc