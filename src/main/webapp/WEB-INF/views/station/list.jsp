<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>NursingStation Manager</title>
</head>
<body>
	<table width="100%" border="1">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>date</td>
			<td colspan="2">action</td>
		</tr>
		<c:forEach items="${list}" var="station">
			<tr>
				<td>${station.id}</td>
				<td>${station.name}</td>
				<td>${station.createDate}</td>
				<td><spring:url value="/station/edit/${station.id}"
						var="editurl" /><a href="${editurl}">edit</a></td>
				<td><spring:url value="/station/delete/${station.id}"
						var="deleteurl" /><a href="${deleteurl}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>