<%@page import="model.viewrefVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// Object 타입으로 저장 --> 업캐스팅 되서 저장 됨
		// 꺼내서 사용할 때, 다운캐스팅
		viewrefVO vo = (viewrefVO)request.getAttribute("vo");
		
	%>
	
	<h1><%=vo.getCalory() %></h1>
	<h1><%=vo.getHref() %></h1>
	<h1><%=vo.getIngre() %></h1>
	<h1><%=vo.getRname() %></h1>
	<h1><%=vo.getSequence() %></h1>
	<h1><%=vo.getType() %></h1>				
</body>
</html>