package com.crowfea;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClazzDao extends DBOper{
	public void createTable(String stuid) {
		
		 Statement stmt = null;
		 try {
			stmt = conn.createStatement();
			String table="stu"+stuid;
			String sql = "CREATE TABLE IF NOT EXISTS `table`(`clazzid` varchar(50) NOT NULL ,"
					+ "`clazzname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`teaname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,"
					+ "PRIMARY KEY (`clazzid`)) "
					+ "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
			
			
			sql=sql.replace("table", table);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//this.executeQuery(sql,null);
		
	}
	
    //获取用户列表
    public List<Clazz> getClazz(String stuid){
    	List<Clazz>clazzList = new ArrayList<Clazz>();
        Clazz clazz = new Clazz();
        String sql = "SELECT * FROM user";
        try{
            ResultSet rs = this.executeQuery(sql,null);
            while(rs.next()){
                clazz.setClazzid(rs.getString("username"));
                clazz.setClazzname(rs.getString("password"));
                clazz.setTeaname(rs.getString("category"));
                clazzList.add(clazz);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return clazzList;
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
    //添加课程
    public boolean addClazz(String stuid,Clazz clazz){
    	
       boolean r = false;
       createTable(stuid);
       String table="stu"+stuid;
        String sql = "INSERT INTO table (clazzid,clazzname,teaname)VALUES(?,?,?) ";
        sql=sql.replace("table",table);
        
        try{
            int num = this.executeUpdate(sql,new String[]{clazz.getClazzid(),clazz.getClazzname(),clazz.getTeaname()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        

        return r;
    }
    //删除课程
    public boolean delClazz(String stuid,Clazz clazz){
        boolean r = false;
        String sql = "DELETE FROM stu"+stuid+" WHERE clazzid = ?";
        try{
            int num = this.executeUpdate(sql,new String[]{clazz.getClazzid()});
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
