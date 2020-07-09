SELECT DISTINCT title
FROM TVProgram JOIN Content USING (content_id)
WHERE program_date BETWEEN '2020-06-01' AND '2020-06-30'
AND Kids_content = 'Y'
AND content_type = 'Movies';
