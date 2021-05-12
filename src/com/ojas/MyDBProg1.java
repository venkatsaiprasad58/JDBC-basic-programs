package com.ojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class MyDBProg1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","Rayuduroyal@58");
			System.out.println("Connected "+ con);
			Statement st = con.createStatement();
			//st.executeUpdate("create table student(sno int,Sname varchar(20),marks int)");
			//st.executeUpdate("insert into student values(1,'prasad',79)");
			System.out.println("Enter no,name & marks");
			int num = sc.nextInt();
			String name  = sc.next();
			int marks = sc.nextInt();
//			int res = st.executeUpdate("insert into student values("+num+",'"+name+"',"+marks+")");
//			System.out.println(res + "Inserted sucessfully");
//			int res = st.executeUpdate("delete from student where sno = "+num);
			int res = st.executeUpdate("update student set sname="+"'"+name+"', marks="+marks+" where sno="+num);
			System.out.println("Table updated Sucessfully");
			st.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

	private static String insert(int i, String string, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
