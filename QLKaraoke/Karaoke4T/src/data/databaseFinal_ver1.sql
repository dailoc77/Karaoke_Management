USE [master]
drop database Karaoke4T
GO
/****** Object:  Database [Karaoke4T]    Script Date: 11/9/2023 11:23:20 PM ******/
CREATE DATABASE [Karaoke4T]
go
USE [Karaoke4T]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[soLuong] [int] NOT NULL,
	[maHD] [varchar](10) NOT NULL,
	[maDV] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHD] [varchar](10) NOT NULL,
	[maPhong] [varchar](10) NOT NULL,
	[thoiLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDV] [varchar](10) NOT NULL,
	[donGia] [float] NULL,
	[soLuong] [int] NOT NULL,
	[tenDichVu] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [varchar](10) NOT NULL,
	[gioKetThuc] [datetime2](7) NULL,
	[gioNhanPhong] [datetime2](7) NULL,
	[ngayLap] [datetime2](7) NULL,
	[tienKhachTra] [float] NOT NULL,
	[tongTien] [float] NOT NULL,
	[maKH] [varchar](10) NULL,
	[maNV] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](10) NOT NULL,
	[gioiTinh] [varchar](5) NOT NULL,
	[tenKH] [nvarchar](max) NULL,
	[SDT] [varchar](11) NULL,
	[CMND] [varchar](11) NULL,
	[diaChi] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNhanVien]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNhanVien](
	[maLNV] [varchar](10) NOT NULL,
	[tenLNV] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLP] [varchar](10) NOT NULL,
	[giaTien] [float] NOT NULL,
	[tenLoaiPhong] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](10) NOT NULL,
	[tenNV] [varchar](255) NULL,
	[gioiTinh] [varchar](255) NULL,
	[ngaySinh] [nvarchar](max) NULL,
	[CMND] [varchar](11) NULL,
	[SDT] [varchar](11) NULL,
	[trangThaiLamViec] [varchar](30) NOT NULL,
	[diaChi] [varchar](max) NULL,
	[maLNV] [varchar](10) NULL,
	[maTK] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[maPDP] [varchar](10) NOT NULL,
	[thoiGianDangKyDatPhong] [datetime2](7) NULL,
	[thoiGianNhanPhong] [datetime2](7) NULL,
	[tinhTrangPhong] [varchar](30) NOT NULL,
	[maKH] [varchar](10) NULL,
	[maNV] [varchar](10) NULL,
	[maPhong] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [varchar](10) NOT NULL,
	[soNguoi] [int] NOT NULL,
	[tenPhong] [varchar](max) NULL,
	[tinhTrangPhong] [varchar](30) NOT NULL,
	[maLP] [varchar](10) NULL,
	[maTTP] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [varchar](10) NOT NULL,
	[tenTK] [nvarchar](max),
	[MK] [nvarchar](max),
	[tenNV][nvarchar](max),
	[email] [varchar](max),
PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrangThaiPhong]    Script Date: 11/9/2023 11:23:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThaiPhong](
	[maTTP] [varchar](10) NOT NULL,
	[tenTrangThaiPhong] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTTP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FKeye54e4p8bj4egjupsyses0hb] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FKeye54e4p8bj4egjupsyses0hb]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FKfe5abn33fe5jtp4lyhif1xyjf] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FKfe5abn33fe5jtp4lyhif1xyjf]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK2kbafpq23m2cuqm32ifoiwi9d] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK2kbafpq23m2cuqm32ifoiwi9d]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FKhjx09obph682p8sjkgctrprsf] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FKhjx09obph682p8sjkgctrprsf]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKg1ebuq3tydt58wb4gutehmh9w] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKg1ebuq3tydt58wb4gutehmh9w]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKoyaa1162ps1nyifmfv2pv2qr] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKoyaa1162ps1nyifmfv2pv2qr]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([maTK])
REFERENCES [dbo].[TaiKhoan] ([maTK])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK592pmnnm2sm98xbre6r63cqa4] FOREIGN KEY([maLNV])
REFERENCES [dbo].[LoaiNhanVien] ([maLNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK592pmnnm2sm98xbre6r63cqa4]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FKjv5cd9rgskfo6ycp5oomaulks] FOREIGN KEY([maLP])
REFERENCES [dbo].[LoaiPhong] ([maLP])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FKjv5cd9rgskfo6ycp5oomaulks]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FKlxs9yc5k8idtuxshdfpswwym9] FOREIGN KEY([maTTP])
REFERENCES [dbo].[TrangThaiPhong] ([maTTP])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FKlxs9yc5k8idtuxshdfpswwym9]
GO
USE [master]
GO
ALTER DATABASE [Karaoke4T] SET  READ_WRITE 
GO
USE [Karaoke4T]
go





SELECT * FROM [dbo].[ChiTietDichVu]

SELECT * FROM [dbo].[ChiTietHoaDon]

SELECT * FROM [dbo].[HoaDon]

SELECT * FROM [dbo].[DichVu]
SELECT * FROM [dbo].[LoaiNhanVien]
SELECT * FROM [dbo].[LoaiPhong]
SELECT * FROM [dbo].[KhachHang]
SELECT * FROM [dbo].[NhanVien]
SELECT * FROM [dbo].[Phong]
SELECT * FROM [dbo].[TrangThaiPhong]
SELECT * FROM [dbo].[TaiKhoan]
SELECT * FROM [dbo].[PhieuDatPhong]



SELECT * FROM [dbo].[KhachHang]

INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA001',N'123456789' ,N'Nam', N'BuiMinh',N'0945601318',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA002',N'123456789' ,N'Nam', N'HaHuyHoang',N'0857526421',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA003',N'123456789' ,N'Nam', N'Hà Huy Hoàng',N'0857363523',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA004',N'123456789' ,N'Nu', N'Dương Thị Diễm',N'0945612345',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA005',N'123456789' ,N'Nam', N'TRẦN THANH NAM',N'0945601321',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA006',N'123456789' ,N'Nu', N'ĐÀO MINH TUYẾT',N'0945601322',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA007',N'123456789' ,N'Nu', N'HUỲNH HIẾU THẢO',N'0945601323',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA008',N'123456789' ,N'Nu', N'NGUYỄN THỊ THANH VÂN',N'0945601324',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA009',N'123456789' ,N'Nam', N'NGUYỄN VĂN CHƯƠNG',N'0945601325',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA010',N'123456789' ,N'Nu', N'HÀ THỊ NGỌC ÁNH',N'0945601326',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA011',N'123456789' ,N'Nu', N'LÊ THỊ RỚT',N'0945601327',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA012',N'123456789' ,N'Nu', N'NGUYỄN THỊ NGỌC TUYẾT',N'0945601328',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA013',N'123456789' ,N'Nu', N'BÙI NGUYỄN NGUYỆT DUNG',N'0945601329',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA014',N'123456789' ,N'Nam', N'LƯU VĂN XÂY',N'0945601330',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA015',N'123456789' ,N'Nam', N'VŨ VĂN NHẬT HÙNG',N'0945601331',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA016',N'123456789' ,N'Nam', N'TRẦN VĂN THIỆN',N'0945601332',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA017',N'123456789' ,N'Nu', N'NGUYỄN THỊ THANH THÚY',N'0945601333',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA018',N'123456789' ,N'Nam', N'NGUYỄN VĂN VINH',N'0945601334',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA019',N'123456789' ,N'Nu', N'NGUYỄN THỊ SÁNG',N'0945601335',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA020',N'123456789' ,N'Nam', N'TỪ TIẾN QUANG HÀO',N'0945601336',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA021',N'123456789' ,N'Nu', N'HUỲNH THỊ ÁNH HỒNG',N'0945601337',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA022',N'123456789' ,N'Nam', N'LÊ THÀNH LỢI',N'0945601338',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA023',N'123456789' ,N'Nam', N'PHẠM HIỀN NHÂN',N'0945601339',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA024',N'123456789' ,N'Nu', N'NGÔ THỊ BẢY',N'0945601340',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA025',N'123456789' ,N'Nam', N'NGUYỄN LÊ MINH SANG',N'0945601341',N'Xã Thới Đông, Huyện Cờ Đỏ, Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA026',N'123456789' ,N'Nu', N'NGUYỄN THỊ TÚ LIÊN',N'0945601342',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA027',N'123456789' ,N'Nu', N'NGUYỄN THỊ PHÚ LIÊN',N'0945601343',N'Xã Đông Hiệp, Huyện Cờ Đỏ,Thành phố Cần Thơ ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA028',N'123456789' ,N'Nam', N'SUH CANG HY',N'0945601344',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA029',N'123456789' ,N'Nam', N'NGUYỄN KỲ NAM',N'0945601345',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA030',N'123456789' ,N'Nu', N'TRẦN THỊ XIÊM',N'0945601346',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA031',N'123456789' ,N'Nam', N'ĐINH THANH SANG',N'0945601347',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA032',N'123456789' ,N'Nam', N'LÊ HOÀNG TRỌNG',N'0945601348',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA033',N'123456789' ,N'Nu', N'HUỲNH THỊ HỒNG NGA',N'0945601349',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA034',N'123456789' ,N'Nam', N'LÂM NGỌC PHƯỢNG',N'0945601350',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA035',N'123456789' ,N'Nu', N'NGUYỄN THỊ KIM NGÂN',N'0945601351',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA036',N'123456789' ,N'Nu', N'NGUYỄN NGỌC MỸ',N'0945601352',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA037',N'123456789' ,N'Nu', N'LÊ THỊ THU HÀ',N'0945601353',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA038',N'123456789' ,N'Nu', N'NGUYỄN THỊ CÚC',N'0945601354',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA039',N'123456789' ,N'Nu', N'HUỲNH THỊ HỒNG NGA',N'0945601355',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA040',N'123456789' ,N'Nam', N'NGUYỄN HỒNG HẢI',N'0945601356',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA041',N'123456789' ,N'Nu', N'TRÀ THỊ TUYẾT THU',N'0945601357',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA042',N'123456789' ,N'Nu', N'PHẠM THỊ VIỆT',N'0945601358',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA043',N'123456789' ,N'Nam', N'TRẦN MINH TUẤN',N'0945601359',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA044',N'123456789' ,N'Nam', N'TRẦN VĂN ĐÔNG',N'0945601360',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA045',N'123456789' ,N'Nam', N'LƯƠNG THÀNH PHÚC',N'0945601361',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA046',N'123456789' ,N'Nam', N'NGUYỄN NGỌC ĐẰNG',N'0945601362',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA047',N'123456789' ,N'Nam', N'HUỲNH VĂN NGÀ',N'0945601363',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA048',N'123456789' ,N'Nam', N'TRỊNH HẢI ĐĂNG',N'0945601364',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA049',N'123456789' ,N'Nu', N'NGUYỄN THỊ MỸ PHƯỢNG',N'0945601365',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA050',N'123456789' ,N'Nam', N'LÊ THANH PHỤNG',N'0945601366',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA051',N'123456789' ,N'Nam', N'TRẦN VĂN THẮNG',N'0945601367',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA052',N'123456789' ,N'Nam', N'NGUYỄN ĐÌNH PHONG',N'0945601368',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA053',N'123456789' ,N'Nu', N'NGUYỄN THỊ PHƯƠNG DUNG',N'0945601369',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA054',N'123456789' ,N'Nu', N'DƯƠNG THỊ THÙY TRANG',N'0945601370',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA055',N'123456789' ,N'Nu', N'ĐỖ THU HƯƠNG',N'0945601371',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA056',N'123456789' ,N'Nam', N'NGUYỄN THANH QUYỀN',N'0945601372',N'Phường An Nghiệp,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA057',N'123456789' ,N'Nam', N'TRẦN THANH HẢI',N'0945601373',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA058',N'123456789' ,N'Nam', N'HÙNG THÀNH CÔNG',N'0945601374',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA059',N'123456789' ,N'Nam', N'TRẦN QUỐC TUẤN',N'0945601375',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA060',N'123456789' ,N'Nam', N'HỒ NGỌC THANH HIỀN',N'0945601376',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA061',N'123456789' ,N'Nam', N'NGUYỄN THỊ HÒA',N'0945601377',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA062',N'123456789' ,N'Nu', N'NGUYỄN THỊ Huệ',N'0945601378',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA063',N'123456789' ,N'Nam', N'AMELLIA NGUYỄN',N'0945601379',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA064',N'123456789' ,N'Nam', N'TRẦN MINH SƠN',N'0945601380',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA065',N'123456789' ,N'Nu', N'VÂN KIM LIÊN',N'0945601381',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA066',N'123456789' ,N'Nu', N'TRẦN THỊ THU HỒNG',N'0945601382',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA067',N'123456789' ,N'Nu', N'LÂM THỊ PHƯỢNG',N'0945601383',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA068',N'123456789' ,N'Nu', N'TRẦN THỊ THẮM',N'0945601384',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA069',N'123456789' ,N'Nam', N'ĐĂNG QUANG ĐẠT',N'0945601385',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA070',N'123456789' ,N'Nam', N'NGUYỄN HUY',N'0945601386',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA071',N'123456789' ,N'Nam', N'NGUYỄN NGỌC LỢI',N'0945601387',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA072',N'123456789' ,N'Nu', N'HUỲNH ĐOAN TRANG',N'0945601388',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA073',N'123456789' ,N'Nu', N'NGUYỄN THỊ DIỄM PHỤNG',N'0945601389',N'Phường Trường Lạc,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA074',N'123456789' ,N'Nam', N'LÝ MINH HIẾU',N'0945601390',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA075',N'123456789' ,N'Nam', N'TÔN CHẤN VÕ',N'0945601391',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA076',N'123456789' ,N'Nam', N'LÝ TRUNG SƠN',N'0945601392',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA077',N'123456789' ,N'Nam', N'NGUYỄN HÙNG BÌNH',N'0945601393',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA078',N'123456789' ,N'Nu', N'PHAN THỊ MỸ DUNG',N'0945601394',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA079',N'123456789' ,N'Nu', N'NGUYỄN THỊ THẢO',N'0945601395',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA080',N'123456789' ,N'Nam', N'NGUYỄN HOÀNG ANH',N'0945601396',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA081',N'123456789' ,N'Nam', N'VÕ HỮU TOẠI',N'0945601397',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA082',N'123456789' ,N'Nu', N'NGUYỄN THỊ KHUÊ BÍCH',N'0945601398',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA083',N'123456789' ,N'Nam', N'TRẦN QUANG SINH',N'0945601399',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA084',N'123456789' ,N'Nam', N'THÁI SÁNG BÌNH',N'0945601400',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA085',N'123456789' ,N'Nam', N'HUỲNH NGỌC ÁNH',N'0945601401',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA086',N'123456789' ,N'Nam', N'PHẠM NGỌC THÀN',N'0945601402',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA087',N'123456789' ,N'Nu', N'TRẦN THỊ XUÂN HỒNG',N'0945601403',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA088',N'123456789' ,N'Nu', N'NGUYỄN THỊ THU THỦY',N'0945601404',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA089',N'123456789' ,N'Nam', N'THÁI MINH HÙNG',N'0945601405',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA090',N'123456789' ,N'Nam', N'VÕ THÀNH TÂM',N'0945601406',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA091',N'123456789' ,N'Nu', N'HỒ THỊ NGỌC CẨM',N'0945601407',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA092',N'123456789' ,N'Nam', N'NGUYỄN NGỌC THẠCH',N'0945601408',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA093',N'123456789' ,N'Nu', N'TỪ QUẾ LAN',N'0945601409',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA094',N'123456789' ,N'Nu', N'MAI THỊ THANH HUYỀN',N'0945601410',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA095',N'123456789' ,N'Nu', N'CHÂU THỤC MAI',N'0945601411',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA096',N'123456789' ,N'Nu', N'NGUYỄN THỊ BÍCH TRÂM',N'0945601412',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA097',N'123456789' ,N'Nu', N'NGUYỄN THỊ HOÀNG TRANG',N'0945601413',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA098',N'123456789' ,N'Nu', N'HUỲNH THỊ THU HƯỜNG',N'0945601414',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA099',N'123456789' ,N'Nu', N'VŨ THU THỦY',N'0945601415',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA100',N'123456789' ,N'Nam', N'PHẠM THANH SĨ',N'0945601416',N'Xã Phường Hòa Thọ Đông,Quận Cẩm Lệ,Thành phố Đà Nẵng ')


