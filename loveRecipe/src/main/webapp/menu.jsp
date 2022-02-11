<<<<<<< HEAD
=======
<%@page import="model.MemberVO"%>
<%@page import="model.DAO"%>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
<<<<<<< HEAD
      rel="stylesheet">
=======
	rel="stylesheet">
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git

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
<<<<<<< HEAD
									<li><a href="mealplan.jsp">식단짜기</a></li>
									<li><a href="newrecipe.jsp">레시피등록</a></li>
								</ul></li>
							<li><a href="feedback.jsp">feedback</a></li>
							<li class="btn-cta"><a href="main.jsp"><span>login</span></a></li>
=======
									<li><a href="newrecipe.jsp">레시피등록</a></li>
								</ul></li>
							<li><a href="feedback.jsp">feedback</a></li>
							<%
								if (info != null) {
							%>
							<li class="btn-cta"><a href="LogoutService"><span>logout</span></a></li>
							<%
								} else {
							%>
							<li class="btn-cta"><a href="main.jsp"><span>login</span></a></li>
							<%
								}
							%>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
						</ul>
					</div>
				</div>

<<<<<<< HEAD
=======
			</div>
		</nav>

		<header id="gtco-header" class="gtco-cover gtco-cover-md"
			role="banner" style="background-image: url(images/main.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-left">


						<div class="row row-mt-15em">
							<div class="col-md-7 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<h1>find your recipe</h1>
							</div>
							<div class="col-md-5 col-md-push-1 animate-box"
								data-animate-effect="fadeInRight">
								<div class="form-wrap">
									<div class="tab">

										<div class="tab-content">
											<div class="tab-content-inner active" data-content="signup">
												<h3 class="cursive-font">search</h3>
												<form action="menuservice">



													<div class="row form-group">
														<label>나라별레시피</label><br> <label><input
															type="radio" name="contry" value="한식">한식</label> <label><input
															type="radio" name="contry" value="양식">양식</label> <label><input
															type="radio" name="contry" value="중식">중식</label> <label><input
															type="radio" name="contry" value="일식">일식</label> <label><input
															type="radio" name="contry" value="동남아">동남아</label> <label><input
															type="radio" name="contry" value="이탈리아">이탈리아</label> <label><input
															type="radio" name="contry" value="멕시코">멕시코</label> <label><input
															type="radio" name="contry" value="퓨전">퓨전</label> <label><input
															type="radio" name="contry" value="날씨">날씨</label>
													</div>

													<div class="row form-group">
														<label>종류별레시피</label><br> <label><input
															type="radio" name="type" value="구이">구이</label> <label><input
															type="radio" name="type" value="국">국</label> <label><input
															type="radio" name="type" value="그라탕,리조또">그라탕/리조또</label>
														<label><input type="radio" name="type"
															value="나물,생채,샐러드">나물/생채/샐러드</label> <label><input
															type="radio" name="type" value="떡,한과">떡,한과</label> <label><input
															type="radio" name="type" value="도시락,간식">도시락/간식</label> <label><input
															type="radio" name="type" value="만두,면류">만두/면류</label> <label><input
															type="radio" name="type" value="밑반찬,김치">밑반찬/김치</label> <label><input
															type="radio" name="type" value="밥,죽,스프">밥/죽/스프</label> <label><input
															type="radio" name="type" value="볶음">볶음</label> <label><input
															type="radio" name="type" value="부침">부침</label> <label><input
															type="radio" name="type" value="빵,과자">빵/과자</label> <label><input
															type="radio" name="type" value="샌드위치,햄버거">샌드위치/햄버거</label>

														<label><input type="radio" name="type" value="양념장">양념장</label>
														<label><input type="radio" name="type" value="양식">양식</label>
														<label><input type="radio" name="type" value="음료">음료</label>

														<label><input type="radio" name="type" value="조림">조림</label>
														<label><input type="radio" name="type"
															value="찌개,전골,스튜">찌개/전골/스튜</label> <label><input
															type="radio" name="type" value="찜">찜</label> <label><input
															type="radio" name="type" value="피자">피자</label> <label><input
															type="radio" name="type" value="후식">후식</label> <label><input
															type="radio" name="type" value="튀김,커틀릿">튀김/커틀릿</label>
													</div>

													<div class="gtco-container">


														<div class="row form-group">

															<label>최대 칼로리 지정</label> <input type="number" name="kcal"
																class="form-control" placeholder="원하시는 칼로리의 최대값">
														</div>



														<div class="row form-group">
															<div class="col-md-12">
																<input type="submit" class="btn btn-primary btn-block"
																	value="search">

															</div>

														</div>
												</form>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
	</div>
	</header>




	<div class="gtco-cover gtco-cover-sm"
		style="background-image: url(images/img_bg_1.jpg)"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container text-center">
			<div class="display-t">
				<div class="display-tc">
					<h1 class="cursive-font">&ldquo;음식에 대한 사랑처럼 진실된 사랑은 없다.&rdquo;</h1>
					<p>&mdash; 조지 버나드 쇼</p>
				</div>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
			</div>
		</nav>

