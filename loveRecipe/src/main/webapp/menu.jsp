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
	<title>레시피를 부탁해 &mdash; Free Website Template, Free HTML5 Template by GetTemplates.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by GetTemplates.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="GetTemplates.co" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	
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
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<!-- <div class="page-inner"> -->
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="main.jsp">레시피를 부탁해! <em>.</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="menu.jsp">Menu</a></li>
						<li class="has-dropdown">
							<a href="services.jsp">Services</a>
							<ul class="dropdown">
								<li><a href="refigator.jsp">나만의 냉장고</a></li>
								<li><a href="mealplan.jsp">식단짜기</a></li>
								<li><a href="newrecipe.jsp">레시피등록</a></li>
							</ul>
						</li>
						<li><a href="feedback.jsp">feedback</a></li>
						<li class="btn-cta"><a href="main.jsp"><span>login</span></a></li>
					</ul>	
				</div>
			</div>
			
		</div>
	</nav>
	
	<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<h1 > find your recipe </h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<h3 class="cursive-font">
												search</h3>
											<form action="#">
											
												<div class="row form-group">
															<label>주재료별</label><br>
					    						     		돼지고기<input type="radio" name="ingrident"   value="fork">
															소고기<input type="radio" name="ingrident"   value="beaf">
															닭고기<input type="radio" name="ingrident"   value="chiken">
															생선 <input type="radio" name="ingrident"   value="fish">
															면 <input type="radio" name="ingrident"  value="noodle">
															과일 <input type="radio" name="ingrident"   value="apple">
															쌀 <input type="radio" name="ingrident"  value="rice">
															오리고기<input type="radio" name="ingrident"   value="duck"> 
												</div>
												
												<div class="row form-group">
															<label>나라별레시피</label><br>
					    						     		한식<input type="radio" name="object"   value="korea">
															중식<input type="radio" name="object"   value="china">
															일식<input type="radio" name="object"   value="japan">
															양식 <input type="radio" name="object"   value="euro">
															동남아 <input type="radio" name="object"  value="phlipean">
															이탈리아 <input type="radio" name="object"   value="italy">
															멕시코 <input type="radio" name="object"  value="mexico">
															퓨전<input type="radio" name="object"   value="fuzen"> 
												</div>
												<div class="row form-group">
															<label>종류별레시피</label><br>
					    						     		구이<input type="radio" name="type"   value="guie">
															국<input type="radio" name="type"   value="guk">
															그라탕/리조또<input type="radio" name="type"   value="grtang">
															나물/생채/샐러드 <input type="radio" name="type"   value="namul">
															떡/한과 <input type="radio" name="type"  value="ttuk">
															도시락/간식 <input type="radio" name="type"   value="dosilack">
															만두/면류 <input type="radio" name="type"  value="mundu">
															밑반찬/김치<input type="radio" name="type"   value="kimchi"> 
															
															밥/죽/스프 <input type="radio" name="type"  value="bap">
															볶음 <input type="radio" name="type"   value="bokum">
															부침 <input type="radio" name="type"  value="buchim">
															빵/과자<input type="radio" name="type"   value="bbang"> 
															샌드위치/햄버거 <input type="radio" name="type"  value="sandwich">
															
															양념장 <input type="radio" name="type"   value="yangnum">
															양식 <input type="radio" name="type"  value="yangsik">
															음료<input type="radio" name="type"   value="umryo"> 
															
															조림 <input type="radio" name="type"   value="jorim">
															찌개/전골/스튜 <input type="radio" name="type"  value="zzikae">
															찜<input type="radio" name="type"   value="zzim"> 
															피자 <input type="radio" name="type"  value="pizza">
															후식<input type="radio" name="type"   value="husik"> 
															튀김/커틀릿<input type="radio" name="type"   value="tikim"> 
												</div>

												<div class="row form-group">
													
														<label>제철구분유무</label>
														<label>(가져오는 레시피의 재료의 제철유무를 판단)</label>
														<select class="form-control" name="seasonal">
														<option value="o">o</option>
														<option value="x">x</option>
														</select>
														<label>날씨구분유무</label><br>
														<label>(오늘날씨와 관련된 레시피) </label>
														<select class="form-control" name="weather">
														<option value="o">o</option>
														<option value="x">x</option>
														</select>
													
												</div>
												<div class="row form-group">
													
														<label>최대 칼로리 지정</label>
														<input type="number" name="kcal" class="form-control" placeholder="원하시는 칼로리의 최대값">
														</div>
									
												 

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary btn-block" value="search">
														
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
	</header>

	
	

	<div class="gtco-cover gtco-cover-sm" style="background-image: url(images/img_bg_1.jpg)"  data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container text-center">
			<div class="display-t">
				<div class="display-tc">
					<h1>&ldquo; 음식에 대한 사랑처럼 진실된 사랑은 없다.&rdquo;</h1>
					<p>&mdash; - 조지 버나드 쇼-</p>
				</div>	
			</div>
		</div>
	</div>

	
	

	<div id="gtco-subscribe">
		<div class="gtco-container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2 class="cursive-font">feedback</h2>
					<p>사이트를 쓰면서 불편햇던점을 보내주세요!</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-inline">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<label for="feedback" class="sr-only">feedback</label>
								<input type="feedback" class="form-control" id="feedback" placeholder="불편했던점을 보내주세요!">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<button type="submit" class="btn btn-default btn-block">send</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<footer id="gtco-footer" role="contentinfo" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
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

