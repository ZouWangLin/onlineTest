<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生考试模块</title>
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
		<div class="row">
			<div class="col-lg-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="text-center">
							在线驾考模拟 <small id="lastTime"></small>
						</h3>
						<label>选择题模块:总时长30分钟，总分100分，每题10分</label>
					</div>
					<div class="panel-body">
						<form
							action="${pageContext.request.contextPath }/student/calcStudentScore"
							method="post" id="calcForm">
							<c:forEach items="${requestScope.datas }" var="subject"
								varStatus="Index">
								<div class="row">
									<div class="col-md-12" style="margin-bottom: 8px;">
										${Index.count }、${subject.subjecttitle }</div>
								</div>
								<div class="row rowquestion">
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="A-${subject.subjectid }">A.${subject.subjectoptiona }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="B-${subject.subjectid }">B.${subject.subjectoptionb }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px;">
										<label class="radio-inline"> <input type="radio"
											name="result[${Index.index }]"
											value="C-${subject.subjectid }">C.${subject.subjectoptionc }
										</label>
									</div>
									<div class="form-group col-md-12"
										style="margin-bottom: 5px; padding-left: 25px;">
										<label class="radio-inline"> 
										<input type="radio"
											name="result[${Index.index }]"
											value="D-${subject.subjectid }">D.${subject.subjectoptiond }
										</label>
									</div>
									<!-- 用户如果不选择的话，设置默认选项为E -->
										<input type="radio" class="hidden"
											name="result[${Index.index }]"
											value="未作答-${subject.subjectid }" checked>
									
								</div>
							</c:forEach>
						</form>

						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<button type="button"
									class="btn btn-outline btn-primary btn-lg btn-block"
									onclick="submit()">提交试卷</button>
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

<script type="text/javascript">
	//1.提交试卷方法
	function submit() {
		$("#calcForm").submit();

	}

	showTime();
	function showTime() {
		var myData = new Date(); //获取当前时间
		var endTime = new Date("${sessionScope.times}"); //设定倒计时结束时间
		var lefttime = (endTime.getTime() - myData.getTime());
		lefttime = Math.ceil(lefttime) //对得到的毫秒数进行四舍五入

		var leftHMS = parseInt((endTime.getTime() - myData.getTime()) / 1000); //得到剩余的毫秒数

		var fz = parseInt(leftHMS / 60 % 60); //得到分钟
		var mz = parseInt(leftHMS % 60); //得到秒数

		function checkTime(i) {
			if (i < 10) {
				return '0' + i;
			} else {
				return i;
			}
		}
		;
		//打印出倒计时
		$("#lastTime").html((fz + '分钟' + mz + '秒').fontcolor("red"));
		if (fz == 0 && mz == 0) {
			alert("考试时间到了，系统自动提交试卷");
			$("#calcForm").submit();
		}
	}
	setInterval(function() {
		showTime();
	}, 1000)
</script>
</html>