<%@page import="model.DAO"%>
<%@page import="model.MemberVO"%>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
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

		int foodType = dao.foodType();
		int memberCount = dao.memberCount();
		int recipeCount = dao.recipeCount();
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
									<li><a href="newrecipe.jsp">레시피등록</a></li>
								</ul></li> 
							<li><a href="feedback.jsp">feedback</a></li>
							<%
									if (info != null){ }else {
								%>
							<li class="btn-cta"><a href="main.jsp"><span>login</span></a></li>
							<% }  %>
						</ul>
					</div>
				</div>

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
									님 환영합니다
								</h1>
								<%
									} else {
								%>
								<h1></h1>
								<%
									}
								%>
							</div>
							<div class="col-md-4 col-md-push-1 animate-box"
								data-animate-effect="fadeInRight">
								<div class="form-wrap">
									<div class="tab">

										<div class="tab-content">
											<div class="tab-content-inner active" data-content="signup">
												<h3 class="cursive-font">login</h3>
												<form action="LoginService" method="POST">
													<div class="row form-group"></div>
													<div class="row form-group">
														<div class="col-md-12">
															<%
																if (info != null) {
															%>
															<%
																} else {
															%>
															<label>id</label> <input type="text" name="id"
																class="form-control">
															<%
																}
															%>
														</div>
													</div>


													<div class="row form-group">
														<div class="col-md-12">
															<%
																if (info != null) {
															%>
															<%
																} else {
															%>
															<label>pw</label> <input type="password" name="pw"
																class="form-control">
															<%
																}
															%>
														</div>
													</div>

													<div class="row form-group">
														<div class="col-md-12">


															<%
																if (info != null) {
															%>

															<%
																if (info.getId().equals("admin")) {
															%>

															<a href="veiwmember.jsp">회원 정보 관리</a>
															<%
																}
															%>
															<a href="LogoutService">로그아웃</a> <a href="updateuser.jsp">회원정보변경</a>

															<%
																} else {
															%>
															<input type="submit" class="btn btn-primary btn-block"
																value="login"> <a href="new.jsp">회원가입</a>
															<%
																}
															%>

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
		</header>

			
		</div>

		<div id="gtco-features" style="background-color: #FBB448;">
			<div class="gtco-container">
				<div class="row">
					<div
						class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
						<h2 class="cursive-font">Our Services</h2>
						<p>사용자들의 행복은 언제나 개발자의 행복</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-sm-6">
						<div class="feature-center animate-box"
							data-animate-effect="fadeIn">
							<span class="icon"> <i class="ti-face-smile"></i>
							</span>
							<h3>Happy</h3>
							<p>요리하는 즐거움</p>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center animate-box"
							data-animate-effect="fadeIn">
							<span class="icon"> <i class="ti-thought"></i>
							</span>
							<h3>Creative</h3>
							<p>창의적인 레시피</p>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center animate-box"
							data-animate-effect="fadeIn">
							<span class="icon"> <i class="ti-check"></i>
							</span>
							<h3>check</h3>
							<p>냉장고 관리</p>
						</div>
					</div>
					
				</div>

			</div>
		</div>



		<script type="text/javascript">
			document.oncontextmenu = function() {
				alert("마우스의 우클릭은 사용할 수 없습니다.")
				return false;
			}
		</script>


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
					</div>
				</div>
			</div>
		</div>

		<div id="gtco-counter" class="gtco-section">
			<div class="gtco-container">

				<div class="row">
					<div
						class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
						<h2 class="cursive-font primary-color">그거 아세요?</h2>
						<p>식사법이 잘못되었다면 약이 소용없고, 식사법이 옳다면 약이 필요없다.</p>
					</div>
				</div>

				<div class="row">

					<div class="col-md-3 col-sm-6 animate-box"
						data-animate-effect="fadeInUp">
						<div class="feature-center">
							<span class="counter js-counter" data-from="0" data-to="5"
								data-speed="3000" data-refresh-interval="50">1</span> <span
								class="counter-label">평균 평점</span>

						</div>
					</div>
					<div class="col-md-3 col-sm-6 animate-box"
						data-animate-effect="fadeInUp">
						<div class="feature-center">
							<span class="counter js-counter" data-from="0"
								data-to="<%=foodType %>" data-speed="3000"
								data-refresh-interval="50">1</span> <span class="counter-label">조리
								방법</span>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 animate-box"
						data-animate-effect="fadeInUp">
						<div class="feature-center">
							<span class="counter js-counter" data-from="0"
								data-to="<%=memberCount %>" data-speed="3000"
								data-refresh-interval="50">1</span> <span class="counter-label">총
								회원수</span>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 animate-box"
						data-animate-effect="fadeInUp">
						<div class="feature-center">
							<span class="counter js-counter" data-from="0"
								data-to="<%=recipeCount %>" data-speed="3000"
								data-refresh-interval="50">1</span> <span class="counter-label">레시피
								수</span>

						</div>
					</div>

				</div>
			</div>
		</div>





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

			<div class="gototop js-top">
				<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
			</div>

			<div class="timer"></div>
			<script src="js/timerMain.js" type="module"></script>

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