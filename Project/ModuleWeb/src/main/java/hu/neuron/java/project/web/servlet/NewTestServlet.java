package hu.neuron.java.project.web.servlet;

import hu.neuron.java.project.business.impl.CollectionTestRunner;
import hu.neuron.java.project.core.entity.TestResult;
import hu.neuron.java.project.core.repository.TestResultRepository;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

/**
 * Servlet implementation class NewTestServlet
 */
@WebServlet("/NewTestServlet")
public class NewTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
	TestResultRepository testResultRepository;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

//			TestResult entity = new TestResult();
//			entity.setName("weterzer");
//			testResultRepository.save(entity);
		
		
		Boolean ready=false;
		CollectionTestRunner collectiontestRun = new CollectionTestRunner();
		ready=collectiontestRun.runTest();
		
		Gson gson = new Gson();
		gson.toJson(ready, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
