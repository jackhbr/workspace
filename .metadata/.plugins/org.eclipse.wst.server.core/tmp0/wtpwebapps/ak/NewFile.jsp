<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%   //这个jsp文件是处理返回的数据的
String username = request.getParameter("username");  //根据组件的name属性来识别，这就是form表单，form必须是全面刷新，ajax则可以局部刷新
String password = request.getParameter("password"); 
System.out.print(username);//这个在控制台上也是可以输出的
if("admin".equals(username) && "11".equals(password))  //if和else后面无论是单个还是多个语句都要加上大括号！！！
{
	%>
	<p>login success</p>
<% 
}
else

{
%>
<p>login fail!</p>
<%} %>

</body>
</html>