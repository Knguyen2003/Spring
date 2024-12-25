create database QUANLYDANHMUC;

use QUANLYDANHMUC;

CREATE TABLE DANHMUC (
    MADM NVARCHAR(100) PRIMARY KEY,              
    TENDANHMUC NVARCHAR(100),          
    NGUOIQUANLY NVARCHAR(100),         
    GHICHU NVARCHAR(255)               
);

CREATE TABLE TINTUC (
    MATT NVARCHAR(100) PRIMARY KEY,              
    TIEUDE NVARCHAR(255),              
    NOIDUNGTT NVARCHAR(MAX),           
    LIENKET NVARCHAR(255),             
    MADM NVARCHAR(100) FOREIGN KEY (MADM) REFERENCES DANHMUC(MADM) on delete cascade on update cascade,
);

-- Insert data into DANHMUC
INSERT INTO DANHMUC (MADM, TENDANHMUC, NGUOIQUANLY, GHICHU)
VALUES 
('DM01', N'Danh m?c th? thao', N'Nguy?n V?n A', N'Chuyên m?c v? th? thao'),
('DM02', N'Danh m?c công ngh?', N'Lê Th? B', N'Chuyên m?c v? công ngh?'),
('DM03', N'Danh m?c v?n hóa', N'Tr?n V?n C', N'Chuyên m?c v? v?n hóa');

-- Insert data into TINTUC
INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
VALUES 
('TT01', N'Tin t?c bóng ?á', N'N?i dung chi ti?t v? tin t?c bóng ?á...', N'https://example.com/tintuc/bongda', 'DM01'),
('TT02', N'Công ngh? AI phát tri?n', N'N?i dung chi ti?t v? công ngh? AI...', N'https://example.com/tintuc/AI', 'DM02'),
('TT03', N'V?n hóa l? h?i', N'N?i dung chi ti?t v? l? h?i...', N'https://example.com/tintuc/lehoi', 'DM03');



select * from DANHMUC