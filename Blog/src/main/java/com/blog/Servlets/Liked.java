package com.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.blog.Dao.LikedDao;
import com.blog.connection.ConnectionProvider;

/**
 * Servlet implementation class Liked
 */

public class Liked extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // Retrieving parameters sent from AJAX request
        String operation = request.getParameter("operation");
        int pid = Integer.parseInt(request.getParameter("pid"));
        int uid = Integer.parseInt(request.getParameter("uid"));

        
        
        LikedDao l=new LikedDao(ConnectionProvider.getcon());
        if ("like".equals(operation)) {
            
        	boolean likedone=l.inserLike(pid, uid);
            out.print(likedone);
        } else {
            out.print("Invalid operation");
        }
    }
}
