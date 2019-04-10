package com.crowfea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClazzServlet
 */
@WebServlet("/ClazzAddServlet")
public class ClazzAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClazzAddServlet() {
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
        String clazzid = request.getParameter("clazzid");
        String clazzname = request.getParameter("clazzname");
        String teaname = request.getParameter("teaname");
        String stuid=request.getParameter("stuid");
        
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        Clazz clazz=new Clazz();
        clazz.setClazzid(clazzid);
        clazz.setClazzname(clazzname);
        clazz.setTeaname(teaname);
        
        //user.setRole(Integer.parseInt(role));
        ClazzDao dao = new ClazzDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        out.print("链接成功！");
        if(dao.addClazz(stuid,clazz)){
            out.print("添加成功！");
        }
        else{
            out.print("添加失败！");
        }
	}

}
