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
  `trangthai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.baohanh: ~5 rows (approximately)
INSERT INTO `baohanh` (`id`, `soThang`, `trangthai`) VALUES
	(1, 12, 1),
	(2, 24, 1),
	(3, 36, 1),
	(4, 6, 1),
	(5, 8, 1);

-- Dumping structure for table cuahangdienthoai.chucnang
CREATE TABLE IF NOT EXISTS `chucnang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.chucnang: ~9 rows (approximately)
INSERT INTO `chucnang` (`id`, `ten`, `trangThai`) VALUES
	(1, 'Sản phẩm', 1),
	(2, 'Phiếu nhập', 1),
	(3, 'Hóa đơn', 1),
	(4, 'Khách hàng', 1),
	(5, 'Nhân viên', 1),
	(6, 'Nhà cung cấp', 1),
	(7, 'Phân quyền', 1),
	(8, 'Thống kê', 1),
	(9, 'Tài khoản', 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctbaohanh: ~0 rows (approximately)

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

-- Dumping data for table cuahangdienthoai.cthoadon: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.ctnhacungcap
CREATE TABLE IF NOT EXISTS `ctnhacungcap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nhacungcap_id` int DEFAULT NULL,
  `phiebansanpham_id` int DEFAULT NULL,
  `gianhap` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phiebansanpham_id` (`phiebansanpham_id`),
  KEY `nhacungcap_id` (`nhacungcap_id`),
  CONSTRAINT `ctnhacungcap_ibfk_1` FOREIGN KEY (`phiebansanpham_id`) REFERENCES `pbsanpham` (`id`),
  CONSTRAINT `ctnhacungcap_ibfk_2` FOREIGN KEY (`nhacungcap_id`) REFERENCES `nhacungcap` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctnhacungcap: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.ctphieunhap
CREATE TABLE IF NOT EXISTS `ctphieunhap` (
  `phieuNhap_id` int NOT NULL,
  `pbsanPham_id` int NOT NULL,
  `soLuong` int DEFAULT NULL,
  `donGia` int DEFAULT NULL,
  `tongTien` int DEFAULT NULL,
  PRIMARY KEY (`phieuNhap_id`,`pbsanPham_id`),
  KEY `pbsanPham_id` (`pbsanPham_id`),
  CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`),
  CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`pbsanPham_id`) REFERENCES `pbsanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctphieunhap: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.ctquyen
CREATE TABLE IF NOT EXISTS `ctquyen` (
  `quyen_id` int NOT NULL,
  `chucNang_id` int NOT NULL,
  `hanhDong` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`quyen_id`,`chucNang_id`,`hanhDong`),
  KEY `chucNang_id` (`chucNang_id`),
  CONSTRAINT `ctquyen_ibfk_1` FOREIGN KEY (`chucNang_id`) REFERENCES `chucnang` (`id`),
  CONSTRAINT `ctquyen_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctquyen: ~0 rows (approximately)
