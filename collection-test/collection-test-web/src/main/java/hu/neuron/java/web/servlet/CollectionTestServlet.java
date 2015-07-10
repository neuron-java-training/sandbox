package hu.neuron.java.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Main;

import com.google.gson.Gson;

import core.test_result.TestResult;

/**
 * Servlet implementation class CollectionTestServlet
 */
@WebServlet("/CollectionTestServlet")
public class CollectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	private static Response rv = new Response(new ArrayList<TestResult>());
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
		
		String op = request.getParameter("op");
		if (op.equals("run")) {
			System.out.println("Run");
			run(initSize, testSize);
		}else if(op.equals("get")){
			System.out.println("get");
			if(rv.isEmpty()){

				run(initSize, testSize);
			}
		}
		
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

	private void run(int initSize, int testSize){
		System.out.println("run");
		Main tester = new Main();
		List<TestResult> result = tester.run(initSize, testSize);
		rv = new Response(result);
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

		public void setData(ArrayList<TestResult> data) {
			this.data = data;
		}
		
		public boolean isEmpty(){
			return data.isEmpty();
		}
	}
}
