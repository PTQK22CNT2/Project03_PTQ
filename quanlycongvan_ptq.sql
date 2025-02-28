-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 26, 2025 lúc 03:42 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlycongvan_ptq`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqcong_van`
--

CREATE TABLE `ptqcong_van` (
  `id` int(11) NOT NULL,
  `PtqSoHieu` varchar(50) NOT NULL,
  `PtqTieuDe` varchar(255) NOT NULL,
  `PtqNoiDung` text NOT NULL,
  `PtqNgayBanHanh` date NOT NULL,
  `PtqLoaiCongVan` enum('Đến','Đi') NOT NULL,
  `PtqTrangThai` enum('Đang xử lý','Hoàn thành','Từ chối') NOT NULL DEFAULT 'Đang xử lý',
  `PtqTaiLieuDinhKem` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqcong_van`
--

INSERT INTO `ptqcong_van` (`id`, `PtqSoHieu`, `PtqTieuDe`, `PtqNoiDung`, `PtqNgayBanHanh`, `PtqLoaiCongVan`, `PtqTrangThai`, `PtqTaiLieuDinhKem`) VALUES
(1, 'CV001', 'Thông báo họp', 'Mời họp ngày 10/03', '2024-03-01', 'Đến', 'Đang xử lý', NULL),
(2, 'CV002', 'Hướng dẫn nghiệp vụ', 'Hướng dẫn về quy trình', '2024-03-02', 'Đi', 'Hoàn thành', 'file1.pdf'),
(3, 'CV003', 'Thông báo nghỉ lễ', 'Nghỉ lễ từ 30/04 đến 01/05', '2024-03-05', 'Đến', 'Đang xử lý', 'file2.pdf');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqdon_vi`
--

CREATE TABLE `ptqdon_vi` (
  `id` int(11) NOT NULL,
  `PtqTenDonVi` varchar(255) NOT NULL,
  `PtqDiaChi` varchar(255) DEFAULT NULL,
  `PtqSoDienThoai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqdon_vi`
--

INSERT INTO `ptqdon_vi` (`id`, `PtqTenDonVi`, `PtqDiaChi`, `PtqSoDienThoai`) VALUES
(1, 'Sở Giáo Dục', '123 Đường A, TP HCM', '0123456789'),
(2, 'Sở Y Tế', '456 Đường B, TP HCM', '0987654321'),
(3, 'Sở Xây Dựng', '789 Đường C, TP HCM', '0345678912');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqnguoi_dung`
--

CREATE TABLE `ptqnguoi_dung` (
  `id` int(11) NOT NULL,
  `PtqHoTen` varchar(100) NOT NULL,
  `PtqEmail` varchar(100) NOT NULL,
  `PtqMatKhau` varchar(32) NOT NULL,
  `PtqVaiTro` enum('Admin','Nhân viên') NOT NULL DEFAULT 'Nhân viên'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqnguoi_dung`
--

INSERT INTO `ptqnguoi_dung` (`id`, `PtqHoTen`, `PtqEmail`, `PtqMatKhau`, `PtqVaiTro`) VALUES
(1, 'Nguyễn Minh Khôi', 'khoi.nguyen@example.com', 'pass123', 'Nhân viên'),
(2, 'Trần Thanh Hương', 'huong.tran@example.com', 'pass456', 'Admin'),
(3, 'Lê Quốc Bảo', 'bao.le@example.com', 'pass789', 'Nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqquan_tri`
--

CREATE TABLE `ptqquan_tri` (
  `id` int(11) NOT NULL,
  `PtqTaiKhoan` varchar(50) NOT NULL,
  `PtqMatKhau` varchar(32) NOT NULL,
  `PtqTrangThai` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqquan_tri`
--

INSERT INTO `ptqquan_tri` (`id`, `PtqTaiKhoan`, `PtqMatKhau`, `PtqTrangThai`) VALUES
(1, 'admin1', 'password123', b'1'),
(2, 'admin2', 'password456', b'1'),
(3, 'admin3', 'password789', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqthong_bao`
--

CREATE TABLE `ptqthong_bao` (
  `id` int(11) NOT NULL,
  `PtqNguoiNhan` int(11) NOT NULL,
  `PtqNoiDung` text NOT NULL,
  `PtqNgayGui` datetime NOT NULL DEFAULT current_timestamp(),
  `PtqTrangThai` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqthong_bao`
--

INSERT INTO `ptqthong_bao` (`id`, `PtqNguoiNhan`, `PtqNoiDung`, `PtqNgayGui`, `PtqTrangThai`) VALUES
(1, 1, 'Bạn có một công văn mới cần xử lý.', '2024-03-01 12:00:00', b'0'),
(2, 2, 'Công văn đã được duyệt thành công.', '2024-03-02 15:00:00', b'1'),
(3, 3, 'Bạn có một thông báo mới.', '2024-03-05 09:00:00', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqxu_ly_cong_van`
--

CREATE TABLE `ptqxu_ly_cong_van` (
  `id` int(11) NOT NULL,
  `PtqCongVanID` int(11) NOT NULL,
  `PtqNguoiXuLy` int(11) NOT NULL,
  `PtqNgayXuLy` datetime NOT NULL DEFAULT current_timestamp(),
  `PtqTrangThaiMoi` enum('Đang xử lý','Hoàn thành','Từ chối') NOT NULL,
  `PtqGhiChu` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqxu_ly_cong_van`
--

INSERT INTO `ptqxu_ly_cong_van` (`id`, `PtqCongVanID`, `PtqNguoiXuLy`, `PtqNgayXuLy`, `PtqTrangThaiMoi`, `PtqGhiChu`) VALUES
(1, 1, 1, '2024-03-01 10:00:00', 'Đang xử lý', 'Cần xem xét thêm'),
(2, 2, 2, '2024-03-02 14:30:00', 'Hoàn thành', 'Đã gửi đi'),
(3, 3, 3, '2024-03-05 08:45:00', 'Đang xử lý', 'Chờ phê duyệt');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ptqcong_van`
--
ALTER TABLE `ptqcong_van`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `PtqSoHieu` (`PtqSoHieu`);

--
-- Chỉ mục cho bảng `ptqdon_vi`
--
ALTER TABLE `ptqdon_vi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ptqnguoi_dung`
--
ALTER TABLE `ptqnguoi_dung`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `PtqEmail` (`PtqEmail`);

--
-- Chỉ mục cho bảng `ptqquan_tri`
--
ALTER TABLE `ptqquan_tri`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `PtqTaiKhoan` (`PtqTaiKhoan`);

--
-- Chỉ mục cho bảng `ptqthong_bao`
--
ALTER TABLE `ptqthong_bao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `PtqNguoiNhan` (`PtqNguoiNhan`);

--
-- Chỉ mục cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  ADD PRIMARY KEY (`id`),
  ADD KEY `PtqCongVanID` (`PtqCongVanID`),
  ADD KEY `PtqNguoiXuLy` (`PtqNguoiXuLy`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ptqcong_van`
--
ALTER TABLE `ptqcong_van`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptqdon_vi`
--
ALTER TABLE `ptqdon_vi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptqnguoi_dung`
--
ALTER TABLE `ptqnguoi_dung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptqquan_tri`
--
ALTER TABLE `ptqquan_tri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptqthong_bao`
--
ALTER TABLE `ptqthong_bao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ptqthong_bao`
--
ALTER TABLE `ptqthong_bao`
  ADD CONSTRAINT `ptqthong_bao_ibfk_1` FOREIGN KEY (`PtqNguoiNhan`) REFERENCES `ptqnguoi_dung` (`id`);

--
-- Các ràng buộc cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  ADD CONSTRAINT `ptqxu_ly_cong_van_ibfk_1` FOREIGN KEY (`PtqCongVanID`) REFERENCES `ptqcong_van` (`id`),
  ADD CONSTRAINT `ptqxu_ly_cong_van_ibfk_2` FOREIGN KEY (`PtqNguoiXuLy`) REFERENCES `ptqnguoi_dung` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
