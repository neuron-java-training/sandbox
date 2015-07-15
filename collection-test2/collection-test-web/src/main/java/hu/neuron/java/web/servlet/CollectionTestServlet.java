package hu.neuron.java.web.servlet;

import hu.neuron.java.business.CollectionTest;
import hu.neuron.java.business_api.collection_test.CollectionTesterInterface;
import hu.neuron.java.business_api.collection_test.TestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CollectionTestServlet
 */
@WebServlet("/CollectionTestServlet")
public class CollectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	private Response rv = new Response(new ArrayList<TestResult>());
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
		String initSizeS = (String) request.getAttribute("initSize");
		int initSize = (initSizeS == null || initSizeS.isEmpty()) ? 1_000_000 : Integer.valueOf((initSizeS));
		
		String testSizeS = (String) request.getAttribute("testSize");
		int testSize = (testSizeS == null || testSizeS.isEmpty()) ? 100 : Integer.valueOf((testSizeS));
		
		CollectionTesterInterface tester = new CollectionTest();
		String op = request.getParameter("op");
		if (op.equals("run")) {
			System.out.println("Run");
			tester.run(initSize, testSize);
		}
		
		rv.setData(tester.getAverageOfResult());
		
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		gson.toJson(rv, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

	
	
	public static class Response {
		private List<TestResult> data;
		
		public Response(List<TestResult> result) {
			super();
			this.data = new ArrayList<>(result);
		}

		public List<TestResult> getData() {
			return data;
		}

		public void setData(List<TestResult> data) {
			this.data = data;
		}
		
		public boolean isEmpty(){
			return data.isEmpty();
		}
	}
}
