package hu.neuron.java.project.online.servlets;

import hu.neuron.java.project.app.tester.WebTestRunner;
import hu.neuron.java.project.core.WebProcessor;

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
	private static volatile boolean processed = false;
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

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("test");
		if(s.equals("Go")){
			tester.runTests();
			processed=false;
			process();
		}
		doGet(request,response);
	}

	@Override
	public void init() {
		if (!processed) {
			process();
			// System.out.println("lefutott az initben");
		}
		tester = new WebTestRunner(getPath()+"WEB-INF/results.txt");
	}

	private void process() {
		String enter = System.getProperty("line.separator");
		ServletContext sc = getServletContext();
		InputStream is = sc.getResourceAsStream("/WEB-INF/results.txt");
		Scanner scr = new Scanner(is).useDelimiter("\\" + enter);
		WebProcessor wp = new WebProcessor(scr, getPath());
		wp.process();
		processed = true;
	}
	
	private String getPath(){
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/index.html");
		String result = path.substring(0, path.indexOf("index.html"));
		return result;
	}

}
