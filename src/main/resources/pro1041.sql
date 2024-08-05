drop database if exists PRO1041;
create database PRO1041;
use PRO1041;

drop table if exists roles;
create table roles
(
    id int auto_increment primary key,
    roleName nvarchar(55) null,
    createdDate date null,
    updatedDate date null
);

drop table if exists users;
create table users
(
    id int auto_increment primary key,
    roleId int,
    username varchar(55) null,
    password varchar(100) null,
    fullName nvarchar(100) null,
    birthDay date null,
    email varchar (55) null,
    address nvarchar(255) null,
    phone varchar(11) null,
    sex bit null,
    score int null,
    createdDate date null,
    updatedDate date null,
    isActived bit null,
    attendance int null,
    foreign key (roleId) references roles(id)
);

drop table if exists events;
create table events
(
    id int primary key auto_increment,
    userId int null,
    title nvarchar(255) null,
    content nvarchar(255) null,
    location nvarchar(255) null,
    status nvarchar(55) null,
    startedDate date null,
    endedDate date null,
    createdDate date null,
    updatedDate date null,
    type nvarchar(55) null, 		--  NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW
    foreign key (userId) references users(id)
);

drop table if exists account;
create table account
(
    id int primary key,
    isActive bit not null,
    username varchar(55) null,
    password varchar(55) null
);

drop table if exists user_event;	--  NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW NEW
create table user_event(
                           userId INT,
                           eventId INT,
                           PRIMARY KEY (userId, eventId),
                           FOREIGN KEY (userId) REFERENCES users(id),
                           FOREIGN KEY (eventId) REFERENCES events(id)
);

insert into account values (1,1, "", "");

insert into roles (roleName) VALUES
                                 (N'Chủ nhiệm'),
                                 (N'Phó chủ nhiệm'),
                                 (N'Thủ quỹ'),
                                 (N'Thành viên');

