package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;

public class ELServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
//		ServletContext application=request.getServletContext();
//		HttpSession session=request.getSession();
		
		Student stu=new Student();
		stu.setName("小明");
		stu.setSex("男");
		stu.setAge(20);
		
		request.setAttribute("stu", stu);
//		application.setAttribute("name", "小明");
//		session.setAttribute("sex", "男");
//		session.setAttribute("name", "小牛");
//		request.setAttribute("age", 20);
		
		try {
			request.getRequestDispatcher("testEL.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
		
	}
	
}
