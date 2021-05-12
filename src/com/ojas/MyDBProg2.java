package com.ojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class MyDBProg2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","Rayuduroyal@58");
			System.out.println("Connected "+ con);
			Scanner sc = new Scanner(System.in);
			//Statement st1 = con.createStatement();
			System.out.println("Enter the num,name,marks");
			int num = sc.nextInt();
			String name = sc.next();
			int marks = sc.nextInt();
			PreparedStatement st = con.prepareStatement("insert into student(?,?,?)");
			st.setInt(1, num);
			st.setString(2, name);
			st.setInt(3, marks);
			int res = st.executeUpdate();
			if(res > 0) {
				System.out.println("Record inserted sucessfully");
			}
			else {
				System.out.println("Try again");
			}
			st.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
