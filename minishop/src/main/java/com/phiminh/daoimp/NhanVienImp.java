package com.phiminh.daoimp;

import com.phiminh.entity.NhanVien;

public interface NhanVienImp {
	boolean KiemTraDangNhap(String email,String matkhau);
	boolean ThemNhanVien(NhanVien nhanVien);
}
