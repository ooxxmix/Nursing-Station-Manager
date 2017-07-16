<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Nurse</title>
<script src="//code.jquery.com/jquery.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.row {
	margin-top: 40px;
}

select {
	width: 100%;
	height: 200px;
}

select {
	font-size: 28px;
}
</style>
</head>
<body>
	<div class="container">

		<div class="row">
			<form:form id="NurseForm"
				action="${pageContext.request.contextPath}/nurse/save" method="post"
				modelAttribute="nurse" class="form-horizontal">
				<div class="col-xs-12">
					<div class="form-group pull-right">
						<a href="${pageContext.request.contextPath}"
							class="btn btn-default btn-lg">返回</a>
						<button id="submit_btn" class="btn btn-default btn-lg">儲存</button>
					</div>
				</div>
				<form:hidden path="id" />
				<input id="set_station" type="hidden" name="set_station" value="">
				<div class="center-block">
					<div class="col-xs-12">
						<div class="form-group">
							<h2>
								<label for="inputNumber" class="col-sm-3 control-label">員工編號</label>
							</h2>
							<div class="col-sm-9">
								<form:input path="no" type="text" class="form-control input-lg"
									id="inputNumber" />
							</div>
						</div>
						<div class="form-group">
							<h2>
								<label for="inputName" class="col-sm-3 control-label">員工名稱</label>
							</h2>
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

			<div class="col-xs-5">
				<select id="list1" multiple="multiple" size="8">
					<c:forEach var="station" items="${list_not_active}"
						varStatus="status">
						<option value="${station.id}">${station.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-xs-2">
				<div class="center-block" style="position: relative; height: 280px">
					<button type="button" style="position: absolute; top: 80px;"
						class="btn btn-default btn-lg btn-block"
						onclick="insertList('list1','list2');">
						&nbsp;<span class="glyphicon glyphicon-arrow-left"></span>&nbsp;
					</button>
					<button type="button" style="position: absolute; bottom: 80px;"
						class="btn btn-default btn-lg btn-block"
						onclick="insertList('list2','list1');">
						&nbsp;<span class="glyphicon glyphicon-arrow-right"></span>&nbsp;
					</button>
				</div>
			</div>

			<div class="col-xs-5">
				<select id="list2" multiple="multiple" size="8">
					<c:forEach var="station" items="${list_active}" varStatus="status">
						<option value="${station.id}">${station.name}</option>
					</c:forEach>
				</select>
			</div>

		</div>

	</div>
	<script>
		$("#submit_btn").click(function() {
			var option = [];
			$("#list2 option").each(function() {
				option.push($(this).val());
			});

			$("#set_station").val(option);

			$("#NurseForm").submit();
		});

		function insertList(tarL, srcL) {
			var tarObj = document.getElementById(tarL);
			var srcObj = document.getElementById(srcL);
			if (srcObj.selectedIndex >= 0) {
				var opt = document.createElement("option");
				tarObj.options.add(opt);
				opt.text = srcObj.options[srcObj.selectedIndex].text;
				opt.value = srcObj.options[srcObj.selectedIndex].value;
				srcObj.remove(srcObj.selectedIndex);
			}
		}
	</script>
</body>
</html>