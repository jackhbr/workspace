package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	User user = null;
    private String SQL =""; 
    public User login(String username, String password){
        SQL = "select * from login_info where username = ? and password = ?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBDao.getConnection();
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            //�������˼���û����������SQL�����ʺŴ�
            pstmt.setString(1, username);   //���ַ���ֵ��ѧϰ
            pstmt.setString(2, password);
            ResultSet rSet = (ResultSet) pstmt.executeQuery();//�õ����ݿ�Ĳ�ѯ���,һ�����ݼ�
            //�жϽ�����Ƿ���Ч
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

}
