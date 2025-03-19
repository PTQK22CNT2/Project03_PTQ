-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 18, 2025 lúc 03:32 AM
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
(1, 'CV-001', 'Công văn di dời 100 củ', 'công văn mới', '2024-03-01', 'Đến', 'Hoàn thành', 'null'),
(2, 'CV-002', 'Thông báo lịch họp quý I', 'Lịch họp công ty quý I năm 2024.', '2024-03-05', 'Đến', 'Hoàn thành', 'hop_quy1.pdf'),
(3, 'CV-003', 'Kế hoạch đào tạo nội bộ', 'Chi tiết về khóa đào tạo kỹ năng mềm.', '2024-03-10', 'Đi', 'Đang xử lý', 'dao_tao.pdf'),
(4, 'CV-004', 'Đề xuất mua sắm thiết bị', 'Danh sách thiết bị cần mua cho phòng IT.', '2024-03-15', 'Đi', 'Từ chối', NULL);

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
(1, 'Sở Nội Vụ Hà Nội', 'Số 12, Đường Trần Phú, Hà Nội', '024-12345678'),
(2, 'UBND Quận 1', 'Số 5, Đường Nguyễn Huệ, TP.HCM', '028-98765432'),
(3, 'Bộ Giáo Dục và Đào Tạo', 'Số 35, Đường Đại Cồ Việt, Hà Nội', '024-11223344'),
(4, 'Sở Tài Chính Đà Nẵng', 'Số 9, Đường Lê Duẩn, Đà Nẵng', NULL),
(5, 'Trung Tâm Y Tế TP. Hải Phòng', 'Số 15, Đường Lạch Tray, Hải Phòng', '0225-44556677');

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
(1, 'Nguyễn Văn An', 'an.nguyen@example.com', 'PassAn123', 'Nhân viên'),
(2, 'Trần Thị Bích', 'bich.tran@example.com', 'BichSecure99', 'Nhân viên'),
(3, 'Lê Văn Hùng', 'hung.le@example.com', 'HungPass789', 'Admin'),
(4, 'Phạm Thùy Linh', 'linh.pham@example.com', 'LinhTest456', 'Nhân viên'),
(5, 'Hoàng Minh Đức', 'duc.hoang@example.com', 'DucAdmin321', 'Admin'),
(6, 'Tôn Ngộ Không', 'wukong@gmail.com', 'ad123', 'Nhân viên'),
(7, 'Đường Huyền Trang', 'duongtang@gmail.com', 'sugartank123', 'Nhân viên'),
(8, 'Trư Bát Giới', 'bachia@gmail.com', 'bachia123', 'Nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptqquan_tri`
--

CREATE TABLE `ptqquan_tri` (
  `id` int(11) NOT NULL,
  `PtqTaiKhoan` varchar(50) NOT NULL,
  `PtqMatKhau` varchar(32) NOT NULL,
  `PtqTrangThai` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptqquan_tri`
--

INSERT INTO `ptqquan_tri` (`id`, `PtqTaiKhoan`, `PtqMatKhau`, `PtqTrangThai`) VALUES
(1, 'admin1', 'password123', b'1'),
(2, 'admin2', 'securepass', b'1'),
(3, 'admin3', 'adminpass', b'0'),
(4, 'admin4', 'mypassword', b'1'),
(5, 'admin5', 'testpass', b'0');

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
(1, 1, 'Bạn có một công văn mới cần xử lý.', '2024-03-02 08:00:00', b'0'),
(2, 2, 'Hệ thống đã cập nhật lịch họp mới.', '2024-03-06 09:30:00', b'1'),
(3, 3, 'Kế hoạch đào tạo nội bộ đã được phê duyệt.', '2024-03-11 15:45:00', b'0'),
(4, 4, 'Công văn về mua sắm thiết bị đã bị từ chối.', '2024-03-16 10:20:00', b'1'),
(5, 5, 'Bạn đã nhận được hướng dẫn làm việc từ xa.', '2024-03-21 12:10:00', b'0');

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
(1, 1, 3, '2024-03-02 09:30:00', 'Đang xử lý', 'Đã tiếp nhận công văn và đang xem xét.'),
(2, 2, 1, '2024-03-06 10:00:00', 'Hoàn thành', 'Đã thông báo lịch họp đến toàn công ty.'),
(3, 3, 4, '2024-03-11 14:20:00', 'Đang xử lý', 'Chuẩn bị kế hoạch đào tạo nội bộ.'),
(4, 4, 2, '2024-03-16 08:45:00', 'Từ chối', 'Ngân sách không đủ để mua thiết bị.');

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
  ADD KEY `ptqthong_bao_ibfk_1` (`PtqNguoiNhan`);

--
-- Chỉ mục cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  ADD PRIMARY KEY (`id`),
  ADD KEY `PtqNguoiXuLy` (`PtqNguoiXuLy`),
  ADD KEY `ptqxu_ly_cong_van_ibfk_1` (`PtqCongVanID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ptqcong_van`
--
ALTER TABLE `ptqcong_van`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `ptqdon_vi`
--
ALTER TABLE `ptqdon_vi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ptqnguoi_dung`
--
ALTER TABLE `ptqnguoi_dung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `ptqquan_tri`
--
ALTER TABLE `ptqquan_tri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ptqthong_bao`
--
ALTER TABLE `ptqthong_bao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ptqthong_bao`
--
ALTER TABLE `ptqthong_bao`
  ADD CONSTRAINT `ptqthong_bao_ibfk_1` FOREIGN KEY (`PtqNguoiNhan`) REFERENCES `ptqnguoi_dung` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ptqxu_ly_cong_van`
--
ALTER TABLE `ptqxu_ly_cong_van`
  ADD CONSTRAINT `ptqxu_ly_cong_van_ibfk_1` FOREIGN KEY (`PtqCongVanID`) REFERENCES `ptqcong_van` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ptqxu_ly_cong_van_ibfk_2` FOREIGN KEY (`PtqNguoiXuLy`) REFERENCES `ptqnguoi_dung` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
