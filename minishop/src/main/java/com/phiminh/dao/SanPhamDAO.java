package com.phiminh.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phiminh.daoimp.SanPhamImp;
import com.phiminh.entity.ChiTietHoaDon;
import com.phiminh.entity.ChiTietHoaDonId;
import com.phiminh.entity.ChiTietSanPham;
import com.phiminh.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {
	
	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	public List<SanPham> LayDanhSachSanPhamlimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		/*List<SanPham> listSanPhams = (List<SanPham>) session.createQuery("from sanpham limit " + spbatdau + ",3").getResultList();*/
		/*hibernate khong ho tro cau truy van limit tren*/
		List<SanPham> listSanPhams = (List<SanPham>) session.createQuery("from sanpham").setFirstResult(spbatdau).setMaxResults(10).getResultList();
		return listSanPhams;
	}

	@Transactional
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		 //TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class,masanpham);
		/*System.out.println(sanPham.getTensanpham());*/
		
		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getChitietsanpham();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
		
			session.createQuery("delete from chitiethoadon where machitietsanpham="+chiTietSanPham.getMachitietsanpham()).executeUpdate();
			
		}
		
//		session.delete(sanPham);
		session.createQuery("delete from chitietsanpham where masanpham="+masanpham).executeUpdate();
		session.createQuery("delete from sanpham where masanpham="+masanpham).executeUpdate();
		return false;
	}

	
	
	@Transactional
	public boolean ThemSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(sanPham);
		
		System.out.println(id);
		return true;
	}
	
	
	
	@Transactional
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham){
		
		Session session = sessionFactory.getCurrentSession();
		String query = " from sanpham sp where sp.masanpham="+masanpham;
		SanPham sanPhams =  (SanPham) session.createQuery(query).getSingleResult();
		
		
		return sanPhams;
		
	}

	
	
	@Transactional
	public boolean CapNhatSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
		return false;
	}

}
