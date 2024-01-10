<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container mt-3">
		<%@ include file = "navbar.jsp" %>
		<h1 class="text-center my-4">Your Todos</h1>
		<hr>
  		<div class="container">
  			<c:forEach items="${todos }" var="t">
    					<div class="card my-4 border border-success">
    						<div class="card-body">
    							<h3><c:out value="${t.todoTitle }"></c:out></h3>
    							<p><c:out value="${t.todoContent }"></c:out>:</p>
    						</div>
    					</div>
    		</c:forEach>
  		</div>
    </div>
</body>
</html>