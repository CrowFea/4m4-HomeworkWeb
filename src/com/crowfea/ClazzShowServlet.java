package com.crowfea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class clazzShowServlet
 */
@WebServlet("/ClazzShowServlet")
public class ClazzShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClazzShowServlet() {
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
        PrintWriter out = response.getWriter();
        
        
        
        HttpSession session = request.getSession();
        String stuid = (String)session.getAttribute("username");
         
        
        out.print(stuid);
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        
        
        ClazzDao dao = new ClazzDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        
        List<Clazz> clazzList = new ArrayList<Clazz>();
        clazzList=dao.getClazz(stuid);
        //out.print("获取成功！");
        
        //for(int i=0;i<clazzList.size();i++) {
        //	Clazz clazzS=(Clazz) clazzList.get(i);
        //	out.println(clazzS.getClazzid());
        	
        //}
        //out.print("显示成功！");
        
        
        //request.setAttribute("clazzList", clazzList);  
        //request.getRequestDispatcher("pages/Test.jsp").forward(request, response);  
        
        //request.setAttribute("stuid", stuid);  
        //request.getRequestDispatcher("pages/Test.jsp").forward(request, response);  
        
        response.sendRedirect("pages/Test.jsp");
	}

}
