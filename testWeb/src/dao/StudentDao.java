package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentDao {

	
	
	public int searchCount(){
		int result=0;
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/school", "root", "123456");
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("select count(id) as c from student");
			
			if (rs.next()) {
				result=rs.getInt("c");
				
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public List<Student> searchAll(){
		List<Student> list=new ArrayList<Student>();
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/school", "root", "123456");
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("select * from student");
			
			while (rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
				
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public List<Student> searchByBegin(int begin,int num){
		List<Student> list=new ArrayList<Student>();
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/school", "root", "123456");
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("select * from student limit "+begin+","+num);
			
			while (rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
				
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