INSERT INTO `ctquyen` (`quyen_id`, `chucNang_id`, `hanhDong`) VALUES
	(1, 1, 'add'),
	(1, 1, 'delete'),
	(1, 1, 'edit'),
	(1, 1, 'view'),
	(3, 1, 'view'),
	(4, 1, 'view'),
	(5, 1, 'add'),
	(5, 1, 'delete'),
	(5, 1, 'edit'),
	(5, 1, 'view'),
	(1, 2, 'add'),
	(1, 2, 'view'),
	(5, 2, 'add'),
	(5, 2, 'view'),
	(1, 3, 'add'),
	(1, 3, 'delete'),
	(1, 3, 'view'),
	(3, 3, 'add'),
	(3, 3, 'delete'),
	(3, 3, 'view'),
	(1, 4, 'add'),
	(1, 4, 'delete'),
	(1, 4, 'edit'),
	(1, 4, 'view'),
	(3, 4, 'add'),
	(3, 4, 'delete'),
	(3, 4, 'edit'),
	(3, 4, 'view'),
	(1, 5, 'add'),
	(1, 5, 'delete'),
	(1, 5, 'edit'),
	(1, 5, 'view'),
	(5, 5, 'add'),
	(5, 5, 'delete'),
	(5, 5, 'edit'),
	(5, 5, 'view'),
	(1, 6, 'add'),
	(1, 6, 'delete'),
	(1, 6, 'edit'),
	(1, 6, 'view'),
	(5, 6, 'add'),
	(5, 6, 'delete'),
	(5, 6, 'edit'),
	(5, 6, 'view'),
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
  `phieuNhap_id` int DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`imei`),
  KEY `sanPham_id` (`sanPham_id`),
  KEY `pbSanPham_id` (`pbSanPham_id`),
  KEY `phieuNhap_id` (`phieuNhap_id`),
  CONSTRAINT `ctsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`),
  CONSTRAINT `ctsanpham_ibfk_2` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`),
  CONSTRAINT `ctsanpham_ibfk_3` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.ctsanpham: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `khacHang_id` int DEFAULT NULL,
  `nhanVien_id` int DEFAULT NULL,
  `khuyenMai_id` int DEFAULT NULL,
  `ngayXuat` datetime DEFAULT NULL,
  `tongTien` int DEFAULT NULL,
  `trangthai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `khacHang_id` (`khacHang_id`),
  KEY `nhanVien_id` (`nhanVien_id`),
  KEY `khuyenMai_id` (`khuyenMai_id`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`khacHang_id`) REFERENCES `khachhang` (`id`),
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`khuyenMai_id`) REFERENCES `khuyenmai` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.hoadon: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ngaythamgia` datetime DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.khachhang: ~0 rows (approximately)
INSERT INTO `khachhang` (`id`, `ho`, `ten`, `diaChi`, `soDienThoai`, `ngaythamgia`, `trangThai`) VALUES
	(1, 'aa', 'a', NULL, '1234567890', '2024-09-12 22:32:54', 1);

-- Dumping structure for table cuahangdienthoai.khuyenmai
CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tiLe` float DEFAULT NULL,
  `pbSanPham_id` int DEFAULT NULL,
  `dieuKien` int DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pbSanPham_id` (`pbSanPham_id`),
  CONSTRAINT `khuyenmai_ibfk_1` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.khuyenmai: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.nhacungcap: ~3 rows (approximately)
INSERT INTO `nhacungcap` (`id`, `ten`, `diaChi`, `soDienThoai`, `email`, `trangThai`) VALUES
	(1, 'Công Ty TNHH Thế Giới Di Động', 'Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', '2835100100', 'lienhe@thegioididong.com', 1),
	(2, 'Công ty TNHH Thương Mại Công Nghệ Bạch Long', '134 Trần Phú, phường 4, quận 5, Tp. Hồ Chí Minh', '869287135', 'marketing@bachlongmobile.com', 1),
	(3, 'Viễn Thông Đức Huy', '187A Đường 3/2, P. 11, Q. 10, Tp. Hồ Chí Minh', '971151515', 'duchuymobile2011@gmail.com', 1);

-- Dumping structure for table cuahangdienthoai.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gioiTinh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soDienThoai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.nhanvien: ~4 rows (approximately)
INSERT INTO `nhanvien` (`id`, `ho`, `ten`, `gioiTinh`, `soDienThoai`, `email`, `trangThai`) VALUES
	(1, 'Trần Đức', 'Em', 'Nam', '0374126105', '3122410091@sv.sgu.edu.vn', 1),
	(2, 'Trầm Quang', 'Dũng', 'Nam', '0324879561', '3122410054@sv.sgu.edu.vn', 1),
	(3, 'Hoàng', 'Dũng', 'Nam', '0879456213', '3122410052@sv.sgu.edu.vn', 1),
	(4, 'Đoàn Minh', 'Đức', 'Nam', '0546798123', '3122410084@sv.sgu.edu.vn', 1);

-- Dumping structure for table cuahangdienthoai.pbsanpham
CREATE TABLE IF NOT EXISTS `pbsanpham` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sanPham_id` int DEFAULT NULL,
  `ram` int DEFAULT NULL,
  `rom` int DEFAULT NULL,
  `mau` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `soLuong` int DEFAULT '0',
  `giaXuat` int DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `sanPham_id` (`sanPham_id`),
  CONSTRAINT `pbsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.pbsanpham: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.phieunhap
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nhaCungCap_id` int DEFAULT NULL,
  `nhanVien_id` int DEFAULT NULL,
  `ngayNhap` datetime DEFAULT NULL,
  `tongTien` int DEFAULT NULL,
  `trangthai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `nhaCungCap_id` (`nhaCungCap_id`),
  KEY `nhanVien_id` (`nhanVien_id`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`nhaCungCap_id`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.phieunhap: ~0 rows (approximately)

-- Dumping structure for table cuahangdienthoai.quyen
CREATE TABLE IF NOT EXISTS `quyen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.quyen: ~5 rows (approximately)
INSERT INTO `quyen` (`id`, `ten`, `trangThai`) VALUES
	(1, 'Quản lý', 1),
	(2, 'Nhân viên nhập hàng', 1),
	(3, 'Nhân viên bán hàng', 1),
	(4, 'abc', 1),
	(5, 'test', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table cuahangdienthoai.sanpham: ~0 rows (approximately)
INSERT INTO `sanpham` (`id`, `ten`, `hinhAnh`, `kichThuocMan`, `cameraSau`, `cameraTruoc`, `chipXuLy`, `heDieuHanh`, `dungLuongPin`, `thuongHieu_id`, `trangThai`) VALUES
	(1, 'cc', '70981xiaomi-redmi-note-13-pro-plus-black-thumb-600x600.jpg', 1, 'cc', 'cc', 'cc', 'asd', 1111, 1, 1);

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

-- Dumping data for table cuahangdienthoai.taikhoan: ~3 rows (approximately)
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

-- Dumping data for table cuahangdienthoai.thuonghieu: ~0 rows (approximately)
INSERT INTO `thuonghieu` (`id`, `ten`) VALUES
	(1, 'Apple'),
	(2, 'Samsung'),
	(3, 'Xiaomi');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
