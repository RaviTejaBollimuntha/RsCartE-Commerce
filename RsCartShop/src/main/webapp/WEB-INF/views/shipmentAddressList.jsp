<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-12">
		<div class="row">
			<div class="table-responsive">
                 <h1 align="center">Shipment Address Details</h1>
                 <div align="right">	
                 <a href="${pageContext.request.contextPath}/checkout?page=saveorupdate"><button style="color:green;">Add New Address</button></a>
                 </div>	
                 <br>
                 <form:form action="shipmentaddress" method="POST">
				<table class="table table-bordered table-hover table-condensed">
					<thead>
					    <th></th>
						<th>Full Name</th>
						<th>D.No & Address</th>
						<th>LandMark</th>
						<th>Cities</th>
						<th>Region / State</th>
						<th>Country</th>
						<th>Zip Code</th>
						<th></th>
					</thead>
					<tbody>
						<c:forEach var="address" items="${shipmentAddressList}">
							<tr>
								<td><input type="radio" name="shippingid" value="<c:out value="${address.shippingId}"/>"></td>
								<td><c:out value="${address.fullName}" /></td>
								<td><c:out value="${address.address1}" /></td>
								<td><c:out value="${address.address2}" /></td>
								<td><c:out value="${address.city}" /></td>
								<td><c:out value="${address.state}" /></td>
								<td><c:out value="${address.country}" /></td>
								<td><c:out value="${address.zipCode}" /></td>
								<td><a href="${pageContext.request.contextPath}/checkout?id=${address.shippingId} & page=saveorupdate">Edit</a></td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
				<div align="center"><input align="middle" type="submit" value="process to Payment"/></div>
				</form:form>
				<br>
			</div>
		</div>
	</div>
</body>
</html>