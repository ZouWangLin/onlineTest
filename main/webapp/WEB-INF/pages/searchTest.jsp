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

<title>查找试题</title>

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


</head>

<body>

	<div id="wrapper">

		<jsp:include page="common/header.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">查找试题</h1>
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
											<form action="${pageContext.request.contextPath }/search/searchTest" method="GET" id="searchForm">
											<input type="text" class="form-control"
												placeholder="输入查找的关键字" name="searchContent" value="${requestScope.searchContent}"/> 
												</form>
												<span
												class="input-group-btn">
												<button class="btn btn-default form-control" type="button" onclick="submit()">
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
											<th>试题编号</th>
											<th>试题标题</th>
											<th>选项A内容</th>
											<th>选项B内容</th>
											<th>选项C内容</th>
											<th>选项D内容</th>
											<th>正确答案</th>
											<th>答案解析</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									<tbody>
										<c:choose>
											<c:when test="${not empty requestScope.page}">
												<c:forEach items="${requestScope.page.rows}" var="subject"
													varStatus="Index">
													<tr>
														<td>${Index.count }</td>
														<td>${subject.subjecttitle }</td>
														<td>${subject.subjectoptiona }</td>
														<td>${subject.subjectoptionb }</td>
														<td>${subject.subjectoptionc }</td>
														<td>${subject.subjectoptiond }</td>
														<td>${subject.subjectanswer }</td>
														<td>${subject.subjectparse }</td>
														<td><a class="btn btn-primary"
															onclick="viewTest(${subject.subjectid})" role="button"
															data-toggle="modal" data-target="#viewTest">查看试题</a> <a
															class="btn btn-success"
															onclick="viewTest(${subject.subjectid})" role="button"
															data-toggle="modal" data-target="#updateTest">更新试题</a> <a
															class="btn btn-primary"
															onclick="deleteTest(${subject.subjectid})" role="button">删除试题</a></td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<td colspan="9">没有找到与关键字相匹配的试题!</td>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
								<div class="col-md-12 text-right">
									<itcast:page
										url="${pageContext.request.contextPath }/search/searchTest" />
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
	<!-- /#page-wrapper -->

	<!-- 更新试题模态框（Modal） -->
	<div class="modal fade" id="updateTest" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="update">更新试题</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="row">
							<div class="col-md-12">
								<form role="form" class="form-horizontal" id="updateTestForm">
									<div class="form-group">
										<label class="control-label col-md-2" for="problem">试题题目</label>
										<input type="hidden" name="subjectid" class="subjectid">
										<div class="col-md-10" id="problem">
											<input class="form-control subjecttitle" name="subjecttitle">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-2">答案A</label>
										<div class="col-md-10">
											<input class="form-control subjectoptiona"
												name="subjectoptiona">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2">答案B</label>
										<div class="col-md-10">
											<input class="form-control subjectoptionb"
												name="subjectoptionb">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2">答案C</label>
										<div class="col-md-10">
											<input class="form-control subjectoptionc"
												name="subjectoptionc">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2">答案D</label>
										<div class="col-md-10">
											<input class="form-control subjectoptiond"
												name="subjectoptiond">
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-2 control-label">正确答案</label>
										<div class="col-md-10">
											<label class="radio-inline"> <input type="radio"
												name="subjectanswer" class="subjectanswerA" value="A">A
											</label> <label class="radio-inline"> <input type="radio"
												name="subjectanswer" class="subjectanswerB" value="B">B
											</label> <label class="radio-inline"> <input type="radio"
												name="subjectanswer" class="subjectanswerC" value="C">C
											</label> <label class="radio-inline"> <input type="radio"
												name="subjectanswer" class="subjectanswerD" value="D">D
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">试题解析</label>
										<div class="col-md-10">
											<textarea class="form-control subjectparse" rows="3"
												name="subjectparse"></textarea>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-default"
							onclick="updateTestSubmit()">提交更改</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
	<!--查看试题模态框(Modal)-->
	<div class="modal fade" id="viewTest" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">查看试题</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-md-2" for="problem">试题题目</label>
									<div class="col-md-10" id="problem">
										<input class="form-control subjecttitle" disabled>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-2">答案A</label>
									<div class="col-md-10">
										<input class="form-control subjectoptiona" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-2">答案B</label>
									<div class="col-md-10">
										<input class="form-control subjectoptionb" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-2">答案C</label>
									<div class="col-md-10">
										<input class="form-control subjectoptionc" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-2">答案D</label>
									<div class="col-md-10">
										<input class="form-control subjectoptiond" disabled>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label">正确答案</label>
									<div class="col-md-10">
										<label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" class="subjectanswerA" value="A"
											disabled>A
										</label> <label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" class="subjectanswerB" value="B"
											disabled>B
										</label> <label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" class="subjectanswerC" value="C"
											disabled>C
										</label> <label class="radio-inline"> <input type="radio"
											name="optionsRadiosInline" class="subjectanswerD" value="D"
											disabled>D
										</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">试题解析</label>
									<div class="col-md-10">
										<textarea class="form-control subjectparse" rows="3" disabled></textarea>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<button type="button" class="btn btn-default btn-lg"
							data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

	<!-- 删除模态框（Modal） -->
	<div class="modal fade" id="deleteTest" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabe212">
						<i class="fa fa-info-circle"></i>&nbsp;提示
					</h4>
				</div>
				<div class="modal-body">试题删除成功！</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->

		</div>
		<!-- /.modal -->
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<!-- 设置查看，更新，删除事件 -->
	<script type="text/javascript">
			/* 提交表单进行搜索 */
			function submit(){
				$("#searchForm").submit();
			}
			/* 查看试题js方法 */
			function viewTest(subjectid){
				$.ajax({
					   type: "POST",
					   url: "${pageContext.request.contextPath}/managerTest/viewTest",
					   data: "subjectid="+subjectid,
					   dataType:"json",
					   success: function(data){
						   $(".subjectid").val(data.subjectid);
					    	$(".subjecttitle").val(data.subjecttitle);
					    	$(".subjectoptiona").val(data.subjectoptiona);
					    	$(".subjectoptionb").val(data.subjectoptionb);
					    	$(".subjectoptionc").val(data.subjectoptionc);
					    	$(".subjectoptiond").val(data.subjectoptiond);
					    	if(data.subjectanswer=="A"){
					    		$(".subjectanswerA").attr("checked","checked");
					    	}else if(data.subjectanswer=="B"){
					    		$(".subjectanswerB").attr("checked","checked");
					    	}else if(data.subjectanswer=="B"){
					    		$(".subjectanswerC").attr("checked","checked");
					    	}else{
					    		$(".subjectanswerD").attr("checked","checked");
					    	} 
					    	$(".subjectparse").val(data.subjectparse);
					   }
					});
			}
			/* 删除试题 */
			function deleteTest(subjectid){
				if(confirm("你确定要删除当前试题吗?")){
					$.ajax({
						  type: "POST",
						  url: "${pageContext.request.contextPath}/managerTest/deleteTest",
						  data: "subjectid="+subjectid,
						  dataType:"json",
						  success:function(data){
							  if(data.status==200){
								 alert("试题删除成功!");
								 window.location.reload();
							  }else{
								  alert("删除失败!");
							  }
						  }
					})
				}
			}
			/* 更新试题 */
			function updateTestSubmit(){
				$.ajax({
					type: "POST",
					  url: "${pageContext.request.contextPath}/managerTest/updateTest",
					  data: $("#updateTestForm").serialize(),
					  dataType:"json",
					  success:function(data){
						  if(data.status==200){
							 alert("试题更新成功!");
							 window.location.reload();
						  }else{
							  alert("更新失败!");
						  }
					  }
				})
			}
			
		</script>

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

</body>

</html>
