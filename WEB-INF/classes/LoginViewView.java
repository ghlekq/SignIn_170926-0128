package chapter4.session.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginViewView
 */
@WebServlet(description = "The menu", urlPatterns = { "/menu.view" })
public class LoginViewView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String htmlTemplate;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewView() {
        super();
        // TODO Auto-generated constructor stub
        htmlTemplate = "<html>\n    <head>\n    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n        %s\n    </head>\n    <body>\n        %s\n        %s\n        %s\n    </body>\n</html>\n";
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	String title = "<title> Welcome " + session.getAttribute("username") + " <br> </title>";
    	String heading1 = "<h1> Session ID: " + session.getId() + " <br> </h1>";
    	String center = "<center><br>*** Try out our new sign-in page<br></center>";
    	String hyperLinkTemplate = "<br><a href='%s'>Try now</a>";
    	String hyperLink = String.format(hyperLinkTemplate, response.encodeURL("signin.html"));
    	String html = String.format(htmlTemplate, title, heading1, center, hyperLink);
    	out.print(html);
    	out.close();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
