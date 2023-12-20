package com.blog.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikedDao {
	
	
	
	private Connection con;

	public LikedDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikedDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	
//	Insert Like
	
	public boolean inserLike(int pid,int uid)
	{
		boolean insert=false;
		try {
			
			String query="Insert into liked(pid,uid)values(?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			
			ps.executeUpdate();
				insert=true;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return insert;
	}
//	countLink
	
	
	public int countLike(int pid)
	{
		int count=0;
		
		
		try {
			
			String query="Select count(*) as cl from liked where pid=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1,pid);
			ResultSet rs= stmt.executeQuery();
			while(rs.next())
			{
				
				count=rs.getInt("cl");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return count;
		
		
		
	}
//	isLiked
	
	public boolean isLike(int pid,int uid)
	{
		boolean isLike=false;
		
		try {
			
			
			String q="Select * from liked where pid=? and uid=?";
			PreparedStatement stmt=con.prepareStatement(q);
			stmt.setInt(1, pid);
			stmt.setInt(2, uid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				isLike=true;
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return isLike;
		
	}
	
//	removeLike
public boolean removeLike(int pid,int uid)
{
	boolean removed=false;
	
	try {
		
		
		String query="delete from liked where pid=? and uid=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1, pid);
		stmt.setInt(2, uid);
		if(stmt.execute())
		{
			removed=true;
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return removed;
	
	
}
	
	

}
