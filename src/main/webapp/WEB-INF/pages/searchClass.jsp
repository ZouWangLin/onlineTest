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

<title>查找班级成绩</title>

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
					<h1 class="page-header">查找班级成绩</h1>
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
								<div class="col-md-3"  style="padding-bottom: 8px;">
									<button type="button"
									class="btn btn-outline btn-primary btn-md" onclick="exportClass()">
									导出当前班的成绩
									</button>
								</div>
								<div class="col-md-3 col-md-offset-6">
									<form role="form" class="form-inline">
										<label for="selectClass">选择班级&nbsp;&nbsp;</label> <select
											class="form-control" id="classNameSelect"
											name="classNameCheck">
										</select>
									</form>
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
										<c:choose>
											<c:when test="${not empty requestScope.page.rows}">
												<c:forEach var="student" items="${requestScope.page.rows }">
													<tr>
														<td class="text-center">${student.studentid }</td>
														<td class="text-center">${student.username }</td>
														<td class="text-center">${classname}</td>
														<td class="text-center">${student.result }</td>
														<td class="text-center">
															<button type="button"
																class="btn btn-outline btn-primary btn-md btn-block"
																onclick="viewStudent(${student.studentid })">查看考试情况</button>
														</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<td colspan="5" class="text-center">没有找到当前学生的信息！检查学号是否输入错误!</td>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
								<div class="col-md-12 text-right">
									<itcast:page
										url="${pageContext.request.contextPath }/class/selectClass" />
								</div>
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
	
	<!-- 提示用户选择班级模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
               <h4 class="modal-title" id="myModalLabel"><span class="fa fa-info-circle"></span> 提示</h4>
            </div>
            <div class="modal-body">要想打印成绩，请先选择一个班级！</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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

	<script>
		$(function() {
			/* 发送ajax请求添加节点 */
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/class/findAll",
				success : function(data) {
					//定义用户的选择
					var blankNodes = "<option value='-1'>请选择班级</option>";
					$("#classNameSelect").append(blankNodes);
					$.each(data, function(i, ele) {
						//1.找到select标签,添加节点
						var classno="${requestScope.classno}";//获取服务端request域中的classno
						//2.第一次可能为空
						if(classno==""){
							var nodes = "<option value="+ele.classid+">"+ele.classname +"</option>";
						}else{
							if(ele.classid==classno){
								var nodes = "<option selected value="+ele.classid+">"+ele.classname +"</option>";
							}else{
								var nodes = "<option value="+ele.classid+">"+ele.classname +"</option>";
							}
						}
						$("#classNameSelect").append(nodes);
					});
				}
			});
			/* 监听用户的选择，用户选择一个班级后显示对应的学生 */
			$("#classNameSelect").change(function() {
				//1.获取用户的选择
				var choice=$(this).val();
				//2.发送一个请求给服务器
				window.location.href = "/class/selectClass?classno="+choice;
			});
		});
		
		function viewStudent(id){
			window.location.href="http://localhost:8080/imageserver/"+id+".html";
		}
		
		//导出当前班级的成绩
		function exportClass(){
			//1.获取用户的选择的班级号
			var classno=$("#classNameSelect option:selected").val();
			//2.如果用户没有选择班级，给出提示
			if(classno==-1){
				$('#myModal').modal();
			}else{
				//3.如果用户选择了班级，向服务器发送一个请求，请求导出成绩
				window.location.href="/class/exportClass?classno="+classno;
			}
		}
	</script>

</body>

</html>
