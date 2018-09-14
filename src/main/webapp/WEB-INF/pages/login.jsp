<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

       <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title text-center">在线考试系统</h3>
                        <label id="tip"></label>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="${pageContext.request.contextPath }/user/loginCheck">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="账号" name="userId" type="text" id="userId" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" type="password"  id="password">
                                </div>
                                <div class="form-group">
                                    <label class="radio-inline">
                                        <input type="radio" name="role" id="optionsRadiosInline1" value="teacher" checked>教师登录
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="role" id="optionsRadiosInline2" value="student">学生登录
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a class="btn btn-lg btn-success btn-block" 
                                onclick="checkLogin($('#userId').val(),$('#password').val())">Login</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
    
    <script>
    	//用户登录
    	function checkLogin(userId,password){
    		$.ajax({
    			   type: "POST",
    			   url: "${pageContext.request.contextPath}/user/loginCheck",
    			   data: "userId="+userId+"&password="+password+"&role="+$("input[name='role']:checked").val(),
    			   dataType:"json",
    			   success: function(data){
    			     if(data.status!=200){
    			    	 //如果登录失败，显示错误信息
    			    	 $("#tip").html(data.msg.fontcolor("red"));
    			     }else{
    			    	 //如果登录成功，页面跳转
    			    	 if(data.msg=="teacher"){
    			    		 window.location.href="${pageContext.request.contextPath}/";
    			    	 }else{
    			    		 window.location.href="${pageContext.request.contextPath}/student/test";
    			    	 }
    			     }
    			   }
    			});
    	}
    </script>

</body>

</html>
