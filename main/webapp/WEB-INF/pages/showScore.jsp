<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题解析</title>
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
	<!-- 使用将当前页面转换成pdf，一定要有
		<div class="container">
			<div id="content"></div>
		</div>
		这种结构
	 -->
	<div id="wrapper">
		<div class="container">
		<div class="row" id="content">
			<div class="col-lg-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="text-center">
							${sessionScope.student.username }考试情况分析 <small
								class="text-danger">考试得分:${requestScope.e3Result.msg }</small>
						</h3>
						<label>选择题模块:总时长30分钟，总分100分，每题10分</label>
					</div>
					<div class="panel-body">
						<form
							action="${pageContext.request.contextPath }/student/calcStudentScore"
							method="post" id="calcForm">
							<c:forEach items="${requestScope.e3Result.data }" var="subject"
								varStatus="Index">
								<div class="row">
									<div class="col-md-12" style="margin-bottom: 8px;">
										${Index.count }、${subject.subjecttitle }</div>
								</div>
								<div class="row">
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="A-${subject.subjectid }"
											disabled ${subject.studentAnswer=='A'?'checked':'' }>A.${subject.subjectoptiona }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="B-${subject.subjectid }"
											disabled ${subject.studentAnswer=='B'?'checked':'' }>B.${subject.subjectoptionb }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px;">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="C-${subject.subjectid }"
											disabled ${subject.studentAnswer=='C'?'checked':'' }>C.${subject.subjectoptionc }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px;">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="D-${subject.subjectid }"
											disabled ${subject.studentAnswer=='D'?'checked':'' }>D.${subject.subjectoptiond }
										</label>
									</div>

									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px;">
										<p style="margin-bottom: 5px;">
											<font class='text-danger' style="font-size: 17px;">试题分析：</font>
											你的答案<span class="text-danger text-inline">${subject.studentAnswer }</span>,
											正确答案<span class="text-danger">${subject.subjectanswer }</span>.
										</p>
										<p style="margin-bottom: 2px;">
											&nbsp;&nbsp;&nbsp;&nbsp;${subject.subjectparse }</p>
									</div>
								</div>
							</c:forEach>
						</form>

						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<button type="button"
									class="btn btn-outline btn-primary btn-lg btn-block"
									id="down">下载试卷</button>
							</div>
						</div>


					</div>
					<div class="panel-footer">
						<span class="fa fa-info-circle"></span>考试需知：考生不可以使用电子设备进行作弊，一旦发现此种情况。该考生成绩作废，并做出严肃的处理!
					</div>
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


<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

<!-- 导出pdf文件 -->
<script src="${pageContext.request.contextPath }/js/jspdf.debug.js"></script>
<script src="${pageContext.request.contextPath }/js/html2canvas.js"></script>
<script type="text/javascript">
	//1.提交试卷方法
	function submit() {
		$("#calcForm").submit();
	}
	//2.导出pdf文件
	document.getElementById("down").onclick = function(){

    html2canvas(document.getElementById("content"), {
        onrendered: function(canvas) {

            //通过html2canvas将html渲染成canvas，然后获取图片数据
            var imgData = canvas.toDataURL('image/jpeg');

            //初始化pdf，设置相应格式
            var doc = new jsPDF("p", "mm", "a1");

            //这里设置的是a4纸张尺寸
            doc.addImage(imgData, 'JPEG', 0, 0,594,841);

            //输出保存命名为content的pdf
            doc.save('content.pdf');
        }
    });

}

</script>
</html>