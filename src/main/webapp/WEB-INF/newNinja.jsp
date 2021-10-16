<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninja">
			    <form:select path="dojo">
			        <c:forEach var="oneDojo" items="${ dojos }">
			            <form:option value="${ oneDojo.id }" label="${ oneDojo.name }" />
			        </c:forEach>
			    </form:select>
			<p>
			    <form:label path="fName">First Name:</form:label>
			    <form:input path="fName"/>
			</p>
			<p>
			    <form:errors path="fName"/>	    
			</p>
			<p>
			    <form:label path="lName">Last Name:</form:label>
			    <form:input path="lName"/>
			</p>
			<p>
			    <form:errors path="lName"/>	    
			</p>
			<p>
			    <form:label path="age">Age:</form:label>
			    <form:input path="age"/>
			</p>
			<p>
			    <form:errors path="age"/>	    
			</p>
			<input type="submit" value="Submit"/>
		</form:form>	
	</div>
</body>
</html>