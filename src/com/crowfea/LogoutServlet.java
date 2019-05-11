package com.crowfea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
        String category=request.getParameter("category");
        
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
       
        
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setCategory(category);
    
        
        //user.setRole(Integer.parseInt(role));
        
       
        
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
       
        if(dao.delUser(user)){
        	out.print("<script>alert('É¾³ý³É¹¦');window.location.href='Logout.jsp'</script>");
        }
        else{
        	out.print("<script>alert('É¾³ýÊ§°Ü');window.location.href='Logout.jsp'</script>");
        }
	}

}
