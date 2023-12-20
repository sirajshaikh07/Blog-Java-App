package com.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.blog.Dao.PostDao;
import com.blog.connection.ConnectionProvider;
import com.blog.entities.Post;
import com.blog.entities.User;

/**
 * Servlet implementation class addpost
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class addpost extends HttpServlet {
	private static final String UPLOAD_DIRECTORY = "D:\\Eclipse\\Blog\\src\\main\\webapp\\post_img";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String postName=request.getParameter("bName");
		String content =request.getParameter("bContent");
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		out.print(cid);
		
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		int uid=u.getUdi();
		
		
		// Handle file upload
        Part imagePart = request.getPart("bImg"); // Assuming input name for file is "image"
        String imageName = getFileName(imagePart);
        if (imageName != null && !imageName.isEmpty()) {
            String uploadPath = UPLOAD_DIRECTORY + File.separator + imageName;
            File uploadFile = new File(uploadPath);



            // Save the file
            imagePart.write(uploadFile.getAbsolutePath());
            
        }
        
        
//        POSTING OBject
        Post p=new Post(postName,content,imageName,cid,uid);
        
        PostDao pdao=new PostDao(ConnectionProvider.getcon());
        if(pdao.addpost(p))
        {
        	
        	System.out.println("Post Added");
        	
        	response.sendRedirect("profile.jsp");
        }
        
        else
        {
        	System.out.println("Not Added");
        	
        }
        
      
		
		
		
		
	}
	  private String getFileName(Part part) {
          if (part != null) {
              for (String content : part.getHeader("content-disposition").split(";")) {
                  if (content.trim().startsWith("filename")) {
                      return content.substring(content.indexOf("=") + 2, content.length() - 1);
                  }
              }
          }
          return null;
      }

}
