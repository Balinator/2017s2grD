package ro.msg.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String msg = req.getParameter("messageText");
		List<String> messages = (List<String>) req.getServletContext().getAttribute("messages");
		
		if (messages == null) {
			messages = new ArrayList<String>();
			req.getServletContext().setAttribute("messages", messages);
		}
		
		messages.add(req.getSession().getAttribute(Constants.USERNAME) + ": " + msg);
		req.getRequestDispatcher("ChatWindow.jsp").forward(req, resp);
		
		
	}

}
