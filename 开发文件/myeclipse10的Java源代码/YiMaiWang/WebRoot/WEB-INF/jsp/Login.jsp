<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link type="text/css" rel="stylesheet" href="statics/css/style.css" />
</head>
<script type="text/javascript"
	src="tatics/js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript"
	src="statics/js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="statics/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="statics/js/menu.js"></script>
<script type="text/javascript" src="statics/js/select.js"></script>
<script type="text/javascript" src="statics/js/lrscroll.js"></script>
<script type="text/javascript" src="statics/js/iban.js"></script>
<script type="text/javascript" src="statics/js/fban.js"></script>
<script type="text/javascript" src="statics/js/f_ban.js"></script>
<script type="text/javascript" src="statics/js/mban.js"></script>
<script type="text/javascript" src="statics/js/bban.js"></script>
<script type="text/javascript" src="statics/js/hban.js"></script>
<script type="text/javascript" src="statics/js/tban.js"></script>
<script type="text/javascript" src="statics/js/lrscroll_1.js"></script>
<body>
	<div class="soubg">
		<div class="sou">
			<span class="fr"> <span class="fl">你好，${loginName}请<a
					href="Login.html">登录</a>&nbsp; &nbsp; </span> <span class="fl">|&nbsp;关注我们：</span>
				<span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#"
					class="sh2">微信</a> </span> <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
						src="statics/images/s_tel.png" align="absmiddle" /> </a> </span> </span>
		</div>
	</div>
	<div class="log_bg">
		<div class="top">
			<div class="logo">
				<a href="Index.html"><img src="statics/images/logo.png" /> </a>
			</div>
		</div>
		<div class="login">
			<div class="log_img">
				<img src="statics/images/l_img.png" width="611" height="425" />
			</div>
			<div class="log_c">
				<form action="selectUser" method="post">
					<table border="0"
						style="width:370px; font-size:14px; margin-top:30px;"
						cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td width="55">&nbsp;</td>
							<td><span class="fl" style="font-size:24px;">登录</span> <span
								class="fr">还没有商城账号，<a href="regist"
									style="color:#ff4e00;">立即注册</a> </span></td>
						</tr>
						<tr height="70">
							<td>用户名</td>
							<td><input type="text" value="${loginName}" class="l_user"
								name="loginName"  required placeholder="请输入用户名"/>
							</td>
						</tr>
						<tr height="70">
							<td>密&nbsp; &nbsp; 码</td>
							<td><input type="password" value="${password}" class="l_pwd"
								name="password" required placeholder="请输入密码"/><br>
								${no}
							</td>
						</tr>
						
						<tr>
							<td>&nbsp;</td>
							<td style="font-size:12px; padding-top:20px;"><span
								style="font-family:'宋体';" class="fl"> <label
									class="r_rad"><input type="checkbox" /> </label><label
									class="r_txt">请保存我这次的登录信息</label> </span> <span class="fr"><a
									href="#" style="color:#ff4e00;">忘记密码</a> </span></td>
						</tr>
						<tr height="60">
							<td>&nbsp;</td>
							<td><input type="submit" value="登录" class="log_btn" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="btmbg">
		<div class="btm">
			备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018
			尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
			<img src="statics/images/b_1.gif" width="98" height="33" /><img
				src="statics/images/b_2.gif" width="98" height="33" /><img
				src="statics/images/b_3.gif" width="98" height="33" /><img
				src="statics/images/b_4.gif" width="98" height="33" /><img
				src="statics/images/b_5.gif" width="98" height="33" /><img
				src="statics/images/b_6.gif" width="98" height="33" />
		</div>
	</div>
</body>
<!-- 现在，作为站长的你可以为消灭 IE6 尽一份力，为自己的网站添加“Let’s Kill IE6”口号，当用户在使用 IE6 浏览器访问网站时就会弹出如上图的提示信息，让我们一起加速 IE6 的灭亡！ -->
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
</html>
