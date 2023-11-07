﻿
use master 

drop DATABASE[Karaoke4T]
create DATABASE[Karaoke4T]
USE [Karaoke4T]

/****** Object:  Table [dbo].[ChiTietDichVu]     ******/
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    ******/
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

/****** Object:  Table [dbo].[DichVu]    ******/
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
/****** Object:  Table [dbo].[HoaDon]   ******/
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
/****** Object:  Table [dbo].[KhachHang]     ******/
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
	[maDC] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/****** Object:  Table [dbo].[LoaiNhanVien]    ******/
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
/****** Object:  Table [dbo].[LoaiPhong]    ******/
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
/****** Object:  Table [dbo].[NhanVien]    ******/
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
	[maDC] [varchar](10) NULL,
	[maLNV] [varchar](10) NULL,
	[maTK] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Phong]   ******/
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
/****** Object:  Table [dbo].[TrangThaiPhong]     ******/
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

/****** Object:  Table [dbo].[DiaChi]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaChi](
	[maDC] [varchar](10) NOT NULL,
	[phuongXa] [nvarchar](max) NULL,
	[quanHuyen] [nvarchar](max) NULL,
	[tinhTP] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/****** Object:  Table [dbo].[TaiKhoan]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [varchar](10) NOT NULL,
	[tenTK] [nvarchar](max) NULL,
	[MK] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO




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
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK592pmnnm2sm98xbre6r63cqa4] FOREIGN KEY([maLNV])
REFERENCES [dbo].[LoaiNhanVien] ([maLNV])

GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK592pmnnm2sm98xbre6r63cqa4]



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


ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK5tlbi42hvoctodk23eiohcc9l] FOREIGN KEY([maDC])
REFERENCES [dbo].[DiaChi] ([maDC])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK5tlbi42hvoctodk23eiohcc9l]
GO

ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FKiba0wt7q374ij2ewwixhddy5a] FOREIGN KEY([maDC])
REFERENCES [dbo].[DiaChi] ([maDC])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FKiba0wt7q374ij2ewwixhddy5a]
GO




SELECT * FROM [dbo].[ChiTietDichVu]

SELECT * FROM [dbo].[ChiTietHoaDon]

SELECT * FROM [dbo].[HoaDon]

SELECT * FROM [dbo].[DiaChi]
SELECT * FROM [dbo].[DichVu]
SELECT * FROM [dbo].[LoaiNhanVien]
SELECT * FROM [dbo].[LoaiPhong]
SELECT * FROM [dbo].[KhachHang]
SELECT * FROM [dbo].[NhanVien]
SELECT * FROM [dbo].[Phong]
SELECT * FROM [dbo].[TrangThaiPhong]
SELECT * FROM [dbo].[TaiKhoan]
SELECT * FROM [dbo].[DiaChi]

GO
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00001', N'Thị trấn Cờ Đỏ', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00002', N'Xã Đông Hiệp', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00003', N'Xã Đông Thắng', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00004', N'Xã Thạnh Phú', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00005', N'Xã Thới Đông', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00006', N'Xã Thới Hưng', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00007', N'Xã Thới Xuân', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00008', N'Xã Trung An', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00009', N'Xã Trung Hưng', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00010', N'Xã Trung Thạnh', N'Huyện Cờ Đỏ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00011', N'Thị trấn Phong Điền', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00012', N'Xã Giai Xuân', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00013', N'Xã Mỹ Khánh', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00014', N'Xã Nhơn Ái', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00015', N'Xã Nhơn Nghĩa', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00016', N'Xã Tân Thới', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00017', N'Xã Trường Long', N'Huyện Phong Điền', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00018', N'Thị trấn Thới Lai', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00019', N'Xã Định Môn', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00020', N'Xã Đông Bình', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00021', N'Xã Đông Thuận', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00022', N'Xã Tân Thạnh', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00023', N'Xã Thới Tân', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00024', N'Xã Thới Thạnh', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00025', N'Xã Trường Thắng', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00026', N'Xã Trường Thành', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00027', N'Xã Trường Xuân', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00028', N'Xã Trường Xuân A', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00029', N'Xã Trường Xuân B', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00030', N'Xã Xuân Thắng', N'Huyện Thới Lai', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00031', N'Thị trấn Thanh An', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00032', N'Thị trấn Vĩnh Thạnh', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00033', N'Xã Thạnh An', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00034', N'Xã Thạnh Lộc', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00035', N'Xã Thạnh Lợi', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00036', N'Xã Thạnh Mỹ', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00037', N'Xã Thạnh Qưới', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00038', N'Xã Thạnh Thắng', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00039', N'Xã Thạnh Tiến', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00040', N'Xã Vĩnh Bình', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00041', N'Xã Vĩnh Trinh', N'Huyện Vĩnh Thạnh', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00042', N'Phường An Thới', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00043', N'Phường Bình Thủy', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00044', N'Phường Bùi Hữu Nghĩa', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00045', N'Phường Long Hòa', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00046', N'Phường Long Tuyền', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00047', N'Phường Thới An Đông', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00048', N'Phường Trà An', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00049', N'Phường Trà Nóc', N'Quận Bình Thuỷ', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00050', N'Phường Ba Láng', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00051', N'Phường Hưng Phú', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00052', N'Phường Hưng Thạnh', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00053', N'Phường Lê Bình', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00054', N'Phường Phú Thứ', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00055', N'Phường Tân Phú', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00056', N'Phường Thường Thạnh', N'Quận Cái Răng', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00057', N'Phường An Bình', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00058', N'Phường An Cư', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00059', N'Phường An Hòa', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00060', N'Phường An Hội', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00061', N'Phường An Khánh', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00062', N'Phường An Lạc', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00063', N'Phường An Nghiệp', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00064', N'Phường An Phú', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00065', N'Phường Cái Khế', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00066', N'Phường Hưng Lợi', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00067', N'Phường Tân An', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00068', N'Phường Thới Bình', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00069', N'Phường Xuân Khánh', N'Quận Ninh Kiều', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00070', N'Phường Châu Văn Liêm', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00071', N'Phường Long Hưng', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00072', N'Phường Phước Thới', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00073', N'Phường Thới An', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00074', N'Phường Thới Hòa', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00075', N'Phường Thới Long', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00076', N'Phường Trường Lạc', N'Quận Ô Môn', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00077', N'Phường Tân Hưng', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00078', N'Phường Tân Lộc', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00079', N'Phường Thạnh Hoà', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00080', N'Phường Thới Thuận', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00081', N'Phường Thốt Nốt', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00082', N'Phường Thuận An', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00083', N'Phường Thuận Hưng', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00084', N'Phường Trung Kiên', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00085', N'Phường Trung Nhứt', N'Quận Thốt Nốt', N'Thành phố Cần Thơ')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00086', N'Xã Hòa Bắc', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00087', N'Xã Hòa Châu', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00088', N'Xã Hòa Khương', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00089', N'Xã Hòa Liên', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00090', N'Xã Hòa Nhơn', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00091', N'Xã Hòa Ninh', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00092', N'Xã Hòa Phong', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00093', N'Xã Hòa Phú', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00094', N'Xã Hòa Phước', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00095', N'Xã Hòa Sơn', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00096', N'Xã Hòa Tiến', N'Huyện Hòa Vang', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00097', N'Phường Hòa An', N'Quận Cẩm Lệ', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00098', N'Phường Hòa Phát', N'Quận Cẩm Lệ', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00099', N'Phường Hòa Thọ Đông', N'Quận Cẩm Lệ', N'Thành phố Đà Nẵng')
INSERT [dbo].[DiaChi] ([maDC], [phuongXa], [quanHuyen], [tinhTP]) VALUES (N'DC00100', N'Phường Hòa Thọ Tây', N'Quận Cẩm Lệ', N'Thành phố Đà Nẵng')
GO







SELECT * FROM [dbo].[KhachHang]

INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA001',N'123456789' ,N'Nam', N'BuiMinh',N'0945601318', N'DC00001')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA002',N'123456789' ,N'Nam', N'HaHuyHoang',N'0857526421', N'DC09182')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA003',N'123456789' ,N'Nam', N'Hà Huy Hoàng',N'0857363523', N'DC04819')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA004',N'123456789' ,N'Nu', N'Dương Thị Diễm',N'0945612345', N'DC01206')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA005',N'123456789' ,N'Nam', N'TRẦN THANH NAM',N'0945601321', N'DC02839')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA006',N'123456789' ,N'Nu', N'ĐÀO MINH TUYẾT',N'0945601322', N'DC09183')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA007',N'123456789' ,N'Nu', N'HUỲNH HIẾU THẢO',N'0945601323', N'DC00007')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA008',N'123456789' ,N'Nu', N'NGUYỄN THỊ THANH VÂN',N'0945601324', N'DC00008')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA009',N'123456789' ,N'Nam', N'NGUYỄN VĂN CHƯƠNG',N'0945601325', N'DC00009')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA010',N'123456789' ,N'Nu', N'HÀ THỊ NGỌC ÁNH',N'0945601326', N'DC00010')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA011',N'123456789' ,N'Nu', N'LÊ THỊ RỚT',N'0945601327', N'DC00011')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA012',N'123456789' ,N'Nu', N'NGUYỄN THỊ NGỌC TUYẾT',N'0945601328', N'DC00012')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA013',N'123456789' ,N'Nu', N'BÙI NGUYỄN NGUYỆT DUNG',N'0945601329', N'DC00013')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA014',N'123456789' ,N'Nam', N'LƯU VĂN XÂY',N'0945601330', N'DC00014')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA015',N'123456789' ,N'Nam', N'VŨ VĂN NHẬT HÙNG',N'0945601331', N'DC00015')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA016',N'123456789' ,N'Nam', N'TRẦN VĂN THIỆN',N'0945601332', N'DC00016')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA017',N'123456789' ,N'Nu', N'NGUYỄN THỊ THANH THÚY',N'0945601333', N'DC00017')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA018',N'123456789' ,N'Nam', N'NGUYỄN VĂN VINH',N'0945601334', N'DC00018')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA019',N'123456789' ,N'Nu', N'NGUYỄN THỊ SÁNG',N'0945601335', N'DC00019')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA020',N'123456789' ,N'Nam', N'TỪ TIẾN QUANG HÀO',N'0945601336', N'DC00020')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA021',N'123456789' ,N'Nu', N'HUỲNH THỊ ÁNH HỒNG',N'0945601337', N'DC00021')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA022',N'123456789' ,N'Nam', N'LÊ THÀNH LỢI',N'0945601338', N'DC00022')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA023',N'123456789' ,N'Nam', N'PHẠM HIỀN NHÂN',N'0945601339', N'DC00023')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA024',N'123456789' ,N'Nu', N'NGÔ THỊ BẢY',N'0945601340', N'DC00024')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA025',N'123456789' ,N'Nam', N'NGUYỄN LÊ MINH SANG',N'0945601341', N'DC00025')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA026',N'123456789' ,N'Nu', N'NGUYỄN THỊ TÚ LIÊN',N'0945601342', N'DC00026')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA027',N'123456789' ,N'Nu', N'NGUYỄN THỊ PHÚ LIÊN',N'0945601343', N'DC00027')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA028',N'123456789' ,N'Nam', N'SUH CANG HY',N'0945601344', N'DC00028')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA029',N'123456789' ,N'Nam', N'NGUYỄN KỲ NAM',N'0945601345', N'DC00029')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA030',N'123456789' ,N'Nu', N'TRẦN THỊ XIÊM',N'0945601346', N'DC00030')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA031',N'123456789' ,N'Nam', N'ĐINH THANH SANG',N'0945601347', N'DC00031')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA032',N'123456789' ,N'Nam', N'LÊ HOÀNG TRỌNG',N'0945601348', N'DC00032')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA033',N'123456789' ,N'Nu', N'HUỲNH THỊ HỒNG NGA',N'0945601349', N'DC00033')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA034',N'123456789' ,N'Nam', N'LÂM NGỌC PHƯỢNG',N'0945601350', N'DC00034')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA035',N'123456789' ,N'Nu', N'NGUYỄN THỊ KIM NGÂN',N'0945601351', N'DC00035')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA036',N'123456789' ,N'Nu', N'NGUYỄN NGỌC MỸ',N'0945601352', N'DC00036')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA037',N'123456789' ,N'Nu', N'LÊ THỊ THU HÀ',N'0945601353', N'DC00037')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA038',N'123456789' ,N'Nu', N'NGUYỄN THỊ CÚC',N'0945601354', N'DC00038')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA039',N'123456789' ,N'Nu', N'HUỲNH THỊ HỒNG NGA',N'0945601355', N'DC00039')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA040',N'123456789' ,N'Nam', N'NGUYỄN HỒNG HẢI',N'0945601356', N'DC00040')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA041',N'123456789' ,N'Nu', N'TRÀ THỊ TUYẾT THU',N'0945601357', N'DC00041')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA042',N'123456789' ,N'Nu', N'PHẠM THỊ VIỆT',N'0945601358', N'DC00042')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA043',N'123456789' ,N'Nam', N'TRẦN MINH TUẤN',N'0945601359', N'DC00043')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA044',N'123456789' ,N'Nam', N'TRẦN VĂN ĐÔNG',N'0945601360', N'DC00044')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA045',N'123456789' ,N'Nam', N'LƯƠNG THÀNH PHÚC',N'0945601361', N'DC00045')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA046',N'123456789' ,N'Nam', N'NGUYỄN NGỌC ĐẰNG',N'0945601362', N'DC00046')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA047',N'123456789' ,N'Nam', N'HUỲNH VĂN NGÀ',N'0945601363', N'DC00047')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA048',N'123456789' ,N'Nam', N'TRỊNH HẢI ĐĂNG',N'0945601364', N'DC00048')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA049',N'123456789' ,N'Nu', N'NGUYỄN THỊ MỸ PHƯỢNG',N'0945601365', N'DC00049')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA050',N'123456789' ,N'Nam', N'LÊ THANH PHỤNG',N'0945601366', N'DC00050')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA051',N'123456789' ,N'Nam', N'TRẦN VĂN THẮNG',N'0945601367', N'DC00051')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA052',N'123456789' ,N'Nam', N'NGUYỄN ĐÌNH PHONG',N'0945601368', N'DC00052')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA053',N'123456789' ,N'Nu', N'NGUYỄN THỊ PHƯƠNG DUNG',N'0945601369', N'DC00053')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA054',N'123456789' ,N'Nu', N'DƯƠNG THỊ THÙY TRANG',N'0945601370', N'DC00054')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA055',N'123456789' ,N'Nu', N'ĐỖ THU HƯƠNG',N'0945601371', N'DC00055')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA056',N'123456789' ,N'Nam', N'NGUYỄN THANH QUYỀN',N'0945601372', N'DC00056')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA057',N'123456789' ,N'Nam', N'TRẦN THANH HẢI',N'0945601373', N'DC00057')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA058',N'123456789' ,N'Nam', N'HÙNG THÀNH CÔNG',N'0945601374', N'DC00058')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA059',N'123456789' ,N'Nam', N'TRẦN QUỐC TUẤN',N'0945601375', N'DC00059')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA060',N'123456789' ,N'Nam', N'HỒ NGỌC THANH HIỀN',N'0945601376', N'DC00060')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA061',N'123456789' ,N'Nam', N'NGUYỄN THỊ HÒA',N'0945601377', N'DC00061')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA062',N'123456789' ,N'Nu', N'NGUYỄN THỊ Huệ',N'0945601378', N'DC00062')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA063',N'123456789' ,N'Nam', N'AMELLIA NGUYỄN',N'0945601379', N'DC00063')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA064',N'123456789' ,N'Nam', N'TRẦN MINH SƠN',N'0945601380', N'DC00064')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA065',N'123456789' ,N'Nu', N'VÂN KIM LIÊN',N'0945601381', N'DC00065')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA066',N'123456789' ,N'Nu', N'TRẦN THỊ THU HỒNG',N'0945601382', N'DC00066')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA067',N'123456789' ,N'Nu', N'LÂM THỊ PHƯỢNG',N'0945601383', N'DC00067')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA068',N'123456789' ,N'Nu', N'TRẦN THỊ THẮM',N'0945601384', N'DC00068')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA069',N'123456789' ,N'Nam', N'ĐĂNG QUANG ĐẠT',N'0945601385', N'DC00069')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA070',N'123456789' ,N'Nam', N'NGUYỄN HUY',N'0945601386', N'DC00070')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA071',N'123456789' ,N'Nam', N'NGUYỄN NGỌC LỢI',N'0945601387', N'DC00071')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA072',N'123456789' ,N'Nu', N'HUỲNH ĐOAN TRANG',N'0945601388', N'DC00072')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA073',N'123456789' ,N'Nu', N'NGUYỄN THỊ DIỄM PHỤNG',N'0945601389', N'DC00073')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA074',N'123456789' ,N'Nam', N'LÝ MINH HIẾU',N'0945601390', N'DC00074')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA075',N'123456789' ,N'Nam', N'TÔN CHẤN VÕ',N'0945601391', N'DC00075')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA076',N'123456789' ,N'Nam', N'LÝ TRUNG SƠN',N'0945601392', N'DC00076')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA077',N'123456789' ,N'Nam', N'NGUYỄN HÙNG BÌNH',N'0945601393', N'DC00077')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA078',N'123456789' ,N'Nu', N'PHAN THỊ MỸ DUNG',N'0945601394', N'DC00078')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA079',N'123456789' ,N'Nu', N'NGUYỄN THỊ THẢO',N'0945601395', N'DC00079')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA080',N'123456789' ,N'Nam', N'NGUYỄN HOÀNG ANH',N'0945601396', N'DC00080')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA081',N'123456789' ,N'Nam', N'VÕ HỮU TOẠI',N'0945601397', N'DC00081')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA082',N'123456789' ,N'Nu', N'NGUYỄN THỊ KHUÊ BÍCH',N'0945601398', N'DC00082')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA083',N'123456789' ,N'Nam', N'TRẦN QUANG SINH',N'0945601399', N'DC00083')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA084',N'123456789' ,N'Nam', N'THÁI SÁNG BÌNH',N'0945601400', N'DC00084')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA085',N'123456789' ,N'Nam', N'HUỲNH NGỌC ÁNH',N'0945601401', N'DC00085')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA086',N'123456789' ,N'Nam', N'PHẠM NGỌC THÀN',N'0945601402', N'DC00086')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA087',N'123456789' ,N'Nu', N'TRẦN THỊ XUÂN HỒNG',N'0945601403', N'DC00087')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA088',N'123456789' ,N'Nu', N'NGUYỄN THỊ THU THỦY',N'0945601404', N'DC00088')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA089',N'123456789' ,N'Nam', N'THÁI MINH HÙNG',N'0945601405', N'DC00089')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA090',N'123456789' ,N'Nam', N'VÕ THÀNH TÂM',N'0945601406', N'DC00090')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA091',N'123456789' ,N'Nu', N'HỒ THỊ NGỌC CẨM',N'0945601407', N'DC00091')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA092',N'123456789' ,N'Nam', N'NGUYỄN NGỌC THẠCH',N'0945601408', N'DC00092')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA093',N'123456789' ,N'Nu', N'TỪ QUẾ LAN',N'0945601409', N'DC00093')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA094',N'123456789' ,N'Nu', N'MAI THỊ THANH HUYỀN',N'0945601410', N'DC00094')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA095',N'123456789' ,N'Nu', N'CHÂU THỤC MAI',N'0945601411', N'DC00095')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA096',N'123456789' ,N'Nu', N'NGUYỄN THỊ BÍCH TRÂM',N'0945601412', N'DC00096')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA097',N'123456789' ,N'Nu', N'NGUYỄN THỊ HOÀNG TRANG',N'0945601413', N'DC00097')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA098',N'123456789' ,N'Nu', N'HUỲNH THỊ THU HƯỜNG',N'0945601414', N'DC00098')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA099',N'123456789' ,N'Nu', N'VŨ THU THỦY',N'0945601415', N'DC00099')
INSERT [dbo].[KhachHang] ([maKH],[CMND] ,[gioiTinh], [tenKH], [SDT], [maDC]) VALUES (N'KHAA100',N'123456789' ,N'Nam', N'PHẠM THANH SĨ',N'0945601416', N'DC00100')






SELECT * FROM [dbo].[LoaiNhanVien]

INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV001', N'Quản lý')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV002', N'Thu ngân')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV003', N'Lễ tân')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV004', N'Bảo vệ')
INSERT [dbo].[LoaiNhanVien] ([maLNV], [tenLNV]) VALUES (N'LNV005', N'Vệ sinh')

SELECT * FROM [dbo].[TaiKhoan]

INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK001', N'Admin','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK002', N'HU?NH VAN VU','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK003',N'HU?NH TH? L? H?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK004',N'LÊ TH? HOA MAI','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK005', N'TR?N THANH NAM','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK006',N'ÐÀO MINH TUY?T','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK007',N'HU?NH HI?U TH?O','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK008',N'NGUY?N TH? THANH VÂN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK009', N'NGUY?N VAN CHUONG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK010',N'HÀ TH? NG?C ÁNH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK011',N'LÊ TH? R?T','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK012',N'NGUY?N TH? NG?C TUY?T','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK013',N'BÙI NGUY?N NGUY?T DUNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK014', N'LUU VAN XÂY','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK015', N'VU VAN NH?T HÙNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK016', N'TR?N VAN THI?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK017',N'NGUY?N TH? THANH THÚY','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK018', N'NGUY?N VAN VINH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK019',N'NGUY?N TH? SÁNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK020', N'T? TI?N QUANG HÀO','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK021',N'HU?NH TH? ÁNH H?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK022', N'LÊ THÀNH L?I','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK023', N'PH?M HI?N NHÂN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK024',N'NGÔ TH? B?Y','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK025', N'NGUY?N LÊ MINH SANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK026',N'NGUY?N TH? TÚ LIÊN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK027',N'NGUY?N TH? PHÚ LIÊN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK028', N'SUH CANG HY','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK029', N'NGUY?N K? NAM','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK030',N'TR?N TH? XIÊM','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK031', N'ÐINH THANH SANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK032', N'LÊ HOÀNG TR?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK033',N'HU?NH TH? H?NG NGA','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK034', N'LÂM NG?C PHU?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK035',N'NGUY?N TH? KIM NGÂN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK036',N'NGUY?N NG?C M?','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK037',N'LÊ TH? THU HÀ','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK038',N'NGUY?N TH? CÚC','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK039',N'HU?NH TH? H?NG NGA','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK040', N'NGUY?N H?NG H?I','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK041',N'TRÀ TH? TUY?T THU','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK042',N'PH?M TH? VI?T','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK043', N'TR?N MINH TU?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK044', N'TR?N VAN ÐÔNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK045', N'LUONG THÀNH PHÚC','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK046', N'NGUY?N NG?C Ð?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK047', N'HU?NH VAN NGÀ','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK048', N'TR?NH H?I ÐANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK049',N'NGUY?N TH? M? PHU?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK050', N'LÊ THANH PH?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK051', N'TR?N VAN TH?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK052', N'NGUY?N ÐÌNH PHONG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK053',N'NGUY?N TH? PHUONG DUNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK054',N'DUONG TH? THÙY TRANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK055',N'Ð? THU HUONG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK056', N'NGUY?N THANH QUY?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK057', N'TR?N THANH H?I','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK058', N'HÙNG THÀNH CÔNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK059', N'TR?N QU?C TU?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK060', N'H? NG?C THANH HI?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK061', N'NGUY?N TH? HÒA','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK062',N'NGUY?N TH? Hu?','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK063', N'AMELLIA NGUY?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK064', N'TR?N MINH SON','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK065',N'VÂN KIM LIÊN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK066',N'TR?N TH? THU H?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK067',N'LÂM TH? PHU?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK068',N'TR?N TH? TH?M','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK069', N'ÐANG QUANG Ð?T','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK070', N'NGUY?N HUY','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK071', N'NGUY?N NG?C L?I','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK072',N'HU?NH ÐOAN TRANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK073',N'NGUY?N TH? DI?M PH?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK074', N'LÝ MINH HI?U','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK075', N'TÔN CH?N VÕ','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK076', N'LÝ TRUNG SON','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK077', N'NGUY?N HÙNG BÌNH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK078',N'PHAN TH? M? DUNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK079',N'NGUY?N TH? TH?O','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK080', N'NGUY?N HOÀNG ANH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK081', N'VÕ H?U TO?I','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK082',N'NGUY?N TH? KHUÊ BÍCH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK083', N'TR?N QUANG SINH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK084', N'THÁI SÁNG BÌNH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK085', N'HU?NH NG?C ÁNH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK086', N'PH?M NG?C THÀN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK087',N'TR?N TH? XUÂN H?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK088',N'NGUY?N TH? THU TH?Y','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK089', N'THÁI MINH HÙNG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK090', N'VÕ THÀNH TÂM','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK091',N'H? TH? NG?C C?M','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK092', N'NGUY?N NG?C TH?CH','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK093',N'T? QU? LAN','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK094',N'MAI TH? THANH HUY?N','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK095',N'CHÂU TH?C MAI','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK096',N'NGUY?N TH? BÍCH TRÂM','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK097',N'NGUY?N TH? HOÀNG TRANG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK098',N'HU?NH TH? THU HU?NG','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK099',N'VU THU TH?Y','karaoke4t')
INSERT [dbo].[TaiKhoan] ([maTK], [tenTK],[MK] ) VALUES (N'TK100', N'PH?M THANH SI','karaoke4t')





SELECT * FROM [dbo].[NhanVien]

INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0001', N'Nam', N'Admin', N'2001-01-01 00:00:00.0000000', N'999999999', N'9999999999',N'Đang làm', N'DC00001', N'LNV002','TK001')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0002', N'Nam', N'HU?NH VAN VU', N'2001-01-01 00:00:00.0000000', N'856378092', N'0945601318',N'Đang làm', N'DC02853', N'LNV002','TK002')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0003', N'Nu', N'HU?NH TH? L? H?NG', N'2001-01-01 00:00:00.0000000', N'745715032', N'0945601319',N'Đang làm', N'DC00003', N'LNV002','TK003')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0004', N'Nu', N'LÊ TH? HOA MAI', N'2001-01-01 00:00:00.0000000', N'612348590', N'0945601320',N'Đang làm', N'DC00004', N'LNV002','TK004')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0005', N'Nam', N'TR?N THANH NAM', N'2001-01-01 00:00:00.0000000', N'939364414', N'0945601321',N'Đang làm', N'DC02839', N'LNV002','TK005')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0006', N'Nu', N'ÐÀO MINH TUY?T', N'2001-01-01 00:00:00.0000000', N'856370984', N'0945601322',N'Đang làm', N'DC09183', N'LNV002','TK006')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0007', N'Nu', N'HU?NH HI?U TH?O', N'2001-01-01 00:00:00.0000000', N'728609067', N'0945601323',N'Đang làm', N'DC00007', N'LNV002','TK007')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0008', N'Nu', N'NGUY?N TH? THANH VÂN', N'2001-01-01 00:00:00.0000000', N'691694850', N'0945601324',N'Đang làm', N'DC00008', N'LNV002','TK008')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0009', N'Nam', N'NGUY?N VAN CHUONG', N'2001-01-01 00:00:00.0000000', N'130891152', N'0945601325',N'Đang làm', N'DC00009', N'LNV002','TK009')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0010', N'Nu', N'HÀ TH? NG?C ÁNH', N'2001-01-01 00:00:00.0000000', N'577742431', N'0945601326',N'Đang làm', N'DC00010', N'LNV002','TK010')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0011', N'Nu', N'LÊ TH? R?T', N'2001-01-01 00:00:00.0000000', N'609929488', N'0945601327',N'Đang làm', N'DC00011', N'LNV002','TK011')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0012', N'Nu', N'NGUY?N TH? NG?C TUY?T', N'2001-01-01 00:00:00.0000000', N'936686798', N'0945601328',N'Đang làm', N'DC00012', N'LNV002','TK012')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0013', N'Nu', N'BÙI NGUY?N NGUY?T DUNG', N'2001-01-01 00:00:00.0000000', N'850520689', N'0945601329',N'Đang làm', N'DC00013', N'LNV002','TK013')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0014', N'Nam', N'LUU VAN XÂY', N'2001-01-01 00:00:00.0000000', N'809074124', N'0945601330',N'Đang làm', N'DC00014', N'LNV002','TK014')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0015', N'Nam', N'VU VAN NH?T HÙNG', N'2001-01-01 00:00:00.0000000', N'982617914', N'0945601331',N'Đang làm', N'DC00015', N'LNV002','TK015')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0016', N'Nam', N'TR?N VAN THI?N', N'2001-01-01 00:00:00.0000000', N'745949172', N'0945601332',N'Đang làm', N'DC00016', N'LNV002','TK016')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0017', N'Nu', N'NGUY?N TH? THANH THÚY', N'2001-01-01 00:00:00.0000000', N'332652156', N'0945601333',N'Đang làm', N'DC00017', N'LNV002','TK017')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0018', N'Nam', N'NGUY?N VAN VINH', N'2001-01-01 00:00:00.0000000', N'663280321', N'0945601334',N'Đang làm', N'DC00018', N'LNV002','TK018')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0019', N'Nu', N'NGUY?N TH? SÁNG', N'2001-01-01 00:00:00.0000000', N'477912976', N'0945601335',N'Đang làm', N'DC00019', N'LNV002','TK019')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0020', N'Nam', N'T? TI?N QUANG HÀO', N'2001-01-01 00:00:00.0000000', N'214452571', N'0945601336',N'Đang làm', N'DC00020', N'LNV002','TK020')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0021', N'Nu', N'HU?NH TH? ÁNH H?NG', N'2001-01-01 00:00:00.0000000', N'777721195', N'0945601337',N'Đang làm', N'DC00021', N'LNV002','TK021')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0022', N'Nam', N'LÊ THÀNH L?I', N'2001-01-01 00:00:00.0000000', N'346424043', N'0945601338',N'Đang làm', N'DC00022', N'LNV002','TK022')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0023', N'Nam', N'PH?M HI?N NHÂN', N'2001-01-01 00:00:00.0000000', N'801546389', N'0945601339',N'Đang làm', N'DC00023', N'LNV002','TK023')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0024', N'Nu', N'NGÔ TH? B?Y', N'2001-01-01 00:00:00.0000000', N'629316102', N'0945601340',N'Đang làm', N'DC00024', N'LNV002','TK024')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0025', N'Nam', N'NGUY?N LÊ MINH SANG', N'2001-01-01 00:00:00.0000000', N'676768538', N'0945601341',N'Đang làm', N'DC00025', N'LNV002','TK025')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0026', N'Nu', N'NGUY?N TH? TÚ LIÊN', N'2001-01-01 00:00:00.0000000', N'916617429', N'0945601342',N'Đang làm', N'DC00026', N'LNV002','TK026')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0027', N'Nu', N'NGUY?N TH? PHÚ LIÊN', N'2001-01-01 00:00:00.0000000', N'162526565', N'0945601343',N'Đang làm', N'DC00027', N'LNV002','TK027')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0028', N'Nam', N'SUH CANG HY', N'2001-01-01 00:00:00.0000000', N'819658551', N'0945601344',N'Đang làm', N'DC00028', N'LNV002','TK028')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0029', N'Nam', N'NGUY?N K? NAM', N'2001-01-01 00:00:00.0000000', N'561502289', N'0945601345',N'Đang làm', N'DC00029', N'LNV002','TK029')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0030', N'Nu', N'TR?N TH? XIÊM', N'2001-01-01 00:00:00.0000000', N'518456812', N'0945601346',N'Đang làm', N'DC00030', N'LNV002','TK030')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0031', N'Nam', N'ÐINH THANH SANG', N'2001-01-01 00:00:00.0000000', N'497112385', N'0945601347',N'Đang làm', N'DC00031', N'LNV002','TK031')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0032', N'Nam', N'LÊ HOÀNG TR?NG', N'2001-01-01 00:00:00.0000000', N'118705679', N'0945601348',N'Đang làm', N'DC00032', N'LNV002','TK032')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0033', N'Nu', N'HU?NH TH? H?NG NGA', N'2001-01-01 00:00:00.0000000', N'228860116', N'0945601349',N'Đang làm', N'DC00033', N'LNV002','TK033')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0034', N'Nam', N'LÂM NG?C PHU?NG', N'2001-01-01 00:00:00.0000000', N'265099490', N'0945601350',N'Đang làm', N'DC00034', N'LNV002','TK034')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0035', N'Nu', N'NGUY?N TH? KIM NGÂN', N'2001-01-01 00:00:00.0000000', N'847266784', N'0945601351',N'Đang làm', N'DC00035', N'LNV002','TK035')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0036', N'Nu', N'NGUY?N NG?C M?', N'2001-01-01 00:00:00.0000000', N'719705897', N'0945601352',N'Đang làm', N'DC00036', N'LNV002','TK036')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0037', N'Nu', N'LÊ TH? THU HÀ', N'2001-01-01 00:00:00.0000000', N'852272269', N'0945601353',N'Đang làm', N'DC00037', N'LNV002','TK037')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0038', N'Nu', N'NGUY?N TH? CÚC', N'2001-01-01 00:00:00.0000000', N'490259507', N'0945601354',N'Đang làm', N'DC00038', N'LNV002','TK038')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0039', N'Nu', N'HU?NH TH? H?NG NGA', N'2001-01-01 00:00:00.0000000', N'975145490', N'0945601355',N'Đang làm', N'DC00039', N'LNV002','TK039')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0040', N'Nam', N'NGUY?N H?NG H?I', N'2001-01-01 00:00:00.0000000', N'251699858', N'0945601356',N'Đang làm', N'DC00040', N'LNV002','TK040')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0041', N'Nu', N'TRÀ TH? TUY?T THU', N'2001-01-01 00:00:00.0000000', N'424586968', N'0945601357',N'Đang làm', N'DC00041', N'LNV002','TK041')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0042', N'Nu', N'PH?M TH? VI?T', N'2001-01-01 00:00:00.0000000', N'600804186', N'0945601358',N'Đang làm', N'DC00042', N'LNV002','TK042')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0043', N'Nam', N'TR?N MINH TU?N', N'2001-01-01 00:00:00.0000000', N'563153298', N'0945601359',N'Đang làm', N'DC00043', N'LNV002','TK043')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0044', N'Nam', N'TR?N VAN ÐÔNG', N'2001-01-01 00:00:00.0000000', N'267185145', N'0945601360',N'Đang làm', N'DC00044', N'LNV002','TK044')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0045', N'Nam', N'LUONG THÀNH PHÚC', N'2001-01-01 00:00:00.0000000', N'446044855', N'0945601361',N'Đang làm', N'DC00045', N'LNV002','TK045')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0046', N'Nam', N'NGUY?N NG?C Ð?NG', N'2001-01-01 00:00:00.0000000', N'574583404', N'0945601362',N'Đang làm', N'DC00046', N'LNV002','TK046')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0047', N'Nam', N'HU?NH VAN NGÀ', N'2001-01-01 00:00:00.0000000', N'128312574', N'0945601363',N'Đang làm', N'DC00047', N'LNV002','TK047')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0048', N'Nam', N'TR?NH H?I ÐANG', N'2001-01-01 00:00:00.0000000', N'185331584', N'0945601364',N'Đang làm', N'DC00048', N'LNV002','TK048')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0049', N'Nu', N'NGUY?N TH? M? PHU?NG', N'2001-01-01 00:00:00.0000000', N'238534722', N'0945601365',N'Đang làm', N'DC00049', N'LNV002','TK049')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0050', N'Nam', N'LÊ THANH PH?NG', N'2001-01-01 00:00:00.0000000', N'382302194', N'0945601366',N'Đang làm', N'DC00050', N'LNV002','TK050')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0051', N'Nam', N'TR?N VAN TH?NG', N'2001-01-01 00:00:00.0000000', N'487529764', N'0945601367',N'Đang làm', N'DC00051', N'LNV002','TK051')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0052', N'Nam', N'NGUY?N ÐÌNH PHONG', N'2001-01-01 00:00:00.0000000', N'826931275', N'0945601368',N'Đang làm', N'DC00052', N'LNV002','TK052')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0053', N'Nu', N'NGUY?N TH? PHUONG DUNG', N'2001-01-01 00:00:00.0000000', N'187612904', N'0945601369',N'Đang làm', N'DC00053', N'LNV002','TK053')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0054', N'Nu', N'DUONG TH? THÙY TRANG', N'2001-01-01 00:00:00.0000000', N'658990706', N'0945601370',N'Đang làm', N'DC00054', N'LNV002','TK054')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0055', N'Nu', N'Ð? THU HUONG', N'2001-01-01 00:00:00.0000000', N'218690496', N'0945601371',N'Đang làm', N'DC00055', N'LNV002','TK055')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0056', N'Nam', N'NGUY?N THANH QUY?N', N'2001-01-01 00:00:00.0000000', N'976326214', N'0945601372',N'Đang làm', N'DC00056', N'LNV002','TK056')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0057', N'Nam', N'TR?N THANH H?I', N'2001-01-01 00:00:00.0000000', N'598938981', N'0945601373',N'Đang làm', N'DC00057', N'LNV002','TK057')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0058', N'Nam', N'HÙNG THÀNH CÔNG', N'2001-01-01 00:00:00.0000000', N'256782607', N'0945601374',N'Đang làm', N'DC00058', N'LNV002','TK058')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0059', N'Nam', N'TR?N QU?C TU?N', N'2001-01-01 00:00:00.0000000', N'458457848', N'0945601375',N'Đang làm', N'DC00059', N'LNV002','TK059')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0060', N'Nam', N'H? NG?C THANH HI?N', N'2001-01-01 00:00:00.0000000', N'787649814', N'0945601376',N'Đang làm', N'DC00060', N'LNV002','TK060')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0061', N'Nam', N'NGUY?N TH? HÒA', N'2001-01-01 00:00:00.0000000', N'350351733', N'0945601377',N'Đang làm', N'DC00061', N'LNV002','TK061')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0062', N'Nu', N'NGUY?N TH? Hu?', N'2001-01-01 00:00:00.0000000', N'492637311', N'0945601378',N'Đang làm', N'DC00062', N'LNV002','TK062')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0063', N'Nam', N'AMELLIA NGUY?N', N'2001-01-01 00:00:00.0000000', N'601658206', N'0945601379',N'Đang làm', N'DC00063', N'LNV002','TK063')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0064', N'Nam', N'TR?N MINH SON', N'2001-01-01 00:00:00.0000000', N'920633471', N'0945601380',N'Đang làm', N'DC00064', N'LNV002','TK064')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0065', N'Nu', N'VÂN KIM LIÊN', N'2001-01-01 00:00:00.0000000', N'929368593', N'0945601381',N'Đang làm', N'DC00065', N'LNV002','TK065')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0066', N'Nu', N'TR?N TH? THU H?NG', N'2001-01-01 00:00:00.0000000', N'102737486', N'0945601382',N'Đang làm', N'DC00066', N'LNV002','TK066')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0067', N'Nu', N'LÂM TH? PHU?NG', N'2001-01-01 00:00:00.0000000', N'415249659', N'0945601383',N'Đang làm', N'DC00067', N'LNV002','TK067')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0068', N'Nu', N'TR?N TH? TH?M', N'2001-01-01 00:00:00.0000000', N'545083215', N'0945601384',N'Đang làm', N'DC00068', N'LNV002','TK068')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0069', N'Nam', N'ÐANG QUANG Ð?T', N'2001-01-01 00:00:00.0000000', N'630248585', N'0945601385',N'Đang làm', N'DC00069', N'LNV002','TK069')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0070', N'Nam', N'NGUY?N HUY', N'2001-01-01 00:00:00.0000000', N'974705465', N'0945601386',N'Đang làm', N'DC00070', N'LNV002','TK070')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0071', N'Nam', N'NGUY?N NG?C L?I', N'2001-01-01 00:00:00.0000000', N'312211891', N'0945601387',N'Đang làm', N'DC00071', N'LNV002','TK071')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0072', N'Nu', N'HU?NH ÐOAN TRANG', N'2001-01-01 00:00:00.0000000', N'218732846', N'0945601388',N'Đang làm', N'DC00072', N'LNV002','TK072')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0073', N'Nu', N'NGUY?N TH? DI?M PH?NG', N'2001-01-01 00:00:00.0000000', N'288616228', N'0945601389',N'Đang làm', N'DC00073', N'LNV002','TK073')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0074', N'Nam', N'LÝ MINH HI?U', N'2001-01-01 00:00:00.0000000', N'336351069', N'0945601390',N'Đang làm', N'DC00074', N'LNV002','TK074')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0075', N'Nam', N'TÔN CH?N VÕ', N'2001-01-01 00:00:00.0000000', N'187611170', N'0945601391',N'Đang làm', N'DC00075', N'LNV002','TK075')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0076', N'Nam', N'LÝ TRUNG SON', N'2001-01-01 00:00:00.0000000', N'822455970', N'0945601392',N'Đang làm', N'DC00076', N'LNV002','TK076')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0077', N'Nam', N'NGUY?N HÙNG BÌNH', N'2001-01-01 00:00:00.0000000', N'340598685', N'0945601393',N'Đang làm', N'DC00077', N'LNV002','TK077')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0078', N'Nu', N'PHAN TH? M? DUNG', N'2001-01-01 00:00:00.0000000', N'957958937', N'0945601394',N'Đang làm', N'DC00078', N'LNV002','TK078')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0079', N'Nu', N'NGUY?N TH? TH?O', N'2001-01-01 00:00:00.0000000', N'230508097', N'0945601395',N'Đang làm', N'DC00079', N'LNV002','TK079')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0080', N'Nam', N'NGUY?N HOÀNG ANH', N'2001-01-01 00:00:00.0000000', N'508354413', N'0945601396',N'Đang làm', N'DC00080', N'LNV002','TK080')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0081', N'Nam', N'VÕ H?U TO?I', N'2001-01-01 00:00:00.0000000', N'819889076', N'0945601397',N'Đang làm', N'DC00081', N'LNV002','TK081')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0082', N'Nu', N'NGUY?N TH? KHUÊ BÍCH', N'2001-01-01 00:00:00.0000000', N'107477378', N'0945601398',N'Đang làm', N'DC00082', N'LNV002','TK082')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0083', N'Nam', N'TR?N QUANG SINH', N'2001-01-01 00:00:00.0000000', N'391144624', N'0945601399',N'Đang làm', N'DC00083', N'LNV002','TK083')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0084', N'Nam', N'THÁI SÁNG BÌNH', N'2001-01-01 00:00:00.0000000', N'758412343', N'0945601400',N'Đang làm', N'DC00084', N'LNV002','TK084')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0085', N'Nam', N'HU?NH NG?C ÁNH', N'2001-01-01 00:00:00.0000000', N'803964720', N'0945601401',N'Đang làm', N'DC00085', N'LNV002','TK085')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0086', N'Nam', N'PH?M NG?C THÀN', N'2001-01-01 00:00:00.0000000', N'632751190', N'0945601402',N'Đang làm', N'DC00086', N'LNV002','TK086')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0087', N'Nu', N'TR?N TH? XUÂN H?NG', N'2001-01-01 00:00:00.0000000', N'183468709', N'0945601403',N'Đang làm', N'DC00087', N'LNV002','TK087')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0088', N'Nu', N'NGUY?N TH? THU TH?Y', N'2001-01-01 00:00:00.0000000', N'581047473', N'0945601404',N'Đang làm', N'DC00088', N'LNV002','TK088')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0089', N'Nam', N'THÁI MINH HÙNG', N'2001-01-01 00:00:00.0000000', N'471822981', N'0945601405',N'Đang làm', N'DC00089', N'LNV002','TK089')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0090', N'Nam', N'VÕ THÀNH TÂM', N'2001-01-01 00:00:00.0000000', N'180750981', N'0945601406',N'Đang làm', N'DC00090', N'LNV002','TK090')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0091', N'Nu', N'H? TH? NG?C C?M', N'2001-01-01 00:00:00.0000000', N'545918939', N'0945601407',N'Đang làm', N'DC00091', N'LNV002','TK091')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0092', N'Nam', N'NGUY?N NG?C TH?CH', N'2001-01-01 00:00:00.0000000', N'888949528', N'0945601408',N'Đang làm', N'DC00092', N'LNV002','TK092')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0093', N'Nu', N'T? QU? LAN', N'2001-01-01 00:00:00.0000000', N'273905310', N'0945601409',N'Đang làm', N'DC00093', N'LNV002','TK093')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0094', N'Nu', N'MAI TH? THANH HUY?N', N'2001-01-01 00:00:00.0000000', N'266293441', N'0945601410',N'Đang làm', N'DC00094', N'LNV002','TK094')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0095', N'Nu', N'CHÂU TH?C MAI', N'2001-01-01 00:00:00.0000000', N'607858860', N'0945601411',N'Đang làm', N'DC00095', N'LNV002','TK095')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0096', N'Nu', N'NGUY?N TH? BÍCH TRÂM', N'2001-01-01 00:00:00.0000000', N'914209881', N'0945601412',N'Nghĩ việc', N'DC00096', N'LNV002','TK096')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0097', N'Nu', N'NGUY?N TH? HOÀNG TRANG', N'2001-01-01 00:00:00.0000000', N'496693162', N'0945601413',N'Đang làm', N'DC00097', N'LNV002','TK097')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0098', N'Nu', N'HU?NH TH? THU HU?NG', N'2001-01-01 00:00:00.0000000', N'449695586', N'0945601414',N'Đang làm', N'DC00098', N'LNV002','TK098')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0099', N'Nu', N'VU THU TH?Y', N'2001-01-01 00:00:00.0000000', N'837607714', N'0945601415',N'Đang làm', N'DC00099', N'LNV002','TK099')
INSERT [dbo].[NhanVien] ([maNV], [gioiTinh], [tenNV], [ngaySinh], [CMND], [SDT], [trangThaiLamViec], [maDC], [maLNV], [maTK] ) VALUES (N'NVAA0100', N'Nam', N'PH?M THANH SI', N'2001-01-01 00:00:00.0000000', N'8262644681', N'0945601416',N'Đang làm', N'DC00100', N'LNV002','TK100')




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
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA006', N'P009', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA007', N'P005', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA008', N'P004', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA012', N'P008', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA016', N'P007', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA022', N'P006', 0)
INSERT [dbo].[ChiTietHoaDon] ([maHD], [maPhong], [thoiLuong]) VALUES (N'HDAA031', N'P004', 0)





SELECT * FROM [dbo].[ChiTietDichVu]
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA005', 0)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA013', 11)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA028', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA032', 21)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA037', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA054', 14)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA061', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV001', N'HDAA074', 30)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA005', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA023', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA028', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA032', 40)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA054', 2)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA061', 2)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA065', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA067', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA070', 4)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA072', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV002', N'HDAA075', 5)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA026', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA029', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA032', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA054', 25)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA065', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA066', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV003', N'HDAA077', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA013', 22)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA032', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA037', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV004', N'HDAA054', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA002', 5)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA013', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA025', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA028', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA030', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA032', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA054', 17)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA065', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA070', 2)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA072', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA088', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA110', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV005', N'HDAA114', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA002', 65)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA003', 12)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA006', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA024', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA026', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA029', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA032', 31)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA054', 9)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA061', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA074', 5)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA093', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA105', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA108', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA111', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA116', 3)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV006', N'HDAA119', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA002', 15)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA003', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA028', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA032', 21)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA054', 2)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA061', 10)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA080', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA092', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA102', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA106', 1)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA107', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA108', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA112', 20)
INSERT [dbo].[ChiTietDichVu] ([maDV], [maHD], [soLuong]) VALUES (N'DV007', N'HDAA118', 1)