GO
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA101',N'123456789',N'Nam', N'Hà Huy Hoàng',N'0945601417','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA102',N'123456789',N'Nam', N'Đặng Nhật Khương',N'0942245015','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA103',N'123456789',N'Nam', N'Nguyễn Thanh Sơn',N'0394566461','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA104',N'123456789',N'Nam', N'Huynh Anh Khang',N'0968234562','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA105',N'123456789',N'Nam', N'Đặng Nhật Khương',N'0942245016','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA106',N'123456789',N'Nam', N'Bùi Bình Minh',N'0933873344','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA107',N'123456789',N'Nam', N'Nguyễn Thanh Châu',N'0394566462','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA108',N'123456789',N'Nam', N'Nguyễn Thanh Công',N'0394566464','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA109',N'123456789',N'Nam', N'Nguyễn Hoàng Khách',N'0394555458','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA110',N'123456789',N'Nam', N'Nguyễn Minh Sơn',N'0394566466','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA111',N'123456789',N'Nam', N'Nguyễn Thanh Sơn',N'0394566467','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH],[CMND], [gioiTinh], [tenKH], [SDT], [diaChi]) VALUES (N'KHAA112',N'123456789',N'Nam', N'Nguyễn Hoàng Khánh',N'0394566463','Xã Đông Hiệp, Huyện Cờ Đỏ, Thành phố Cần Thơ')
GO




SELECT * FROM [dbo].[LoaiNhanVien]

INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV001', N'Quản lý')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV002', N'Thu ngân')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV003', N'Lễ tân')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV004', N'Bảo vệ')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV005', N'Vệ sinh')

SELECT * FROM [dbo].[TaiKhoan]

INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK001',N'admin',N'123',N'Admin', 'maiqtruong2403@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK002',N'dailoc',N'1234',N'Truong Dai Loc', 'truongdailoc2003@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK003',N'thienthach',N'123',N'Mai Ho Thien Thach', 'thachgpt@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK004',N'duongphan',N'123',N'Phan Nguyen Dai Duong', 'duongphan1912@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK005',N'HUYNHHIEUTHAO', N'123', N'HUYNH HIEU THAO','HUYNHHIEUTHAO@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK006',N'NGUYENTHITHANHVAN',N'123',N'NGUYEN THI THANH VAN', 'NGUYENTHITHANHVAN@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK007',N'NGUYENVANCHUONG',N'123', N'NGUYEN VAN CHUONG','NGUYENVANCHUONG@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK008',N'HATHINGOCANH',N'123', N'HA THI NGOC ANH','HATHINGOCANH@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK009',N'USERNAME',N'123', N'USERNAME','USERNAME@gmail.com')
INSERT[dbo].[TaiKhoan]([maTK],[tenTK],[MK],[tenNV],[email])VALUES(N'TK010',N'USERNAME123',N'123', N'USERNAME USERNAME','USERNAME11@gmail.com')
go



