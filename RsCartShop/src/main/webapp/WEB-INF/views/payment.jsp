<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Payment Details | RsCart</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">


</head>

<body>
	<header>
		<%@include file="template/header.jsp"%>
	</header>
	<section id="slider">
		<%@include file="slider.jsp"%>
	</section>
	<!--/slider-->
	<section id="do_action" style="margin-left:auto; ">
		<div class="container" ng-app="Homeapp" ng-controller="HomeController">
			<div class="row">
				<h2 align="center" id="addressTitle">Select a Payment Method</h2>

				<div class="col-sm-6">
					<div class="total_area">
                       <ul>
						<form:form name="paymentForm" action="${pageContext.request.contextPath}/createOrderByCC"
							method="POST">
									<h3 align="center">Payment Details</h3>
								<div class="form-group">
									<label for="cardNumber"> ACCOUNT NUMBER</label>
									<div class="input-group">
										<input type="text" class="form-control" id="AccountNumber"
											name="AccountNumber" placeholder="Valid Account Number"
											required autofocus /> 
									</div>
								</div>
								<div class="form-group">
									<label for="cardNumber"> CARD NUMBER</label>
									<div class="input-group">
										<input type="text" class="form-control" id="creditCardNumber"
											name="creditCardNumber" placeholder="Valid Card Number"
											required autofocus /> 
									</div>
								</div>
								<div class="form-group">
									<label for="cardNumber"> NAME ON CARD</label>
									<div class="input-group">
										<input type="text" class="form-control" id="name" name="name"
											placeholder="Name on Card" required autofocus />
									</div>
								</div>
								<div class="form-group">
									<label for="expityMonth"> EXPIRY DATE</label>
									<div class="input-group">
										<input type="text" class="form-control" id="expityMonth"
											name="month" placeholder="MM" required /> <input type="text"
											class="form-control" id="expityYear" name="year"
											placeholder="YY" required />
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<label for="cvCode"> CV CODE</label> <input type="password"
											class="form-control" id="cvCode" name="cvvCode"
											placeholder="CV" required />
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
								<label for="cvCode">Final Amount::</label> <span style="color: green;"><strong>Rs.<c:out
											value="${cart.grandtotal}" />
								</strong></span>
								<input type="hidden" id="amount" name="amount" value="${cart.grandtotal}"/>
									</div>
								</div>
								<div align="center">
									<input type="submit" class="btn btn-default update"
										value="Finish Payment" />
								</div>	
													
						</form:form>
						</ul>
					</div>
				</div>
			</div>


		</div>

	</section>
	
	<footer id="footer">
		<!--Footer-->
		<div class="footer-bottom" style="background:#F1F2F3">
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