<%@page import="model.ingrivo"%>
<%@page import="model.refivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberVO"%>
<%@page import="model.DAO"%>
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
	rel="stylesheet">


<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">


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
	ArrayList<refivo> refilist = null;
	ArrayList<ingrivo> ingrilist = null;

	if (info != null) {
		refilist = dao.selectrefi(info.getId());
	} else {
		refilist = null;
	}
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
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="gtco-header" class="gtco-cover gtco-cover-sm"
			role="banner" style="background-image: url(images/refrigerator2.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-center">


						<div class="row row-mt-15em">
							<div class="col-md-12 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<%
									if (info != null) {
								%>
								<h1><%=info.getNickname()%>님의 냉장고
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
			</div>
	</div>
	</header>
	<div id="gtco-features"
		style="background-image: url(images/refrigerator4.jpg)">
		<div class="gtco-container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<div id="ref1" style="background-color: #464E2E; color: white">
						<table border="1" width="800px" align="center">
							<caption>
								<h2 class="cursive-font">현재 보유 재료</h2>
							</caption>
							<tr style="font-size: 1.5em">
								<th>재료</th>
								<th>갯수</th>

								<th>재료타입</th>
								<th>유통기한</th>
								<th>제철</th>
								<th>칼로리</th>
								<th>현재장소</th>
								<th>권장장소</th>
							</tr>
							<%
								if (refilist != null && info != null) {
								for (int i = 0; i < refilist.size(); i++) {
									ingrilist = dao.selectingri(refilist.get(i).getIngre_name());
									String ingriname = refilist.get(i).getIngre_name();
							%>
							<tr>
								<td><%=refilist.get(i).getIngre_name()%></td>
								<td><%=refilist.get(i).getIngre_amount()%></td>
								<%
									if (ingrilist != null) {
								%>
								<td><%=ingrilist.get(0).getType()%></td>
								<td><%=dao.expire(ingrilist.get(0).getExpire())%></td>
								<td><%=ingrilist.get(0).getSeason()%></td>
								<td><%=ingrilist.get(0).getCarloy()%></td>
								<td><%=refilist.get(i).getIngre_temp()%></td>
								<td><%=ingrilist.get(0).getTempt()%></td>
								<%
									} else {
								}
								%>
								<td>
									<form action="deleteingri">
										<input type="hidden" name="ingri" value="<%=ingriname%>">
										<input type="hidden" name="id" value="<%=info.getId()%>">
										<button type="submit" style="color: black;">
											<span class="material-icons">delete_forever</span>
										</button>
									</form>
								</td>
							</tr>
							<%
								}
							}
							%>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div id="gtco-subscribe" style="background-image: url(images/ice.jpg)">
		<div class="gtco-container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-right gtco-heading">
					<h2 class="cursive-font" style="color: #055052;">냉동실</h2>
					<fieldset>
						<form action="#">
							<input type="text" name="ingre1" placeholder="재료명을 입력하세요."><br>
							<input type="number" name="number1" placeholder="갯수를 입력하세요."><br>
							<input type="button" value="등록" onClick="low_save();" class="btn">
						</form>
					</fieldset>
					<div id="ref1" style="background-color: green; color: white">
						<table>
							<thead>
								<tr>
									<td>재료</td>
									<td>갯수</td>
								</tr>
							</thead>

							<tbody id="low">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="gtco-subscribe"
		style="background-image: url(images/fruit.jpg)">
		<div class="gtco-container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-right gtco-heading">
					<h2 class="cursive-font">냉장실</h2>
					<fieldset>
						<form action="#">
							<input type="text" name="ingre2" placeholder="재료명을 입력하세요."><br>
							<input type="number" name="number2" placeholder="갯수를 입력하세요."><br>
							<input type="button" value="등록" onClick="mid_save()" class="btn">
						</form>
					</fieldset>
					<div id="ref2" style="background-color: red; color: white">
						<table>
							<thead>
								<tr>
									<td>재료</td>
									<td>갯수</td>
								</tr>
							</thead>

							<tbody id="mid">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="gtco-subscribe"
		style="background-image: url(images/onion.jpg)">
		<div class="gtco-container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-right gtco-heading">
					<h2 class="cursive-font" style="color: #865439">상온</h2>
					<fieldset>
						<form action="#">
							<input type="text" name="ingre3" placeholder="재료명을 입력하세요."><br>
							<input type="number" name="number3" placeholder="갯수를 입력하세요."><br>
							<input type="button" value="등록" onClick="high_save()" class="btn">
						</form>
					</fieldset>
					<div id="ref3" style="background-color: #865439; color: white">
						<table>
							<thead>
								<tr>
									<td>재료</td>
									<td>갯수</td>
								</tr>
							</thead>

							<tbody id="high">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
   
   function low_save() {
      // input태그 값 가져오기
      var ingre1 = $('input[name=ingre1]').val();
      var number1 = $('input[name=number1]').val();
      // ajax 
      // 비동기 통신
      
      $.ajax({
         url : 'refService', // 값을 보낼 주소
         type : 'POST', // get or post
         data : { // 전달하고자하는 데이터
            ingre1 : ingre1, //  javascript 객체 형태로  name : value
            number1 : number1
         },
         //dataType : 'json', // json 데이터로 응답받을 때,
         success : function(res){ // 통신이 성공했을 때 실행되는 함수
            // res --> Server에서 응답해준 데이터가 매개변수에 자동으로 담김
            low_print(ingre1, number1);

         },
         error : function(){ // 통신이 실패한경우에 실행되는 함수 
            alert("error");
         }
      });
      
   }
   
   function low_print(ingre1, number1){
      // div에 추가
      // jqury 에서 html 하는 코드
      // $('선택자').html('문자열'); --> 덮어쓰기 내용물을 싹 지워버리고 '문자열'교체
      // $('선택자').after(); --> 선택자 바로 앞에
      // $('선택자').before(); --> 바로뒤
      // $('선택자').append(); --> 선택자 안에 요소 추가 
      tr = `
         <tr> 
            <td><a href="detail?ingre1=`+ ingre1 +`&number1=`+ number1+`">` + ingre1 +`</a></td>
            <td>` + number1 + `</td>
         </tr>
      `;
      
      
      $('tbody[id=low]').append(tr);
      
   }
   function mid_save() {
      // input태그 값 가져오기
      var ingre2 = $('input[name=ingre2]').val()
      var number2 = $('input[name=number2]').val()

      // ajax 
      // 비동기 통신
      
      $.ajax({
         url : 'refService', 
         type : 'post', 
         data : {
            'ingre2' : ingre2,
            'number2' : number2
         },
         success : function(res){ 
            mid_print(ingre2, number2);

         },
         error : function(){ 
            alert("error");
         }
      });
      
   }
   function mid_print(ingre2, number2){
      tr = `
         <tr> 
            <td><a href="detail?ingre2=`+ ingre2 +`&number2=`+ number2+`">` + ingre2 +`</a></td>
            <td>` + number2 + `</td>
         </tr>
      `;
      
      
      $('tbody[id=mid]').append(tr);
      
   }
   function high_save() {
      // input태그 값 가져오기
      var ingre3 = $('input[name=ingre3]').val()
      var number3 = $('input[name=number3]').val()

      // ajax 
      // 비동기 통신
      
      $.ajax({
         url : 'refService', 
         type : 'post', 
         data : { 
            'ingre3' : ingre3,
            'number3' : number3
         },
         success : function(res){ 
            high_print(ingre3, number3);
         },
         error : function(){ 
            alert("error");
         }
      });
      
   }

   function high_print(ingre3, number3){

      tr = `
         <tr> 
            <td><a href="detail?ingre3=`+ ingre3 +`&number3=`+ number3+`">` + ingre3 +`</a></td>
            <td>` + number3 + `</td>
         </tr>
      `;
      
      
      $('tbody[id=high]').append(tr);
      
   }
   </script>

	<!-- </div> -->

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