INSERT INTO users (roleId, username, password, fullName, birthDay, email, address, phone, sex, score, createdDate, updatedDate, isActived, attendance) VALUES
                                                                                                                                                           (1, 'phanlamhung', '1234', N'Nguyễn Phan Lâm Hùng', '1999-01-01', 'hung@example.com', N'123 Đường A, Hà Nội', '0909123456', 1, 0, '2023-01-01', '2023-01-01', 1, 8),
                                                                                                                                                           (2, 'giangnd', '123', N'Nguyễn Đằng Giang', '1999-02-01', 'giang@example.com', N'456 Đường B, TP.HCM', '0909876543', 1, 0, '2023-01-02', '2023-01-02', 1, 8),
                                                                                                                                                           (3, 'haithach', '456', N'Nguyễn Dung Hải Thạch', '2002-03-01', 'thach@example.com', N'789 Đường C, Đà Nẵng', '0909345678', 1, 1, '2023-01-03', '2023-01-03', 1, 8),
                                                                                                                                                           (4, 'vulam', '789', N'Hà Vũ Lâm', '1998-04-01', 'lam@example.com', N'101 Đường D, Cần Thơ', '0909789123', 1, 2, '2023-01-04', '2023-01-04', 1, 8),
                                                                                                                                                           (4, 'user1', '3221', N'User 1', '2000-01-01', 'user1@example.com', N'123 Đường X, Hà Nội', '0909123401', 0, 0, '2023-02-01', '2023-02-01', 1, 8),
                                                                                                                                                           (4, 'user2', '3221', N'User 2', '2000-02-01', 'user2@example.com', N'456 Đường Y, TP.HCM', '0909123402', 1, 0, '2023-02-02', '2023-02-02', 1, 7),
                                                                                                                                                           (4, 'user3', '3221', N'User 3', '2000-03-01', 'user3@example.com', N'789 Đường Z, Đà Nẵng', '0909123403', 1, 1, '2023-02-03', '2023-02-03', 1, 6),
                                                                                                                                                           (4, 'user4', '3221', N'User 4', '2000-04-01', 'user4@example.com', N'101 Đường AA, Cần Thơ', '0909123404', 1, 2, '2023-02-04', '2023-02-04', 1, 5),
                                                                                                                                                           (4, 'user5', '3221', N'User 5', '2000-05-01', 'user5@example.com', N'123 Đường BB, Hà Nội', '0909123405', 0, 0, '2023-02-05', '2023-02-05', 1, 8),
                                                                                                                                                           (4, 'user6', '3221', N'User 6', '2000-06-01', 'user6@example.com', N'456 Đường CC, TP.HCM', '0909123406', 1, 0, '2023-02-06', '2023-02-06', 1, 7),
                                                                                                                                                           (4, 'user7', '3221', N'User 7', '2000-07-01', 'user7@example.com', N'789 Đường DD, Đà Nẵng', '0909123407', 1, 1, '2023-02-07', '2023-02-07', 1, 6),
                                                                                                                                                           (4, 'user8', '3221', N'User 8', '2000-08-01', 'user8@example.com', N'101 Đường EE, Cần Thơ', '0909123408', 1, 2, '2023-02-08', '2023-02-08', 1, 5),
                                                                                                                                                           (4, 'user9', '3221', N'User 9', '2000-09-01', 'user9@example.com', N'123 Đường FF, Hà Nội', '0909123409', 1, 0, '2023-02-09', '2023-02-09', 1, 4),
                                                                                                                                                           (4, 'user10', '3221', N'User 10', '2000-10-01', 'user10@example.com', N'456 Đường GG, TP.HCM', '0909123410', 0, 0, '2023-02-10', '2023-02-10', 1, 7),
                                                                                                                                                           (4, 'user11', '3221', N'User 11', '2000-11-01', 'user11@example.com', N'789 Đường HH, Đà Nẵng', '0909123411', 1, 1, '2023-02-11', '2023-02-11', 1, 6),
                                                                                                                                                           (4, 'user12', '3221', N'User 12', '2000-12-01', 'user12@example.com', N'101 Đường II, Cần Thơ', '0909123412', 1, 2, '2023-02-12', '2023-02-12', 1, 5),
                                                                                                                                                           (4, 'user13', '3221', N'User 13', '2001-01-01', 'user13@example.com', N'123 Đường JJ, Hà Nội', '0909123413', 1, 0, '2023-02-13', '2023-02-13', 1, 8),
                                                                                                                                                           (4, 'user14', '3221', N'User 14', '2001-02-01', 'user14@example.com', N'456 Đường KK, TP.HCM', '0909123414', 1, 0, '2023-02-14', '2023-02-14', 1, 7),
                                                                                                                                                           (4, 'user15', '3221', N'User 15', '2001-03-01', 'user15@example.com', N'789 Đường LL, Đà Nẵng', '0909123415', 0, 1, '2023-02-15', '2023-02-15', 1, 6),
                                                                                                                                                           (4, 'user16', '3221', N'User 16', '2001-04-01', 'user16@example.com', N'101 Đường MM, Cần Thơ', '0909123416', 1, 2, '2023-02-16', '2023-02-16', 1, 5),
                                                                                                                                                           (4, 'user17', '3221', N'User 17', '2001-05-01', 'user17@example.com', N'123 Đường NN, Hà Nội', '0909123417', 1, 0, '2023-02-17', '2023-02-17', 1, 8),
                                                                                                                                                           (4, 'user18', '3221', N'User 18', '2001-06-01', 'user18@example.com', N'456 Đường OO, TP.HCM', '0909123418', 1, 0, '2023-02-18', '2023-02-18', 1, 3),
                                                                                                                                                           (4, 'user19', '3221', N'User 19', '2001-07-01', 'user19@example.com', N'789 Đường PP, Đà Nẵng', '0909123419', 0, 1, '2023-02-19', '2023-02-19', 1, 6),
                                                                                                                                                           (4, 'user20', '3221', N'User 20', '2001-08-01', 'user20@example.com', N'101 Đường QQ, Cần Thơ', '0909123420', 1, 2, '2023-02-20', '2023-02-20', 1, 5),
                                                                                                                                                           (4, 'user21', '3221', N'User 21', '2001-09-01', 'user21@example.com', N'123 Đường RR, Hà Nội', '0909123421', 1, 0, '2023-02-21', '2023-02-21', 1, 8),
                                                                                                                                                           (4, 'user22', '3221', N'User 22', '2001-10-01', 'user22@example.com', N'456 Đường SS, TP.HCM', '0909123422', 0, 0, '2023-02-22', '2023-02-22', 1, 7),
                                                                                                                                                           (4, 'user23', '3221', N'User 23', '2001-11-01', 'user23@example.com', N'789 Đường TT, Đà Nẵng', '0909123423', 1, 1, '2023-02-23', '2023-02-23', 1, 6),
                                                                                                                                                           (4, 'user24', '3221', N'User 24', '2001-12-01', 'user24@example.com', N'101 Đường UU, Cần Thơ', '0909123424', 0, 2, '2023-02-24', '2023-02-24', 1, 5),
                                                                                                                                                           (4, 'user25', '3221', N'User 25', '2002-01-01', 'user25@example.com', N'123 Đường WW, Hà Nội', '0909123425', 1, 0, '2023-02-25', '2023-02-25', 1, 2),
                                                                                                                                                           (4, 'user26', '3221', N'User 26', '2002-02-01', 'user26@example.com', N'456 Đường XX, TP.HCM', '0909123426', 1, 3, '2023-02-26', '2023-02-26', 1, 0);

