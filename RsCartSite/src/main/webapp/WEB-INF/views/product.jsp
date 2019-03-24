<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Product Details | RsCart</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<body>
	<header> 
		<%@include file="template/header.jsp"%>
		</header>
	<!--/header-->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="resources/images/home/${product.productId}.jpg" alt="" />
							</div>
							<div id="similar-product" class="carousel slide"
								data-ride="carousel">
								<!-- Wrapper for slides -->
								<div class="carousel-inner">
									<div class="item active">
										<a href=""><img
											src="resources/images/product-details/product1.jpg" width="80px" height="300px" alt=""></a>
										<a href=""><img
											src="resources/images/product-details/product2.jpg" width="80px" height="300px" alt=""></a>
										<a href=""><img
											src="resources/images/product-details/product3.jpg" width="80px" height="300px" alt=""></a>
											<a href=""><img
											src="resources/images/product-details/product4.jpg" width="80px" height="300px" alt=""></a>
									</div>
									<div class="item">
										<a href=""><img
											src="resources/images/product-details/product5.jpg" width="80px" height="300px" alt=""></a>
										<a href=""><img
											src="resources/images/product-details/product6.jpg" width="80px" height="300px" alt=""></a>
										<a href=""><img
											src="resources/images/product-details/product7.jpg" width="80px" height="300px" alt=""></a>
											<a href=""><img
											src="resources/images/product-details/product8.jpg" width="80px" height="300px" alt=""></a>
									</div>

								</div>

								<!-- Controls -->
								<a class="left item-control" href="#similar-product"
									data-slide="prev"> <i class="fa fa-angle-left"></i>
								</a> <a class="right item-control" href="#similar-product"
									data-slide="next"> <i class="fa fa-angle-right"></i>
								</a>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information">
								<!--/product-information-->
								<img src="resources/images/product-details/new.jpg"
									class="newarrival" alt="" />
								<c:set var="product" value="${product}" />
								<c:url var="add" value="/addProduct">
									<c:param name="productId" value="${product.productId}" />
								</c:url>
								<c:url var="addToWishlist" value="/addToWishlist">
									<c:param name="productId" value="${product.productId}" />
								</c:url>
								<div class="product-title">
									<h2>
										<c:out value="${product.name}" />
									</h2>
								</div>
								<span> <span class="product-price"> <c:out
											value="Rs.${product.price}" />
								</span> <a href="${add}" role="button" class="btn btn-default cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
								</a> <a href="${addToWishlist}" role="button"
									class="btn btn-default cart"> <i class="fa fa-star"></i>
										Add to Wishlist
								</a>
								</span>
								<p>
									<b>Availability:</b> <blink style="color: green;"> In Stock</blink> ${product.available} Left Only
								</p>
								<p>
									<b>Brand:</b>
									<c:out value="${product.manufacturer}" />
								</p>
								<a href=""><img
									src="resources/images/product-details/share.png"
									class="share img-responsive" alt="" /></a>
							</div>
							<!--/product-information-->
						</div>
					</div>
					<!--/product-details-->
					<c:choose>
						<c:when test="${not empty customer}">
							<div class="category-tab shop-details-tab">
								<div class="col-sm-12">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#reviews" data-toggle="tab">Reviews(<c:out
													value="${fn:length(reviewsList)}" />)
										</a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade active in" id="reviews">
										<div class="col-sm-12">
											<div>
												<c:forEach var="reviewMap" items="${reviewsList}">
													<c:set var="customer" value="${reviewMap.key}" />
													<c:set var="review" value="${reviewMap.value}" />
													<ul>
														<li><a href="account"><i class="fa fa-user"></i>
																<c:out value="${customer.userName}" /></a></li>
														<li><a href=""><i class="fa fa-calendar-o"></i> <c:out
																	value="${review.date}" /></a></li>
													</ul>
													<strong> <c:out value="${review.reviewTitle}" />
													</strong>
													<p>
														<c:out value="${review.reviewText}" />
													</p>
												</c:forEach>
											</div>
											<p>
												<b>Write Your Review</b>
											</p>

											<form method="POST" action="reviews">
												<input type="hidden" name="productId"
													value="${product.productId}" /> <span> <input
													type="text" name="reviewTitle" placeholder="Review Title" />
													<input type="email" placeholder="Email Address" />
												</span>

												<textarea name="reviewText"></textarea>
												<b>Rating: </b> <select name="rating">
													<option value="Excellent">Excellent</option>
													<option value="Very Good">Very Good</option>
													<option value="Good">Good</option>
													<option value="Not Bad">Not Bad</option>
													<option value="Bad">Bad</option>
												</select>
												<button type="submit" class="btn btn-default pull-right">
													Submit</button>
											</form>
										</div>
									</div>

								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="category-tab shop-details-tab">
								<div class="col-sm-12">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#reviews" data-toggle="tab">Reviews</a></li>
									</ul>
								</div>
								<div class="tab-content">
									<a href="login">Log In to Create a Review</a>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<!--/category-tab-->

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
