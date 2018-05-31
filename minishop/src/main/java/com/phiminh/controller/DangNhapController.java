package com.phiminh.controller;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phiminh.entity.NhanVien;
import com.phiminh.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")

public class DangNhapController {
	
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default() {
		return "dangnhap";
	}
	

	/*@PostMapping*/
	@Transactional
	public String DangKy (@RequestParam String email,@RequestParam String matkhau,@RequestParam String nhaplaimatkhau,ModelMap map) {
		
		boolean ktmail = validate(email);
		if(ktmail) {
			if(matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setTendangnhap(email);
				nhanVien.setMatkhau(matkhau);
				
			boolean ktThem =nhanVienService.ThemNhanVien(nhanVien);
			if(ktThem) {
				map.addAttribute("kiemtradangnhap", "Tao tai khaon thanh cong ^^");
			} else {
				map.addAttribute("kiemtradangnhap", "Tao tai khoan that bai @_@");
			}
				
		} else {
			map.addAttribute("kiemtradangnhap", "Mat khau khong trung khop @_@");
		}
		}else {
			map.addAttribute("kiemtradangnhap", "Vui long nhap dung dinh dang email @_@");
		}
		
		return "dangnhap";
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	
	@PostMapping
	@Transactional
	public String XulyDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		
		boolean kiemtra = nhanVienService.KiemTraDangNhap(email, matkhau);
		
		if(kiemtra) {
			modelMap.addAttribute("kiemtradangnhap", "Đăng nhập thành công ^^");
			/*System.out.println("dang nhap thanh cong");*/
			return "dashboard";
		}else {
			modelMap.addAttribute("kiemtradangnhap", "Đăng nhập thất bại @_@");
			/*System.out.println("dang nhap that bai");*/
			return "dangnhap";
		}
		
	}
}


 