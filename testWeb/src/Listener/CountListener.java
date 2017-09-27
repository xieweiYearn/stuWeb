package Listener;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		ServletContext applicaion=se.getSession().getServletContext();
		
		int num=0;
		if(applicaion.getAttribute("num")!=null){
			
			num=(Integer) applicaion.getAttribute("num");
		}
		num++;
		applicaion.setAttribute("num", num);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
