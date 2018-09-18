<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath }/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath }/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


</head>
<body>

	<div id="wrapper">

		<jsp:include page="common/header.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">欢迎使用在线考试系统</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="well well-lg">
					<h4 class="fa fa-info-circle">各位老师您好:</h4>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;你现在使用的是XXX公司开发的在线考试系统，通过该系统，你可以在线录入考试题目，更新考试
						系统以及查询考试题目！同时还可以对学生信息还有学生成绩信息进行维护。</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-wrapper -->

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/morrisjs/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>




</html>
