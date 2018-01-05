package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����Ҫȫ��ת��Ϊutf-8���룬���������������ݿ��ϵ����ݱ���ҲҪ��Ϊutf-8���룬�������ִ���

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");
        //��ȡ�û���������
		List<User> userList = new ArrayList<User>();
        String username = request.getParameter("username");
        //��get�����о�Ҫ������ת���������ʽ���������Ļ�תΪ����
        username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        

        String password = request.getParameter("password");
        //��ȡUserDaoʵ��
        System.out.println("������˻���Ϊ"+username+" ���������Ϊ"+password);
        UserDao userDao = new UserDao();

        User user = userDao.login(username,password);
        // �ж�user�Ƿ�Ϊ��
        if(user != null){
        // ת����LoginSuccess.jspҳ��
        //  getRequestDispatcher()������ת��
        	userList= userDao.getAll();
        	request.setAttribute("userList", userList); //�������ڲ�ͬ�����д��ݲ���һ���������uselist������loginsuccess.jsp������д�����������������ǩ 
             
        	
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }else{
        // ��¼ʧ��
            request.getRequestDispatcher("LoginFailed.jsp").forward(request, response);
                }
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);//���Ǻܶ�ΪʲôҪ��dopost�е���doget�أ������Ҵ�Ҷ���ô����
    }
//    һ�����������ʱ�����ȵ��õ���service����
//    Ȼ��������form����post�����doPost����������get�����doGet���������������д��Ĭ��ΪdoGet����
//    ���ԣ�һ������£�doGet������doPost��������һ��Ҫ��ִ�еġ�

}
