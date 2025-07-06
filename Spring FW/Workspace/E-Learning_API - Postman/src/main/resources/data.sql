-- CATEGORY
INSERT INTO category (id, name) VALUES
                                    (1, 'Lập trình Java'),
                                    (2, 'Lập trình Web'),
                                    (3, 'Phân tích dữ liệu');

-- ACCOUNT
INSERT INTO account (id, username, password, role, email, create_at, update_at, date_of_birth, address) VALUES
(1, 'admin', '$2a$12$eyqL0tpiYkp.hLalJ9tqqOsanRvkoxmCbfLlv1wZIzXmN/tq8tXIC', 'ADMIN', 'admin@gmail.com', '2024-01-01T08:00:00', '2024-01-01T08:00:00', '1990-01-01', 'Hà Nội'),
(2, 'alice', '$2a$12$gcnWbd55yFFdhGdC4uVxyuX35.f7s7G2G3a/ipztQQEPrRf9yc3Au', 'USER', 'alice@gmail.com', '2024-01-01T08:00:00', '2024-01-01T08:00:00', '1995-02-15', 'Hà Nội'),
(3, 'bob', '$2a$12$6vW6MzBR1zJgt4L2wci4n.KZS1ukZ/vhVfD6qlPNYvekWjY2j3jYO', 'USER', 'bob@gmail.com', '2024-01-01T08:00:00', '2024-01-01T08:00:00', '1996-03-20', 'TP.HCM'),
(4, 'charlie', '$2a$12$MxkR6mZTe56D4hv0AZ4ADuCJFBloeWDo3sIMvMeJujgFESfxHQlYS', 'USER', 'charlie@gmail.com', '2024-01-01T08:00:00', '2024-01-01T08:00:00', '1997-04-10', 'Đà Nẵng'),
(5, 'david', '$2a$12$8OLyQ80Jl7wFQd8kkjqwjud/FaS94dfIz28qRxCdxdsvi4TaqNN6y', 'USER', 'david@gmail.com', '2024-01-01T08:00:00', '2024-01-01T08:00:00', '1998-05-05', 'Cần Thơ');

-- CERTIFICATE
INSERT INTO certificate (id, type) VALUES
(1, 'ASSOCIATE'),
(2, 'PROFESSIONAL'),
(3, 'MASTER');

-- COURSE
INSERT INTO course (id, name, sessions, hours, category_id, certificate_id, description) VALUES
(1, 'Java Core', 10, 30, 1, 1, 'Khoá học căn bản về Java'),
(2, 'Spring Boot', 12, 36, 1, 2, 'Phát triển ứng dụng web với Spring Boot'),
(3, 'HTML & CSS', 8, 24, 2, 3, 'Thiết kế giao diện web cơ bản'),
(4, 'Python for Data', 15, 40, 3, null, 'Nhập môn xử lý dữ liệu với Python'),
(5, 'SQL Cơ bản', 6, 20, 3, null, 'Học cách truy vấn dữ liệu với SQL');

-- LESSON
INSERT INTO lesson (id, title, description, duration, course_id) VALUES
(1, 'Java OOP', 'Lập trình hướng đối tượng với Java', 3, 1),
(2, 'Dependency Injection', 'DI trong Spring', 4, 2),
(3, 'CSS Grid', 'Thiết kế giao diện với CSS Grid', 3, 3),
(4, 'NumPy Basics', 'Xử lý dữ liệu với NumPy', 4, 4),
(5, 'Câu lệnh SELECT', 'Truy vấn cơ bản trong SQL', 2, 5);
