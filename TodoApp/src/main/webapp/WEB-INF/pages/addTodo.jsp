<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container mt-3">
			<%@ include file="navbar.jsp" %>
			<h1 class="text-center mt-3">Add Todo</h1>
    				<br>
    				<form:form action="saveTodo" method="post" modelAttribute="todo">
    					<div class="form-group">
    						<!-- <input name="title" type"text"> -->
    						<form:input path="todoTitle" cssClass="form-control" placeholder="Enter Title" />
    					</div>
    					<div class="form-group">
    						<form:textarea path="todoContent" cssClass="form-control" placeholder="Enter Description" cssStyle="height:300px;" />
    					</div>
    					<div class="container">
	    					<button class="btn btn-outline-success">Save</button>
    					</div>
    				</form:form>
    	</div>
</body>
</html>