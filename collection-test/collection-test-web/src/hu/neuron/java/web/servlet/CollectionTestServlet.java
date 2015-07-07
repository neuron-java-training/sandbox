package hu.neuron.java.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.test_result.TestResult;
import app.Main;

/**
 * Servlet implementation class CollectionTestServlet
 */
@WebServlet("/CollectionTestServlet")
public class CollectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String initSizeS = (String) request.getAttribute("initSize");
		int initSize = (initSizeS == null || initSizeS.isEmpty()) ? 1_000_000 : Integer.valueOf((initSizeS));
		
		String testSizeS = (String) request.getAttribute("testSize");
		int testSize = (testSizeS == null || testSizeS.isEmpty()) ? 100 : Integer.valueOf((testSizeS));
		
		Main tester = new Main();
		List<TestResult> result = tester.run(initSize, testSize);
		request.getSession().setAttribute("resultSession", result);
		
		response.sendRedirect("collectionTest.jsp");
		
	}

}
