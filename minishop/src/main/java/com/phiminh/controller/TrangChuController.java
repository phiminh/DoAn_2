package com.phiminh.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
/*import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
/*import org.springframework.transaction.annotation.Transactional;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.phiminh.entity.SanPham;
import com.phiminh.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController {
	
	
	
	@Autowired
	SanPhamService SanPhamService;
	
	@GetMapping
	@Transactional
	public  String Default(ModelMap modelMap) {
		
		List<SanPham> listsanPhams = SanPhamService.LayDanhSachSanPhamlimit(0);
		
		modelMap.addAttribute("listSanPham", listsanPhams);
		return "trangchu";
	}
}


	
