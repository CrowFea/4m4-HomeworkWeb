package com.crowfea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBOper{
    //��ȡ�û��б�
    public List<User> getUser(){
        List<User>userList = new ArrayList<User>();
        User user = new User();
        String sql = "SELECT * FROM user";
        try{
            ResultSet rs = this.executeQuery(sql,null);
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setUserpass(rs.getString("userpass"));
                user.setLognum(rs.getInt("lognum"));
                user.setRegtime(rs.getString("regtime"));
                userList.add(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return userList;
    }
    //�����û�����ȡ�û�
    public User getUserByName(String name){
        User user = null;
        String sql = "SELECT * FROM user WHERE��username = ?";
        try{            
            ResultSet rs = this.executeQuery(sql, new String[]{name});
            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setUserpass(rs.getString("userpass"));
                user.setLognum(rs.getInt("lognum"));
                user.setRegtime(rs.getString("regtime"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return user;
    }
    //�޸��û���Ϣ
    public boolean editUser(User user){
        boolean r = false;
        String sql = "UPDATE user SET password = ? WHERE username = ?";
        try{
            int num = this.executeUpdate(sql, new String[]{user.getUserpass(),user.getUsername()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return r;

    }
    //����û�
    public boolean addUser(User user){
        boolean r = false;
        
        
        //���뵽user
        String sql = "INSERT INTO user (username,password,category)VALUES(?,?,?) ";
        try{
            int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getUserpass(),user.getCategory()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //���뵽teaAll����stuALL
        if(user.getCategory().equals("��ʦ")) {
        	sql = "INSERT INTO teaAll (id,name,school)VALUES(?,?,?) ";
            try{
                int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getName(),user.getSchool()});
                if(num > 0){
                    r = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                this.closeAll();
            }
        }
        else if(user.getCategory().equals("ѧ��")) {
        	sql = "INSERT INTO stuAll (id,name,school)VALUES(?,?,?) ";
            try{
                int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getName(),user.getSchool()});
                if(num > 0){
                    r = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                this.closeAll();
            }
        }

        return r;
    }
    //ɾ��ָ���û�
    public boolean delUser(User user){
        boolean r = false;
        String sql = "DELETE FROM user WHERE username = ?";
        if(user.getCategory().equals("��ʦ")) {
        	sql = "DELETE FROM teaAll WHERE username = ?";
            try{
                int num = this.executeUpdate(sql,new String[]{user.getUsername()});
                if(num > 0){
                    r = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(user.getCategory().equals("ѧ��")) {
        	sql = "DELETE FROM stuAll WHERE username = ? ";
            try{
                int num = this.executeUpdate(sql,new String[]{user.getUsername()});
                if(num > 0){
                    r = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
         sql = "DELETE FROM user WHERE username = ?";
        try{
            int num = this.executeUpdate(sql,new String[]{user.getUsername()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return r;
    }
    
    
    
}
