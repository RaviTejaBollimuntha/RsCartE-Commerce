<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Order Details | RsCart</title>
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
	<div class="container">
		<div class="container">
		
			<section id="main">

			<h3>Thanks for placing your order!! Your order will be
				dispatched soon!!</h3>
			<a href=""><c:out value="Order Number: ${orderDetails.orderId}" /></a>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Product</th>
						<th>Price</th>
						<th>Order Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${prodList}">
						<tr>
							<td class="col-sm-8 col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object"
										src="resources/images/home/${product.productId}.jpg"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<c:out value="${product.name}" />
										</h4>
										<h5 class="media-heading">
											by
											<c:out value="${product.manufacturer}   " />
										</h5>
										<span>Status: </span><span class="text-success"><strong>In
												Stock</strong></span>
									</div>
								</div>
							</td>
							<td><strong><c:out value="Rs.${product.price}" /></strong></td>
							<td><strong><c:out
										value="${orderDetails.orderStatus}" /></strong></td>

						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td><strong><c:out
									value="Total:${orderDetails.orderTotal}" /></strong></td>
					</tr>
				</tbody>
			</table>
		</div>
		</section>	
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
<script src="resources/js/jquery-1.8.0.js"></script>
	<script src="resources/js/price-range.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>
	
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/main.js"></script>
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