<<<<<<< HEAD
		<header id="gtco-header" class="gtco-cover gtco-cover-md"
			role="banner" style="background-image: url(images/main.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-left">
=======
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git


<<<<<<< HEAD
						<div class="row row-mt-15em">
							<div class="col-md-7 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<h1>find your recipe</h1>
							</div>
							<div class="col-md-5 col-md-push-1 animate-box"
								data-animate-effect="fadeInRight">
								<div class="form-wrap">
									<div class="tab">
=======


	<footer id="gtco-footer" role="contentinfo"
		style="background-image: url(images/img_bg_1.jpg)"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row row-pb-md">
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git

<<<<<<< HEAD
										<div class="tab-content">
											<div class="tab-content-inner active" data-content="signup">
												<h3 class="cursive-font">search</h3>
												<form action="menuservice">
=======
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git



<<<<<<< HEAD
													<div class="row form-group">
														<label>나라별레시피</label><br> <label><input
															type="radio" name="contry" value="한식">한식</label> <label><input
															type="radio" name="contry" value="양식">양식</label> <label><input
															type="radio" name="contry" value="중식">중식</label> <label><input
															type="radio" name="contry" value="일식">일식</label> <label><input
															type="radio" name="contry" value="동남아">동남아</label> <label><input
															type="radio" name="contry" value="이탈리아">이탈리아</label> <label><input
															type="radio" name="contry" value="멕시코">멕시코</label> <label><input
															type="radio" name="contry" value="퓨전">퓨전</label> <label><input
															type="radio" name="contry" value="날씨">날씨</label>
													</div>

													<div class="row form-group">
                                             <label>종류별레시피</label><br>
                                                <label><input type="radio" name="type" value="구이">구이</label>
                                             <label><input type="radio" name="type" value="국">국</label>
                                             <label><input type="radio" name="type" value="그라탕,리조또">그라탕/리조또</label>
                                             <label><input type="radio" name="type" value="나물,생채,샐러드">나물/생채/샐러드</label>
                                             <label><input type="radio" name="type" value="떡,한과">떡,한과</label>
                                             <label><input type="radio" name="type" value="도시락,간식">도시락/간식</label>
                                             <label><input type="radio" name="type" value="만두,면류">만두/면류</label>
                                             <label><input type="radio" name="type" value="밑반찬,김치">밑반찬/김치</label>
                                             
                                             <label><input type="radio" name="type" value="밥,죽,스프">밥/죽/스프</label>
                                             <label><input type="radio" name="type" value="볶음">볶음</label>
                                             <label><input type="radio" name="type" value="부침">부침</label>
                                             <label><input type="radio" name="type" value="빵,과자">빵/과자</label>
                                             <label><input type="radio" name="type" value="샌드위치,햄버거">샌드위치/햄버거</label>
                                             
                                             <label><input type="radio" name="type" value="양념장">양념장</label>
                                             <label><input type="radio" name="type" value="양식">양식</label>
                                             <label><input type="radio" name="type" value="음료">음료</label>
                                             
                                             <label><input type="radio" name="type" value="조림">조림</label>
                                             <label><input type="radio" name="type" value="찌개,전골,스튜">찌개/전골/스튜</label>
                                             <label><input type="radio" name="type" value="찜">찜</label>
                                             <label><input type="radio" name="type" value="피자">피자</label>
                                             <label><input type="radio" name="type" value="후식">후식</label>
                                             <label><input type="radio" name="type" value="튀김,커틀릿">튀김/커틀릿</label>
                                    </div>

<div class="gtco-container">


													<div class="row form-group">

														<label>최대 칼로리 지정</label> <input type="number" name="kcal"
															class="form-control" placeholder="원하시는 칼로리의 최대값">
													</div>



													<div class="row form-group">
														<div class="col-md-12">
															<input type="submit" class="btn btn-primary btn-block"
																value="search">

														</div>

													</div>


												</form>
											</div>
</div>

										</div>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</header>




		<div class="gtco-cover gtco-cover-sm"
			style="background-image: url(images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container text-center">
				<div class="display-t">
					<div class="display-tc">
						<h1 class="cursive-font">&ldquo;음식에 대한 사랑처럼 진실된 사랑은
							없다.&rdquo;</h1>
						<p>&mdash; 조지 버나드 쇼</p>
=======
				<div class="col-md-12 text-center">
					<div class="gtco-widget">
						<h3>Get Social</h3>
						<ul class="gtco-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
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


<<<<<<< HEAD
<div class="timer"></div>
<script src="js/timerMain.js" type="module"></script>
=======
	<div class="timer"></div>
	<script src="js/timerMain.js" type="module"></script>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git


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