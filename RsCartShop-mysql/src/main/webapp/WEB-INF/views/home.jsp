<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | RsCart</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<style type="text/css" style="display: none">
   .glyphicon { margin-right:5px; }
.thumbnail
{
    margin-bottom: 20px;
    padding: 0px;
    -webkit-border-radius: 0px;
    -moz-border-radius: 0px;
    border-radius: 0px;
}

.item.list-group-item
{
    float: none;
    width: 100%;
    background-color: #fff;
    margin-bottom: 10px;
}
.item.list-group-item:nth-of-type(odd):hover,.item.list-group-item:hover
{
    background: #f1f2f3;
}

.item.list-group-item .list-group-image
{
    margin-right: 10px;
}
.item.list-group-item .thumbnail
{
    margin-bottom: 0px;
}
.item.list-group-item .caption
{
    padding: 9px 9px 0px 9px;
}
.item.list-group-item:nth-of-type(odd)
{
    background: #eeeeee;
}

.item.list-group-item:before, .item.list-group-item:after
{
    display: table;
    content: " ";
}

.item.list-group-item img
{
    float: left;
}
.item.list-group-item:after
{
    clear: both;
}
.list-group-item-text
{
    margin: 0 0 11px;
}
   
</style>

</head>

<body>
    <header id="header">
		<%@include file="template/header.jsp"%>
	</header>
	<section id="slider">
		<%@include file="slider.jsp"%>
	</section>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
				<div id="well" class="well well-sm">
					<div class="btn-group">
						<a href="#" id="list" class="btn btn-default btn-sm"><span
							class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
							id="grid" class="btn btn-default btn-sm"><span
							class="glyphicon glyphicon-th"></span>Grid</a>
					</div>
				</div>
				<div id="products" class="row list-group">
						<c:choose>
							<c:when test="${featProd.size() != 0 }">
								<c:forEach var="featProds" items="${featProd}">
									<c:url var="url" value="product">
										<c:param name="productId" value="${featProds.productId}" />
									</c:url>
									<div class="item  col-xs-4 col-lg-4">
										<div class="thumbnail">
											<img class="group list-group-image"
												src="resources/images/${featProds.productId}.jpg"
												width="193" height="80" />
											<div class="caption">
												<h4 class="group inner list-group-item-heading">
													<a href="${url}"><c:out value="${featProds.name}" /></a>
												</h4>
												<p class="group inner list-group-item-text">
													<c:out value="${featProds.manufacturer}" />
												</p>
												<p class="group inner list-group-item-text">
													<c:out value="${featProds.description}" />
												</p>
												<div class="row">
													<div class="col-xs-12 col-md-6">
														<p class="lead">
															Rs.
															<c:out value="${featProds.price}" />
														</p>
													</div>
													<c:url var="add" value="/addProduct">
														<c:param name="productId" value="${featProds.productId}" />
													</c:url>
													<div class="col-xs-12 col-md-6">
														<a class="btn btn-success" href="${add}">Add to cart</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<h3 align="center" style="color:maroon; ">Searching Products Not Available </h3>
							</c:otherwise>
						</c:choose>
				</div>	
       		    <div id='page'></div>
       		    <div class="demo4_top demo4_bottom" align="center">
       		    <input id="total" type="hidden"  value="${pagecount}"/>
       		    <input id="pageno" type="hidden"  value="${pageno}"/>
       		    <input id="search" type="hidden"  value="${search}"/>
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
					<%@include file="template/footer.jsp" %>
                    
				</div>
			</div>
		</div>
	</footer>
	<!--/Footer-->
    <script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-1.8.0.js"></script>
	<script src="resources/js/price-range.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>	
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/pagenation.js"></script>
	<script src="resources/js/jquery.bootpag.min.js"></script>
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
</script>


