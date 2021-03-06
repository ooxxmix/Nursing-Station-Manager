<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nurse List</title>
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
			<div class="col-xs-12">
				<div class="form-group pull-right">
					<a href="${pageContext.request.contextPath}"
						class="btn btn-default btn-lg">返回</a>
				</div>
			</div>
			<div class="col-xs-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="active">
							<th>員工編號</th>
							<th>護士姓名</th>
							<th>修改時間</th>
							<th nowrap="nowrap" style="width: 1%">動作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(list) > 0}">
							<c:forEach var="nurse" items="${list}" varStatus="status">
								<tr>
									<td>${nurse.no}</td>
									<td>${nurse.name}</td>
									<td>${nurse.createDate}</td>
									<td nowrap="nowrap">
										<spring:url value="/nurse/edit/${nurse.id}" var="editurl" />
										<a href="${editurl}" class="btn btn-default" role="button">  
											<span class="glyphicon glyphicon-folder-open" />
										</a> 
										<spring:url value="/nurse/delete/${nurse.id}" var="deleteurl" />
										<a href="${deleteurl}" class="btn btn-default" role="button" onclick="return confirm('確認?');">
											<span class="glyphicon glyphicon-trash" />
										</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${fn:length(list) <= 0}">
							<tr>
								<td align="center" colspan="4">查無資料!!</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>