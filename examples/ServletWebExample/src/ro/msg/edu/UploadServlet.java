package ro.msg.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part=req.getPart("uploadedFile");
		part.write(req.getRealPath("/")+part.getSubmittedFileName());
		resp.getWriter().write("<html><head></head><body>Salvat cu succes!</body> </html>");
	}
	
	
	

}
