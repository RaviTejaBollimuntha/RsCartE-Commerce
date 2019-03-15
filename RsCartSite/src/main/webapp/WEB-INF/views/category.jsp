<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Category| RsCart</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">


</head>

<body>
<header id="header">
		<%@include file="template/header.jsp"%>
	</header>
<section>
		<div class="container">
			<div class="row">
				<div class="padding-right">
					<div class="features_items">
						<c:choose>
							<c:when test="${empty subCatProds}">
								<c:forEach var="catProds" items="${catProds}">
									<c:url var="url" value="product">
										<c:param name="productId" value="${catProds.productId}" />
									</c:url>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resources/images/home/${catProds.productId}.jpg"
														alt="" /> <a href="${url}">
														<h2>
															<c:out value="${catProds.name}" />
														</h2>
													</a>
													<p>
														Rs.
														<c:out value="${catProds.price}" />
													</p>
													<c:url var="add" value="/addProduct">
														<c:param name="productId" value="${catProds.productId}" />
													</c:url>
													<a href="${url}" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												<div class="product-overlay">
													<div class="overlay-content">
														<a href="${url}">
															<h2>
																<c:out value="${catProds.name}" />
															</h2>
														</a>
														<p>
															Rs.
															<c:out value="${catProds.price}" />
														</p>
														<c:url var="add" value="/addProduct">
															<c:param name="productId" value="${catProds.productId}" />
														</c:url>
														<a href="${url}" class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
											</div>
											<div class="choose">
												<ul class="nav nav-pills nav-justified">
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to wishlist</a></li>
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to compare</a></li>
												</ul>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:if test="${not empty subCatProds}"></c:if>
								<c:forEach var="subCatProds" items="${subCatProds}">
									<c:url var="url" value="product">
										<c:param name="productId" value="${subCatProds.productId}" />
									</c:url>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img
														src="resources/images/home/${subCatProds.productId}.jpg"
														alt="" /> <a href="${url}">
														<h2>
															<c:out value="${subCatProds.name}" />
														</h2>
													</a>
													<p>
														Rs.
														<c:out value="${subCatProds.price}" />
													</p>
													<c:url var="add" value="/addProduct">
														<c:param name="productId" value="${subCatProds.productId}" />
													</c:url>
													<a href="${url}" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												<div class="product-overlay">
													<div class="overlay-content">
														<a href="${url}">
															<h2>
																<c:out value="${subCatProds.name}" />
															</h2>
														</a>
														<p>
															Rs.
															<c:out value="${subCatProds.price}" />
														</p>
														<c:url var="add" value="/addProduct">
															<c:param name="productId"
																value="${subCatProds.productId}" />
														</c:url>
														<a href="${url}" class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
											</div>
											<div class="choose">
												<ul class="nav nav-pills nav-justified">
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to wishlist</a></li>
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to compare</a></li>
												</ul>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
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
<script>
	$(document).ready(function() {
		$('#list').click(function(event) {
			event.preventDefault();
			$('#products .item').addClass('list-group-item');
		});
		$('#grid').click(function(event) {
			event.preventDefault();
			$('#products .item').removeClass('list-group-item');
			$('#products .item').addClass('grid-group-item');
		});
	});
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

