/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.0.M2
 * Generated at: 2015-07-08 10:59:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hu.neuron.java.project.core.TestResult;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ArrayList<TestResult> testRun= (ArrayList<TestResult>)request.getAttribute("testRun");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>WebModule</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form name=\"MainServletForm\" id=\"MainServletForm\" action=\"MainServlet\">\r\n");
      out.write("\t\t<button type=\"submit\" name=\"submitButton\" value=\"newTest\">New\r\n");
      out.write("\t\t\tTest</button>\r\n");
      out.write("\t\t<button type=\"submit\" name=\"submitButton\" value=\"result\">Result</button>\r\n");
      out.write("\t\t<br> <br>\r\n");
      out.write("\t\t");

			if(testRun != null && !testRun.isEmpty()) {
		
      out.write("\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Average test times</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t<td>InitTime</td>\r\n");
      out.write("\t\t\t\t<td>SortingTime</td>\r\n");
      out.write("\t\t\t\t<td>GetItemTime</td>\r\n");
      out.write("\t\t\t\t<td>DeleteItemsByRangeTime</td>\r\n");
      out.write("\t\t\t\t<td>DuplicationClearTime</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				for(TestResult row : testRun) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print(row.getName());
      out.write(" </td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print((double)row.getInitTime()/1_000_000);
      out.write(" ms </td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print((double)row.getSortingTime()/1_000_000);
      out.write(" ms </td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print((double)row.getGetItemTime()/1_000_000);
      out.write(" ms </td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print((double)row.getDeleteItemsByRangeTime()/1_000_000);
      out.write(" ms </td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print((double)row.getDuplicationClearTime()/1_000_000);
      out.write(" ms </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
