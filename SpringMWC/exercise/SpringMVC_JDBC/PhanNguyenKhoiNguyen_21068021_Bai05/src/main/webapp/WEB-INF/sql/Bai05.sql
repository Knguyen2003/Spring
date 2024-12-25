create database QuanLyNhanVien

use QuanLyNhanVien

-- Tạo bảng Employee với Id tự tăng
CREATE TABLE Employee (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100),
    Salary Float,
    Designation NVARCHAR(50)
);

-- Thêm dữ liệu mẫu
INSERT INTO Employee (Name, Salary, Designation) VALUES 
(N'Thanh Vân', 2400000.0, N'Tester'),
(N'Hoàng Giang', 2300000.00, N'Developer'),
(N'Hồng Minh', 2400000.00, N'QA'),
(N'Hoàng Khánh', 2500000.00, N'Developer'),
(N'Ngọc Dung', 2200000.00, N'QA');

select * from [dbo].[Employee]

delete from [dbo].[Employee]