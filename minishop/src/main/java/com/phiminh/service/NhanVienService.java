package com.phiminh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phiminh.dao.NhanVienDAO;
import com.phiminh.daoimp.NhanVienImp;
import com.phiminh.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp {
	
	@Autowired 
	NhanVienDAO nhanVienDAO;

	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra = nhanVienDAO.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	public boolean ThemNhanVien(NhanVien nhanVien) {
		boolean ktThem = nhanVienDAO.ThemNhanVien(nhanVien);
		
		return ktThem;
	}

	
	
}
