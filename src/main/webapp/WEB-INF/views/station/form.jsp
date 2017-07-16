<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Station</title>
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
						<button type="submit" class="btn btn-default btn-lg">新增</button>
					</div>
				</div>
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
	</div>
</body>
</html>