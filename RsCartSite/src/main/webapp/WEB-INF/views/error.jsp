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
		<div class="content-404">
			<img src="resources/images/404.png" class="img-responsive" />
			<h3>
			<b>OPPS!</b> 
			</h3><br>
			<h5>
				Sorry! We are experiencing technical difficulties with our shopping cart right now.
				We apologize for the inconvenience, but we are experiencing technical difficulties with our shopping cart. 
				Purchases (including membership and registrations) cannot be made at this time.
				We are working hard to try and resolve the issue as soon as possible. 
				Thank you for your understanding.		 	
			</h5>
			${message} 
		</div>
	</div>
	<div id="contact-page" class="container">
		<div class="bg">
			<div class="row">
				<div class="col-sm-12">
					<h2 class="title text-center">
						Contact <strong>Us</strong>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<div class="contact-form">
						<h2 class="title text-center">Get In Touch</h2>
						<div class="status alert alert-success" style="display: none"></div>
						<form id="main-contact-form" class="contact-form row"
							name="contact-form" method="post">
							<div class="form-group col-md-6">
								<input type="text" name="name" class="form-control"
									required="required" placeholder="Name">
							</div>
							<div class="form-group col-md-6">
								<input type="email" name="email" class="form-control"
									required="required" placeholder="Email">
							</div>
							<div class="form-group col-md-12">
								<input type="text" name="subject" class="form-control"
									required="required" placeholder="Subject">
							</div>
							<div class="form-group col-md-12">
								<textarea name="message" id="message" required="required"
									class="form-control" rows="8" placeholder="Your Message Here"></textarea>
							</div>
							<div class="form-group col-md-12">
								<input class="form-control" type="submit" name="submit" value="Submit">
							</div>
						</form>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="contact-info">
						<h2 class="title text-center">Contact Info</h2>
						<address>
							<p>RS Cart Inc.</p>
							<p>935 W. Webster Ave New Streets Chicago, IL 60614, NY</p>
							<p>Newyork USA</p>
							<p>Mobile: +2346 17 38 93</p>
							<p>Fax: 1-714-252-0026</p>
							<p>Email:rscartsite@gmail.com</p>
						</address>
						<div class="social-networks">
							<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-youtube"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="container text-center">
		<div class="content-404">
			<h3>
				<a href="home">Bring me back Home</a>
			</h3>
		</div>
	</div>
</body>
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
</html>
