package com.phiminh.controller;

import java.io.File;
import java.io.IOException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phiminh.entity.ChiTietSanPham;
import com.phiminh.entity.DanhMucSanPham;
import com.phiminh.entity.JSON_SanPham;
import com.phiminh.entity.MauSanPham;
import com.phiminh.entity.SanPham;
import com.phiminh.entity.SizeSanPham;
import com.phiminh.service.SanPhamService;

@Controller
@RequestMapping("api/")
public class ApiController {

	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping(path="LaySanPhamLimit" , produces="text/plain; charset=utf-8")
	@ResponseBody
	public String LaySanPhamLimit(@RequestParam int spbatdau) {
		
		String html = "";
		
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachSanPhamlimit(spbatdau);
		for (SanPham sanPham : listSanPhams) {
			
			html += "<tr>";
			html += "<td><div class='checkbox'><label><input class='checkboxsanpham' type='checkbox' value='"+sanPham.getMasanpham()+"'></label></div></td>";
			html += "<td class='tensp' data-masp='" + sanPham.getMasanpham() +"'>" +sanPham.getTensanpham() +"</td>";
			html += "<td class='giatien'>" + sanPham.getGiatien() + "</td>";
			html += "<td class='gianhcho'>" + sanPham.getGianhcho() + "</td>";
			html += "<td style='color:white' class='btn btn-warning capnhatsanpham' data-id=" + sanPham.getMasanpham() +">Sửa</td>";
			html += "</td>";
		}
		
		return html;
	}
	
	@GetMapping("XoaSanPham")
	@ResponseBody 
	public String XoaSanPhamTheoMaSanPham (@RequestParam int masp) {
//		System.out.println("aa :" + masp);
//		try {
//		sanPhamService.XoaSanPhamTheoMaSanPham(masp);
//		return "OK";
//		}catch(Exception ex) {
//			return ex.getMessage();
//		}
//		sanPhamService.XoaSanPhamTheoMaSanPham(masp);
//		sanPhamService.XoaSanPhamTheoMaSanPham(masp);
//		System.out.println("aa :" + masp);
		sanPhamService.XoaSanPhamTheoMaSanPham(masp);
		return "true";
	}
	
	
	@Autowired
	ServletContext context;
	
	@PostMapping("UploadFile")
	@ResponseBody 
	public String UploadFile (MultipartHttpServletRequest request) {
		
		String path_save_file = context.getRealPath("/resources/Image/sanpham/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());
		
		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path_save_file);
		return "true";
	}
	
	
	@PostMapping("themsanpham")
	@ResponseBody
	public void themsanpham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
//		System.out.println("chay");
		JsonNode jsonObject;
		System.out.println(dataJson);
		try {
			SanPham sanPham = new SanPham();
			jsonObject = objectMapper.readTree(dataJson);
			
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhmucsanpham").asInt());
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listChiTiet = new HashSet<ChiTietSanPham>();
			for (JsonNode objectChitiet : jsonChitiet) {
				 ChiTietSanPham  chiTietSanPham = new ChiTietSanPham(); 
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objectChitiet.get("mausanpham").asInt());
				
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMasize(objectChitiet.get("sizesanpham").asInt());
				
				chiTietSanPham.setMausanpham(mauSanPham);
				chiTietSanPham.setSizesanpham(sizeSanPham);
				chiTietSanPham.setSoluong(objectChitiet.get("soluong").asInt());
				
				listChiTiet.add(chiTietSanPham);
				
			}
			
