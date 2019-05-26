<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div>
		<h1>Email Change Request</h1>
		<c:if test="${not empty tokenresult}">
			<p class="bg-success">${tokenresult}</p>
		</c:if>
		<form:form class="form-horizontal" action="resetemail" method="POST" commandName="resetemail">
			<div class="form-group">
			    <div class="form-group">
					<label for="email" class="col-md-3 control-label"> New Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="newEmail"
													placeholder="Email Address">
						</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-md-3 control-label">Re-New Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="newEmailConfirm"
													placeholder="Re-Email Address">
						</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password</label> 
					<div class="col-md-9">
					<input type="password" class="form-control"
						id="password" name="password" placeholder="Old Password">
						</div>
				</div>						
			<div class="col-md-offset-3 col-md-9">
				<div class="col-sm-9">
					<input type="submit" value="Change" class="btn btn-success" />
				</div>
			</div>
			</div>
		</form:form>
	</div>
</body>

</html>
