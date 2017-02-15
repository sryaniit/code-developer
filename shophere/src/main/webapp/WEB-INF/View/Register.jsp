<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
</head>

<body>
<div align="center">


<h4>Register Form</h4>

<form:form action="register" commandName="userobj" method="post">

Name: <form:input type="text" path="name" required="true" placeholder="enter name" />
<br/>

UserName:<form:input type="text" placeholder="Username" required="true" path="username" /> 
<br/>

Password:<form:input type="password" placeholder="password" required="true" path="password" maxsize="15" />
<br/>

Mobile number:<form:input type="tel" placeholder="mobileno" required="true" path="mobilenum" maxsize="10" value=""/>
<br/>

Email Address :<form:input type="email" placeholder="Enter Address" required="true" path="email"/>
<br/>

Department:  <form:select path="dept" required="true" >
<form:option value="cse" label="cse"> </form:option>
<form:option value="mech" label="mech"> </form:option>
<form:option value="it" label="it"> </form:option>
<form:option value="civil" label="civil"> </form:option>
<form:option value="ece" label="ece"> </form:option>
<form:option value="eee" label="eee"> </form:option>
<form:option value="btech" label="btech"> </form:option>
</form:select>
<br/>

College : <form:input type="text" path="college" placeholder="Enter college name" required="true" />
<br/>
<br/>

<input type="submit" value="register"></input>
<a href="login">Already A USER!</a> 
<br/>

</form:form>
</div>
</body>
</html>