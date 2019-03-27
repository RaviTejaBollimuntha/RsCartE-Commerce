<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Pwd Rest</title>
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
												<div class="panel-title">Password Rest Request</div>
											</div>
											<div class="panel-body">
												<form:form id="account-password-forgot"
													class="form-horizontal" role="form" method="post" commandName="pwdreset">
													<div id="signupalert">
														<p style='color:red'>
                                            			  <form:errors path="*"/>
                                             			</p>                                            											
													</div>
													<form:hidden path="customerid" />
													<div style="margin-bottom: 25px" class="input-group">
														<span class="input-group-addon"><i
															class="glyphicon glyphicon-lock"></i></span> <input
															id="newPassword" type="password" class="form-control"
															name="newPassword" placeholder="New password">
													</div>
													<div style="margin-bottom: 25px" class="input-group">
														<span class="input-group-addon"><i
															class="glyphicon glyphicon-lock"></i></span> <input
															id="newPasswordConfirm" type="password" class="form-control"
															name="newPasswordConfirm" placeholder="Re-New password">
													</div>
													<div style="margin-top: 10px" class="form-group">
														<div class="loginStatus"></div>
														<div class="col-sm-12 controls">
															<button id="btn-login" type="submit"
																class="btn btn-success">Request</button>
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
		<div class="footer-bottom" style="background: #FFBB00">
			<div class="container">
				<div class="row">
					<%@include file="template/footer.jsp"%>

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
