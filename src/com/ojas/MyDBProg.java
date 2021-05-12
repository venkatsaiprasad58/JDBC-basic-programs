package com.ojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class MyDBProg {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","Rayuduroyal@58");
			System.out.println("Connected "+ con);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

