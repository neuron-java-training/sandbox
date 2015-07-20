package hu.neuron.java.web.servlet;

import hu.neuron.java.service.TestService;
import hu.neuron.java.service.vo.ResultVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.google.gson.Gson;

/**
 * Servlet implementation class CollectionTestServlet
 */
@Component("/CollectionTestServlet")
@WebServlet(name = "/CollectionTestServlet", urlPatterns = "/CollectionTestServlet")
public class CollectionTestServlet extends HttpRequestHandlerServlet implements HttpRequestHandler{
	private static final long serialVersionUID = 1L;
    
	@Autowired
	TestService testService;
	
	private Response rv = new Response(new ArrayList<ResultVO>());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionTestServlet() {
        super();
    }
    
    @Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("handleRequest");
    	String initSizeS = (String) request.getAttribute("initSize");
		int initSize = (initSizeS == null || initSizeS.isEmpty()) ? 1_000_000 : Integer.valueOf((initSizeS));
		
		String testSizeS = (String) request.getAttribute("testSize");
		int testSize = (testSizeS == null || testSizeS.isEmpty()) ? 100 : Integer.valueOf((testSizeS));
		
		String op = request.getParameter("op");
		if (op.equals("run")) {
			System.out.println("Run");
			testService.run(initSize, testSize);
		}
		
		rv.setData(testService.getAverageOfResult());
		
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		gson.toJson(rv, response.getWriter());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		handleRequest(request, response);
	}

	
	
	public static class Response {
		private List<ResultVO> data;
		
		public Response(List<ResultVO> result) {
			super();
			this.data = new ArrayList<>(result);
		}

		public List<ResultVO> getData() {
			return data;
		}

		public void setData(List<ResultVO> data) {
			this.data = data;
		}
		
		public boolean isEmpty(){
			return data.isEmpty();
		}
	}
}
