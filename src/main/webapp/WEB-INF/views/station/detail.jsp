<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Station</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.row {
	margin-top: 40px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="${pageContext.request.contextPath}/station/save"
				method="post" modelAttribute="station">
				<div class="col-xs-12">
					<div class="form-group pull-right">
						<a href="${pageContext.request.contextPath}/station/list"
							class="btn btn-default btn-lg">返回</a>
						<button type="submit" class="btn btn-default btn-lg">儲存</button>
					</div>
				</div>
				<form:hidden path="id" />
				<div class="center-block">
					<div class="col-xs-12">
						<div class="form-group">
							<h1>
								<label for="inputName" class="col-sm-3 control-label">站點名稱</label>
							</h1>
							<div class="col-sm-9">
								<form:input path="name" type="text"
									class="form-control input-lg" id="inputName" placeholder="輸入名稱" />
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<h2>站點護士列表</h2>
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="active">
							<th>員工編號</th>
							<th>新增時間</th>
						</tr>
					</thead>
					<c:if test="${fn:length(nurses) > 0}">
						<c:forEach var="nurse" items="${nurses}" varStatus="status">
							<tr>
								<td>${nurse.no}</td>
								<td>${nurse.createDate}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${fn:length(nurses) <= 0}">
						<tr>
							<td align="center" colspan="3">查無資料!!</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>

	</div>
</body>
</html>