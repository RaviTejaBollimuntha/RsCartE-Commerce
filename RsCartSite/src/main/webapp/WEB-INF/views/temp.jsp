<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Cart Details | RsCart</title>
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
	<!--/header-->
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel" >
						<ol class="carousel-indicators">
							<li data-target="slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="slider-carousel" data-slide-to="1"></li>
							<li data-target="slider-carousel" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>RS</span>-Cart</h1>
									<h2>Best Online Shopping</h2>
									<p>Electronic commerce or ecommerce is a term for any type of business, or commercial transaction, 
									that involves the transfer of information across the Internet. ... 
									It is currently one of the most important aspects of the Internet to emerge. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="resources/images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="resources/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>RS</span>-Cart</h1>
									<h2>100% Responsive Design</h2>
									<p>Electronic commerce or ecommerce is a term for any type of business, or commercial transaction, 
									that involves the transfer of information across the Internet. ... 
									It is currently one of the most important aspects of the Internet to emerge. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="resources/images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="resources/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>RS</span>-Cart</h1>
									<h2>Best Online Shopping</h2>
									<p>Electronic commerce or ecommerce is a term for any type of business, or commercial transaction, 
									that involves the transfer of information across the Internet. ... 
									It is currently one of the most important aspects of the Internet to emerge. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="resources/images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="resources/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>							
						</div>					
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
				
				
				</div>
			</div>
		</div>
	</section>

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
	<!--/Footer-->

	<script src="resources/js/jquery-1.8.0.js"></script>
	<script src="resources/js/price-range.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>
	
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>
