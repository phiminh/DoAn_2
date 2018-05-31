<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<body id="body-login">
<div id="body-flex-login">
	<div id="container-login" > 
		<div id="header-top" class="header-login">
			<span class="actived" id="dangnhap" >ĐĂNG NHẬP</span> / <span id="dangky" >ĐĂNG KÝ</span>
		</div>
		
		<div id="container-center-login">
			<div class="container-login-form" id="container-center-login">
				<form action="" method="post">
				<input id="email" name="email" class="material-textinput" placeholder="EMAIL" type="text"/><br>
				<input id="matkhau" name="matkhau" class="material-textinput" placeholder="MẬT KHẨU" type="password"/><br>
				
				<input id="btnDangNhap" class="material-primary-button"  style="color: white; font-weight: bolder;" type="submit" value="ĐĂNG NHẬP"/><br>
			</form>
			</div>
			
			
			<div class="container-signup-form " id="container-center-login ">
				<form action="" method="post">
				<input id="email" name="email" class="material-textinput" placeholder="EMAIL" type="text"/><br>
				<input id="matkhau" name="matkhau" class="material-textinput" placeholder="MẬT KHẨU" type="password"/><br>
				<input id="nhaplaimatkhau" name="nhaplaimatkhau" class="material-textinput" placeholder="NHẬP LẠI MẬT KHẨU" type="password"/><br>
				
				<input id="btnDangKy" class="material-primary-button"  style="color: white; font-weight: bolder;" type="submit" value="ĐĂNG Ký"/><br>
			</form>
			</div>
			
		</div> 
		<br>
		
		 <span style="color: red; font-weight: bold;"> ${kiemtradangnhap} </span> 
		<%-- <span style="color: red; font-weight: bold;"> ${kiemtradangnhap2} </span> --%>
	</div>
</div>
	
	
	<jsp:include page="footer.jsp"/>
</body>


</html>