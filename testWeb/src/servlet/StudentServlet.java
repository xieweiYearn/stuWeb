package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import entity.Student;

public class StudentServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response){
	
	try {
		int nums=2;//一页多少条数据
		StudentDao studao=new StudentDao();
			
		int total=studao.searchCount();	
		int maxye=0;
		
		if(total%nums==0){
			maxye=total/nums;
		}else{
			maxye=total/nums+1;
		}
		
	int ye=1;
		if(request.getParameter("ye")!=null){
		ye=Integer.parseInt(request.getParameter("ye"));
		}
		

		if(ye>maxye){
			ye=maxye;
		}
		if(ye<1){
			ye=1;
		}
				
		int begin=(ye-1)*2;
		List<Student> list=studao.searchByBegin(begin, nums);
		request.setAttribute("ye", ye);
		request.setAttribute("maxye", maxye);
		request.setAttribute("stus", list);
		request.getRequestDispatcher("student.jsp").forward(request, response);
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
