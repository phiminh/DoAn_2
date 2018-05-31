package com.phiminh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phiminh.entity.DanhMucSanPham;
import com.phiminh.entity.MauSanPham;
import com.phiminh.entity.SanPham;
import com.phiminh.entity.SizeSanPham;
import com.phiminh.service.DanhMucService;
import com.phiminh.service.MauSanPhamService;
import com.phiminh.service.SanPhamService;
import com.phiminh.service.SizeSanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachSanPhamlimit(0);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		List<MauSanPham> listMauSanPham = mauSanPhamService.LayDanhSachMau();
		List<SizeSanPham> listSizeSanPham = sizeSanPhamService.LayDanhSachSize();
		
		
		
		modelMap.addAttribute("listSanPham", listSanPhams);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("listsize", listSizeSanPham);
		modelMap.addAttribute("listmau", listMauSanPham);
		return"themsanpham";
	}

}
