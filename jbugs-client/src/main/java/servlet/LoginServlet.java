package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		req.getSession().setAttribute(Constants.USERNAME, username);
		req.getSession().setAttribute(Constants.PASSWORD, pass);

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login page</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("Bine ai venit:" + username);
			out.println("</body>");
			out.println("</html>");
		}

	}

}
