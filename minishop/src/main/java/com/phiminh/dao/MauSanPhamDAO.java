package com.phiminh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phiminh.daoimp.MauSanPhamImp;
import com.phiminh.entity.MauSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImp {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<MauSanPham> LayDanhSachMau() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from mausanpham";
		List<MauSanPham>listMauSanPham = session.createQuery(query).getResultList();
		// TODO Auto-generated method stub
		return listMauSanPham;
	}

}
