<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Oops!!</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
</head>
<!--/head-->

<body>
     <header id="header">
		<%@include file="template/header.jsp"%>
	</header>
	<div class="container text-center">
		<div class="logo-404">
			<img src="resources/images/404/404.png" class="img-responsive" />
		</div>
		<div class="content-404">
			<h3>Ops! We are currently experiencing some technical issues.
			 Please try again later.</h3>
			  ${message}
		</div>
	</div>
	<div class="container text-center">
		<div class="logo-404">
			<h2>
			   <a href="home">Bring me back Home</a>
			</h2>
		</div>
	</div>
	<footer id="footer">
		<!--Footer-->
		<div class="footer-bottom" style="background:#FFBB00">
			<div class="container">
				<div class="row">
					<%@include file="template/footer.jsp" %>
                    
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
