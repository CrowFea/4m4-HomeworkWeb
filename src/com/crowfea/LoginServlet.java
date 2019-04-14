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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        ServletContext ctx = request.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");       
        DBOper db = new DBOper();
        db.getConn(server, dbname, dbuser, dbpwd);
        String sql = "SELECT username,password FROM user WHERE username = ? AND password = ?";
        
        ResultSet rs = db.executeQuery(sql,new String[]{username,userpass});
        try {
            if(rs != null && rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String logtime = sdf.format(new Date()); 
                session.setAttribute("logtime",logtime);
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                
                
                ClazzDao dao = new ClazzDao();
                dao.getConn(server, dbname, dbuser, dbpwd);
                
                List<Clazz> clazzList = new ArrayList<Clazz>();
                clazzList=dao.getClazz(username);
                
                out.print("<script>alert('��½��');window.location.href='Login.jsp'</script>");
                request.setAttribute("clazzList", clazzList);  
                request.getRequestDispatcher("pages/Test.jsp").forward(request, response);  
                
                response.sendRedirect("pages/Test.jsp");
            }else{
            	out.print("<script>alert('��������ȷ���˺�����');window.location.href='index.jsp'</script>");
            	
                //out.print("��¼ʧ��");
                //out.print("<br><a href = 'index.jsp'>���µ�½</a>");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void init()throws ServletException {

    }

}
