<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<header id="header">
		<%@include file="template/header.jsp"%>
	</header>
	<!--/header-->
	<section id="slider">
		<%@include file="slider.jsp"%>
	</section>
	<!--/slider-->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${cart.numberOfItems== 0}">
									<tr>
										<c:url var="home" value="home" />
										<div style="text-align: center">
											<h4>Your Shopping Cart is Empty</h4>
											<a href="${home}" class="btn btn-info">Continue Shopping</a>
										</div>
									</tr>
								</c:when>
								<c:otherwise>
									<c:set var="productsList" value="${cart.orderItemsList}" />
									<c:forEach var="list" items="${productsList}">
										<tr>
											<td class="col-sm-8 col-md-6">
												<div class="media">
													<a class="thumbnail pull-left" href="#"> <img
														class="media-object"
														src="resources/images/${list.product.productId}.jpg"
														style="width: 72px; height: 72px;">
													</a>
													<div class="media-body">
														<c:url var="product" value="product">
															<c:param name="productId"
																value="${list.product.productId}" />
														</c:url>
														<h4 class="media-heading">
															<a href="${product}"> <c:out
																	value="${list.product.name}" /></a>
														</h4>
														<h5 class="media-heading">
															by
															<c:out value="${list.product.manufacturer}   " />
														</h5>
														<span>Status: </span><span class="text-success"><strong>In
																Stock</strong></span>
													</div>
												</div>
											</td>
											<form action="update" method="POST">
												<td class="col-sm-1 col-md-1" style="text-align: center">
													<input type="number" name="quantity"
													value="<c:out value="${list.quantity}"/>" size="2"
													maxlength="2" max="10" min="1" /> <input type="hidden"
													name="productid" value="${list.product.productId}" />
													<button type="submit"
														class="updateQuantity btn btn-default">Update</button>
												</td>
											</form>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${list.product.price}" /></strong></td>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${list.total}" /></strong></td>
											<td class="col-sm-1 col-md-1"><c:url var="remove"
													value="remove">
													<c:param name="productId" value="${list.product.productId}" />
												</c:url> <a href="${remove}" type="button" class="btn btn-danger">
													<span class="glyphicon glyphicon-remove"></span> Remove
											</a> <c:if test="${not empty customer}">
													<c:url var="moveToWishList" value="/moveToWishList">
														<c:param name="productId"
															value="${list.product.productId}" />
													</c:url>
													<a href="${moveToWishList}" type="button"
														class="btn btn-success"> Move to Wishlist </a>
												</c:if></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<div>
						<c:if test="${not empty param.addWishList}">
							<p class="text-info">Cannot Move Product to Wishlist</p>
						</c:if>
					</div>

				</div>
			</div>
		</div>
	</section>
	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>Choose if you have a discount code or reward points you want
					to use .</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="total_area">						
							<ul class="user_option">
								<li>
								<form action="coupon" method="post">
								<label>Use Coupon Code::</label> 
								<input type="text" name="coupon">
							    <input class="btn btn-default check_out" type="submit"	value="Apply" />
								</form>
								</li>
								<c:choose>
								   <c:when test="${check eq 1}" >
								   <h3 style="color:green;"><c:out  value="${paid}"></c:out></h3>
								   </c:when>
								   <c:otherwise>
								     <h3 style="color:red;"><c:out  value="${paid}"></c:out></h3>
								   </c:otherwise>
								</c:choose>																
								
							</ul>					
							
						
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span style="color: green;"><strong>Rs.<c:out
											value="${cart.total}" /></strong></span></li>
							<li>GST Tax <span style="color: green;"><strong>Rs.<c:out
											value="${cart.subtotal}" /></strong></span>
							</li>
							<li>Shipping Cost 
							   <c:choose>
									<c:when test="${cart.total lt 750 && cart.total ne 0.0}">									 
										<strong><span style="color: green;"><p>Rs.50</p></span></strong>
									</c:when>
									<c:otherwise>
										<strong><span style="color: green;"><p>Free</p></span></strong>
									</c:otherwise>
								</c:choose> 
							</li>
							<li>Total <span style="color: green;"><strong>Rs.<c:out
											value="${cart.grandtotal}" />
								</strong></span></li>
						</ul>
						<c:url var="emptycart" value="clear" />
						<a class="btn btn-default update" href="${emptycart}"
							type="button" class="btn btn-default"> Clear Cart <span
							class="glyphicon glyphicon-shopping-cart"></span>
						</a>
						<c:url var="home" value="home" />
						<a class="btn btn-default update" href="${home}" type="button"
							class="btn btn-default"> <span
							class="glyphicon glyphicon-shopping-cart"></span>Continue
							Shopping 
						</a>
						<c:url var="checkout" value="checkout" />
						<a class="btn btn-default update" href="${checkout}" type="button"
							class="btn btn-success"> Checkout <span
							class="glyphicon glyphicon-play"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#do_action-->
	<footer id="footer">
		<!--Footer-->
		<div class="footer-bottom" style="background: #F1F2F3">
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
