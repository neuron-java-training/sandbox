package hu.neuron.java.servlet;

import hu.neuron.java.myapp.app.Main;
import hu.neuron.java.myapp.app.TestResults;
import hu.neuron.java.myapp.app.TestRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataFactoryServlet
 */
@WebServlet("/DataFactoryServlet")
public class DataFactoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataFactoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<TestResults> list = new ArrayList<>();
		String op = request.getParameter("operator");

		if (op.equals("run")) {
			list = (List<TestResults>) ButtonActions.buttonAction();
			request.getSession().setAttribute("resultlist", list);
		} else {
			list = Main.main();
			request.getSession().setAttribute("resultlist", list);
		}

		response.sendRedirect("resultlist.jsp");

		TestRunner.setTestresults(new ArrayList<TestResults>());
	}

}
