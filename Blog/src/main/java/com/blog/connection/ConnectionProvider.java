 package com.blog.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con=null;


	public static Connection getcon()
	{

		try
		{
			if(con== null)
			{
			Class.forName("com.mysql.jdbc.Driver"); // Use "com.mysql.cj.jdbc.Driver" for MySQL 8
             con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blogs", "root", "Siraj12@1");
			}


		}
		catch(Exception e)
		{

			System.out.println(e);
		}



	 return con;

	}

}
