DROP DATABASE IF EXISTS PRO1041;
CREATE DATABASE PRO1041;
USE PRO1041;

DROP TABLE IF EXISTS roles;
CREATE TABLE roles 
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleName NVARCHAR(55) NULL,
    createdDate DATE NULL,
    updatedDate DATE NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleId INT,
    username VARCHAR(55) NULL,
    password VARCHAR(100) NULL,
    fullName NVARCHAR(100) NULL,
    birthDay DATE NULL,
    email VARCHAR (55) NULL,
    address NVARCHAR(255) NULL,
    phone VARCHAR(11) NULL,
    sex BIT NULL,
    score NVARCHAR(50) NULL,
    createdDate DATE NULL,
    updatedDate DATE NULL,
    isActived BIT NULL,
    attendance INT NULL,
    FOREIGN KEY (roleId) REFERENCES roles(id) 
);

DROP TABLE IF EXISTS passwordresettoken;
CREATE TABLE passwordresettoken
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(55) NOT NULL,
    token VARCHAR(255) NOT NULL,
    expirationdate DATETIME NOT NULL
);

DROP TABLE IF EXISTS events;
CREATE TABLE events 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NULL,
    title NVARCHAR(255) NULL,
    content NVARCHAR(255) NULL,
    location NVARCHAR(255) NULL,
    status NVARCHAR(55) NULL,
    startedDate DATE NULL,
    endedDate DATE NULL,
    createdDate DATE NULL,
    updatedDate DATE NULL,
    FOREIGN KEY (userId) REFERENCES users(id)
);

DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id INT PRIMARY KEY,
    active BIT NOT NULL,
    username VARCHAR(55) NULL,
    password VARCHAR(55) NULL
);

INSERT INTO account VALUES (1, 1, '', '');

INSERT INTO roles (roleName) VALUES 
(N'Chủ nhiệm'),
(N'Phó chủ nhiệm'),
(N'Thủ quỹ'),
(N'Thành viên');

INSERT INTO users (roleId, username, password, fullName, birthDay, email, address, phone, sex, score, createdDate, updatedDate, isActived, attendance) VALUES 
(1, 'phanlamhung', '1234', N'Nguyễn Phan Lâm Hùng', '1999-01-01', 'hung@example.com', N'123 Đường A, Hà Nội', '0909123456', 1, NULL, '2023-01-01', '2023-01-01', 1, 10),
(2, 'giangnd', '123', N'Nguyễn Đằng Giang', '1999-02-01', 'giang@example.com', N'456 Đường B, TP.HCM', '0909876543', 1, NULL, '2023-01-02', '2023-01-02', 1, 8),
(3, 'haithach', '456', N'Nguyễn Dung Hải Thạch', '2002-03-01', 'thach@example.com', N'789 Đường C, Đà Nẵng', '0909345678', 1, NULL, '2023-01-03', '2023-01-03', 1, 7),
(4, 'vulam', '789', N'Hà Vũ Lâm', '1998-04-01', 'lam@example.com', N'101 Đường D, Cần Thơ', '0909789123', 1, NULL, '2023-01-04', '2023-01-04', 1, 9);

INSERT INTO events (userId, title, content, location, status, startedDate, endedDate, createdDate, updatedDate) VALUES
(1, 'Hội thảo Java Cơ Bản', 'Tìm hiểu các kiến thức cơ bản về lập trình Java.', 'Phòng 101', 'sắp diễn ra', '2024-08-01', '2024-08-01', '2024-07-10', '2024-07-10'),
(2, 'Kỹ Thuật Java Nâng Cao', 'Làm chủ các kỹ thuật lập trình Java nâng cao.', 'Phòng 102', 'sắp diễn ra', '2024-08-05', '2024-08-05', '2024-07-10', '2024-07-10'),
(3, 'Java cho Phát Triển Web', 'Khám phá Java trong phát triển web.', 'Phòng 103', 'sắp diễn ra', '2024-08-10', '2024-08-10', '2024-07-10', '2024-07-10'),
(4, 'Giới Thiệu Spring Boot', 'Bắt đầu với Spring Boot.', 'Phòng 104', 'sắp diễn ra', '2024-08-15', '2024-08-15', '2024-07-10', '2024-07-10'),
(1, 'Viết CV Hiệu Quả', 'Học cách viết một CV hiệu quả.', 'Phòng 105', 'sắp diễn ra', '2024-08-20', '2024-08-20', '2024-07-10', '2024-07-10'),
(2, 'Kỹ Năng Thuyết Trình', 'Cải thiện kỹ năng thuyết trình trước đám đông.', 'Phòng 106', 'sắp diễn ra', '2024-08-25', '2024-08-25', '2024-07-10', '2024-07-10'),
(3, 'Kỹ Thuật Giải Quyết Vấn Đề', 'Nâng cao kỹ năng giải quyết vấn đề.', 'Phòng 107', 'sắp diễn ra', '2024-08-30', '2024-08-30', '2024-07-10', '2024-07-10'),
(1, 'Trình Diễn Dự Án Java', 'Trình diễn các dự án Java của bạn.', 'Phòng 108', 'sắp diễn ra', '2024-09-05', '2024-09-05', '2024-07-10', '2024-07-10');
