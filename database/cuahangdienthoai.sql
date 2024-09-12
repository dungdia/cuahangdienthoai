-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table cuahangdienthoai.baohanh
CREATE TABLE IF NOT EXISTS `baohanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `soThang` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.baohanh: ~5 rows (approximately)
INSERT INTO `baohanh` (`id`, `soThang`) VALUES
	(1, 12),
	(2, 24),
	(3, 36),
	(4, 6),
	(5, 8);

-- Dumping structure for table cuahangdienthoai.chucnang
CREATE TABLE IF NOT EXISTS `chucnang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.chucnang: ~10 rows (approximately)
INSERT INTO `chucnang` (`id`, `ten`) VALUES
	(1, 'Sản phẩm'),
	(2, 'Phiếu nhập'),
	(3, 'Hóa đơn'),
	(4, 'Khách hàng'),
	(5, 'Nhân viên'),
	(6, 'Nhà cung cấp'),
	(7, 'Phân quyền'),
	(8, 'Thống kê'),
	(9, 'Tài khoản');

-- Dumping structure for table cuahangdienthoai.ctbaohanh
CREATE TABLE IF NOT EXISTS `ctbaohanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `baoHanh_id` int DEFAULT NULL,
  `hoaDon_id` int DEFAULT NULL,
  `imei_sanPham` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngayKetThuc` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `baoHanh_id` (`baoHanh_id`),
  KEY `hoaDon_id` (`hoaDon_id`),
  KEY `imei_sanPham` (`imei_sanPham`),
  CONSTRAINT `ctbaohanh_ibfk_1` FOREIGN KEY (`baoHanh_id`) REFERENCES `baohanh` (`id`),
  CONSTRAINT `ctbaohanh_ibfk_2` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  CONSTRAINT `ctbaohanh_ibfk_3` FOREIGN KEY (`imei_sanPham`) REFERENCES `ctsanpham` (`imei`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctbaohanh: ~13 rows (approximately)
INSERT INTO `ctbaohanh` (`id`, `baoHanh_id`, `hoaDon_id`, `imei_sanPham`, `ngayKetThuc`) VALUES
	(10, 1, 8, '123456789012345', '2025-05-03 10:58:13'),
	(11, 1, 9, '123456789045789', '2025-05-04 07:41:03'),
	(12, 1, 10, '123456789578945', '2025-05-04 07:47:59'),
	(13, 1, 11, '145687923512364', '2025-05-05 21:51:11'),
	(14, 1, 12, '741569823612358', '2025-05-05 21:53:26'),
	(15, 1, 13, '451369874512648', '2025-05-05 21:55:52'),
	(16, 1, 14, '453269781465982', '2025-05-05 21:57:40'),
	(17, 1, 15, '145236987456123', '2025-05-05 22:00:44'),
	(18, 1, 15, '451201365879564', '2025-05-05 22:01:04'),
	(19, 1, 15, '457136524895746', '2025-05-05 22:01:20'),
	(20, 1, 16, '456784596132546', '2025-05-05 22:03:06'),
	(21, 1, 16, '978456321456795', '2025-05-05 22:03:21'),
	(22, 1, 17, '031648952364159', '2025-05-05 22:40:51');

-- Dumping structure for table cuahangdienthoai.cthoadon
CREATE TABLE IF NOT EXISTS `cthoadon` (
  `hoaDon_id` int NOT NULL,
  `imei` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `soLuong` int DEFAULT NULL,
  `giaBanRa` int DEFAULT NULL,
  `tongTien` int DEFAULT NULL,
  PRIMARY KEY (`hoaDon_id`,`imei`),
  KEY `imei` (`imei`),
  CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`imei`) REFERENCES `ctsanpham` (`imei`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.cthoadon: ~13 rows (approximately)
INSERT INTO `cthoadon` (`hoaDon_id`, `imei`, `soLuong`, `giaBanRa`, `tongTien`) VALUES
	(8, '123456789012345', 1, 26490000, 26490000),
	(9, '123456789045789', 1, 22990000, 22990000),
	(10, '123456789578945', 1, 22990000, 22990000),
	(11, '145687923512364', 1, 22990000, 18392000),
	(12, '741569823612358', 1, 22990000, 18392000),
	(13, '451369874512648', 1, 22990000, 22990000),
	(14, '453269781465982', 1, 22990000, 18392000),
	(15, '145236987456123', 1, 8990000, 8990000),
	(15, '451201365879564', 1, 8990000, 8990000),
	(15, '457136524895746', 1, 8990000, 8990000),
	(16, '456784596132546', 1, 8990000, 8990000),
	(16, '978456321456795', 1, 22990000, 18392000),
	(17, '031648952364159', 1, 22990000, 22990000);

-- Dumping structure for table cuahangdienthoai.ctphieunhap
CREATE TABLE IF NOT EXISTS `ctphieunhap` (
  `phieuNhap_id` int NOT NULL,
  `pbsanPham_id` int NOT NULL,
  `soLuong` int DEFAULT NULL,
  `donGia` int DEFAULT NULL,
  `tongTien` bigint DEFAULT NULL,
  PRIMARY KEY (`phieuNhap_id`,`pbsanPham_id`),
  KEY `pbsanPham_id` (`pbsanPham_id`),
  CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`),
  CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`pbsanPham_id`) REFERENCES `pbsanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctphieunhap: ~9 rows (approximately)
INSERT INTO `ctphieunhap` (`phieuNhap_id`, `pbsanPham_id`, `soLuong`, `donGia`, `tongTien`) VALUES
	(1, 1, 4, 15000000, 60000000),
	(2, 1, 1, 15000000, 15000000),
	(3, 16, 12, 14000000, 168000000),
	(4, 4, 1, 20000000, 20000000),
	(5, 3, 2, 26000000, 52000000),
	(5, 12, 4, 4000000, 16000000),
	(5, 16, 3, 14000000, 42000000),
	(8, 23, 1, 20000000, 20000000),
	(9, 1, 1, 13000000, 13000000);

-- Dumping structure for table cuahangdienthoai.ctquyen
CREATE TABLE IF NOT EXISTS `ctquyen` (
  `quyen_id` int NOT NULL,
  `chucNang_id` int NOT NULL,
  `hanhDong` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`quyen_id`,`chucNang_id`,`hanhDong`) USING BTREE,
  KEY `chucNang_id` (`chucNang_id`),
  CONSTRAINT `ctquyen_ibfk_1` FOREIGN KEY (`chucNang_id`) REFERENCES `chucnang` (`id`),
  CONSTRAINT `ctquyen_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctquyen: ~39 rows (approximately)
INSERT INTO `ctquyen` (`quyen_id`, `chucNang_id`, `hanhDong`) VALUES
	(1, 1, 'add'),
	(1, 1, 'delete'),
	(1, 1, 'edit'),
	(1, 1, 'view'),
	(3, 1, 'view'),
	(4, 1, 'view'),
	(1, 2, 'add'),
	(1, 2, 'view'),
	(1, 3, 'add'),
	(1, 3, 'delete'),
	(1, 3, 'view'),
	(1, 4, 'add'),
	(1, 4, 'delete'),
	(1, 4, 'edit'),
	(1, 4, 'view'),
	(1, 5, 'add'),
	(1, 5, 'delete'),
	(1, 5, 'edit'),
	(1, 5, 'view'),
	(1, 6, 'add'),
	(1, 6, 'delete'),
	(1, 6, 'edit'),
	(1, 6, 'view'),
	(1, 7, 'add'),
	(1, 7, 'delete'),
	(1, 7, 'edit'),
	(1, 7, 'view'),
	(1, 8, 'add'),
	(1, 8, 'delete'),
	(1, 8, 'edit'),
	(1, 8, 'view'),
	(1, 9, 'add'),
	(1, 9, 'delete'),
	(1, 9, 'edit'),
	(1, 9, 'view');

-- Dumping structure for table cuahangdienthoai.ctsanpham
CREATE TABLE IF NOT EXISTS `ctsanpham` (
  `imei` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `sanPham_id` int DEFAULT NULL,
  `pbSanPham_id` int DEFAULT NULL,
  `hoaDon_id` int DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`imei`),
  KEY `hoaDon_id` (`hoaDon_id`),
  KEY `sanPham_id` (`sanPham_id`),
  KEY `pbSanPham_id` (`pbSanPham_id`),
  CONSTRAINT `ctsanpham_ibfk_1` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  CONSTRAINT `ctsanpham_ibfk_2` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`),
  CONSTRAINT `ctsanpham_ibfk_3` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctsanpham: ~13 rows (approximately)
INSERT INTO `ctsanpham` (`imei`, `sanPham_id`, `pbSanPham_id`, `hoaDon_id`, `trangThai`) VALUES
	('031648952364159', 10, 16, 17, 1),
	('123456789012345', 10, 23, 8, 1),
	('123456789045789', 10, 16, 9, 1),
	('123456789578945', 10, 16, 10, 1),
	('145236987456123', 8, 12, 15, 1),
	('145687923512364', 10, 16, 11, 1),
	('451201365879564', 8, 12, 15, 1),
	('451369874512648', 10, 16, 13, 1),
	('453269781465982', 10, 16, 14, 1),
	('456784596132546', 8, 12, 16, 1),
	('457136524895746', 8, 12, 15, 1),
	('741569823612358', 10, 16, 12, 1),
	('978456321456795', 10, 16, 16, 1);

-- Dumping structure for table cuahangdienthoai.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `khacHang_id` int DEFAULT NULL,
  `nhanVien_id` int DEFAULT NULL,
  `khuyenMai_id` int DEFAULT NULL,
  `ngayXuat` datetime DEFAULT NULL,
  `tongTien` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khacHang_id` (`khacHang_id`),
  KEY `nhanVien_id` (`nhanVien_id`),
  KEY `khuyenMai_id` (`khuyenMai_id`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`khacHang_id`) REFERENCES `khachhang` (`id`),
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`khuyenMai_id`) REFERENCES `khuyenmai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.hoadon: ~0 rows (approximately)
INSERT INTO `hoadon` (`id`, `khacHang_id`, `nhanVien_id`, `khuyenMai_id`, `ngayXuat`, `tongTien`) VALUES
	(8, 1, 1, 1, '2024-05-03 10:58:15', 26490000),
	(9, 3, 1, 1, '2024-05-04 07:41:17', 22990000),
	(10, 2, 1, 1, '2024-05-04 07:48:11', 22990000),
	(11, 2, 1, 3, '2024-05-05 21:51:27', 18392000),
	(12, 1, 1, 3, '2024-05-05 21:53:40', 18392000),
	(13, 3, 1, 3, '2024-05-05 21:56:01', 18392000),
	(14, 2, 1, 3, '2024-05-05 21:57:54', 18392000),
	(15, 1, 1, 2, '2024-05-05 22:01:28', 18879000),
	(16, 1, 1, 3, '2024-05-05 22:03:58', 27382000),
	(17, 3, 1, 2, '2024-05-05 22:41:02', 16093000);

-- Dumping structure for table cuahangdienthoai.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngayThamGia` datetime DEFAULT NULL,
  `trangThai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.khachhang: ~21 rows (approximately)
INSERT INTO `khachhang` (`id`, `ho`, `ten`, `soDienThoai`, `ngayThamGia`, `trangThai`) VALUES
	(1, 'Nguyễn Văn', 'A', '0123987654', '2024-04-21 09:28:34', 1),
	(2, 'Đỗ Văn', 'Thừa', '0984756213', '2024-04-20 09:28:43', 1),
	(3, 'Bó Đạt', 'Chách', '0963258741', '2024-04-17 09:28:47', 1),
	(4, 'Nguyễn Văn', 'Sơn', '05623491562', '2024-05-05 22:44:52', 1),
	(5, 'Trình Khánh', 'Nam', '05698743261', '2024-05-05 22:45:26', 1),
	(6, 'Bùi Hoàng', 'Long', '0651487952', '2024-05-05 22:45:46', 1),
	(7, 'Nguyễn Việt', 'Hùng', '0213459713', '2024-05-05 22:46:31', 1),
	(8, 'Lê Trung', 'Kiên', '0136594871', '2024-05-05 22:46:51', 1),
	(9, 'Trần Nguyễn Vũ', 'Phong', '0147956435', '2024-05-05 22:47:11', 1),
	(10, 'Nguyễn Văn', 'Liêm', '0146598743', '2024-05-05 22:48:39', 1),
	(11, 'Trần Hữu', 'Nghị', '05623498715', '2024-05-05 22:49:06', 1),
	(12, 'Lê Hữu', 'Thọ', '0146985647', '2024-05-05 22:49:51', 1),
	(13, 'Lê Hữu', 'Giàu', '0564897463', '2024-05-05 22:50:01', 1),
	(14, 'Nguyễn Hoàng', 'Dũng', '03459876132', '2024-05-05 22:50:32', 1),
	(15, 'Đoàn Thanh', 'Luân', '07864351648', '2024-05-05 22:50:53', 1),
	(16, 'Trần Văn', 'Cường', '04623154956', '2024-05-05 22:54:04', 1),
	(17, 'Huỳnh Đức', 'Trung', '04956321456', '2024-05-05 22:51:26', 1),
	(18, 'Nguyễn Thị', 'Hường', '06541356489', '2024-05-05 22:53:04', 1),
	(19, 'Đoàn Minh', 'Dũng', '04561398746', '2024-05-05 22:52:11', 1),
	(20, 'Nguyễn Tường', 'Vy', '04562149765', '2024-05-05 22:54:37', 1),
	(21, 'Lê Thị Thanh', 'Trúc', '04561324789', '2024-05-05 22:53:34', 1);

-- Dumping structure for table cuahangdienthoai.khuyenmai
CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tiLe` float DEFAULT NULL,
  `sanPham_id` int DEFAULT NULL,
  `dieuKien` int DEFAULT NULL,
  `trangThai` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pbSanPham_id` (`sanPham_id`),
  CONSTRAINT `khuyenmai_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.khuyenmai: ~0 rows (approximately)
INSERT INTO `khuyenmai` (`id`, `ten`, `tiLe`, `sanPham_id`, `dieuKien`, `trangThai`) VALUES
	(1, 'Không khuyến mãi', 0, NULL, 0, 1),
	(2, 'Giảm 30% cho đơn hàng từ 20 triệu', 0.3, NULL, 20000000, 1),
	(3, 'Giảm 20% cho Samsung Galaxy S24 5G', 0.2, 10, 0, 1);

-- Dumping structure for table cuahangdienthoai.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.nhacungcap: ~3 rows (approximately)
INSERT INTO `nhacungcap` (`id`, `ten`, `diaChi`, `soDienThoai`, `email`, `trangThai`) VALUES
	(1, 'Công Ty TNHH Thế Giới Di Động', 'Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', '02835100100', 'lienhe@thegioididong.com', 1),
	(2, 'Công ty TNHH Thương Mại Công Nghệ Bạch Long', '134 Trần Phú, phường 4, quận 5, Tp. Hồ Chí Minh', '869287135', 'marketing@bachlongmobile.com', 1),
	(3, 'Viễn Thông Đức Huy', '187A Đường 3/2, P. 11, Q. 10, Tp. Hồ Chí Minh', '0971151515', 'duchuymobile2011@gmail.com', 1);

-- Dumping structure for table cuahangdienthoai.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gioiTinh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `chucVu` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.nhanvien: ~4 rows (approximately)
INSERT INTO `nhanvien` (`id`, `ho`, `ten`, `gioiTinh`, `soDienThoai`, `email`, `chucVu`, `trangThai`) VALUES
	(1, 'Trần Đức', 'Em', 'Nam', '0374126105', '3122410091@sv.sgu.edu.vn', 'Quản lý', 1),
	(2, 'Trầm Quang', 'Dũng', 'Nam', '0324879561', '3122410054@sv.sgu.edu.vn', 'Nhân viên nhập hàng', 1),
	(3, 'Hoàng', 'Dũng', 'Nam', '0879456213', '3122410052@sv.sgu.edu.vn', 'Nhân viên bán hàng', 1),
	(4, 'Đoàn Minh', 'Đức', 'Nam', '0546798123', '3122410084@sv.sgu.edu.vn', 'Lao công', 1);

-- Dumping structure for table cuahangdienthoai.pbsanpham
CREATE TABLE IF NOT EXISTS `pbsanpham` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sanPham_id` int DEFAULT NULL,
  `ram` int DEFAULT NULL,
  `rom` int DEFAULT NULL,
  `mau` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soLuong` int DEFAULT '0',
  `giaNhap` int DEFAULT NULL,
  `giaXuat` int DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `sanPham_id` (`sanPham_id`),
  CONSTRAINT `pbsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.pbsanpham: ~0 rows (approximately)
INSERT INTO `pbsanpham` (`id`, `sanPham_id`, `ram`, `rom`, `mau`, `soLuong`, `giaNhap`, `giaXuat`, `trangThai`) VALUES
	(1, 1, 6, 128, 'Đen', 6, 15000000, 22990000, 1),
	(2, 1, 6, 256, 'Đen', 0, 20000000, 25990000, 1),
	(3, 1, 6, 512, 'Đen', 2, 26000000, 31990000, 1),
	(4, 2, 6, 128, 'Đen', 1, 20000000, 25990000, 1),
	(5, 2, 6, 256, 'Đen', 0, 23000000, 28990000, 1),
	(6, 2, 6, 512, 'Đen', 0, 29000000, 34990000, 1),
	(7, 3, 8, 128, 'Titan đen', 0, 23000000, 28990000, 1),
	(8, 3, 8, 256, 'Titan đen', 0, 26000000, 31990000, 1),
	(9, 3, 8, 512, 'Titan đen', 0, 32000000, 37990000, 1),
	(10, 8, 8, 256, 'Tím', 0, 4000000, 8990000, 1),
	(11, 8, 8, 256, 'Xanh', 0, 4000000, 8990000, 1),
	(12, 8, 8, 256, 'Đen', 0, 4000000, 8990000, 1),
	(13, 9, 8, 256, 'Đen', 0, 5000000, 10990000, 1),
	(14, 9, 8, 256, 'Tím', 0, 5000000, 10990000, 1),
	(15, 9, 8, 256, 'Trắng', 0, 5000000, 10990000, 1),
	(16, 10, 8, 256, 'Vàng', 7, 14000000, 22990000, 1),
	(17, 10, 8, 256, 'Xám', 0, 14000000, 22990000, 1),
	(18, 10, 8, 256, 'Đen', 0, 14000000, 22990000, 1),
	(19, 10, 8, 256, 'Tím', 0, 14000000, 22990000, 1),
	(20, 10, 8, 512, 'Vàng', 0, 20000000, 26490000, 1),
	(21, 10, 8, 512, 'Xám', 0, 20000000, 26490000, 1),
	(22, 10, 8, 512, 'Đen', 0, 20000000, 26490000, 1),
	(23, 10, 8, 512, 'Tím', 0, 20000000, 26490000, 1),
	(24, 4, 8, 256, 'Titan xanh', 0, 28990000, 34990000, 1),
	(25, 4, 8, 256, 'Titan xanh', 0, 28990000, 34990000, 1),
	(26, 4, 8, 512, 'Titan xanh', 0, 31990000, 40990000, 1),
	(27, 4, 8, 256, 'Titan đen', 0, 28999000, 35990000, 1),
	(28, 6, 8, 128, 'Xanh lá', 0, 4599000, 5290000, 1),
	(29, 6, 8, 128, 'Vàng', 0, 4599000, 5290000, 1),
	(30, 6, 6, 128, 'Xanh lá', 0, 4299000, 4990000, 0),
	(31, 6, 8, 128, 'Đen', 0, 4699000, 5290000, 1),
	(32, 6, 8, 256, 'Đen', 0, 4899000, 5690000, 1),
	(33, 7, 8, 128, 'Xanh lá', 0, 6699000, 7490000, 1),
	(34, 7, 8, 128, 'Xanh lá', 0, 6699000, 7490000, 1),
	(35, 7, 8, 256, 'Tím', 0, 6899000, 7890000, 1),
	(36, 5, 12, 256, 'Trắng', 0, 15990000, 22990000, 1);

-- Dumping structure for table cuahangdienthoai.phieunhap
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nhaCungCap_id` int DEFAULT NULL,
  `nhanVien_id` int DEFAULT NULL,
  `ngayNhap` datetime DEFAULT NULL,
  `tongTien` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhaCungCap_id` (`nhaCungCap_id`),
  KEY `nhanVien_id` (`nhanVien_id`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`nhaCungCap_id`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.phieunhap: ~0 rows (approximately)
INSERT INTO `phieunhap` (`id`, `nhaCungCap_id`, `nhanVien_id`, `ngayNhap`, `tongTien`) VALUES
	(1, 1, 1, '2024-04-16 13:32:01', 60000000),
	(2, 1, 1, '2024-04-24 14:44:19', 15000000),
	(3, 1, 1, '2024-04-24 14:44:57', 168000000),
	(4, 2, 1, '2024-04-24 14:47:17', 20000000),
	(5, 1, 1, '2024-04-24 14:56:26', 110000000),
	(8, 1, 1, '2024-04-24 15:10:24', 20000000),
	(9, 1, 1, '2024-04-24 15:11:26', 13000000);

-- Dumping structure for table cuahangdienthoai.quyen
CREATE TABLE IF NOT EXISTS `quyen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.quyen: ~4 rows (approximately)
INSERT INTO `quyen` (`id`, `ten`, `trangThai`) VALUES
	(1, 'Quản lý', 1),
	(2, 'Nhân viên nhập hàng', 1),
	(3, 'Nhân viên bán hàng', 1),
	(4, 'abc', 1);

-- Dumping structure for table cuahangdienthoai.sanpham
CREATE TABLE IF NOT EXISTS `sanpham` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `hinhAnh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `kichThuocMan` float DEFAULT NULL,
  `cameraSau` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cameraTruoc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `chipXuLy` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `heDieuHanh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dungLuongPin` int DEFAULT NULL,
  `thuongHieu_id` int DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `thuongHieu_id` (`thuongHieu_id`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`thuongHieu_id`) REFERENCES `thuonghieu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.sanpham: ~0 rows (approximately)
INSERT INTO `sanpham` (`id`, `ten`, `hinhAnh`, `kichThuocMan`, `cameraSau`, `cameraTruoc`, `chipXuLy`, `heDieuHanh`, `dungLuongPin`, `thuongHieu_id`, `trangThai`) VALUES
	(1, 'iPhone 15', 'iphone15.jpg', 6.1, 'Chính 48 MP & Phụ 12 MP', '12 MP', 'Apple A16 Bionic', 'iOS', 3349, 1, 1),
	(2, 'iPhone 15 Plus', 'iphone15plus.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP', '12 MP ', 'Apple A16 Bionic', 'iOS', 4383, 1, 1),
	(3, 'iPhone 15 Pro', 'iphone15pro.jpg', 6.1, 'Chính 48 MP & Phụ 12 MP, 12 MP', '12 MP', 'Apple A17 Pro', 'iOS', 3274, 1, 1),
	(4, 'iPhone 15 Pro Max', 'iphone15promax.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP, 12 MP', '12 MP', 'Apple A17 Pro', 'iOS', 4422, 1, 1),
	(5, 'Xiaomi 14 5G', 'xiaomi14.jpg', 6.36, 'Chính 50 MP & Phụ 50 MP, 50 MP', '32 MP', 'Snapdragon 8 Gen 3', 'Android', 4610, 3, 1),
	(6, 'Xiaomi Redmi Note 13', 'redminote13.jpg', 6.67, 'Chính 108 MP & Phụ 8 MP, 2 MP', '16 MP', 'Snapdragon 685', 'Android', 5000, 3, 1),
	(7, 'Xiaomi Redmi Note 13 Pro', 'redminote13pro.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'MediaTek Helio G99-Ultra', 'Android', 5000, 3, 1),
	(8, 'Xiaomi Redmi Note 13 Pro 5G', '181xiaomi-redmi-note-13-pro-5g-violet-thumb-600x600.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'Snapdragon 7s Gen 2 8 nhân', 'Android', 5100, 3, 1),
	(9, 'Xiaomi Redmi Note 13 Pro+ 5G', '81xiaomi-redmi-note-13-pro-plus-black-thumb-600x600.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'MediaTek Dimensity 7200 Ultra', 'Android', 5000, 3, 1),
	(10, 'Samsung Galaxy S24 5G', '296samsung-galaxy-s24-yellow-thumb-600x600.jpg', 6.2, 'Chính 50 MP & Phụ 12 MP, 10 MP', '12 MP', 'Exynos 2400', 'Android', 4000, 2, 1);

-- Dumping structure for table cuahangdienthoai.taikhoan
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nhanVien_id` int DEFAULT NULL,
  `quyen_id` int DEFAULT NULL,
  `tenTaiKhoan` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `matKhau` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `nhanVien_id` (`nhanVien_id`),
  KEY `quyen_id` (`quyen_id`),
  CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.taikhoan: ~0 rows (approximately)
INSERT INTO `taikhoan` (`id`, `nhanVien_id`, `quyen_id`, `tenTaiKhoan`, `matKhau`, `trangThai`) VALUES
	(1, 1, 1, 'ducem', '123456', 1),
	(2, 2, 2, 'dead', '123456', 1),
	(3, 3, 3, 'dungdia', '123456', 1);

-- Dumping structure for table cuahangdienthoai.thuonghieu
CREATE TABLE IF NOT EXISTS `thuonghieu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.thuonghieu: ~3 rows (approximately)
INSERT INTO `thuonghieu` (`id`, `ten`) VALUES
	(1, 'Apple'),
	(2, 'Samsung'),
	(3, 'Xiaomi');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
