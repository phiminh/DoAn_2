package com.phiminh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phiminh.daoimp.SizeSanPhamImp;
import com.phiminh.entity.SizeSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO implements SizeSanPhamImp {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List<SizeSanPham> LayDanhSachSize() {
		
		Session session = sessionFactory.getCurrentSession();
		String query = "from sizesanpham";
		List<SizeSanPham> listSizeSanPham = session.createQuery(query).getResultList();
		// TODO Auto-generated method stub
		return listSizeSanPham;
	}
}
