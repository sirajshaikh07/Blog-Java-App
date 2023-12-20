package com.blog.Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import com.blog.Dao.UserDao;
import com.blog.connection.ConnectionProvider;
import com.blog.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("user");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String about=request.getParameter("about");
		String submit=request.getParameter("submit");
		String gender=request.getParameter("gender");

		int insert=0;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		if(submit.equals("submit"))
		{
//			User Data

		    User u =new User();
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			u.setAbout(about);
			u.setGender(gender);


//			UserDao
			UserDao dao=new UserDao(ConnectionProvider.getcon());
			if(dao.insertUser(u))
			{




				response.sendRedirect("Register_Login/login.jsp");



			}
			else
			{

				out.print("Data Not Inserted Succesfully");

			}







		}
		else
		{

			response.sendRedirect("index.jsp");


		}



	}

}