insert into events (userId, title, content, location, status, startedDate, endedDate, createdDate, updatedDate, type) values
                                                                                                                          (1, 'Hội thảo Java Cơ Bản', 'Tìm hiểu các kiến thức cơ bản về lập trình Java.', 'Phòng 102', 'đã diễn ra', '2024-06-02', '2024-06-02', '2024-07-10', '2024-07-10', 'core'),
                                                                                                                          (2, 'Kỹ Thuật Java Nâng Cao', 'Làm chủ các kỹ thuật lập trình Java nâng cao.', 'Phòng 102', 'đã diễn ra', '2024-06-05', '2024-06-05', '2024-07-10', '2024-07-10', 'core'),
                                                                                                                          (3, 'Java cho Phát Triển Web', 'Khám phá Java trong phát triển web.', 'Phòng 102', 'đã diễn ra', '2024-06-10', '2024-06-10', '2024-07-10', '2024-07-10', 'advance'),
                                                                                                                          (4, 'Giới Thiệu Spring Boot', 'Bắt đầu với Spring Boot.', 'Phòng 104', 'đã diễn ra', '2024-07-15', '2024-07-15', '2024-07-10', '2024-07-10', 'soft-skill'),
                                                                                                                          (1, 'Viết CV Hiệu Quả', 'Học cách viết một CV hiệu quả.', 'Phòng 104', 'đã diễn ra', '2024-07-20', '2024-07-20', '2024-07-10', '2024-07-10', 'soft-skill'),
                                                                                                                          (2, 'Kỹ Năng Thuyết Trình', 'Cải thiện kỹ năng thuyết trình trước đám đông.', 'Phòng 104', 'đã diễn ra', '2024-07-25', '2024-07-25', '2024-07-10', '2024-07-10', 'soft-skill'),
                                                                                                                          (3, 'Kỹ Thuật Giải Quyết Vấn Đề', 'Nâng cao kỹ năng giải quyết vấn đề.', 'Phòng 102', 'đã diễn ra', '2024-07-30', '2024-07-30', '2024-07-10', '2024-07-10', 'soft-skill'),
                                                                                                                          (1, 'Trình Diễn Dự Án Java', 'Trình diễn các dự án Java của bạn.', 'Phòng 102', 'đã diễn ra', '2024-08-05', '2024-08-05', '2024-07-10', '2024-07-10', 'advance'),
                                                                                                                          (2, 'Quản trị dự án', 'Tìm hiểu về Agile và SCRUM', 'Phòng 108', 'sắp diễn ra', '2024-08-15', '2024-08-15', '2024-07-10', '2024-07-10', 'advance');

INSERT INTO user_event (userId, eventId) VALUES
                                             (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8),
                                             (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8),
                                             (3, 1), (3, 2), (3, 3), (3, 4), (3, 5), (3, 6), (3, 7), (3, 8),
                                             (4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8),
                                             (5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8),
                                             (6, 1), (6, 2), (6, 3), (6, 4), (6, 5), (6, 6), (6, 7),
                                             (7, 1), (7, 2), (7, 3), (7, 4), (7, 5), (7, 6),
                                             (8, 1), (8, 3), (8, 5), (8, 7), (8, 8),
                                             (9, 1), (9, 2), (9, 3), (9, 4), (9, 5), (9, 6), (9, 7), (9, 8),
                                             (10, 1), (10, 2), (10, 3), (10, 4), (10, 5), (10, 7), (10, 8),
                                             (11, 1), (11, 2), (11, 3), (11, 4), (11, 5), (11, 6),
                                             (12, 1), (12, 2), (12, 3), (12, 4), (12, 5),
                                             (13, 1), (13, 2), (13, 3), (13, 4),
                                             (14, 1), (14, 2), (14, 4), (14, 5), (14, 6), (14, 7), (14, 8),
                                             (15, 1), (15, 2), (15, 3), (15, 4), (15, 5), (15, 6),
                                             (16, 1), (16, 4), (16, 5), (16, 6), (16, 7),
                                             (17, 1), (17, 2), (17, 3), (17, 4), (17, 5), (17, 6), (17, 7), (17, 8),
                                             (18, 1), (18, 2), (18, 3), (18, 4), (18, 5), (18, 6), (18, 7),
                                             (19, 1), (19, 3), (19, 4), (19, 5), (19, 6), (19, 7),
                                             (20, 1), (20, 2), (20, 3), (20, 4), (20, 5),
                                             (21, 1), (21, 2), (21, 3), (21, 4), (21, 5), (21, 6), (21, 7), (21, 8),
                                             (22, 1), (22, 6), (22, 7),
                                             (23, 1), (23, 2), (23, 3), (23, 4), (23, 5), (23, 6),
                                             (24, 1), (24, 2), (24, 3), (24, 4), (24, 5),
                                             (25, 1), (25, 2), (25, 3), (25, 4), (25, 5), (25, 6), (25, 7), (25, 8),
                                             (26, 1), (26, 2), (26, 3), (26, 4), (26, 5), (26, 6), (26, 7),
                                             (27, 3), (27, 4), (27, 5), (27, 6), (27, 7), (27, 8),
                                             (28, 1), (28, 2), (28, 3), (28, 4), (28, 5),
                                             (29, 1), (29, 2);

--  các sự kiện mà một thành viên đã tham dự
SELECT  e.id , e.title
FROM users u
         JOIN user_event ue ON u.id = ue.userId
         JOIN events e ON ue.eventId = e.id
WHERE u.username = 'user15';

-- tất cả thành viên và sự kiện họ đã tham dự
SELECT u.username, e.id as event_id, u.fullName, e.title
FROM users u
         JOIN user_event ue ON u.id = ue.userId
         JOIN events e ON ue.eventId = e.id
ORDER BY u.username, e.id ;
