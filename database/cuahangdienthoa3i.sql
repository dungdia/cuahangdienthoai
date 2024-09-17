-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2024 at 04:27 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuahangdienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `baohanh`
--

CREATE TABLE `baohanh` (
  `id` int(11) NOT NULL,
  `soThang` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `baohanh`
--

INSERT INTO `baohanh` (`id`, `soThang`, `trangthai`) VALUES
(1, 12, 1),
(2, 24, 1),
(3, 36, 1),
(4, 6, 1),
(5, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `chucnang`
--

CREATE TABLE `chucnang` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chucnang`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `ctbaohanh`
--

CREATE TABLE `ctbaohanh` (
  `id` int(11) NOT NULL,
  `baoHanh_id` int(11) DEFAULT NULL,
  `hoaDon_id` int(11) DEFAULT NULL,
  `imei_sanPham` varchar(255) DEFAULT NULL,
  `ngayKetThuc` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctbaohanh`
--

INSERT INTO `ctbaohanh` (`id`, `baoHanh_id`, `hoaDon_id`, `imei_sanPham`, `ngayKetThuc`) VALUES
(5, 1, 4, '123456789012354', '2025-09-15 09:09:36');

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `hoaDon_id` int(11) NOT NULL,
  `imei` varchar(255) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `giaBanRa` int(11) DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`hoaDon_id`, `imei`, `soLuong`, `giaBanRa`, `tongTien`) VALUES
(4, '123456789012354', 1, 2758800, 2758800);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `phieuNhap_id` int(11) NOT NULL,
  `pbsanPham_id` int(11) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` int(11) DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`phieuNhap_id`, `pbsanPham_id`, `soLuong`, `donGia`, `tongTien`) VALUES
(6, 37, 12, 2299000, 27588000);

-- --------------------------------------------------------

--
-- Table structure for table `ctquyen`
--

CREATE TABLE `ctquyen` (
  `quyen_id` int(11) NOT NULL,
  `chucNang_id` int(11) NOT NULL,
  `hanhDong` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctquyen`
--

INSERT INTO `ctquyen` (`quyen_id`, `chucNang_id`, `hanhDong`) VALUES
(1, 1, 'add'),
(1, 1, 'delete'),
(1, 1, 'edit'),
(1, 1, 'view'),
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

-- --------------------------------------------------------

--
-- Table structure for table `ctsanpham`
--

CREATE TABLE `ctsanpham` (
  `imei` varchar(255) NOT NULL,
  `sanPham_id` int(11) DEFAULT NULL,
  `pbSanPham_id` int(11) DEFAULT NULL,
  `phieuNhap_id` int(11) DEFAULT NULL,
  `giaNhap` int(11) NOT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctsanpham`
--

INSERT INTO `ctsanpham` (`imei`, `sanPham_id`, `pbSanPham_id`, `phieuNhap_id`, `giaNhap`, `trangThai`) VALUES
('123456789012345', 11, 37, 6, 2299000, 1),
('123456789012346', 11, 37, 6, 2299000, 1),
('123456789012347', 11, 37, 6, 2299000, 1),
('123456789012348', 11, 37, 6, 2299000, 1),
('123456789012349', 11, 37, 6, 2299000, 1),
('123456789012350', 11, 37, 6, 2299000, 1),
('123456789012351', 11, 37, 6, 2299000, 1),
('123456789012352', 11, 37, 6, 2299000, 1),
('123456789012353', 11, 37, 6, 2299000, 1),
('123456789012354', 11, 37, 6, 2299000, 0),
('123456789012355', 11, 37, 6, 2299000, 1),
('123456789012356', 11, 37, 6, 2299000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL,
  `khacHang_id` int(11) DEFAULT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `khuyenMai_id` int(11) DEFAULT NULL,
  `ngayXuat` datetime DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id`, `khacHang_id`, `nhanVien_id`, `khuyenMai_id`, `ngayXuat`, `tongTien`, `trangthai`) VALUES
(4, 7, 1, 1, '2024-09-15 09:09:47', 2758800, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id` int(11) NOT NULL,
  `ho` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `ngaythamgia` datetime DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id`, `ho`, `ten`, `diaChi`, `soDienThoai`, `ngaythamgia`, `trangThai`) VALUES
(1, 'Nguyễn Văn', 'Mười', NULL, '0123456789', '2024-09-13 19:25:23', 1),
(2, 'Đỗ Văn', 'Thừa', NULL, '0984756213', '2024-04-20 09:28:43', 1),
(3, 'Bó Đạt', 'Chách', NULL, '0963258741', '2024-04-17 09:28:47', 1),
(4, 'Nguyễn Văn', 'Sơn', NULL, '05623491562', '2024-05-05 22:44:52', 1),
(5, 'Trình Khánh', 'Nam', NULL, '05698743261', '2024-05-05 22:45:26', 1),
(6, 'Bùi Hoàng', 'Long', NULL, '0651487952', '2024-05-05 22:45:46', 1),
(7, 'Nguyễn Việt', 'Hùng', NULL, '0213459713', '2024-05-05 22:46:31', 1),
(8, 'Lê Trung', 'Kiên', NULL, '0136594871', '2024-05-05 22:46:51', 1),
(9, 'Trần Nguyễn Vũ', 'Phong', NULL, '0147956435', '2024-05-05 22:47:11', 1),
(10, 'Nguyễn Văn', 'Liêm', NULL, '0146598743', '2024-05-05 22:48:39', 1),
(11, 'Trần Hữu', 'Nghị', NULL, '05623498715', '2024-05-05 22:49:06', 1),
(12, 'Lê Hữu', 'Thọ', NULL, '0146985647', '2024-05-05 22:49:51', 1),
(13, 'Lê Hữu', 'Giàu', NULL, '0564897463', '2024-05-05 22:50:01', 1),
(14, 'Nguyễn Hoàng', 'Dũng', NULL, '03459876132', '2024-05-05 22:50:32', 1),
(15, 'Đoàn Thanh', 'Luân', NULL, '07864351648', '2024-05-05 22:50:53', 1),
(16, 'Trần Văn', 'Cường', NULL, '04623154956', '2024-05-05 22:54:04', 1),
(17, 'Huỳnh Đức', 'Trung', NULL, '04956321456', '2024-05-05 22:51:26', 1),
(18, 'Nguyễn Thị', 'Hường', NULL, '06541356489', '2024-05-05 22:53:04', 1),
(19, 'Đoàn Minh', 'Dũng', NULL, '04561398746', '2024-05-05 22:52:11', 1),
(20, 'Nguyễn Tường', 'Vy', NULL, '04562149765', '2024-05-05 22:54:37', 1),
(21, 'Lê Thị Thanh', 'Trúc', NULL, '04561324789', '2024-05-05 22:53:34', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `id` int(11) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `tiLe` float DEFAULT NULL,
  `sanPham_id` int(11) DEFAULT NULL,
  `dieuKien` int(11) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`id`, `ten`, `tiLe`, `sanPham_id`, `dieuKien`, `trangthai`) VALUES
(1, 'Không khuyến mãi', 0, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`id`, `ten`, `diaChi`, `soDienThoai`, `email`, `trangThai`) VALUES
(1, 'Công Ty TNHH Thế Giới Di Động', 'Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', '2835100100', 'lienhe@thegioididong.com', 1),
(2, 'Công ty TNHH Thương Mại Công Nghệ Bạch Long', '134 Trần Phú, phường 4, quận 5, Tp. Hồ Chí Minh', '869287135', 'marketing@bachlongmobile.com', 1),
(3, 'Viễn Thông Đức Huy', '187A Đường 3/2, P. 11, Q. 10, Tp. Hồ Chí Minh', '971151515', 'duchuymobile2011@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` int(11) NOT NULL,
  `ho` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `gioiTinh` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `ho`, `ten`, `gioiTinh`, `soDienThoai`, `email`, `trangThai`) VALUES
(1, 'Trần Đức', 'Em', 'Nam', '374126105', '3122410091@sv.sgu.edu.vn', 1),
(2, 'Trầm Quang', 'Dũng', 'Nam', '324879561', '3122410054@sv.sgu.edu.vn', 1),
(3, 'Hoàng', 'Dũng', 'Nam', '879456213', '3122410052@sv.sgu.edu.vn', 1),
(4, 'Đoàn Minh', 'Đức', 'Nam', '546798123', '3122410084@sv.sgu.edu.vn', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pbsanpham`
--

CREATE TABLE `pbsanpham` (
  `id` int(11) NOT NULL,
  `sanPham_id` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `mau` varchar(255) DEFAULT NULL,
  `soLuong` int(11) DEFAULT 0,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pbsanpham`
--

INSERT INTO `pbsanpham` (`id`, `sanPham_id`, `ram`, `rom`, `mau`, `soLuong`, `trangThai`) VALUES
(1, 1, 6, 128, 'Đen', 0, 1),
(2, 1, 6, 256, 'Đen', 0, 1),
(3, 1, 6, 512, 'Đen', 0, 1),
(4, 2, 6, 128, 'Đen', 0, 1),
(5, 3, 6, 256, 'Đen', 0, 1),
(6, 2, 6, 512, 'Đen', 0, 1),
(10, 8, 8, 256, 'Tím', 0, 1),
(11, 8, 8, 256, 'Xanh', 0, 1),
(12, 8, 8, 256, 'Đen', 0, 1),
(13, 9, 8, 256, 'Đen', 0, 1),
(14, 9, 8, 256, 'Tím', 0, 1),
(15, 9, 8, 256, 'Trắng', 0, 1),
(16, 10, 8, 256, 'Vàng', 0, 1),
(17, 10, 8, 256, 'Xám', 0, 1),
(18, 10, 8, 256, 'Đen', 0, 1),
(19, 10, 8, 256, 'Tím', 0, 1),
(20, 10, 8, 512, 'Vàng', 0, 1),
(21, 10, 8, 512, 'Xám', 0, 1),
(22, 10, 8, 512, 'Đen', 0, 1),
(23, 10, 8, 512, 'Tím', 0, 1),
(24, 4, 8, 256, 'Titan xanh', 0, 1),
(25, 4, 8, 256, 'Titan xanh', 0, 1),
(26, 4, 8, 512, 'Titan xanh', 0, 1),
(27, 4, 8, 256, 'Titan đen', 0, 1),
(28, 6, 8, 128, 'Xanh lá', 0, 1),
(29, 6, 8, 128, 'Vàng', 0, 1),
(30, 6, 6, 128, 'Xanh lá', 0, 0),
(31, 6, 8, 128, 'Đen', 0, 1),
(32, 6, 8, 256, 'Đen', 0, 1),
(33, 7, 8, 128, 'Xanh lá', 0, 1),
(34, 7, 8, 128, 'Xanh lá', 0, 1),
(35, 7, 8, 256, 'Tím', 0, 1),
(36, 5, 12, 256, 'Trắng', 0, 1),
(37, 11, 12, 128, 'Đen', 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `id` int(11) NOT NULL,
  `nhaCungCap_id` int(11) DEFAULT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `ngayNhap` datetime DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`id`, `nhaCungCap_id`, `nhanVien_id`, `ngayNhap`, `tongTien`, `trangthai`) VALUES
(6, 1, 1, '2024-09-15 09:06:05', 27588000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`id`, `ten`, `trangThai`) VALUES
(1, 'Quản lý', 1),
(2, 'Nhân viên nhập hàng', 1),
(3, 'Nhân viên bán hàng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `hinhAnh` varchar(255) DEFAULT NULL,
  `kichThuocMan` float DEFAULT NULL,
  `cameraSau` varchar(255) DEFAULT NULL,
  `cameraTruoc` varchar(255) DEFAULT NULL,
  `chipXuLy` varchar(255) DEFAULT NULL,
  `heDieuHanh` varchar(255) DEFAULT NULL,
  `dungLuongPin` int(11) DEFAULT NULL,
  `thuongHieu_id` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `ten`, `hinhAnh`, `kichThuocMan`, `cameraSau`, `cameraTruoc`, `chipXuLy`, `heDieuHanh`, `dungLuongPin`, `thuongHieu_id`, `trangThai`) VALUES
(1, 'iPhone 15', 'iphone15.jpg', 6.1, 'Chính 48 MP & Phụ 12 MP', '12 MP', 'Apple A16 Bionic', 'iOS', 3349, 1, 1),
(2, 'iPhone 15 Plus', 'iphone15plus.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP', '12 MP ', 'Apple A16 Bionic', 'iOS', 4383, 1, 1),
(3, 'iPhone 13', '671iphone15.jpg', 6.67, 'Chính 38 MP & Phụ 18 MP', '8 MP', 'Apple A15 Bionic', 'iOS', 4000, 1, 1),
(4, 'iPhone 15 Pro Max', 'iphone15promax.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP, 12 MP', '12 MP', 'Apple A17 Pro', 'iOS', 4422, 1, 1),
(5, 'Xiaomi 14 5G', 'xiaomi14.jpg', 6.36, 'Chính 50 MP & Phụ 50 MP, 50 MP', '32 MP', 'Snapdragon 8 Gen 3', 'Android', 4610, 3, 1),
(6, 'Xiaomi Redmi Note 13', 'redminote13.jpg', 6.67, 'Chính 108 MP & Phụ 8 MP, 2 MP', '16 MP', 'Snapdragon 685', 'Android', 5000, 3, 1),
(7, 'Xiaomi Redmi Note 13 Pro', 'redminote13pro.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'MediaTek Helio G99-Ultra', 'Android', 5000, 3, 1),
(8, 'Xiaomi Redmi Note 13 Pro 5G', '181xiaomi-redmi-note-13-pro-5g-violet-thumb-600x600.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'Snapdragon 7s Gen 2 8 nhân', 'Android', 5100, 3, 1),
(9, 'Xiaomi Redmi Note 13 Pro+ 5G', '81xiaomi-redmi-note-13-pro-plus-black-thumb-600x600.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'MediaTek Dimensity 7200 Ultra', 'Android', 5000, 3, 1),
(10, 'Samsung Galaxy S24 5G', '296samsung-galaxy-s24-yellow-thumb-600x600.jpg', 6.2, 'Chính 50 MP & Phụ 12 MP, 10 MP', '12 MP', 'Exynos 2400', 'Android', 4000, 2, 1),
(11, 'Xiaomi 14C', '842xiaomi-redmi-14c-blue-1-600x600.jpg', 123, '123', '123', '123', 'iOS', 12312, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `quyen_id` int(11) DEFAULT NULL,
  `tenTaiKhoan` varchar(255) DEFAULT NULL,
  `matKhau` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `nhanVien_id`, `quyen_id`, `tenTaiKhoan`, `matKhau`, `trangThai`) VALUES
(1, 1, 1, 'ducem', '123456', 1),
(2, 2, 2, 'dead', '123456', 1),
(3, 3, 3, 'dungdia', '123456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`id`, `ten`) VALUES
(1, 'Apple'),
(2, 'Samsung'),
(3, 'Xiaomi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `baoHanh_id` (`baoHanh_id`),
  ADD KEY `hoaDon_id` (`hoaDon_id`),
  ADD KEY `imei_sanPham` (`imei_sanPham`);

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`hoaDon_id`,`imei`),
  ADD KEY `imei` (`imei`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`phieuNhap_id`,`pbsanPham_id`),
  ADD KEY `pbsanPham_id` (`pbsanPham_id`);

--
-- Indexes for table `ctquyen`
--
ALTER TABLE `ctquyen`
  ADD PRIMARY KEY (`quyen_id`,`chucNang_id`,`hanhDong`),
  ADD KEY `chucNang_id` (`chucNang_id`);

--
-- Indexes for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD PRIMARY KEY (`imei`),
  ADD KEY `sanPham_id` (`sanPham_id`),
  ADD KEY `pbSanPham_id` (`pbSanPham_id`),
  ADD KEY `phieuNhap_id` (`phieuNhap_id`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `khacHang_id` (`khacHang_id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`),
  ADD KEY `khuyenMai_id` (`khuyenMai_id`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pbSanPham_id` (`sanPham_id`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanPham_id` (`sanPham_id`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhaCungCap_id` (`nhaCungCap_id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `thuongHieu_id` (`thuongHieu_id`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`),
  ADD KEY `quyen_id` (`quyen_id`);

--
-- Indexes for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `baohanh`
--
ALTER TABLE `baohanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `chucnang`
--
ALTER TABLE `chucnang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  ADD CONSTRAINT `ctbaohanh_ibfk_1` FOREIGN KEY (`baoHanh_id`) REFERENCES `baohanh` (`id`),
  ADD CONSTRAINT `ctbaohanh_ibfk_2` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ctbaohanh_ibfk_3` FOREIGN KEY (`imei_sanPham`) REFERENCES `ctsanpham` (`imei`);

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`imei`) REFERENCES `ctsanpham` (`imei`);

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`),
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`pbsanPham_id`) REFERENCES `pbsanpham` (`id`);

--
-- Constraints for table `ctquyen`
--
ALTER TABLE `ctquyen`
  ADD CONSTRAINT `ctquyen_ibfk_1` FOREIGN KEY (`chucNang_id`) REFERENCES `chucnang` (`id`),
  ADD CONSTRAINT `ctquyen_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`);

--
-- Constraints for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD CONSTRAINT `ctsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`),
  ADD CONSTRAINT `ctsanpham_ibfk_2` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`),
  ADD CONSTRAINT `ctsanpham_ibfk_3` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`khacHang_id`) REFERENCES `khachhang` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`khuyenMai_id`) REFERENCES `khuyenmai` (`id`);

--
-- Constraints for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD CONSTRAINT `khuyenmai_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `pbsanpham` (`id`);

--
-- Constraints for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  ADD CONSTRAINT `pbsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`nhaCungCap_id`) REFERENCES `nhacungcap` (`id`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`thuongHieu_id`) REFERENCES `thuonghieu` (`id`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
