<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div id="wrapper">
		<div class="row" style="padding-top: 15px;">
			<div class="col-lg-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="lead">
							网站出了一点小问题，工程师正在抢修的路上.......
							<button type="button" class="btn btn-outline btn-primary btn-lg" onclick="back()">返回首页</button>
							<br/>
						</h1>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-4">
								<img src="${pageContext.request.contextPath }/data/error.jpg" class="img-responsive" alt="Cinque Terre">
							</div>
							<div class="col-md-4">
								<img src="${pageContext.request.contextPath }/data/error.jpg" class="img-responsive" alt="Cinque Terre">
							</div>
							<div class="col-md-4">
								<img src="${pageContext.request.contextPath }/data/error.jpg" class="img-responsive" alt="Cinque Terre">
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<p class="text-center">	
							Copyright&nbsp;&nbsp;<span class="glyphicon glyphicon-copyright-mark "></span>2008-2018&nbsp;
						xiaozou&nbsp;&nbsp;版权所有
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

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
<script type="text/javascript">
	function back(){
		window.location.href="${pageContext.request.contextPath}/";
	}
</script>

</html>