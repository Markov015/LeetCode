-- SELECT student_id, student_name, subject_name,  COUNT(*) AS attended_exams
-- FROM Students RIGHT JOIN Examinations USING (student_id)
-- GROUP BY student_id, subject_name
-- ORDER BY student_id, subject_name;
--
-- SELECT s.student_id, s.student_name, t.subject_name, COUNT(*) AS attended_exams
-- FROM Students s LEFT JOIN (
--     SELECT *
--     FROM Subjects LEFT JOIN Examinations USING (subject_name)
-- ) AS t
-- ON s.student_id = t.student_id
-- GROUP BY s.student_id, t.subject_name
-- ORDER BY s.student_id, t.subject_name;
--
-- SELECT student_id, student_name, subject_name, COUNT(*) AS attended_exams
-- FROM Students CROSS JOIN Subjects LEFT JOIN Examinations USING (student_id, subject_name)
-- GROUP BY student_id, subject_name;

SELECT st.student_id, st.student_name, su.subject_name, COUNT(e.subject_name) AS attended_exams
FROM Students st CROSS JOIN Subjects su LEFT JOIN Examinations e
ON st.student_id = e.student_id AND su.subject_name = e.subject_name
GROUP BY st.student_id, su.subject_name
ORDER BY st.student_id, su.subject_name;
