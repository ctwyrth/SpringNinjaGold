<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto my-5">
			<div class="row justify-content-start mb-5"><span class="h3">Your Gold: <c:out value="${gold}" /> gold</span></div>
			<div class="row align-items-center justify-content-between mb-3">
				<div class="col-2 border border-0 rounded bg-success text-center py-4 px-2" style="height: 200px;">
					<form action="/addGold" method="POST">
						<h4>Farm</h4>
						<p class="my-3">(earns 10-20 gold)</p>
						<input type="hidden" name="name" value="farm"/>
						<input type="submit" value="Find Gold!" class="btn btn-sm btn-light" />
					</form>
				</div>
				<div class="col-2 border border-0 rounded bg-warning text-center py-4 px-2" style="height: 200px;">
					<form action="/addGold" method="POST">
						<h4>Cave</h4>
						<p class="my-3">(earns 5-10 gold)</p>
						<input type="hidden" name="name" value="cave" />
						<input type="submit" value="Find Gold!" class="btn btn-sm btn-light" />
					</form>
				</div>
				<div class="col-2 border border-0 rounded bg-danger text-center py-4 px-2" style="height: 200px;">
					<form action="/addGold" method="POST">
						<h4>House</h4>
						<p class="my-3">(earns 2-5 gold)</p>
						<input type="hidden" name="name" value="house" />
						<input type="submit" value="Find Gold!" class="btn btn-sm btn-light" />
					</form>
				</div>
				<div class="col-2 border border-0 rounded bg-info text-center py-4 px-2" style="height: 200px;">
					<form action="/addGold" method="Post">
						<h4>Quest</h4>
						<p class="my-3">(earn/lose 0-50 gold)</p>
						<input type="hidden" name="name" value="quest" />
						<input type="submit" value="Find Gold!" class="btn btn-sm btn-light" />
					</form>
				</div>
			</div>
			<div class="row p-3">
				<h3>Activities:</h3>
				<textarea name="actions" id="actions" rows="10" class="container-fluid border border-1 border-dark" style="overflow: scroll;">
					<c:forEach var="action" items="${actions}">
						<c:out value="${action}" />
					</c:forEach>
				</textarea>
			</div>
			<div class="mt-4">
				<button class="btn btn-sm btn-primary" onclick="reset()">Reset</button>
			</div>
		</div>
	</div>
</body>
</html>