-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2018 at 07:42 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbminishop`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `mahoadon` int(11) NOT NULL,
  `machitietsanpham` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giatien` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`mahoadon`, `machitietsanpham`, `soluong`, `giatien`) VALUES
(1, 1, 1, '185,000'),
(3, 3, 1, '225,000');

-- --------------------------------------------------------

--
-- Table structure for table `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `machitietsanpham` int(11) NOT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `masize` int(11) DEFAULT NULL,
  `mamau` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `ngaynhap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`machitietsanpham`, `masanpham`, `masize`, `mamau`, `soluong`, `ngaynhap`) VALUES
(1, 1, 1, 1, 5, '08/05/2018'),
(2, 2, 2, 3, 2, '17/05/2018'),
(3, 4, 1, 1, 1, '11/05/2018'),
(5, NULL, 2, 3, 2, '11/05/2018'),
(14, NULL, 2, 1, 0, NULL),
(15, NULL, 1, 3, 2, NULL),
(17, NULL, 3, 1, 4, NULL),
(18, NULL, 2, 2, 10, NULL),
(19, NULL, 2, 2, 10, NULL),
(20, NULL, 3, 1, 4, NULL),
(21, NULL, 3, 1, 4, NULL),
(22, NULL, 2, 2, 10, NULL),
(25, NULL, 2, 3, 2, NULL),
(26, NULL, 2, 3, 2, NULL),
(27, NULL, 2, 3, 2, NULL),
(28, NULL, 2, 3, 2, NULL),
(29, NULL, 2, 1, 4, NULL),
(32, 6, 2, 1, 5, NULL),
(33, 7, 1, 3, 3, NULL),
(34, 8, 1, 2, 1, NULL),
(35, 8, 2, 1, 3, NULL),
(36, 9, 1, 2, 1, NULL),
(37, 9, 2, 3, 3, NULL),
(38, NULL, 1, 3, 5, NULL),
(39, NULL, 1, 3, 5, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `machucvu` int(11) NOT NULL,
  `tenchucvu` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`machucvu`, `tenchucvu`) VALUES
(1, 'Admin'),
(2, 'Nhân Viên'),
(3, 'Người Dùng');

-- --------------------------------------------------------

--
-- Table structure for table `danhmucsanpham`
--