SELECT * FROM [dbo].[NhanVien]
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0001', N'Nam', N'MAI HO THIEN THACH', N'2001-01-01 00:00:00.0000000', N'999999999', N'9999999999',N'Đang làm',N'LNV002','TK001',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0002', N'Nam', N'HU?NH VAN VU', N'2001-01-01 00:00:00.0000000', N'856378092', N'0945601318',N'Đang làm',N'LNV002','TK002',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0003', N'Nu', N'HU?NH TH? L? H?NG', N'2001-01-01 00:00:00.0000000', N'745715032', N'0945601319',N'Đang làm',N'LNV002','TK003',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0004', N'Nu', N'LÊ TH? HOA MAI', N'2001-01-01 00:00:00.0000000', N'612348590', N'0945601320',N'Đang làm',N'LNV002','TK004',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0005', N'Nam', N'TR?N THANH NAM', N'2001-01-01 00:00:00.0000000', N'939364414', N'0945601321',N'Đang làm',N'LNV002','TK005',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0006', N'Nu', N'ÐÀO MINH TUY?T', N'2001-01-01 00:00:00.0000000', N'856370984', N'0945601322',N'Đang làm',N'LNV002','TK006',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0007', N'Nu', N'HU?NH HI?U TH?O', N'2001-01-01 00:00:00.0000000', N'728609067', N'0945601323',N'Đang làm',N'LNV002','TK007',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0008', N'Nu', N'NGUY?N TH? THANH VÂN', N'2001-01-01 00:00:00.0000000', N'691694850', N'0945601324',N'Đang làm',N'LNV002','TK008',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0009', N'Nam', N'NGUY?N VAN CHUONG', N'2001-01-01 00:00:00.0000000', N'130891152', N'0945601325',N'Đang làm',N'LNV002','TK009',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0010', N'Nu', N'HÀ TH? NG?C ÁNH', N'2001-01-01 00:00:00.0000000', N'577742431', N'0945601326',N'Đang làm',N'LNV002','TK010',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0011', N'Nu', N'LÊ TH? R?T', N'2001-01-01 00:00:00.0000000', N'609929488', N'0945601327',N'Đang làm',N'LNV002','TK011',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0012', N'Nu', N'NGUY?N TH? NG?C TUY?T', N'2001-01-01 00:00:00.0000000', N'936686798', N'0945601328',N'Đang làm',N'LNV002','TK012',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0013', N'Nu', N'BÙI NGUY?N NGUY?T DUNG', N'2001-01-01 00:00:00.0000000', N'850520689', N'0945601329',N'Đang làm',N'LNV002','TK013',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0014', N'Nam', N'LUU VAN XÂY', N'2001-01-01 00:00:00.0000000', N'809074124', N'0945601330',N'Đang làm',N'LNV002','TK014',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0015', N'Nam', N'VU VAN NH?T HÙNG', N'2001-01-01 00:00:00.0000000', N'982617914', N'0945601331',N'Đang làm',N'LNV002','TK015',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0016', N'Nam', N'TR?N VAN THI?N', N'2001-01-01 00:00:00.0000000', N'745949172', N'0945601332',N'Đang làm',N'LNV002','TK016',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0017', N'Nu', N'NGUY?N TH? THANH THÚY', N'2001-01-01 00:00:00.0000000', N'332652156', N'0945601333',N'Đang làm',N'LNV002','TK017',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0018', N'Nam', N'NGUY?N VAN VINH', N'2001-01-01 00:00:00.0000000', N'663280321', N'0945601334',N'Đang làm',N'LNV002','TK018',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0019', N'Nu', N'NGUY?N TH? SÁNG', N'2001-01-01 00:00:00.0000000', N'477912976', N'0945601335',N'Đang làm',N'LNV002','TK019',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0020', N'Nam', N'T? TI?N QUANG HÀO', N'2001-01-01 00:00:00.0000000', N'214452571', N'0945601336',N'Đang làm',N'LNV002','TK020',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0021', N'Nu', N'HU?NH TH? ÁNH H?NG', N'2001-01-01 00:00:00.0000000', N'777721195', N'0945601337',N'Đang làm',N'LNV002','TK021',N'Phường Hòa An,Quận Cẩm Lệ,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0022', N'Nam', N'LÊ THÀNH L?I', N'2001-01-01 00:00:00.0000000', N'346424043', N'0945601338',N'Đang làm',N'LNV002','TK022',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0023', N'Nam', N'PH?M HI?N NHÂN', N'2001-01-01 00:00:00.0000000', N'801546389', N'0945601339',N'Đang làm',N'LNV002','TK023',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0024', N'Nu', N'NGÔ TH? B?Y', N'2001-01-01 00:00:00.0000000', N'629316102', N'0945601340',N'Đang làm',N'LNV002','TK024',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0025', N'Nam', N'NGUY?N LÊ MINH SANG', N'2001-01-01 00:00:00.0000000', N'676768538', N'0945601341',N'Đang làm',N'LNV002','TK025',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0026', N'Nu', N'NGUY?N TH? TÚ LIÊN', N'2001-01-01 00:00:00.0000000', N'916617429', N'0945601342',N'Đang làm',N'LNV002','TK026',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0027', N'Nu', N'NGUY?N TH? PHÚ LIÊN', N'2001-01-01 00:00:00.0000000', N'162526565', N'0945601343',N'Đang làm',N'LNV002','TK027',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0028', N'Nam', N'SUH CANG HY', N'2001-01-01 00:00:00.0000000', N'819658551', N'0945601344',N'Đang làm',N'LNV002','TK028',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0029', N'Nam', N'NGUY?N K? NAM', N'2001-01-01 00:00:00.0000000', N'561502289', N'0945601345',N'Đang làm',N'LNV002','TK029',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0030', N'Nu', N'TR?N TH? XIÊM', N'2001-01-01 00:00:00.0000000', N'518456812', N'0945601346',N'Đang làm',N'LNV002','TK030',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0031', N'Nam', N'ÐINH THANH SANG', N'2001-01-01 00:00:00.0000000', N'497112385', N'0945601347',N'Đang làm',N'LNV002','TK031',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0032', N'Nam', N'LÊ HOÀNG TR?NG', N'2001-01-01 00:00:00.0000000', N'118705679', N'0945601348',N'Đang làm',N'LNV002','TK032',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0033', N'Nu', N'HU?NH TH? H?NG NGA', N'2001-01-01 00:00:00.0000000', N'228860116', N'0945601349',N'Đang làm',N'LNV002','TK033',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0034', N'Nam', N'LÂM NG?C PHU?NG', N'2001-01-01 00:00:00.0000000', N'265099490', N'0945601350',N'Đang làm',N'LNV002','TK034',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0035', N'Nu', N'NGUY?N TH? KIM NGÂN', N'2001-01-01 00:00:00.0000000', N'847266784', N'0945601351',N'Đang làm',N'LNV002','TK035',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0036', N'Nu', N'NGUY?N NG?C M?', N'2001-01-01 00:00:00.0000000', N'719705897', N'0945601352',N'Đang làm',N'LNV002','TK036',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0037', N'Nu', N'LÊ TH? THU HÀ', N'2001-01-01 00:00:00.0000000', N'852272269', N'0945601353',N'Đang làm',N'LNV002','TK037',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0038', N'Nu', N'NGUY?N TH? CÚC', N'2001-01-01 00:00:00.0000000', N'490259507', N'0945601354',N'Đang làm',N'LNV002','TK038',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0039', N'Nu', N'HU?NH TH? H?NG NGA', N'2001-01-01 00:00:00.0000000', N'975145490', N'0945601355',N'Đang làm',N'LNV002','TK039',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0040', N'Nam', N'NGUY?N H?NG H?I', N'2001-01-01 00:00:00.0000000', N'251699858', N'0945601356',N'Đang làm',N'LNV002','TK040',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0041', N'Nu', N'TRÀ TH? TUY?T THU', N'2001-01-01 00:00:00.0000000', N'424586968', N'0945601357',N'Đang làm',N'LNV002','TK041',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0042', N'Nu', N'PH?M TH? VI?T', N'2001-01-01 00:00:00.0000000', N'600804186', N'0945601358',N'Đang làm',N'LNV002','TK042',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0043', N'Nam', N'TR?N MINH TU?N', N'2001-01-01 00:00:00.0000000', N'563153298', N'0945601359',N'Đang làm',N'LNV002','TK043',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0044', N'Nam', N'TR?N VAN ÐÔNG', N'2001-01-01 00:00:00.0000000', N'267185145', N'0945601360',N'Đang làm',N'LNV002','TK044',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0045', N'Nam', N'LUONG THÀNH PHÚC', N'2001-01-01 00:00:00.0000000', N'446044855', N'0945601361',N'Đang làm',N'LNV002','TK045',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0046', N'Nam', N'NGUY?N NG?C Ð?NG', N'2001-01-01 00:00:00.0000000', N'574583404', N'0945601362',N'Đang làm',N'LNV002','TK046',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0047', N'Nam', N'HU?NH VAN NGÀ', N'2001-01-01 00:00:00.0000000', N'128312574', N'0945601363',N'Đang làm',N'LNV002','TK047',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0048', N'Nam', N'TR?NH H?I ÐANG', N'2001-01-01 00:00:00.0000000', N'185331584', N'0945601364',N'Đang làm',N'LNV002','TK048',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0049', N'Nu', N'NGUY?N TH? M? PHU?NG', N'2001-01-01 00:00:00.0000000', N'238534722', N'0945601365',N'Đang làm',N'LNV002','TK049',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0050', N'Nam', N'LÊ THANH PH?NG', N'2001-01-01 00:00:00.0000000', N'382302194', N'0945601366',N'Đang làm',N'LNV002','TK050',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0051', N'Nam', N'TR?N VAN TH?NG', N'2001-01-01 00:00:00.0000000', N'487529764', N'0945601367',N'Đang làm',N'LNV002','TK051',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0052', N'Nam', N'NGUY?N ÐÌNH PHONG', N'2001-01-01 00:00:00.0000000', N'826931275', N'0945601368',N'Đang làm',N'LNV002','TK052',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0053', N'Nu', N'NGUY?N TH? PHUONG DUNG', N'2001-01-01 00:00:00.0000000', N'187612904', N'0945601369',N'Đang làm',N'LNV002','TK053',N'Xã Hòa Nhơn,Huyện Hòa Vang,Thành phố Đà Nẵng' )
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0054', N'Nu', N'DUONG TH? THÙY TRANG', N'2001-01-01 00:00:00.0000000', N'658990706', N'0945601370',N'Đang làm',N'LNV002','TK054',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0055', N'Nu', N'Ð? THU HUONG', N'2001-01-01 00:00:00.0000000', N'218690496', N'0945601371',N'Đang làm',N'LNV002','TK055',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0056', N'Nam', N'NGUY?N THANH QUY?N', N'2001-01-01 00:00:00.0000000', N'976326214', N'0945601372',N'Đang làm',N'LNV002','TK056',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0057', N'Nam', N'TR?N THANH H?I', N'2001-01-01 00:00:00.0000000', N'598938981', N'0945601373',N'Đang làm',N'LNV002','TK057',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0058', N'Nam', N'HÙNG THÀNH CÔNG', N'2001-01-01 00:00:00.0000000', N'256782607', N'0945601374',N'Đang làm',N'LNV002','TK058',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0059', N'Nam', N'TR?N QU?C TU?N', N'2001-01-01 00:00:00.0000000', N'458457848', N'0945601375',N'Đang làm',N'LNV002','TK059',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0060', N'Nam', N'H? NG?C THANH HI?N', N'2001-01-01 00:00:00.0000000', N'787649814', N'0945601376',N'Đang làm',N'LNV002','TK060',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0061', N'Nam', N'NGUY?N TH? HÒA', N'2001-01-01 00:00:00.0000000', N'350351733', N'0945601377',N'Đang làm',N'LNV002','TK061',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0062', N'Nu', N'NGUY?N TH? Hu?', N'2001-01-01 00:00:00.0000000', N'492637311', N'0945601378',N'Đang làm',N'LNV002','TK062',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0063', N'Nam', N'AMELLIA NGUY?N', N'2001-01-01 00:00:00.0000000', N'601658206', N'0945601379',N'Đang làm',N'LNV002','TK063',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0064', N'Nam', N'TR?N MINH SON', N'2001-01-01 00:00:00.0000000', N'920633471', N'0945601380',N'Đang làm',N'LNV002','TK064',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0065', N'Nu', N'VÂN KIM LIÊN', N'2001-01-01 00:00:00.0000000', N'929368593', N'0945601381',N'Đang làm',N'LNV002','TK065',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0066', N'Nu', N'TR?N TH? THU H?NG', N'2001-01-01 00:00:00.0000000', N'102737486', N'0945601382',N'Đang làm',N'LNV002','TK066',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0067', N'Nu', N'LÂM TH? PHU?NG', N'2001-01-01 00:00:00.0000000', N'415249659', N'0945601383',N'Đang làm',N'LNV002','TK067',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0068', N'Nu', N'TR?N TH? TH?M', N'2001-01-01 00:00:00.0000000', N'545083215', N'0945601384',N'Đang làm',N'LNV002','TK068',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0069', N'Nam', N'ÐANG QUANG Ð?T', N'2001-01-01 00:00:00.0000000', N'630248585', N'0945601385',N'Đang làm',N'LNV002','TK069',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0070', N'Nam', N'NGUY?N HUY', N'2001-01-01 00:00:00.0000000', N'974705465', N'0945601386',N'Đang làm',N'LNV002','TK070',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0071', N'Nam', N'NGUY?N NG?C L?I', N'2001-01-01 00:00:00.0000000', N'312211891', N'0945601387',N'Đang làm',N'LNV002','TK071',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0072', N'Nu', N'HU?NH ÐOAN TRANG', N'2001-01-01 00:00:00.0000000', N'218732846', N'0945601388',N'Đang làm',N'LNV002','TK072',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0073', N'Nu', N'NGUY?N TH? DI?M PH?NG', N'2001-01-01 00:00:00.0000000', N'288616228', N'0945601389',N'Đang làm',N'LNV002','TK073',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0074', N'Nam', N'LÝ MINH HI?U', N'2001-01-01 00:00:00.0000000', N'336351069', N'0945601390',N'Đang làm',N'LNV002','TK074',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0075', N'Nam', N'TÔN CH?N VÕ', N'2001-01-01 00:00:00.0000000', N'187611170', N'0945601391',N'Đang làm',N'LNV002','TK075',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0076', N'Nam', N'LÝ TRUNG SON', N'2001-01-01 00:00:00.0000000', N'822455970', N'0945601392',N'Đang làm',N'LNV002','TK076',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0077', N'Nam', N'NGUY?N HÙNG BÌNH', N'2001-01-01 00:00:00.0000000', N'340598685', N'0945601393',N'Đang làm',N'LNV002','TK077',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0078', N'Nu', N'PHAN TH? M? DUNG', N'2001-01-01 00:00:00.0000000', N'957958937', N'0945601394',N'Đang làm',N'LNV002','TK078',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0079', N'Nu', N'NGUY?N TH? TH?O', N'2001-01-01 00:00:00.0000000', N'230508097', N'0945601395',N'Đang làm',N'LNV002','TK079',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0080', N'Nam', N'NGUY?N HOÀNG ANH', N'2001-01-01 00:00:00.0000000', N'508354413', N'0945601396',N'Đang làm',N'LNV002','TK080',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0081', N'Nam', N'VÕ H?U TO?I', N'2001-01-01 00:00:00.0000000', N'819889076', N'0945601397',N'Đang làm',N'LNV002','TK081',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0082', N'Nu', N'NGUY?N TH? KHUÊ BÍCH', N'2001-01-01 00:00:00.0000000', N'107477378', N'0945601398',N'Đang làm',N'LNV002','TK082',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0083', N'Nam', N'TR?N QUANG SINH', N'2001-01-01 00:00:00.0000000', N'391144624', N'0945601399',N'Đang làm',N'LNV002','TK083',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0084', N'Nam', N'THÁI SÁNG BÌNH', N'2001-01-01 00:00:00.0000000', N'758412343', N'0945601400',N'Đang làm',N'LNV002','TK084',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0085', N'Nam', N'HU?NH NG?C ÁNH', N'2001-01-01 00:00:00.0000000', N'803964720', N'0945601401',N'Đang làm',N'LNV002','TK085',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0086', N'Nam', N'PH?M NG?C THÀN', N'2001-01-01 00:00:00.0000000', N'632751190', N'0945601402',N'Đang làm',N'LNV002','TK086',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0087', N'Nu', N'TR?N TH? XUÂN H?NG', N'2001-01-01 00:00:00.0000000', N'183468709', N'0945601403',N'Đang làm',N'LNV002','TK087',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0088', N'Nu', N'NGUY?N TH? THU TH?Y', N'2001-01-01 00:00:00.0000000', N'581047473', N'0945601404',N'Đang làm',N'LNV002','TK088',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0089', N'Nam', N'THÁI MINH HÙNG', N'2001-01-01 00:00:00.0000000', N'471822981', N'0945601405',N'Đang làm',N'LNV002','TK089',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0090', N'Nam', N'VÕ THÀNH TÂM', N'2001-01-01 00:00:00.0000000', N'180750981', N'0945601406',N'Đang làm',N'LNV002','TK090', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0091', N'Nu', N'H? TH? NG?C C?M', N'2001-01-01 00:00:00.0000000', N'545918939', N'0945601407',N'Đang làm',N'LNV002','TK091', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0092', N'Nam', N'NGUY?N NG?C TH?CH', N'2001-01-01 00:00:00.0000000', N'888949528', N'0945601408',N'Đang làm',N'LNV002','TK092', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0093', N'Nu', N'T? QU? LAN', N'2001-01-01 00:00:00.0000000', N'273905310', N'0945601409',N'Đang làm',N'LNV002','TK093', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0094', N'Nu', N'MAI TH? THANH HUY?N', N'2001-01-01 00:00:00.0000000', N'266293441', N'0945601410',N'Đang làm',N'LNV002','TK094', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0095', N'Nu', N'CHÂU TH?C MAI', N'2001-01-01 00:00:00.0000000', N'607858860', N'0945601411',N'Đang làm',N'LNV002','TK095', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0096', N'Nu', N'NGUY?N TH? BÍCH TRÂM', N'2001-01-01 00:00:00.0000000', N'914209881', N'0945601412',N'Nghĩ việc',N'LNV002','TK096', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0097', N'Nu', N'NGUY?N TH? HOÀNG TRANG', N'2001-01-01 00:00:00.0000000', N'496693162', N'0945601413',N'Đang làm',N'LNV002','TK097', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0098', N'Nu', N'HU?NH TH? THU HU?NG', N'2001-01-01 00:00:00.0000000', N'449695586', N'0945601414',N'Đang làm',N'LNV002','TK098', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0099', N'Nu', N'VU THU TH?Y', N'2001-01-01 00:00:00.0000000', N'837607714', N'0945601415',N'Đang làm',N'LNV002','TK099', N'Phường An Hòa,Quận Ninh Kiều,Thành phố Cần Thơ')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec],[maLNV], [maTK],[diaChi] ) VALUES (N'NVAA0100', N'Nam', N'PH?M THANH SI', N'2001-01-01 00:00:00.0000000', N'8262644681', N'0945601416',N'Đang làm', N'LNV002','TK100',N'Phường Thới Hòa,Quận Ô Môn,Thành phố Cần Thơ')






