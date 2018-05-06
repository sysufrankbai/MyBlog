<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${request.info }</title>
<link rel="stylesheet" href="image/style.css" />
</head>

<body style="text-align:center" bgcolor="#f3f3f3">
		<form id="Form1" method="post">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr><td height="100"></td></tr>
				<tr>
					<td valign="top" align="center">
						<table width="400" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid;BORDER-TOP:#cccccc 1px solid;BORDER-LEFT:#cccccc 1px solid;BORDER-BOTTOM:#cccccc 1px solid;BORDER-COLLAPSE:collapse;BACKGROUND-COLOR:#ffffff">
							<tr style="height:30px"  style="background:(image/main/l-bg5.jpg)">
								<td colspan="2"  style="text-align:center"><font color="#ffff66"><b>${request.info }</b></font></td>
							</tr>
							<tr style="height:150px">
								<td colspan="2" style = "text-align:center">${request.info}</td>
								<% 
									String url = (String)request.getAttribute("url");
									response.setHeader("Refresh","2;url=" + url);
								%>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
