package com.phiminh.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int machitietsanpham;
	
	/*1 chi tiet 1 san pham*/
	@OneToOne(/*cascade = CascadeType.ALL*/)
	@JoinColumn(name="masanpham")
	SanPham sanPham;
	
	/*1 chi tiet 1 size san pham*/
	@OneToOne(/*cascade = CascadeType.ALL*/)
	@JoinColumn(name="masize")
	SizeSanPham sizesanpham;
	
	/*1 chi tiet 1 mau san pham*/
	@OneToOne(/*cascade = CascadeType.ALL*/)
	@JoinColumn(name="mamau")
	MauSanPham mausanpham;
	
	int soluong;
	String ngaynhap;

	
	public int getMachitietsanpham() {
		return machitietsanpham;
	}
	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public SizeSanPham getSizesanpham() {
		return sizesanpham;
	}
	public void setSizesanpham(SizeSanPham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public MauSanPham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
}
