INSERT INTO student (student_id, name, birth_date, email) VALUES (1, 'jijeong', '2002-03-04', 'jijeong@example.com');
INSERT INTO student (student_id, name, birth_date, email) VALUES (2, 'ojeong', '2014-08-26', 'ojeong@example.com');

INSERT INTO course (course_id, course_name, instructor, score) VALUES (1, 'Math', 'kim', 3);
INSERT INTO course (course_id, course_name, instructor, score) VALUES (2, 'English', 'lee', 2);

INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (1, 1, '2023-01-01');
INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (2, 2, '2023-02-01');
