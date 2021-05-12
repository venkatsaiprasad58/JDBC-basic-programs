package com.ojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class Student {
	int sno;
	String sname;
	int marks;

	public Student() {
		System.out.println("default constructor");
	}

	public Student(int sno, String sname, int marks) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.marks = marks;
	}
}

class Operations {
	Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "Rayuduroyal@58");
			System.out.println("connected " + con + "\n");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	void menu() {
		String m = "Menu Driven Application\n";
		m += "1. Add Student\n";
		m += "2. Delete Student\n";
		m += "3. Update Student\n";
		m += "4. List Students\n";
		m += "5. Exit\n";
		System.out.println(m);
	}

	boolean addStudent(Student stud) {
		boolean b = false;
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("insert into student1 values(?,?,?)");
			pst.setInt(1, stud.sno);
			pst.setString(2, stud.sname);
			pst.setInt(3, stud.marks);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	boolean deleteStudent(int sno) {
		boolean b = false;
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("delete from student1 where sno = ?");
			pst.setInt(1, sno);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	boolean updatestudent(int sno, String sname, int marks) {
		boolean b = false;
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("update student1 set sname = ? , marks = ? where sno =?");
			pst.setString(1, sname);
			pst.setInt(2, marks);
			pst.setInt(3, sno);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	void listStudents() {
		try {
			Connection con = getConnect();
			PreparedStatement pst = con.prepareStatement("Select * from student1");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class MenuDrivenJdbc {
	public static void main(String[] args) {
		int sno, marks;
		String sname;
		boolean res;
		Scanner sc = new Scanner(System.in);
		Operations op = new Operations();
		while (true) {
			op.menu();
			System.out.println("enter your choice");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("enter student Details");
				sno = sc.nextInt();
				sname = sc.next();
				marks = sc.nextInt();
				Student stud = new Student(sno, sname, marks);
				res = op.addStudent(stud);
				if (res == true) {
					System.out.println("inserted successfully \n\n");
				} else {
					System.out.println("not inserted");
				}
				break;
			case 2:
				System.out.println("enter student to delete");
				sno = sc.nextInt();
				res = op.deleteStudent(sno);
				if (res == true) {
					System.err.println("deleted successfully \n\n");
				} else {
					System.out.println("Not deleted");
				}
				break;
			case 3:
				System.out.println("enter student details to update");
				sno = sc.nextInt();
				sname = sc.next();
				marks = sc.nextInt();
				res = op.updatestudent(sno, sname, marks);
				if (res == true) {
					System.err.println("updated successfully \n\n");
				} else {
					System.out.println("Not updated");
				}
				break;
			case 4:
				System.out.println("Students list");
				op.listStudents();
				System.out.println();
				System.out.println();
				break;
			case 5:
				System.exit(0);
			}
		}
	}
}