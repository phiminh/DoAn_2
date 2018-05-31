<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>

<link rel="stylesheet" href="resources/Styles/styles.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="header" class="container-fluid header">
		<nav class="navbar navbar-default none_nav">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><img src='<c:url value ="/resources/Image/logo_yame.png"/>'></a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav navbar-center">
			        <!-- <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li> -->
			        <li class="active"><a href="#">TRANG CHỦ</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Action</a></li>
			            <li><a href="#">Another action</a></li>
			            <li><a href="#">Something else here</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">Separated link</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">One more separated link</a></li>
			          </ul>
			        </li>
			        <li><a href="#">DỊCH VỤ</a></li>
			        <li><a href="#">LIÊN HỆ</a></li>
			        
			      </ul>
			      
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
			        <li><a href="#">ĐĂNG KÝ</a></li>
			        <li><a href="#"><img src='<c:url value ="/resources/Image/cart-icon.png"/>' style="height: 40px; width: 40px;"></a></li>
			       
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
		</nav>
		
		
		<div class="event_header container">
			<span>Ngày 30/04 - 01/05/2018 </span> <br>
			<span style="font-size: 50px">Mua 1 tặng 1</span> <br>
			<button>XEM NGAY</button>
		</div>
	</div>


	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4">
				<img class="icon" src='<c:url value ="/resources/Image/chatluong_icon.png"/>'/> <br>
				<span style="font-size: 30px; font-weight: bolder;">CHẤT LƯỢNG</span> <br>
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4">
				<img class="icon" src='<c:url value ="/resources/Image/tietkiem_icon.png"/>'/> <br>
				<span style="font-size: 30px; font-weight: bolder;">TIẾT KIỆM CHI PHÍ</span> <br>
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4">
				<img class="icon" src='<c:url value ="/resources/Image/giaohang_icon.png"/>'/> <br>
				<span style="font-size: 30px; font-weight: bolder;">GIAO HÀNG</span> <br>
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
			</div>
			
		</div>
	</div>
	
	<div id="title-sanpham"class="container">
		<span>SẢN PHẨM HOT</span>
		<div class="row">
			<c:forEach var="sanpham" items="${listSanPham }" >
				<div class="col-md-3 col-sm-6">
					<div class="sanpham">
						<img alt="hinh" src='<c:url value ="/resources/Image/sanpham/${sanpham.getHinhsanpham() }"/>'/> <br>
						<span style="font-size: 19px"> ${sanpham.getTensanpham()} </span> <br>
						<span class="gia">${sanpham.getGiatien()}VND</span>
					</div>
				
				</div>
			</c:forEach>
			
			
			<%-- <div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="sanpham">
					<img alt="hinh" src='<c:url value ="/resources/Image/ao_so_mi_nam.jpg"/>'/> <br>
					<span>Áo sơ mi</span> <br>
					<span class="gia">150,000 VND</span>
				</div>
				
			</div> --%>
			<!-- end san pham -->
			
			
			
			
		</div>
	</div>	


	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">LIÊN HỆ</span> <br></p>
				<span> Địa chỉ: 57 Nguyễn Trãi, Q. Ninh kiều, TPCT</span><br>
				<span>Email: phiminh1997@gmail.com</span> <br>
				<span>Điện thoại: 0947493410</span>
			</div>
			
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">GÓP Ý</span></p>
				<input class="material-textinput" style="margin-bottom: 10px" type="text" placeholder="Email"/>
				<textarea rows="4" cols="50" placeholder="Nội dung"></textarea>
				<button class="material-primary-button">ĐỒNG Ý</button>
			</div>
		</div>
	</div>	
	
	
	
	<jsp:include page="footer.jsp"/>
</body>


</html>