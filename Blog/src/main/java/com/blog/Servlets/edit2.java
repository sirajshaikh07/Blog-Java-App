package com.blog.Servlets;

// ... (existing imports and servlet declaration)

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.blog.Dao.UserDao;
import com.blog.connection.ConnectionProvider;
import com.blog.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class edit2 extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "D:\\Eclipse\\Blog\\src\\main\\webapp\\img";

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // Retrieve user details from the request
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String about = request.getParameter("about");
        String email = request.getParameter("email");

        // Get the current user from the session
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        // Update user details
        currentUser.setAbout(about);
        currentUser.setName(name);
        currentUser.setEmail(email);
        currentUser.setGender(gender);

        // Handle file upload
        Part imagePart = request.getPart("image"); // Assuming input name for file is "image"
        String imageName = getFileName(imagePart);
        if (imageName != null && !imageName.isEmpty()) {
            String uploadPath = UPLOAD_DIRECTORY + File.separator + imageName;
            File uploadFile = new File(uploadPath);



            // Save the file
            imagePart.write(uploadFile.getAbsolutePath());
            currentUser.setImage(imageName);
        }

        // Update user profile in the database
        UserDao userDao = new UserDao(ConnectionProvider.getcon());
        if (userDao.updateprofile(currentUser)) {
            out.print("Update");
        } else {
            out.print("Not Update");
        }

        out.close();
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
