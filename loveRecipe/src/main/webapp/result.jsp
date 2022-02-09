<%@page import="java.awt.print.Printable"%>
<%@page import="model.menuvo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberVO"%>
<%@page import="model.DAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<!--
   Aesthetic by gettemplates.co
   Twitter: http://twitter.com/gettemplateco
   URL: http://gettemplates.co
-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>레시피를 부탁해 &mdash; Free Website Template, Free HTML5
	Template by GetTemplates.co</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by GetTemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="GetTemplates.co" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Bootstrap DateTimePicker -->
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
   <script src="js/respond.min.js"></script>
   <![endif]-->


</head>
<body>
	<%
		DAO dao = new DAO();
	MemberVO info = (MemberVO) session.getAttribute("info");
	ArrayList<menuvo> menulist = (ArrayList) session.getAttribute("menulist");
	%>

	<div class="gtco-loader"></div>

	<div id="page">


		<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="main.jsp"><em class="cursive-font"
								style="font-size: 3rem">레시피를 부탁해</em></a>
						</div>
					</div>
					<div class="col-xs-8 text-right menu-1">
						<ul>
							<li><a href="menu.jsp">Menu</a></li>
							<li class="has-dropdown"><a href="services.jsp">Services</a>
								<ul class="dropdown">
									<li><a href="refigator.jsp">나만의 냉장고</a></li>
									<li><a href="mealplan.jsp">식단짜기</a></li>
									<li><a href="newrecipe.jsp">레시피등록</a></li>
								</ul></li>
							<li><a href="feedback.jsp">feedback</a></li>
							<li class="btn-cta"><a href="main.jsp"><span>login</span></a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="gtco-header" class="gtco-cover gtco-cover-md"
			role="banner" style="background-image: url(images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-left">


						<div class="row row-mt-15em">
							<div class="col-md-7 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<%
									if (info != null) {
								%>
								<%
									if (info.getId().equals("admin")) {
								%>
								<h1>관리자님 환영합니다</h1>
								<%
									}
								%>
								<h1><%=info.getNickname()%>
									님 이 검색하신 결과입니다!
								</h1>
								<%
									} else {
								%>
								<h1>로그인을 하세요!</h1>
								<%
									}
								%>
							</div>



						</div>
					</div>
				</div>
		</header>



		<div class="gtco-section">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2 class="cursive-font primary-color"><%=menulist.size()%>개의
							결과가 검색되엇습니다.
						</h2>
					</div>
				</div>
				<div class="row">
					<%
						if (menulist != null) {
						for (int i = 0; i < menulist.size(); i++) {
					%>
					<div class="col-lg-4 col-md-4 col-sm-6">
					
						<div class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src=<%=menulist.get(i).getImage()%> alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
							
								<h2>요리 이름 : <%=menulist.get(i).getName()%></h2>
								<h2>국가 분류 : <%=menulist.get(i).getCountry()%></h2>
								<h2>방법 분류 : <%=menulist.get(i).getFoodtype()%></h2>
						
								
								
								<h2>총칼로리 : <%=menulist.get(i).getCalory()%>kcal</h2>

							
							</div>
						</div>
					<a href="viewrecipen.jsp">레시피 보기</a><br><br>
					</div>
					<%
						}
					}
					%>









					<footer id="gtco-footer" role="contentinfo"
						style="background-image: url(images/img_bg_1.jpg)"
						data-stellar-background-ratio="0.5">
						<div class="overlay"></div>
						<div class="gtco-container">
							<div class="row row-pb-md">




								<div class="col-md-12 text-center">
									<div class="gtco-widget">
										<h3>Get Social</h3>
										<ul class="gtco-social-icons">
											<li><a href="#"><i class="icon-twitter"></i></a></li>
											<li><a href="#"><i class="icon-facebook"></i></a></li>
											<li><a href="#"><i class="icon-linkedin"></i></a></li>
											<li><a href="#"><i class="icon-dribbble"></i></a></li>
										</ul>
									</div>
								</div>

							</div>



						</div>
					</footer>
					<!-- </div> -->

				</div>

				<div class="gototop js-top">
					<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
				</div>

				<!-- jQuery -->
				<script src="js/jquery.min.js"></script>
				<!-- jQuery Easing -->
				<script src="js/jquery.easing.1.3.js"></script>
				<!-- Bootstrap -->
				<script src="js/bootstrap.min.js"></script>
				<!-- Waypoints -->
				<script src="js/jquery.waypoints.min.js"></script>
				<!-- Carousel -->
				<script src="js/owl.carousel.min.js"></script>
				<!-- countTo -->
				<script src="js/jquery.countTo.js"></script>

				<!-- Stellar Parallax -->
				<script src="js/jquery.stellar.min.js"></script>

				<!-- Magnific Popup -->
				<script src="js/jquery.magnific-popup.min.js"></script>
				<script src="js/magnific-popup-options.js"></script>

				<script src="js/moment.min.js"></script>
				<script src="js/bootstrap-datetimepicker.min.js"></script>


				<!-- Main -->
				<script src="js/main.js"></script>
</body>
</html>