<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<div id="accountForm" class="col-md-8">
		<h1>Account Information</h1>
		<c:if test="${flag eq 1}">
			<p class="bg-success">Account Updated successfully!!.</p>
		</c:if>
		<form:form class="form-horizontal" action="updatecustdetails" method="post">
		<form:errors path="*"/>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="userName">User Name:</label> <input type="text"
						class="form-control" name="userName" placeholder="User Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="firstName">First Name:</label> <input type="text"
						class="form-control" name="firstName" placeholder="First Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="lastName">Last Name:</label> <input type="text"
						class="form-control" name="lastName" placeholder="Last Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="phoneNumber">Mobile Number:</label> <input type="text"
						class="form-control" name="phoneNumber"
						placeholder="Mobile Number" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<input type="submit" value="Save" class="btn btn-success" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
