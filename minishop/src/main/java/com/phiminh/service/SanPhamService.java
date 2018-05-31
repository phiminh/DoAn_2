package com.phiminh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phiminh.dao.SanPhamDAO;
import com.phiminh.daoimp.SanPhamImp;
import com.phiminh.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{

	@Autowired
	SanPhamDAO sanPhamDAO;
	
	
	
	public List<SanPham> LayDanhSachSanPhamlimit(int spbatdau) {
		
		return sanPhamDAO.LayDanhSachSanPhamlimit(spbatdau);
	}



	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.XoaSanPhamTheoMaSanPham(masanpham);
	}



	public boolean ThemSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.ThemSanPham(sanPham);
	}



	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		// TODO Auto-generated method stub
		
		return sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}



	public boolean CapNhatSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.CapNhatSanPham(sanPham);
	}

}
