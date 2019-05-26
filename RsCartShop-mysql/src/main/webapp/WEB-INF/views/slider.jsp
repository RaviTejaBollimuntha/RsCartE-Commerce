<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<div class="col-sm-6">
						<h1>
							<span>RS</span>-Cart
						</h1>
						<h2>Best Online Shopping</h2>
						<p>Electronic commerce or ecommerce is a term for any type of
							business, or commercial transaction, that involves the transfer
							of information across the Internet. ... It is currently one of
							the most important aspects of the Internet to emerge.</p>
						<button type="button" class="btn btn-default get">Get it
							now</button>
					</div>
					<div class="col-sm-6">
						<img src="resources/images/girl1.jpg"
							class="girl img-responsive" alt="" /> 
					</div>
				</div>
				<div class="item">
					<div class="col-sm-6">
						<h1>
							<span>RS</span>-Cart
						</h1>
						<h2>100% Responsive Design</h2>
						<p>Electronic commerce or ecommerce is a term for any type of
							business, or commercial transaction, that involves the transfer
							of information across the Internet. ... It is currently one of
							the most important aspects of the Internet to emerge.</p>
						<button type="button" class="btn btn-default get">Get it
							now</button>
					</div>
					<div class="col-sm-6">
						<img src="resources/images/girl2.jpg"
							class="girl img-responsive" alt="" />
					</div>
				</div>
				<div class="item">
					<div class="col-sm-6">
						<h1>
							<span>RS</span>-Cart
						</h1>
						<h2>100% Responsive Design</h2>
						<p>Electronic commerce or ecommerce is a term for any type of
							business, or commercial transaction, that involves the transfer
							of information across the Internet. ... It is currently one of
							the most important aspects of the Internet to emerge.</p>
						<button type="button" class="btn btn-default get">Get it
							now</button>
					</div>
					<div class="col-sm-6">
						<img src="resources/images/girl3.jpg"
							class="girl img-responsive" alt="" /> 
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

</body>
</html>