package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	User user = null;
    private String SQL =""; 
    List<User> userList = new ArrayList<User>();  
    public User login(String username, String password){
        SQL = "select * from login_info where username = ? and password = ?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBDao.getConnection();
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            //这里的意思将用户名和密码填到SQL语句的问号处
            pstmt.setString(1, username);   //这种方法值得学习
            pstmt.setString(2, password);
            ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果,一个数据集
            //判断结果集是否有效
            if(rSet.next()){
                user = new User();
                user.setUsername(rSet.getString("username"));
                user.setPassword(rSet.getString("password"));
                System.out.println("asdasdas");
                System.out.println(user.getUsername()+"  "+user.getPassword());
                
            }
            connection.close();
            pstmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            DBDao.closeConnection(connection);
        }
        return user;
    }
    
    public  List<User>  getAll()
    {
    	Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;  
        SQL = "select * from login_info";
        try {
            connection = DBDao.getConnection();
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            //这里的意思将用户名和密码填到SQL语句的问号处
         
            rs = pstmt.executeQuery();//得到数据库的查询结果,一个数据集
            //判断结果集是否有效
            while(rs.next()){
            	 String username = rs.getString("username");  
                 String password = rs.getString("password");  
                 user = new User();
                 user.setPassword(password);
                 user.setUsername(username);
                 System.out.println("获取的名字为"+username+" 获取的密码为"+password);
                 userList.add(user);  
                
            }
            connection.close();
            pstmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            DBDao.closeConnection(connection);
        }
        return userList;
    }
    
   public List<String> getAllUserName()
   {
	   List<String> usernameList = new ArrayList<String>(); 
	   SQL = "select username from login_info";
       Connection connection = null;
       PreparedStatement pstmt = null;
       try {
           connection = DBDao.getConnection();
           pstmt = (PreparedStatement) connection.prepareStatement(SQL);
           ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果,一个数据集
           //判断结果集是否有效
           while(rSet.next()){
        	   String username = rSet.getString("username"); 
               System.out.println(username);
               usernameList.add(username);
           }
           connection.close();
           pstmt.close();
       } catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }finally{
           DBDao.closeConnection(connection);
       }
       return usernameList;
   }
    

}
