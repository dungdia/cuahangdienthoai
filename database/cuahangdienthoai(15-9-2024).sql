-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2024 at 08:46 PM
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
(1, 'abc', 'abc', NULL, '0123456789', '2024-09-13 19:25:23', 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
