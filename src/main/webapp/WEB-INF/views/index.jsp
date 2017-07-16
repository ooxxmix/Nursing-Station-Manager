<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Nursingstation Manager</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
a {
	margin-top: 60px;
}

.center-block {
	width: 80%
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="center-block">
				<a href="station/add"
					class="btn btn-default btn-lg col-xs-12 col-md-12" role="button">
					<span class="glyphicon glyphicon-pencil"></span> 新增站點
				</a> <a href="station/list"
					class="btn btn-default btn-lg col-xs-12 col-md-12" role="button">
					<span class="glyphicon glyphicon-th-list"></span> 站點列表
				</a> <a href="nurse/add"
					class="btn btn-default btn-lg col-xs-12 col-md-12" role="button">
					<span class="glyphicon glyphicon-user"></span> 新增護士
				</a> <a href="nurse/list"
					class="btn btn-default btn-lg col-xs-12 col-md-12" role="button">
					<span class="glyphicon glyphicon-th-list"></span> 護士列表
				</a>
			</div>
		</div>
	</div>
</body>
</html>