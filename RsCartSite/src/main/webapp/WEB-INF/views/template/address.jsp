<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE section PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<body>
	<section id="do_action">
	<div class="container" ng-app="Homeapp" ng-controller="HomeController">
		<form:form commandName="shippingAddress" id="billingFormm"
			action="address" method="POST">
			<div class="row">
				<h2 align="center" id="addressTitle">Shipment Address Form</h2>

				<div class="col-sm-6">
					<div class="total_area">
						<c:set var="address" value="${shippingaddress}" />
						<div class="form-group">
							<label for="fullName"> Full Name </label> <input id="fullName"
								name="fullName" type="text" class="form-control"
								placeholder="Full Name" value="${shippingaddress.fullName}" />
						</div>
						<div class="form-group">
							<label for="address1"> D.No & Address </label> <input
								id="address1" name="address1" type="text" class="form-control"
								placeholder="Address 1" value="${shippingaddress.address1}" />
						</div>
						<div class="form-group">
							<label for="fullname"> LandMark </label> <input id="address2"
								name="address2" type="text" class="form-control"
								placeholder="Address 2" value="${shippingaddress.address2}" />
						</div>
						<div class="form-group">
							<label for="zipCode"> Zip Code </label> <input id="zipCode"
								name="zipCode" type="text" class="form-control"
								placeholder="Zip Code" value="${shippingaddress.zipCode}" />
						</div>

					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">

						<ul>
							<li class="single_field"><input type="checkbox"
								ng-model="default" checked="checked"> Please Check For
								default Address</li>
							<li class="single_field" id="data"><label>Country:</label> <select
								ng-model="CountryId" ng-change="state()" name="country">
									<c:choose>
										<c:when test="${shippingaddress.state ne null}">
											<option value="${shippingaddress.country}" ng-selected="default">${shippingaddress.country}</option>
										</c:when>
										<c:otherwise>
											<option value="" ng-selected="defalut">Select
												Country</option>
										</c:otherwise>
									</c:choose>
									<option value="">Select Country</option>
									<option data-ng-repeat="t in countrylist"
										value="{{t.id}}{{t.name}}">{{t.name}}</option>

							</select></li>
							<li class="single_field"><label>Region / State:</label> <select
								ng-model="StateID" ng-change="city()" name="state">
									<c:choose>
										<c:when test="${shippingaddress.state ne null}">
											<option value="${shippingaddress.state}" ng-selected="default">${shippingaddress.state}</option>
										</c:when>
										<c:otherwise>
											<option value="" ng-selected="defalut">Select
												Country</option>
										</c:otherwise>
									</c:choose>
									<option value="">Select State</option>

									<option data-ng-repeat="t in statelist"
										value="{{t.id}}{{t.name}}">{{t.name}}</option>

							</select></li>
							<li class="single_field"><label>Cities:</label> <select
								ng-model="Cityid" name="city">
									<c:choose>
										<c:when test="${shippingaddress.city ne null}">
											<option value="${shippingaddress.city}" ng-selected="default">${shippingaddress.city}</option>
										</c:when>
										<c:otherwise>
											<option value="" ng-selected="defalut">Select
												Country</option>
										</c:otherwise>
									</c:choose>
									<option value="">Select City</option>

									<option data-ng-repeat="t in citylist" value="{{t.name}}">{{t.name}}</option>

							</select></li>

						</ul>
					</div>
				</div>
			</div>
			<div align="center">
				<input type="submit" class="btn btn-default update"
					value="Continue to Payment" />
			</div>
		</form:form>
	</div>

	</section>
</body>
</html>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('Homeapp', []);

	app.controller('HomeController', function($http, $scope) {

		//Get Country record

		$http.get('getcountry').then(function(d) {

			$scope.countrylist = d.data.conlist;

		}, function() {

			alert('failed');

		});

		// Get State record

		$scope.state = function() {

			$http.get('getstate?countryId=' + $scope.CountryId).then(function(d) {

				$scope.statelist = d.data.stlist;

			});

		};

		// Get City record

		$scope.city = function() {

			$http.get('getciti?stateId=' + $scope.StateID).then(function(d) {

				$scope.citylist = d.data.ctlist;

			});

		};



	});
</script>