SELECT * FROM [dbo].[TrangThaiPhong]
INSERT [dbo].[TrangThaiPhong] ([maTTP], [tenTrangThaiPhong]) VALUES (N'TTP001', N'Phòng bận')
INSERT [dbo].[TrangThaiPhong] ([maTTP], [tenTrangThaiPhong]) VALUES (N'TTP002', N'Phòng chờ')
INSERT [dbo].[TrangThaiPhong] ([maTTP], [tenTrangThaiPhong]) VALUES (N'TTP003', N'Phòng trống')
INSERT [dbo].[TrangThaiPhong] ([maTTP], [tenTrangThaiPhong]) VALUES (N'TTP004', N'Phòng tạm')

SELECT * FROM [dbo].[LoaiPhong]
INSERT [dbo].[LoaiPhong] ([maLP], [giaTien], [tenLoaiPhong]) VALUES (N'LP001', 100000, N'Phòng Thường')
INSERT [dbo].[LoaiPhong] ([maLP], [giaTien], [tenLoaiPhong]) VALUES (N'LP002', 180000, N'Phòng Vip')


SELECT * FROM [dbo].[Phong]

INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P001', 10, N'P01',N'Bình thường', N'LP001', N'TTP003')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P002', 12, N'P02',N'Bình thường', N'LP001', N'TTP001')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P003', 5, N'P03',N'Bình thường', N'LP001', N'TTP001')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P004', 15, N'P04',N'Bình thường', N'LP001', N'TTP001')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P005', 10, N'P06',N'Bình thường', N'LP002', N'TTP001')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P006', 10, N'P07',N'Bình thường', N'LP002', N'TTP001')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P007', 10, N'P08',N'Bình thường', N'LP002', N'TTP003')
INSERT [dbo].[Phong] ([maPhong], [soNguoi], [tenPhong], [tinhTrangPhong], [maLP], [maTTP]) VALUES (N'P008', 10, N'P09',N'Bình thường', N'LP002', N'TTP001')


