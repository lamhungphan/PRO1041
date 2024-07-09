use PRO1041;

drop table if exists roles;
create table roles 
(
	id int auto_increment primary key,
    roleName nvarchar(55) null,
    createDate date null,
    updateDate date null
);

drop table if exists users;
create table users
(
	id int auto_increment primary key,
    roleId int,
    username varchar(55) null,
    password varchar(55) null,
    fullName nvarchar(100) null,
    birthDay date null,
    email varchar (55) null,
    address nvarchar(255) null,
    phone varchar(11) null,
    createDate date null,
    updateDate date null,
    isActived bit null,
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
    startDate date null,
    endeDate date null,
    createDate date null,
    updateDate date null,
    foreign key (userId) references users(id)
);

drop table if exists account;
create table account
(
	id int auto_increment primary key,
    username varchar(55) null,
    password varchar(55) null
);


-- Chèn dữ liệu vào bảng roles
INSERT INTO roles (roleName) VALUES 
(N'Chủ nhiệm'),
(N'Phó chủ nhiệm'),
(N'Thủ quỹ'),
(N'Thành viên');

-- Chèn dữ liệu vào bảng users
INSERT INTO users (roleId, username, password, fullName, birthDay, email, address, phone, createDate, updateDate, isActived) VALUES 
(1, 'phanlamhung', '1234', N'Nguyễn Phan Lâm Hùng', '1999-01-01', 'hung@example.com', N'123 Đường A, Hà Nội', '0909123456', '2023-01-01', '2023-01-01', 1),
(2, 'giangnd', '123', N'Nguyễn Đằng Giang', '1999-02-01', 'giang@example.com', N'456 Đường B, TP.HCM', '0909876543', '2023-01-02', '2023-01-02', 1),
(3, 'haithach', '456', N'Nguyễn Dung Hải Thạch', '2002-03-01', 'thach@example.com', N'789 Đường C, Đà Nẵng', '0909345678', '2023-01-03', '2023-01-03', 1),
(4, 'vulam', '789', N'Hà Vũ Lâm', '1998-04-01', 'lam@example.com', N'101 Đường D, Cần Thơ', '0909789123', '2023-01-04', '2023-01-04', 1);


