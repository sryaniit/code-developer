<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
</head>
<body>
<div>
<h4>Register Form</h4>
<form:form action="reg" commandName="userobj">
<form:input path="name"></form:input>
<form:label path="name">Name:</form:label>

UserName:<form:input type="text" placeholder="Username" required="true" path="username" /> <br/>

Password:<form:input type="password" placeholder="password" id="pwd" name="pwd" required="true" path="password" /><br/>

Mobile number:<form:input type="tel" placeholder="mobilenumber" required="true" path="mobilenum"/><br/>

Address : <form:input type="text" placeholder="Enter Address" required="true" path="address"/><br/>

<input type="submit" value="register"></input>
<a href="login">Already A USER!</a> 
</form:form>
</div>
</body>
</html>