SELECT * FROM [dbo].[DichVu]
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV001',15000,500,N'Bia SaiGon')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV002',18000,500,N'Bia Tiger')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV003',18000,500,N'Bia Ruby')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV004',75000,500,N'Rựu SoJu')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV005',200000,200,N'Combo Trái Cây 1')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV006',250000,200,N'Combo Trái Cây 2')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV007',250000,200,N'Combo Trái Cây 3')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV008',250000,100,N'Combo Trái Cây 4')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV009',250000,100,N'Combo Trái Cây 5')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV0010',15000,500,N'Sting')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV0011',15000,500,N'RedBull')
INSERT [dbo].[DichVu] ([maDV],[donGia],[soLuong],[tenDichVu]) VALUES ('DV0012',15000,500,N'Nước Suối')


SELECT * FROM [dbo].[HoaDon]

INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA001',CAST(N'2021-01-01T00:00:00.0000000' AS DateTime2), CAST(N'2021-01-01T00:00:00.0000000' AS DateTime2), CAST(N'2021-01-01T00:00:00.0000000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA004',CAST(N'2021-11-19T11:29:24.5110000' AS DateTime2), CAST(N'2021-11-19T11:29:24.5110000' AS DateTime2), CAST(N'2021-11-19T11:29:24.5110000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA005',CAST(N'2021-11-20T10:26:22.5340000' AS DateTime2), CAST(N'2021-11-20T10:26:22.5340000' AS DateTime2), CAST(N'2021-11-20T10:26:22.5340000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA006',CAST(N'2021-11-23T19:39:03.5000000' AS DateTime2), CAST(N'2021-11-23T19:39:03.5000000' AS DateTime2), CAST(N'2021-11-23T19:39:03.5000000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA007',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T18:41:05.5130000' AS DateTime2), CAST(N'2021-11-24T18:41:05.5130000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA008',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T18:41:51.1660000' AS DateTime2), CAST(N'2021-11-24T18:41:51.1660000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA009',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T18:42:08.3610000' AS DateTime2), CAST(N'2021-11-24T18:42:08.3610000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA010',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T19:45:15.2540000' AS DateTime2), CAST(N'2021-11-24T19:45:15.2540000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA012',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T19:59:20.8880000' AS DateTime2), CAST(N'2021-11-24T19:59:20.8880000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA013',CAST(N'2021-11-24T22:11:40.7560000' AS DateTime2), CAST(N'2021-11-24T20:00:30.1760000' AS DateTime2), CAST(N'2021-11-24T20:00:30.1760000' AS DateTime2), 5984291, 5984291,N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA014',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:01:21.3010000' AS DateTime2), CAST(N'2021-11-24T20:01:21.3010000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA015',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:28:04.9280000' AS DateTime2), CAST(N'2021-11-24T20:28:04.9280000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA016',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:30:50.0890000' AS DateTime2), CAST(N'2021-11-24T20:30:50.0890000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA017',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:37:30.1770000' AS DateTime2), CAST(N'2021-11-24T20:37:30.1770000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA018',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:40:03.4350000' AS DateTime2), CAST(N'2021-11-24T20:40:03.4350000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA020',CAST(N'2021-11-24T21:35:50.9920000' AS DateTime2), CAST(N'2021-11-24T20:45:39.7250000' AS DateTime2), CAST(N'2021-11-24T20:45:39.7250000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA022',CAST(N'2021-11-24T21:25:22.9470000' AS DateTime2), CAST(N'2021-11-24T21:25:22.9380000' AS DateTime2), CAST(N'2021-11-24T21:25:22.9380000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA023',CAST(N'2021-11-24T21:29:48.3980000' AS DateTime2), CAST(N'2021-11-24T21:29:48.3820000' AS DateTime2), CAST(N'2021-11-24T21:29:48.3820000' AS DateTime2), 20000, 20000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA024',CAST(N'2021-11-24T21:34:35.8730000' AS DateTime2), CAST(N'2021-11-24T21:34:35.8600000' AS DateTime2), CAST(N'2021-11-24T21:34:35.8600000' AS DateTime2), 130000, 130000, N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA030',CAST(N'2021-11-25T09:33:39.9210000' AS DateTime2), CAST(N'2021-11-25T09:33:39.9050000' AS DateTime2), CAST(N'2021-11-25T09:33:39.9050000' AS DateTime2), 130000, 130000, N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA031',CAST(N'2021-11-25T15:03:25.8450000' AS DateTime2), CAST(N'2021-11-25T15:03:25.8270000' AS DateTime2), CAST(N'2021-11-25T15:03:25.8270000' AS DateTime2), 130000, 130000, N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA039',CAST(N'2021-11-26T08:19:33.7360000' AS DateTime2), CAST(N'2021-11-26T08:19:33.7270000' AS DateTime2), CAST(N'2021-11-26T08:19:33.7270000' AS DateTime2), 130000, 130000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA040',CAST(N'2021-11-26T08:22:43.8190000' AS DateTime2), CAST(N'2021-11-26T08:22:43.8050000' AS DateTime2), CAST(N'2021-11-26T08:22:43.8050000' AS DateTime2), 130000, 130000,  N'KHAA001',  N'NVAA0003')
INSERT [dbo].[HoaDon] ([maHD], [gioKetThuc], [gioNhanPhong], [ngayLap], [tienKhachTra],[tongTien] ,[maKH],[maNV]) VALUES (N'HDAA041',CAST(N'2021-11-26T08:23:43.4170000' AS DateTime2), CAST(N'2021-11-26T08:23:43.4060000' AS DateTime2), CAST(N'2021-11-26T08:23:43.4060000' AS DateTime2), 218000, 218000,  N'KHAA001',  N'NVAA0003')


SELECT * FROM [dbo].[ChiTietHoaDon]

INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA004', N'P002', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA005', N'P001', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA007', N'P005', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA008', N'P004', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA012', N'P008', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA016', N'P007', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA022', N'P006', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA031', N'P004', 0)





SELECT * FROM [dbo].[ChiTietDichVu]
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA024', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA023', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA013', 10) 
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA013', 22) 
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA013', 11) 
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA005', 0)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA005', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA006', 10)

SELECT * FROM [dbo].[PhieuDatPhong]

INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA003', CAST(N'2021-11-25T15:07:06.4210000' AS DateTime2), CAST(N'2021-11-25T15:07:06.3470000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P001')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA001', CAST(N'2021-11-25T14:57:10.0180000' AS DateTime2), CAST(N'2021-11-25T14:57:09.9390000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P003')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA002', CAST(N'2021-11-25T15:05:57.0480000' AS DateTime2), CAST(N'2021-11-25T15:05:56.9800000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P005')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA004', CAST(N'2021-11-25T15:10:01.3610000' AS DateTime2), CAST(N'2021-11-26T15:10:01.2770000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P006')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA005', CAST(N'2021-11-25T15:20:29.9090000' AS DateTime2), CAST(N'2021-11-25T15:20:29.8310000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P009')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA006', CAST(N'2021-11-25T15:38:45.2730000' AS DateTime2), CAST(N'2021-11-25T15:38:45.1750000' AS DateTime2),N'Bình thường', N'KHAA107', N'NVAA0001', N'P010')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA007', CAST(N'2021-11-25T16:18:03.1400000' AS DateTime2), CAST(N'2021-11-26T16:18:02.1720000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P022')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA008', CAST(N'2021-11-25T23:43:52.1410000' AS DateTime2), CAST(N'2021-11-26T23:43:50.7910000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P018')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA009', CAST(N'2021-11-25T23:44:25.3620000' AS DateTime2), CAST(N'2021-11-26T23:44:14.6880000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P001')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA010', CAST(N'2021-11-26T08:10:24.1570000' AS DateTime2), CAST(N'2021-11-27T08:10:22.5220000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P001')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA011', CAST(N'2021-11-26T08:13:37.7060000' AS DateTime2), CAST(N'2021-11-27T08:13:36.3620000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA012', CAST(N'2021-11-26T08:14:28.3920000' AS DateTime2), CAST(N'2021-11-27T08:14:27.3120000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P007')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA013', CAST(N'2021-11-26T08:18:04.2280000' AS DateTime2), CAST(N'2021-11-27T08:18:03.0280000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P013')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA014', CAST(N'2021-11-26T08:19:25.4500000' AS DateTime2), CAST(N'2021-11-27T08:19:24.4790000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P024')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA015', CAST(N'2021-11-26T08:19:58.1610000' AS DateTime2), CAST(N'2021-11-27T08:19:57.4460000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P022')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA016', CAST(N'2021-11-26T08:20:26.7220000' AS DateTime2), CAST(N'2021-11-27T08:20:25.7500000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P025')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA017', CAST(N'2021-11-26T08:22:35.8070000' AS DateTime2), CAST(N'2021-11-27T08:22:33.5600000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P020')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA018', CAST(N'2021-11-26T08:23:40.6870000' AS DateTime2), CAST(N'2021-11-27T08:23:39.0320000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P027')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA019', CAST(N'2021-11-26T08:31:44.6650000' AS DateTime2), CAST(N'2021-11-27T08:31:43.5600000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P026')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA020', CAST(N'2021-11-26T08:33:32.0020000' AS DateTime2), CAST(N'2021-11-27T08:33:31.0010000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P026')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA021', CAST(N'2021-11-26T08:34:28.3220000' AS DateTime2), CAST(N'2021-11-27T08:34:27.2240000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P007')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA022', CAST(N'2021-11-26T08:36:47.0080000' AS DateTime2), CAST(N'2021-11-27T08:36:46.0770000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA023', CAST(N'2021-11-26T08:37:46.1680000' AS DateTime2), CAST(N'2021-11-27T08:37:45.4830000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA024', CAST(N'2021-11-26T08:50:55.9610000' AS DateTime2), CAST(N'2021-11-27T08:50:54.8910000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA025', CAST(N'2021-11-26T08:58:25.6290000' AS DateTime2), CAST(N'2021-11-27T08:58:24.6380000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA026', CAST(N'2021-11-26T09:02:51.3510000' AS DateTime2), CAST(N'2021-11-27T09:02:47.5050000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P015')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA027', CAST(N'2021-11-26T09:10:46.3780000' AS DateTime2), CAST(N'2021-11-27T09:10:44.9500000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P003')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA028', CAST(N'2021-11-26T09:12:03.6600000' AS DateTime2), CAST(N'2021-11-27T09:12:02.6970000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P003')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA029', CAST(N'2021-11-26T09:24:14.4570000' AS DateTime2), CAST(N'2021-11-27T09:24:13.4280000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P003')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA030', CAST(N'2021-11-26T09:27:57.7930000' AS DateTime2), CAST(N'2021-11-27T09:27:56.7680000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P025')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA031', CAST(N'2021-11-26T10:46:46.6080000' AS DateTime2), CAST(N'2021-11-27T10:46:44.8810000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P002')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA032', CAST(N'2021-11-26T11:03:29.9420000' AS DateTime2), CAST(N'2021-11-26T11:03:28.7390000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P004')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA033', CAST(N'2021-11-26T11:07:12.1330000' AS DateTime2), CAST(N'2021-11-26T12:00:11.0250000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P011')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA034', CAST(N'2021-11-26T11:12:02.4720000' AS DateTime2), CAST(N'2021-11-26T12:00:01.3820000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P005')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA035', CAST(N'2021-11-26T11:21:58.1580000' AS DateTime2), CAST(N'2021-11-26T11:25:56.6730000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P006')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA036', CAST(N'2021-11-26T11:24:40.0070000' AS DateTime2), CAST(N'2021-11-26T11:20:37.9610000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P014')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA037', CAST(N'2021-11-26T11:29:21.4470000' AS DateTime2), CAST(N'2021-11-26T11:30:20.4140000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P008')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA038', CAST(N'2021-11-26T13:10:55.1040000' AS DateTime2), CAST(N'2021-11-27T01:00:54.3610000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P020')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA039', CAST(N'2021-11-26T13:19:04.3450000' AS DateTime2), CAST(N'2021-11-27T03:00:03.0620000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P002')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA040', CAST(N'2021-11-26T13:19:21.8330000' AS DateTime2), CAST(N'2021-11-27T01:00:20.9320000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P002')
INSERT [dbo].[PhieuDatPhong] ([maPDP], [thoiGianDangKyDatPhong], [thoiGianNhanPhong], [tinhTrangPhong], [maKH], [maNV], [maPhong]) VALUES (N'PDPAA041', CAST(N'2021-11-26T13:19:34.3000000' AS DateTime2), CAST(N'2021-11-27T01:00:33.7010000' AS DateTime2),N'Bình thường', N'KHAA103', N'NVAA0001', N'P004')
