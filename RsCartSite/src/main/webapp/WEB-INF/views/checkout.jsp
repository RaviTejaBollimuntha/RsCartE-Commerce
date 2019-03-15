<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>CheckOut Details | RsCart</title>
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
		<%@include file="slider.jsp"%>
	</section><!--/slider-->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12" >
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
								<c:when test="${cart.numberOfItems == 0}">
									<tr>
										<td><c:url var="home" value="home" />
											<h4>Your Shopping Cart is Empty</h4> <a href="${home}"
											class="btn btn-info">Continue Shopping</a></td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:set var="cartList" value="${cart.orderItemsList}" />
									<c:forEach var="item" items="${cartList}">
										<tr>
											<td class="col-sm-8 col-md-6">
												<div class="media">
													<a class="thumbnail pull-left" href="#"> <img
														class="media-object"
														src="resources/images/home/${item.product.productId}.jpg"
														style="width: 72px; height: 72px;">
													</a>
													<div class="media-body">
														<c:url var="product" value="product">
															<c:param name="productId"
																value="${item.product.productId}" />
														</c:url>

														<h4 class="media-heading">
															<a href="${product}"> <c:out
																	value="${item.product.name}" /></a>
														</h4>
														<h5 class="media-heading">
															by
															<c:out value="${item.product.manufacturer}   " />
														</h5>
														<span>Status: </span><span class="text-success"><strong>In
																Stock</strong></span>
													</div>
												</div>
											</td>
											<td class="col-md-1" style="text-align: center">
												<div>
													<c:out value="${item.quantity}" />
												</div>
											</td>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${item.product.price}" /></strong></td>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${item.total}" /></strong></td>
											<td class="col-sm-1 col-md-1"><c:url var="remove"
													value="remove">
													<c:param name="productId"
														value="${item.product.productId}" />
												</c:url> <a href="cart" type="button" class="btn btn-primary"> <span
													class="glyphicon glyphicon-edit"></span> Edit
											</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<hr>
					
				    <%@include file="template/address.jsp"%>
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