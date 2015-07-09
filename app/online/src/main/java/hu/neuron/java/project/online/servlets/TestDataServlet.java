package hu.neuron.java.project.online.servlets;

import hu.neuron.java.project.app.tester.WebTestRunner;
import hu.neuron.java.project.core.BeanProcessor;
import hu.neuron.java.project.core.TableBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDataServlet
 */
@WebServlet("/TestData")
public class TestDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BeanProcessor beanProcessor;
	private static WebTestRunner tester;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDataServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.isUserInRole("admin")){
			request.getRequestDispatcher("/secured/admin/admin.jsp").forward(request, response);
		}
		else if(request.isUserInRole("user")){
			request.getRequestDispatcher("/secured/user.jsp").forward(request, response);
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
		
		TableBean tb = (TableBean) request.getSession().getAttribute("table");
		String g = request.getParameter("test");
		if(g != null && g.equals("Go")){
			tester.runTests();
			tb = generateTable();
			request.getSession().setAttribute("table", tb);
		}
		else{
			String s = request.getParameter("load");
			if(s != null && s.equals("Load results")){
				tb = generateTable();
				request.getSession().setAttribute("table", tb);
			}
		}
		doGet(request,response);
	}

	@Override
	public void init() {
		tester = new WebTestRunner(getPath(getServletContext())+"WEB-INF/results.txt");
	}
	
	private String getPath(ServletContext sc){
		String path = sc.getRealPath("/index.html");
		String result = path.substring(0, path.indexOf("index.html"));
		return result;
	}
	
	private TableBean generateTable(){
		
		ServletContext sc = getServletContext();
		String enter = System.getProperty("line.separator");
		InputStream is = sc.getResourceAsStream("/WEB-INF/results.txt");
		Scanner scr = new Scanner(is).useDelimiter("\\" + enter);
		beanProcessor = new BeanProcessor(scr);
		
		return beanProcessor.generateBean();
	}

}
