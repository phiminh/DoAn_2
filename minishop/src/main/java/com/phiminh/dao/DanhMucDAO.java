package com.phiminh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phiminh.daoimp.DanhMucImp;
import com.phiminh.entity.DanhMucSanPham;



@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String query = "from danhmucsanpham";
		List<DanhMucSanPham> danhMucSanPhams = session.createQuery(query).getResultList();
		
		return danhMucSanPhams;
	}

}
