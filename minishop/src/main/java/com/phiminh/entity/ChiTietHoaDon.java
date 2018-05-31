package com.phiminh.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name="chitiethoadon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	ChiTietHoaDonId chitietHoaDonId;
	
	int soluong;
	int giatien;
	public ChiTietHoaDonId getChitietHoaDonId() {
		return chitietHoaDonId;
	}
	public void setChitietHoaDonId(ChiTietHoaDonId chitietHoaDonId) {
		this.chitietHoaDonId = chitietHoaDonId;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
}
