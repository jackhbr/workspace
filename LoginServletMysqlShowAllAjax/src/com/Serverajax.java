package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serverajax extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username = req.getParameter("username");
		
		 username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		 System.out.println("�����usernameΪ"+username);
		 UserDao userDao = new UserDao();
		 
		 List<String> usernameList = new ArrayList<String>(); 
		 usernameList=userDao.getAllUserName();
		 for (String s : usernameList)  
	        {  
	            if(s.equals(username))  
	            {  
	                resp.getWriter().write("<font color='green'>that is right</font>");  
	                return;  
	            }  
	              
	        }  
	        resp.getWriter().write("<font color='red'>sorry��the name is not exist</font>");  
	        resp.getWriter().flush(); 
	}

}
