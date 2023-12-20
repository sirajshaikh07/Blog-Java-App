package com.blog.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
public class PostDao {



Connection con;



//	getCategories

public PostDao(Connection con) {
	super();
	this.con = con;
}



public PostDao() {
	super();
	// TODO Auto-generated constructor stub
}



public ArrayList<Category>getAllCategory()
{

	ArrayList<Category> list=new ArrayList<>();
	try {

		String query="select * from category";
		Statement stmt=this.con.createStatement();
		ResultSet rs=stmt.executeQuery(query);


		while(rs.next())
		{
			System.out.println("Hello");
			int cid=rs.getInt("c_id");
			String ctype=rs.getString("c_type");
			System.out.println(rs.getInt("c_id"));
			Category c=new Category(cid,ctype);
			System.out.println(c.getCtype());
			list.add(c);




		}



	} catch (Exception e) {
		e.printStackTrace();
	}



	return list;

}

//Add Post

public boolean addpost(Post p)
{
	boolean added=false;
	try {
		
		String query="insert into post(p_name,p_img,p_content,c_id,uid)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,p.getP_name());
		ps.setString(2,p.getP_img());
		ps.setString(3,p.getP_cntent());
		ps.setInt(4,p.getC_id());
		ps.setInt(5,p.getUid());
		
		ps.execute();
		added=true;
		
		
		
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	return added;
	
}




//Fetch All Post Data


public ArrayList<Post> getAllPost(int uid) {
    ArrayList<Post> listp = new ArrayList<>();

    try {
        String query = "SELECT p.p_id, p.p_name, p.p_img, p.p_content, p.date, c.c_id, c.c_type, p.uid " +
                "FROM post p INNER JOIN category c ON p.c_id = c.c_id WHERE p.uid=? limit 6";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, uid);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Post post = new Post(
                rs.getInt("p_id"),
                rs.getString("p_name"),
                rs.getString("p_content"),
                rs.getString("p_img"),
                
                rs.getTimestamp("date"),
                rs.getInt("c_id"),
                rs.getString("c_type"),
                rs.getInt("uid")
            );
            listp.add(post);
        }
        
        rs.close();
        ps.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return listp;
}








}
