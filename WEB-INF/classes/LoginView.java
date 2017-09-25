package chapter4.session.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginView
 */
@WebServlet(description = "Login view", urlPatterns = { "/login.view" })
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String htmlTemplate;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
        super();
        // TODO Auto-generated constructor stub
        htmlTemplate = "<html>\n    <head>\n    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n        <title>Sign in to your account</title>\n    </head>\n    <body>\n        <h1>%s</h1>\n    </body>\n</html>\n";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String)request.getAttribute("username");
		String password = (String)request.getAttribute("password");
		UserDataModel model = new UserDataModel();
		String result = null;
		switch (model.verifyUserCredentials(username, password)) {
		case 0:
			result = "Signed in successfully.";
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.view");
			dispatcher.forward(request, response);
			break;
		case 1:
			response.sendRedirect("login.html");
			result = "Wrong password. Please enter it again.";
			break;
		case 2:
			response.sendRedirect("signin.html");
			result = "The user doesn't exist.";
			break;
		default:
			break;
		}
		String html = String.format(htmlTemplate, result);
		PrintWriter out = response.getWriter();
		out.print(html);
		out.close();
	}

}
