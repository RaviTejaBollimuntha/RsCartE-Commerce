<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Account | RsCart</title>
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
		<div class="row">
			<div class="col-sm-2">
				<nav class="nav-sidebar nav-pills nav-stacked">
				<ul class="nav tabs">
					<li class="active"><a  href="change-account" data-toggle="tab"><i
							class="fa fa-home fa-fw"></i>Update Profile</a></li>
					<li class=""><a href="addressDetails" data-toggle="tab"><i
							class="fa fa-table fa-fw"></i>Edit Address</a></li>
					<li class=""><a href="resetemail" data-toggle="tab"><i
							class="fa fa-table fa-fw"></i>Edit Email</a></li>
					<li class=""><a href="change-password" data-toggle="tab"><i
							class="fa fa-bar-chart-o fa-fw"></i>Change Password</a></li>		
					<li class=""><a href="orderHistory" data-toggle="tab"><i
							class="fa fa-list-alt fa-fw"></i>Orders</a></li>
					<li class=""><a href="wishlist" data-toggle="tab"><i
							class="fa fa-file-o fa-fw"></i>Wishlist</a></li>	
					<li class=""><a href="reviews" data-toggle="tab"><i
							class="fa fa-tasks fa-fw"></i>Reviews & Ratings</a></li>					
				</ul>
				</nav>
			</div>
			<div class="col-sm-8 well">
			   <c:choose>
			    <c:when test="${page ne null}">
			     <c:set var="inpage" value="${page}.jsp" />
				<jsp:include page="${inpage}"></jsp:include>
			    </c:when>
			    
			   </c:choose>				
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