			String tensanpham = jsonObject.get("tensanpham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
			
			
			
			sanPham.setChitietsanpham(listChiTiet);
			sanPham.setDanhmucsanpham(danhMucSanPham);
			sanPham.setTensanpham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setMota(mota);
			sanPham.setHinhsanpham(hinhsanpham);
			sanPham.setGianhcho(gianhcho);
			
			sanPhamService.ThemSanPham(sanPham);
			
			/*System.out.println(jsonObject.get("chitietsanpham"));*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	@PostMapping("capnhatsanpham")
	@ResponseBody
	public void capnhatsanpham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
//		System.out.println("chay");
		JsonNode jsonObject;
		System.out.println(dataJson);
		try {
			SanPham sanPham = new SanPham();
			jsonObject = objectMapper.readTree(dataJson);
			
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhmucsanpham").asInt());
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listChiTiet = new HashSet<ChiTietSanPham>();
			for (JsonNode objectChitiet : jsonChitiet) {
				 ChiTietSanPham  chiTietSanPham = new ChiTietSanPham(); 
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objectChitiet.get("mausanpham").asInt());
				
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMasize(objectChitiet.get("sizesanpham").asInt());
				
				chiTietSanPham.setMausanpham(mauSanPham);
				chiTietSanPham.setSizesanpham(sizeSanPham);
				chiTietSanPham.setSoluong(objectChitiet.get("soluong").asInt());
				
				listChiTiet.add(chiTietSanPham);
				
			}
			
			String tensanpham = jsonObject.get("tensanpham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String mota = jsonObject.get("mota").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();
			String gianhcho = jsonObject.get("gianhcho").asText();
			int masanpham = jsonObject.get("masanpham").asInt();
			
			
			sanPham.setChitietsanpham(listChiTiet);
			sanPham.setDanhmucsanpham(danhMucSanPham);
			sanPham.setTensanpham(tensanpham);
			sanPham.setGiatien(giatien);
			sanPham.setMota(mota);
			sanPham.setHinhsanpham(hinhsanpham);
			sanPham.setGianhcho(gianhcho);
			sanPham.setMasanpham(masanpham);
			
			sanPhamService.CapNhatSanPham(sanPham);
			
			/*System.out.println(jsonObject.get("chitietsanpham"));*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	/*@PostMapping("LayDanhSachSanPhamTheoMa")
	@ResponseBody
	public SanPham LayDanhSachSanPhamTheoMa(@RequestParam int masanpham) {
		SanPham sanPhams = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		return sanPhams;
	}
	*/
	
	@PostMapping(path="LayDanhSachSanPhamTheoMa", produces = "application/json; charset=utf-8")
	@ResponseBody
	public JSON_SanPham LayDanhSachSanPhamTheoMa(@RequestParam int masanpham) {
		
		JSON_SanPham json_SanPham = new JSON_SanPham();
		
		SanPham sanPhams =  sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		
		
		json_SanPham.setMasanpham(sanPhams.getMasanpham());
		json_SanPham.setTensanpham(sanPhams.getTensanpham());
		json_SanPham.setGiatien(sanPhams.getGiatien());
		json_SanPham.setMota(sanPhams.getMota());
		json_SanPham.setHinhsanpham(sanPhams.getHinhsanpham());
		json_SanPham.setGianhcho(sanPhams.getGianhcho());
		
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setMadanhmuc(sanPhams.getDanhmucsanpham().getMadanhmuc());
		danhMucSanPham.setTendanhmuc(sanPhams.getDanhmucsanpham().getTendanhmuc());
		
		
		Set<ChiTietSanPham> chiTietSanPhams = new HashSet<ChiTietSanPham>();
		for (ChiTietSanPham value : sanPhams.getChitietsanpham()) {
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			
			chiTietSanPham.setMachitietsanpham(value.getMachitietsanpham());
			
			MauSanPham mausanpham = new MauSanPham();
			mausanpham.setMamau(value.getMausanpham().getMamau());
			mausanpham.setTenmau(value.getMausanpham().getTenmau());
			
			
			chiTietSanPham.setMausanpham(mausanpham);
			
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setMasize(value.getSizesanpham().getMasize());
			sizeSanPham.setSize(value.getSizesanpham().getSize());
			
			chiTietSanPham.setSizesanpham(sizeSanPham);
			chiTietSanPham.setSoluong(value.getSoluong());
			
			chiTietSanPhams.add(chiTietSanPham);
			
			
		}
		
		
		
		json_SanPham.setDanhmucsanpham(danhMucSanPham);
		json_SanPham.setChitietsanpham(chiTietSanPhams);
		
		return json_SanPham;

	}
	
	
}
