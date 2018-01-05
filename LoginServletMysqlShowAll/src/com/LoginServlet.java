package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//编码要全都转换为utf-8编码，否则会出错，而且数据库上的数据编码也要改为utf-8编码，否则会出现错误

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");
        //获取用户名和密码
		List<User> userList = new ArrayList<User>();
        String username = request.getParameter("username");
        //在get方法中就要用这种转换编码的形式，否则中文会转为乱码
        username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        

        String password = request.getParameter("password");
        //获取UserDao实例
        System.out.println("输入的账户名为"+username+" 输入的密码为"+password);
        UserDao userDao = new UserDao();

        User user = userDao.login(username,password);
        // 判断user是否为空
        if(user != null){
        // 转发到LoginSuccess.jsp页面
        //  getRequestDispatcher()是请求转发
        	userList= userDao.getAll();
        	request.setAttribute("userList", userList); //类似于在不同的类中传递参数一样，把这个uselist传到了loginsuccess.jsp那里进行处理，还给他贴上来标签 
             
        	
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }else{
        // 登录失败
            request.getRequestDispatcher("LoginFailed.jsp").forward(request, response);
                }
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);//不是很懂为什么要在dopost中调用doget呢？？而且大家都这么调用
    }
//    一次请求过来的时候，首先调用的是service方法
//    然后根据你的form表单是post则调用doPost（）方法，get则调用doGet（）方法，如果不写，默认为doGet方法
//    所以，一般情况下，doGet（）和doPost（）是有一个要被执行的。

}
