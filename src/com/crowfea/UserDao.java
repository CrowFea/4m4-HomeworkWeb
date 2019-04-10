package com.crowfea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBOper{
    //获取用户列表
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
    //根据用户名获取用户
    public User getUserByName(String name){
        User user = null;
        String sql = "SELECT * FROM tb_user WHERE　username = ?";
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
    //修改用户信息
    public boolean editUser(User user){
        boolean r = false;
        String sql = "UPDATE tb_user SET userpass = ?,role = ?,regtime = ?,lognum = ? WHERE username = ?";
        try{
            int num = this.executeUpdate(sql, new String[]{user.getUserpass(),""+user.getLognum(),user.getRegtime(),user.getUsername()});
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
    //添加用户
    public boolean addUser(User user){
        boolean r = false;
        
        
        //插入到user
        String sql = "INSERT INTO user (username,password,category)VALUES(?,?,?) ";
        try{
            int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getUserpass(),user.getCategory()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //插入到teaAll或者stuALL
        if(user.getCategory().equals("教师")) {
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
        else if(user.getCategory().equals("学生")) {
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
    //删除指定用户
    public boolean delUser(String name){
        boolean r = false;
        String sql = "DELETE FROM tb_user WHERE username = ?";
        try{
            int num = this.executeUpdate(sql,new String[]{name});
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
