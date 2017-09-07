package ro.msg.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleTest")
public class PinkServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("This is the service, how can I help you?");
	}

	@Override
	public void destroy() {
		System.out.println("This is the destroy method.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("This is the init method.");
	}
		
}
