package hu.neuron.java.project.online.servlets;

import hu.neuron.java.project.app.tester.SQLTestRunner;
import hu.neuron.java.project.core.SQLJSONResponse;
import hu.neuron.java.project.core.SQLProcessor;
import hu.neuron.java.project.core.WebVO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class TestDataServlet
 */
@WebServlet("/SQLDataServlet")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"user", "admin"}))
public class SQLDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SQLProcessor SQLProcessor;
	private static SQLTestRunner tester;
	private static List<WebVO> data;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SQLDataServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.isUserInRole("admin")){
			request.getRequestDispatcher("/secured/admin/ajaxadmin.jsp").forward(request, response);
		}
		else if(request.isUserInRole("user")){
			request.getRequestDispatcher("/secured/ajaxuser.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String g = request.getParameter("test");
		if(g != null && g.equals("Go")){
			
			tester.runTests();
			SQLProcessor = new SQLProcessor();
			data = SQLProcessor.generateVOs();
			doGet(request, response);
		}
		else {
			String s = request.getParameter("load");
			if(s != null && s.equals("Load results")){
				
				SQLProcessor = new SQLProcessor();
				data = SQLProcessor.generateVOs();
				doGet(request, response);
			}
			else{
				Gson gson = new Gson();
				SQLJSONResponse rp = new SQLJSONResponse(data);
				gson.toJson(rp, response.getWriter());
			}
		}
	}

	@Override
	public void init() {
		tester = new SQLTestRunner();
	}

}
