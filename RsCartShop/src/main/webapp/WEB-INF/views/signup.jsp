<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SignUp Details</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<style type="text/css">
.prettyline {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
	background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
}

#rememberme-0 {
	padding: 5px;
}
</style>
</head>
<body>
<header> 
		<%@include file="template/header.jsp"%>
		</header>
	<!--/header-->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
			<hr class="prettyline">
		<br>
		<div style="text-align: center">
		<div class="container">               
				<div id="signupbox" style="margin-top: 50px"
							class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<div class="panel panel-info">
								<div class="panel-heading">
									<div class="panel-title">User Registration</div>
									<div
										style="float: right; font-size: 100%; position: relative; top: -10px">
										<a id="signinlink" href="login">Sign
											In</a>
									</div>
								</div>
								<div class="panel-body">
									<form:form id="signupform" commandName="customerForm" cclass="form-horizontal"
										role="form" method="post">
										<div id="signupalert">
											<p style='color:red'>
                                              <form:errors path="*"/>
                                             </p>                                            											
										</div>
										<div class="form-group">
											<label for="email" class="col-md-3 control-label">First
												Name</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="firstName"
													placeholder="First Name">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-md-3 control-label">Last
												Name</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="lastName"
													placeholder="Last Name">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-md-3 control-label">User
												Name</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="userName"
													placeholder="User Name">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-md-3 control-label">Email</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="emailAddress"
													placeholder="Email Address">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-md-3 control-label">Password</label>
											<div class="col-md-9">
												<input type="password" class="form-control" name="password"
													placeholder="Password">
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-md-3 control-label">
												Re-Password</label>
											<div class="col-md-9">
												<input type="password" class="form-control"
													name="confirmPassword" placeholder="Confirm Password">
											</div>
										</div>										
										<div class="form-group">
											<label for="password" class="col-md-3 control-label">Mobile
												Number</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="phoneNumber"
													placeholder="PhoneNumber">
											</div>
										</div>

										<div class="form-group">
											<!-- Button -->
											<div class="col-md-offset-3 col-md-9">
												<button id="btn-signup" type="submit" class="btn btn-info">
													<i class="icon-hand-right"></i> Sign Up
												</button>
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>		
			</div>
		</div>
		<br>
		<hr class="prettyline">
				</div>
				</div>
			</div>
	</section>

	<footer id="footer">
		<!--Footer-->
		<div class="footer-bottom" style="background:#F1F2F3">
			<div class="container">
				<div class="row">
					<%@include file="template/footer.jsp" %>
                    
				</div>
			</div>
		</div>
	</footer>
	<!--/Footer-->

	<script src="resources/js/jquery-1.8.0.js"></script>
	<script src="resources/js/price-range.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>
	
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/main.js"></script>
</body>

</html>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/jquery-1.8.0.js"></script>
<script>
	$(document).ready(
			function() {
				$(".dropdown").hover(
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideDown("fast");
							$(this).toggleClass('open');
						},
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideUp("fast");
							$(this).toggleClass('open');
						});
			});
</script>