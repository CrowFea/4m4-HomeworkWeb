package com.crowfea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetPassServle
 */
@WebServlet("/ResetPassServlet")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
      
        String username = request.getParameter("username");
        
        String userpass=request.getParameter("userpass");
        
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
       
        
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        
        //user.setRole(Integer.parseInt(role));
        
       
        
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        out.print("链接成功！");
        if(dao.editUser(user)){
        	out.print("<script>alert('修改成功');window.location.href='index.jsp'</script>");
        }
        else{
        	out.print("<script>alert('修改失败');window.location.href='index.jsp'</script>");
        }
	}

}