CREATE TABLE `danhmucsanpham` (
  `madanhmuc` int(11) NOT NULL,
  `tendanhmuc` varchar(100) DEFAULT NULL,
  `hinhdanhmuc` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `danhmucsanpham`
--

INSERT INTO `danhmucsanpham` (`madanhmuc`, `tendanhmuc`, `hinhdanhmuc`) VALUES
(1, 'Áo Sơ Mi', NULL),
(2, 'Áo Sơ Mi Tay Ngắn', NULL),
(3, 'Áo Thun', NULL),
(4, 'Áo Khoác', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `mahoadon` int(11) NOT NULL,
  `tenkhachhang` varchar(100) DEFAULT NULL,
  `sodt` char(12) DEFAULT NULL,
  `diachigiaohang` varchar(200) DEFAULT NULL,
  `tinhtrang` varchar(50) DEFAULT NULL,
  `ngaylap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`mahoadon`, `tenkhachhang`, `sodt`, `diachigiaohang`, `tinhtrang`, `ngaylap`) VALUES
(1, 'Nguyễn Văn A', '0123456789', '123 Nguyễn Văn Cừ', 'Còn hàng', '08/05/2018'),
(2, 'Nguyễn Văn B', '0987654321', '123 Nguyễn Đệ', 'Còn hàng', '08/05/2018'),
(3, 'Trần Thị C', '0292385858', 'Cần Thơ', 'Còn hàng', '11/05/2018');

-- --------------------------------------------------------

--
-- Table structure for table `mausanpham`
--

CREATE TABLE `mausanpham` (
  `mamau` int(11) NOT NULL,
  `tenmau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mausanpham`
--

INSERT INTO `mausanpham` (`mamau`, `tenmau`) VALUES
(1, 'Đen'),
(2, 'Trắng'),
(3, 'Xanh');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manhanvien` int(11) NOT NULL,
  `hoten` varchar(30) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `gioitinh` varchar(3) DEFAULT NULL,
  `cmnd` char(14) DEFAULT NULL,
  `machucvu` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manhanvien`, `hoten`, `diachi`, `gioitinh`, `cmnd`, `machucvu`, `email`, `tendangnhap`, `matkhau`) VALUES
(5, 'Phí Minh', '123 Cần Thơ', 'Nữ', '123456789', 1, 'phiminh1997@gmail.com', 'phiminh', '123456'),
(6, NULL, NULL, NULL, NULL, 2, 'minh@gmail.com', NULL, '123');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL,
  `madanhmuc` int(11) DEFAULT NULL,
  `tensanpham` varchar(100) DEFAULT NULL,
  `giatien` varchar(100) DEFAULT NULL,
  `mota` text,
  `hinhsanpham` text,
  `gianhcho` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masanpham`, `madanhmuc`, `tensanpham`, `giatien`, `mota`, `hinhsanpham`, `gianhcho`) VALUES
(1, 1, 'Sơ Mi Nam No Style TN C01', '185,000', '- Thiết kế với áo sơ mi form basic hiện đại. Đen thời thượng. ', 'SoMiNamNoStyleTNC01.jpg', 'Nam'),
(2, 2, 'Sơ Mi Nam No Style TN C02', '225,000', '- Họa tiết caro hiện đại, vẫn đang rất hợp thời trang và xu hướng, chưa có dấu hiệu hạ nhiệt.\r\n- Túi áo được may tinh tế, hoàn toàn nhập với họa tiết caro, bạn có thể cất giữ vật dụng tiện lợi những vẫn giữ được vẻ trơn tru cho chiếc sơ mi.\r\n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\r\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\r\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.', 'SoMiNamNoStyleTNC02.jpg', 'Nam'),
(4, 2, 'Sơ Mi Nam No Style TN C04', '225,000', '- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn. ', 'SoMiNamNoStyleTNC04.jpg', 'Nam'),
(6, 4, 'Ao Khoac', '300,000', '- Chất liệu : French Terry 2 chiều nhiều tính năng vượt trội + Vải không chứa formaldehyde (chất đây kích ứng da).  +Chống tia UV vượt trội ', 'AoKhoacNu.jpg', 'Nu'),
(7, 3, 'Ao Thun', '79,000', 'BST CONTROL GAME - Chất liệu CVC 4 chiều, bề mặt mịn mượt và đẹp  - Thành phần PE trong sợi vải tăng độ bền, thích hợp với thời tiết mát mẻ.  ', 'AoThunNu.jpg', 'Nu'),
(8, 1, 'So Mi Nam No Style C03', '185,000', '- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. ', 'SoMiNamNoStyleTNC03.jpg', 'Nam'),
(9, 1, 'Ao So Mi Nam No Style C05', '325,000', '- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.', 'SoMiNamNoStyleTNC05.jpg', 'Nam');

-- --------------------------------------------------------

--
-- Table structure for table `sizesanpham`
--

CREATE TABLE `sizesanpham` (
  `masize` int(11) NOT NULL,
  `size` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sizesanpham`
--

INSERT INTO `sizesanpham` (`masize`, `size`) VALUES
(1, 'M'),
(2, 'L'),
(3, 'XL'),
(4, 'XXL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`mahoadon`,`machitietsanpham`),
  ADD KEY `FK_CTHOADON_CTSANPHAM` (`machitietsanpham`);

--
-- Indexes for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`machitietsanpham`),
  ADD KEY `FK_CHITIET_SANPHAM` (`masanpham`),
  ADD KEY `FK_CHITIET_SIZE` (`masize`),
  ADD KEY `FK_CHITIET_MAUSANPHAM` (`mamau`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`machucvu`);

--
-- Indexes for table `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  ADD PRIMARY KEY (`madanhmuc`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahoadon`);

--
-- Indexes for table `mausanpham`
--
ALTER TABLE `mausanpham`
  ADD PRIMARY KEY (`mamau`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manhanvien`),
  ADD KEY `FK_NHANVIEN_CHUCVU` (`machucvu`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masanpham`),
  ADD KEY `FK_SANPHAM_DANHMUC` (`madanhmuc`);

--
-- Indexes for table `sizesanpham`
--
ALTER TABLE `sizesanpham`
  ADD PRIMARY KEY (`masize`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  MODIFY `machitietsanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `chucvu`
--
ALTER TABLE `chucvu`
  MODIFY `machucvu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `danhmucsanpham`
--
ALTER TABLE `danhmucsanpham`
  MODIFY `madanhmuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahoadon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `mausanpham`
--
ALTER TABLE `mausanpham`
  MODIFY `mamau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manhanvien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `sizesanpham`
--
ALTER TABLE `sizesanpham`
  MODIFY `masize` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_CTHOADON_CTSANPHAM` FOREIGN KEY (`machitietsanpham`) REFERENCES `chitietsanpham` (`machitietsanpham`),
  ADD CONSTRAINT `FK_CTHOADON_HOADON` FOREIGN KEY (`mahoadon`) REFERENCES `hoadon` (`mahoadon`);

--
-- Constraints for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD CONSTRAINT `FK_CHITIET_MAUSANPHAM` FOREIGN KEY (`mamau`) REFERENCES `mausanpham` (`mamau`),
  ADD CONSTRAINT `FK_CHITIET_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`),
  ADD CONSTRAINT `FK_CHITIET_SIZE` FOREIGN KEY (`masize`) REFERENCES `sizesanpham` (`masize`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FK_NHANVIEN_CHUCVU` FOREIGN KEY (`machucvu`) REFERENCES `chucvu` (`machucvu`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_SANPHAM_DANHMUC` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmucsanpham` (`madanhmuc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
