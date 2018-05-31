package com.phiminh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phiminh.dao.MauSanPhamDAO;
import com.phiminh.daoimp.MauSanPhamImp;
import com.phiminh.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp {
	
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;

	public List<MauSanPham> LayDanhSachMau() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.LayDanhSachMau();
	}

}
