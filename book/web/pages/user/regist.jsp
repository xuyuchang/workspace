<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%--	静态包含base标签、css样式、JQuery样式--%>
<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {


			$("#username").blur(function () {
				//获取用户名
				var username = this.value;
				//发起jaxa请求
				$.getJSON("userServlet","action=ajaxExistsUsername&username=" + username,function (data) {
					if (data.username){
						$("span.errorMsg").text("用户名已存在");
					}else{
						$("span.errorMsg").text("用户名可用");
					}

				})
			})
			//给验证码图片绑定单击事件
			$("#code_jpg").click(function () {
				//alert(this.src)
				this.src = "${basepath}kaptchaServlet.jpg?id="+Math.random();
			});

			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				//验证用户名
				var usernameText = $("#username").val();
				var usernamePatt = /^\w{5,12}$/;
				if (!usernamePatt.test(usernameText)){
					$("span.errorMsg").text("用户名不合法");
					return false;
				}
				//验证密码
				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if (!passwordPatt.test(passwordText)){
					$("span.errorMsg").text("密码不合法");
					return false;

				}
				//确认密码
				var repwdText = $("#repwd").val();
				if (passwordText != repwdText){
					$("span.errorMsg").text("两次密码不一样");
					return false;
				}
				//确认邮箱
				var emailText = $("#email").val();
				var emailPatt =  /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,})$/;
				if (!emailPatt.test(emailText)){
					$("span.errorMsg").text("邮箱格式错误");
					return false;
				}
				$("span.errorMsg").text("");

			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   value="${requestScope.username}"
										   autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   value="${requestScope.email}"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 85px;" id="code"/>
									<img alt="" id="code_jpg" src="kaptchaServlet.jpg" style="float: right; width: 85px;height: 45px;margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册"  id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%--	静态包含页脚信息--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>