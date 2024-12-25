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
('DM01', N'Danh m?c th? thao', N'Nguy?n V?n A', N'Chuy�n m?c v? th? thao'),
('DM02', N'Danh m?c c�ng ngh?', N'L� Th? B', N'Chuy�n m?c v? c�ng ngh?'),
('DM03', N'Danh m?c v?n h�a', N'Tr?n V?n C', N'Chuy�n m?c v? v?n h�a');

-- Insert data into TINTUC
INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
VALUES 
('TT01', N'Tin t?c b�ng ?�', N'N?i dung chi ti?t v? tin t?c b�ng ?�...', N'https://example.com/tintuc/bongda', 'DM01'),
('TT02', N'C�ng ngh? AI ph�t tri?n', N'N?i dung chi ti?t v? c�ng ngh? AI...', N'https://example.com/tintuc/AI', 'DM02'),
('TT03', N'V?n h�a l? h?i', N'N?i dung chi ti?t v? l? h?i...', N'https://example.com/tintuc/lehoi', 'DM03');



select * from DANHMUC