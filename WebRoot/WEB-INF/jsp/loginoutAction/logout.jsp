<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>您已退出tzm OA系统</title>
	<link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border=0 /></div>
					<div id=LogoutOperate>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 /> <a href="${pageContext.request.contextPath}/loginout_loginUI.do">重新进入系统</a>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: window.close();">关闭当前窗口</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
