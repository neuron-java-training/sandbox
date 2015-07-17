package hu.neuron.java.project.online.servlets;

import hu.neuron.java.project.app.tester.WebTestRunner;
import hu.neuron.java.project.core.TestResultVO;
import hu.neuron.java.project.core.JSONProcessor;
import hu.neuron.java.project.core.JSONResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletContext;
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
@WebServlet("/JSONDataServlet")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"user", "admin"}))
public class JSONDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static JSONProcessor JSONProcessor;
	private static WebTestRunner tester;
	private static ArrayList<TestResultVO> data;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONDataServlet() {
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
			ServletContext sc = getServletContext();
			String enter = System.getProperty("line.separator");
			InputStream is = sc.getResourceAsStream("/WEB-INF/results.txt");
			
			@SuppressWarnings("resource")//JSONProcessos closes the scanner after use
			Scanner scr = new Scanner(is).useDelimiter("\\" + enter);
			JSONProcessor = new JSONProcessor(scr);
			tester.runTests();
			data = JSONProcessor.generateVOs();
			doGet(request, response);
		}
		else {
			String s = request.getParameter("load");
			if(s != null && s.equals("Load results")){
				ServletContext sc = getServletContext();
				String enter = System.getProperty("line.separator");
				InputStream is = sc.getResourceAsStream("/WEB-INF/results.txt");
				
				@SuppressWarnings("resource")//JSONProcessos closes the scanner after use
				Scanner scr = new Scanner(is).useDelimiter("\\" + enter);
				JSONProcessor = new JSONProcessor(scr);
				data = JSONProcessor.generateVOs();
				doGet(request, response);
			}
			else{
				Gson gson = new Gson();
				JSONResponse rp = new JSONResponse(data);
				gson.toJson(rp, response.getWriter());
			}
		}
	}

	@Override
	public void init() {
		ServletContext sc = getServletContext();
		tester = new WebTestRunner(getPath(sc)+"WEB-INF/results.txt");
	}
	
	private String getPath(ServletContext sc){
		String path = sc.getRealPath("/index.html");
		String result = path.substring(0, path.indexOf("index.html"));
		return result;
	}

}
