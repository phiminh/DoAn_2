$(document).ready(function(){
	
	var masanpham = 0;
	/*$("#cot1").click(function(){
		alert("Hello !");
	});*/
	
	$("#dangnhap").click (function(){
		$(this).addClass("actived");
		$("#dangky").removeClass("actived");
		$(".container-login-form").show();
		$(".container-signup-form").hide();
	});
	
	

	$("#dangky").click(function(){
		$(this).addClass("actived");
		$("#dangnhap").removeClass("actived");
		$(".container-login-form").hide();
		$(".container-signup-form").show();
	});
	
	
	
	
	
	
	
	
	
	$("#checkall").change(function(){
		if(this.checked){
			$("#table-sanpham input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#table-sanpham input").each(function(){
				$(this).attr("checked",false);
			})
		}
	})
	
	
	
	$("#xoa-sanpham").click(function(){
		$("#table-sanpham >tbody input:checked").each(function(){
			
			var masanpham = $(this).val();
		    var This = $(this);
			This.closest("tr").remove();
			$.ajax({
				url:"/minishop/api/XoaSanPham",
				type:"GET",
				data:{
					masp:masanpham,
					
				},
				success:function(value){
					
					This.closest("tr").remove();
				}
			})
			
			
		})
	});
	
	
	
	var files = [];
	var tenhinh = "";
	$("#hinhanh").change(function(event){
		files = event.target.files;
		tenhinh = files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		
		$.ajax({
			url:"/minishop/api/UploadFile",
			type:"POST",
			data:forms,
			contentType:false,
			processData:false,
			enctype:"multipart/form-data",
			success:function(value){
				
			}
		})
		
	});
	
	
	$("body").on("click", ".btn-chitiet", function(){
		$(this).remove()
		var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
		$("#containerchitietsanpham").append(chitietclone);
	});
	
	$("#btnThemSanPham").click(function(event){
		event.preventDefault(); /*ngan load lai trang*/
		var formdata = $("#form-sanpham").serializeArray();  /*serializeArray() lay tat ca gia tri cua form*/
		json = {}
		arraychitiet = [];
		
		$.each(formdata, function(i, field){
			json[field.name] = field.value;
		});
		
		$("#containerchitietsanpham >.chitietsanpham").each(function(){
			objectChitiet = {};
			mausanpham = $(this).find('select[name="mausanpham"]').val();
			sizesanpham = $(this).find('select[name="sizesanpham"]').val();
			soluong = $(this).find('input[name="soluong"]').val();
			/*console.log(mausanpham + " - " + sizesanpham + " - " +soluong);*/
			objectChitiet["mausanpham"] = mausanpham;
			objectChitiet["sizesanpham"] = sizesanpham;
			objectChitiet["soluong"] = soluong;
			
			arraychitiet.push(objectChitiet);
		})
		
		json["chitietsanpham"] = arraychitiet;
		json["hinhsanpham"] = tenhinh;
		/*console.log(json);*/
		
		$.ajax({
			url:"/minishop/api/themsanpham",
			type:"POST",
			data:{
				dataJson: JSON.stringify(json)
			},

			success:function(value){
				
			}
		})
	});
	
	
	
	$("#btnCapNhatSanPham").click(function(event){
		event.preventDefault(); /*ngan load lai trang*/
		var formdata = $("#form-sanpham").serializeArray();  /*serializeArray() lay tat ca gia tri cua form*/
		json = {}
		arraychitiet = [];
		
		$.each(formdata, function(i, field){
			json[field.name] = field.value;
		});
		
		$("#containerchitietsanpham >.chitietsanpham").each(function(){
			objectChitiet = {};
			mausanpham = $(this).find('select[name="mausanpham"]').val();
			sizesanpham = $(this).find('select[name="sizesanpham"]').val();
			soluong = $(this).find('input[name="soluong"]').val();
			/*console.log(mausanpham + " - " + sizesanpham + " - " +soluong);*/
			objectChitiet["mausanpham"] = mausanpham;
			objectChitiet["sizesanpham"] = sizesanpham;
			objectChitiet["soluong"] = soluong;
			
			arraychitiet.push(objectChitiet);
		})
		json["masanpham"] = masanpham;
		json["chitietsanpham"] = arraychitiet;
		json["hinhsanpham"] = tenhinh;
		/*console.log(json);*/
		
		$.ajax({
			url:"/minishop/api/capnhatsanpham",
			type:"POST",
			data:{
				dataJson: JSON.stringify(json)
			},

			success:function(value){
				
			}
		})
	})
	
	
	
	
	
	
	
	
	
	$("body").on("click",".capnhatsanpham", function(){
		masanpham = $(this).attr("data-id");
		
		$("#btnCapNhatSanPham").removeClass("hidden");
		/*$("#btnThoat").removeClass("hidden");*/
		$("#btnThemSanPham").addClass("hidden");
		/*alert(masanpham);*/
		$.ajax({
			url:"/minishop/api/LayDanhSachSanPhamTheoMa",
			type:"POST",
			data:{
				masanpham: masanpham
			},

			success:function(value){
				console.log(value);
				$("#tensanpham").val(value.tensanpham);
				$("#giatien").val(value.giatien);
				$("#mota").val(value.mota);
				if(value.gianhcho =="Nam"){
					$("#rd-nam").prop("checked",true);
				}else{
					$("#rd-nu").prop("checked",true);
				}
				
				$("#danhmucsanpham").val(value.danhmucsanpham.madanhmuc);
				
				$("#containerchitietsanpham").empty();
				
				var countchitiet = value.chitietsanpham.length;
				for(i=0; i<countchitiet; i++){
					
					var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
					
					if(i < countchitiet - 1){
						chitietclone.find(".btn-chitiet").remove();
					}
					chitietclone.find("#mausanpham").val(value.chitietsanpham[i].mausanpham.mamau);
					chitietclone.find("#sizesanpham").val(value.chitietsanpham[i].sizesanpham.masize);
					chitietclone.find("#soluong").val(value.chitietsanpham[i].soluong);
				
					
					$("#containerchitietsanpham").append(chitietclone);
					
				}
				
			}
		})
	});
	
	
})