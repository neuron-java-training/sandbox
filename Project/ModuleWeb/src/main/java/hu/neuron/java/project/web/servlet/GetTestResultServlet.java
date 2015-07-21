package hu.neuron.java.project.web.servlet;

import hu.neuron.java.project.business.bo.TestResultBO;
import hu.neuron.java.project.business.mapper.TestResultMapper;
import hu.neuron.java.project.core.entity.TestResult;
import hu.neuron.java.project.core.repository.TestResultRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

/**
 * Servlet implementation class AvgTestResultServlet
 */
@WebServlet("/GetTestResultServlet")
public class GetTestResultServlet extends HttpServlet {
	
	@Autowired
	TestResultRepository testResultDAOImpl;
	
	@Autowired
	TestResultMapper testResultMapper;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTestResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TestResultBO> testResultBOList= new ArrayList<TestResultBO>();
		for(TestResult row : testResultDAOImpl.findAll()){
			testResultBOList.add(testResultMapper.convertEntitytoBO(row));
		}
		Gson gson = new Gson();
		try {
			gson.toJson(testResultBOList, response.getWriter());
		} catch (Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
