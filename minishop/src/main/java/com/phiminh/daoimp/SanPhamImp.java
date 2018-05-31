package com.phiminh.daoimp;

import java.util.List;

import com.phiminh.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> LayDanhSachSanPhamlimit(int spbatdau);
	boolean XoaSanPhamTheoMaSanPham (int masanpham);
	boolean ThemSanPham(SanPham sanPham);
	SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham);
	boolean CapNhatSanPham(SanPham sanPham);
}
