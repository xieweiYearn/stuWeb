package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class UserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		 //jsp 第一个内置对象：out，第二个：request(重要) 第三个 ，response(重定向)跳到一个页面
		  
			try {
				request.setCharacterEncoding("utf-8");
			
			
			String type=request.getParameter("type");
			if(type==null){
				showLogin(request, response);
				}
			else {
			if(type.equals("showLogin")){
				showLogin(request, response);
			}else if(type.equals("doLogin")){
				doLogin(request, response);
				
			}
			}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  }	  	
	public void showLogin(HttpServletRequest request,HttpServletResponse response){
		
		try {
			

			String name = "";
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName")) {
					name = cookies[i].getValue();
					break;
				}
			}
			}
			request.setAttribute("name", name);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doLogin(HttpServletRequest request,HttpServletResponse response){
		  String password=request.getParameter("password");
		  String username=request.getParameter("name");
		  String time=request.getParameter("time");
		  User searchUser=new User();
		  searchUser.setUsername(username);
		  searchUser.setPassword(password);
		  
		  UserDao ud=new UserDao();
		  User user=ud.searchByUserNameAndPassword(searchUser);
		  
		  if(user!=null){
		  
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			  		  
			  Cookie cooklie=new Cookie("userName",user.getUsername());
			  if(time.equals("1")){
				  cooklie.setMaxAge(-1);
			  }
			  else if(time.equals("2")){
				  cooklie.setMaxAge(30);
			  }
			  else  if(time.equals("3")){
				  cooklie.setMaxAge(60);
			  }
			  response.addCookie(cooklie);	
			  
			  try {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
	}else{
		 try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
public void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
		
	}
	
}
