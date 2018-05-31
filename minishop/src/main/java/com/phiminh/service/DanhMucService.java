package com.phiminh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phiminh.dao.DanhMucDAO;
import com.phiminh.daoimp.DanhMucImp;
import com.phiminh.entity.DanhMucSanPham;



@Service
public class DanhMucService implements DanhMucImp{
	
	@Autowired
	DanhMucDAO danhMucDAO;

	public List<DanhMucSanPham> LayDanhMuc() {
		// TODO Auto-generated method stub
		return danhMucDAO.LayDanhMuc();
	}

}
