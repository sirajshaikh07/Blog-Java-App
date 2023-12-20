package com.blog.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.entities.User;

public class UserDao {


	 private Connection con=null;

	 public UserDao(Connection con) {
		super();
		this.con = con;
	}

	boolean done=false;

	 public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insertUser(User u)
	 {


		 try {

			 String query="insert into user(uname,email,password,about,gender)values(?,?,?,?,?)";

			 PreparedStatement stmt=this.con.prepareStatement(query);
			 stmt.setString(1,u.getName() );
			 stmt.setString(2,u.getEmail());
			 stmt.setString(3,u.getPassword());
			 stmt.setString(4,u.getAbout());
			 stmt.setString(5,u.getGender());
			 stmt.execute();
			 done=true;



		} catch (Exception e) {
			// TODO: handle exception


			e.printStackTrace();
		}










		 return done;
	 }



//	Login to get User

	public User getUser(String email,String Password)
	{
		User u=null;

		try

		{

			String query="Select * from user where email=? and password=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, Password);
			ResultSet r=stmt.executeQuery();

			if(r.next())
			{
				u=new User();
				u.setName(r.getString("uname"));
				u.setEmail(r.getString("email"));
				u.setAbout(r.getString("about"));
				u.setImage(r.getString("Photo"));
				u.setUdi(r.getInt("uid"));
				u.setGender(r.getString("Gender"));
				u.setDate(r.getTimestamp("Date"));


			}



		}
		catch(Exception e)
		{


			e.printStackTrace();
		}








		return u;


	}

//	Update Users Profile



	public boolean updateprofile(User u)
	{
		boolean status=false;
		try {

			String query = "UPDATE user SET uname=?, email=?, about=?,Photo=?, Gender=? WHERE uid=?";
			PreparedStatement p = con.prepareStatement(query);

			System.out.println(u.getUdi());
			p.setString(1, u.getName());
			p.setString(2, u.getEmail());
			p.setString(3, u.getAbout());
			p.setString(4, u.getImage());
			p.setString(5, u.getGender());
			p.setInt(6, u.getUdi());
			p.executeUpdate(); // Using executeUpdate() for UPDATE queries

			status=true;


		} catch (Exception e) {
			e.printStackTrace();
		}



		return status;


	}














}
