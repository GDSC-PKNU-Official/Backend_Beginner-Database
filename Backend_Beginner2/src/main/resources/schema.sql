CREATE TABLE IF NOT EXISTS student (
                                       student_id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       birth_date DATE,
                                       email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS course (
                                      course_id INT AUTO_INCREMENT PRIMARY KEY,
                                      course_name VARCHAR(255) NOT NULL,
                                      instructor VARCHAR(255),
                                      score INT
);
