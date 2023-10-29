
--Use master
--create DATABASE[Karaoke4T]
--USE [Karaoke4T]

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
	[maKH] [varchar](10) NULL,
	[maNV] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](10) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[tenKH] [nvarchar](max) NULL,
	[SDT] [varchar](11) NULL,
	[CMND] [varchar](9) NULL,
	[diaChi] [varchar](30) NULL,
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
/****** Object:  Table [dbo].[NhanVien]   ******/
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
	[trangThaiLamViec] [varchar](11) NULL,
	[maDC] [varchar](10) NULL,
	[maLNV] [varchar](10) NULL,
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
	[tinhTrangPhong] [bit] NOT NULL,
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
