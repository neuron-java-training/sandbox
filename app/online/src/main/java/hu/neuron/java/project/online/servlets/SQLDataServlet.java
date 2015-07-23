package hu.neuron.java.project.online.servlets;

import hu.neuron.java.project.app.tester.SQLTestRunner;
import hu.neuron.java.project.core.SQLJSONResponse;
import hu.neuron.java.project.core.SQLProcessor;
import hu.neuron.java.project.core.WebVO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.google.gson.Gson;

/**
 * Servlet implementation class TestDataServlet
 */
@Component("/SQLDataServlet")
@WebServlet(name = "/SQLDataServlet", urlPatterns = "/SQLDataServlet")
public class SQLDataServlet extends HttpRequestHandlerServlet implements
	HttpRequestHandler {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private  SQLProcessor SQLProcessor;

	private  SQLTestRunner tester = new SQLTestRunner();
	
	private static List<WebVO> data;

	protected void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.isUserInRole("ADMIN")){
			request.getRequestDispatcher("/secured/admin/ajaxadmin.jsp").forward(request, response);
		}
		else if(request.isUserInRole("USER")){
			request.getRequestDispatcher("/secured/user/ajaxuser.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String g = request.getParameter("test");
		if(g != null && g.equals("Go")){
			
			tester.runTests();
			data = SQLProcessor.generateVOs();
			forward(request, response);
		}
		else {
			String s = request.getParameter("load");
			if(s != null && s.equals("Load results")){
				
				data = SQLProcessor.generateVOs();
				forward(request, response);
			}
			else{
				Gson gson = new Gson();
				SQLJSONResponse rp = new SQLJSONResponse(data);
				gson.toJson(rp, response.getWriter());
			}
		}
	}
}
