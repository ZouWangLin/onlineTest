<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/vendor/jquery/jquery-1.11.3.min.js"></script>

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
<script
	src="${pageContext.request.contextPath}/js/jquery.ocupload-1.1.2.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

<script type="text/javascript">
	$(function() {
		/* 设置一键导入事件 */
		$("#oneImport").upload({
			action : "${pageContext.request.contextPath}/import/batchImport",
			name : "importFile",
	        onComplete: function (data, self, element) {
	        	console.info(data);
	        	if(data){
	        		$('#uploadSuccess').modal();
	        	}else{
	        		$('#uploadError').modal();
	        	}},
				onSelect:function (self, element) {  
		        	//当选择文件后触发，可以检测文件是否合法
		            this.autoSubmit = false;  
		 			//获取当前文件名
		            var fileName=$("input[name='importFile']").val();
		 			//书写正则表达式
		 			var reg=/^.{1,}\.{1}(xls|xlsx){1}$/;
		 			if(reg.test(fileName)){
		 				this.submit();  
		 			}else{
		 				$('#uploadError').modal(); 
		 			}
		        }
		})
	})
</script>

</head>

<body>

	<div id="wrapper">

		<jsp:include page="common/header.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">录入试题</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-4">
									<h4 class="fa fa-info-circle" style="margin-top: 15px">贴心小提示：一键导入可以加快工作效率</h4>
								</div>
								<div class="col-md-offset-6 col-md-2">
									<button type="button" class="btn btn-primary btn-lg btn-outline"
										id="oneImport">一键导入</button>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-md-offset-2 col-md-8">
									<form role="form" class="form-horizontal" id="submitForm" method="post" action="${pageContext.request.contextPath }/import/oneImport">
										<div class="form-group">
											<label class="control-label col-md-2" for="problem">试题题目</label>
											<div class="col-md-10" id="problem">
												<input class="form-control" name="subjecttitle">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-md-2">答案A</label>
											<div class="col-md-10">
												<input class="form-control" name="subjectoptiona">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2">答案B</label>
											<div class="col-md-10">
												<input class="form-control" name="subjectoptionb">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2">答案C</label>
											<div class="col-md-10">
												<input class="form-control" name="subjectoptionc">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2">答案D</label>
											<div class="col-md-10">
												<input class="form-control" name="subjectoptiond">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-2 control-label">正确答案</label>
											<div class="col-md-10">
												<label class="radio-inline"> <input type="radio"
													name="subjectanswer" id="optionsRadiosInline1"
													value="A" checked>A
												</label> <label class="radio-inline"> <input type="radio"
													name="subjectanswer" id="optionsRadiosInline2"
													value="B">B
												</label> <label class="radio-inline"> <input type="radio"
													name="subjectanswer" id="optionsRadiosInline3"
													value="C">C
												</label> <label class="radio-inline"> <input type="radio"
													name="subjectanswer" id="optionsRadiosInline4"
													value="D">D
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-2 control-label">试题解析</label>
											<div class="col-md-10">
												<textarea class="form-control" rows="3" name="subjectparse"></textarea>
											</div>
										</div>
										<div class="col-md-4 col-md-offset-4">
											<button type="submit" class="btn btn-default">录入</button>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="reset" class="btn btn-default">重置</button>
										</div>
									</form>
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
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- 上传成功模态框 -->
	<div class="modal fade" id="uploadSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<i class="fa fa-info-circle"></i>
					上传提示
				</h4>
			</div>
			<div class="modal-body">
				上传成功!
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
	<!-- 上传失败模态框 -->
	<div class="modal fade" id="uploadError" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<i class="fa fa-info-circle"></i>
					上传提示
				</h4>
			</div>
			<div class="modal-body">
				上传失败!只可以导入xls或者xlsx文件哦!
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>


</body>

</html>
