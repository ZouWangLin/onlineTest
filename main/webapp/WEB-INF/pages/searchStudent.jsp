<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 导入分页插件 -->
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>查找学生成绩</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
</head>

<body>

	<div id="wrapper">

		<jsp:include page="common/header.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">查找学生成绩</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading"
							style="border-bottom-width: 0px; padding-bottom: 2px;">
							<div class="row">
								<div class="col-md-4 col-md-offset-8 pull-center">
									<div class="form-group input-group">
											<form action="${pageContext.request.contextPath }/search/searchStudent" method="GET" id="searchForm">
											<input type="number" class="form-control"
												placeholder="输入查找的学生学号" name="searchContent" value="${requestScope.searchContent}" 
												/> 
												</form>
												<span
												class="input-group-btn">
												<button class="btn btn-default form-control"  onclick="submit()">
													<i class="fa fa-search"></i>
												</button>
											</span>
									</div>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="text-center">学生学号</th>
											<th class="text-center">学生姓名</th>
											<th class="text-center">所在班级</th>
											<th class="text-center">学生成绩</th>
											<th class="text-center">操作</th>
										</tr>
									</thead>
									<tbody>
									<tbody>
										<c:choose>
											<c:when test="${not empty requestScope.student}">
													<tr>
														<td class="text-center">${student.studentid }</td>
														<td class="text-center">${student.username }</td>
														<td class="text-center">${classname}</td>
														<td class="text-center">${student.result }</td>
														<td class="text-center">
															<button type="button" class="btn btn-outline btn-primary btn-md btn-block" onclick="viewStudent()">查看考试情况</button>
														</td>
													</tr>
											</c:when>
											<c:otherwise>
												<td colspan="5" class="text-center">没有找到当前学生的信息！检查学号是否输入错误!</td>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>

	</div>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
	
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	
	<script >
		function submit(){
			$("#searchForm").submit();
		}
		function viewStudent(){
			window.location.href="http://localhost:8080/imageserver/${student.studentid}.html";
		}
	</script>

</body>

</html>
