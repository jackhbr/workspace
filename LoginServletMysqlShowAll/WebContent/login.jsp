<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    
    <%
    
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>登录界面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <!--判断是否为空   论正确引入jq文件的重要性！！！-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
     <script type="text/javascript" > <!-- 这个js函数在form表单提交时被调用，如果不能通过（因为return false）则继续停留在界面内 -->
        
     
     $(document).ready(function(){
    	  $("#username").focus(function(){  //这个要给元素加上id的标签，然后根据便签进行选择函数运行
    		 
    		 // alert("focususername!!");
    	  });
    	  $("#username").blur(function(){
    		 if($("#username").val()=="")
    			  //alert("输入的用户名为"+$("#username").val());	 
    		 {
    			 alert("请不要输入空的用户名");
    		 }
    		 
    		 
    		 //alert("输入的用户名为"+$("#username").val());
    			 
    	  });
    	  
    	  $("#password").blur(function(){
    		  
    		  if($("#password").val()=="")
    			  //alert("输入的用户名为"+$("#username").val());
    			 
    		 {
    			 alert("请不要输入空的密码");
    		 }
    		 else if($("#password").val().length!=6)
    		 
    			 {
    			 alert("请输入六位数字的密码");
    			 }
    	  })
    	/*  $("input").blur(function(){
    		  alert("input are blur!");
    	  });*/
    	});
     
     
     function login(form){
            if(form.username.value == ""){
                alert("用户不能为空！");
                return false;
            }
         
            if(form.password.value == ""){
                alert("密码不能为空！");
                return false;
            }
            if(form.password.value.length!=6){
            	alert("请输入6位数字的密码");
            	return false;
            	}   
        }
     
    
    </script>
  </head>

  <body>
  
     <center>                        <!-- 下面这种跳转方式比较清晰靠谱 -->
         <form method="post" action="http://localhost:8080/LoginServletMysqlShowAll/LoginServlet" onSubmit="return login(this);">
             用户名：<input type="text" name="username" id="username" ><br>
             密码：<input type="password" name="password" id="password"><br>
             登录角色：<select value="role">
                 <option value="普通用户" selected>普通用户</option>
                 <option value="管理员">管理员</option>
                 </select>
                 <br>
            <input type="submit" value="登录">
            <input type="reset" value="重置">
        </form> 
    </center>
  </body>
</html>