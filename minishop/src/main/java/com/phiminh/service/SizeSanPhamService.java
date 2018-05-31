package com.phiminh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phiminh.dao.SizeSanPhamDAO;
import com.phiminh.daoimp.SizeSanPhamImp;
import com.phiminh.entity.SizeSanPham;


@Service
public class SizeSanPhamService implements SizeSanPhamImp {

	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	
	public List<SizeSanPham> LayDanhSachSize() {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.LayDanhSachSize();
	}

}
