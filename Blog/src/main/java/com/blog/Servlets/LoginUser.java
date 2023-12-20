package com.blog.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.blog.Dao.UserDao;
import com.blog.connection.ConnectionProvider;
import com.blog.entities.User;
import com.blog.helper.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 String email=request.getParameter("email");
	 String password=request.getParameter("password");

	 response.setContentType("text/html");
	 PrintWriter out=response.getWriter();

	 UserDao dao=new UserDao(ConnectionProvider.getcon());
	 User u=dao.getUser(email, password);
	 if(u!=null)
	 {

		 HttpSession sess=request.getSession();
		 sess.setAttribute("user", u);
		 response.sendRedirect("profile.jsp");


	 }
	 else
	 {
		 String mesg="Incorrect Message and Password";
		 String alert="alert-danger";
		 Message m=new Message(mesg,alert);
		 HttpSession sess=request.getSession();
		 sess.setAttribute("Msg", m);
		 response.sendRedirect("Register_Login/login.jsp");



		 out.println("<h1>Incorrect Email Id or Password</h1>");

	 }






	}

}
