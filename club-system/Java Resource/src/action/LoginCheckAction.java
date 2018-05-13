package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginCheckAction", urlPatterns = "/loginCheckAction")
public class LoginCheckAction extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username.equals("xnmll")&&password.equals("123123")) {
			session.setAttribute("adminName", "xnmll");
			request.getRequestDispatcher("/Managers_Home.jsp")
			.forward(request, response);
		}else {
			request.getRequestDispatcher(
					"/login.jsp?errorMessage=用户名或密码错误!").forward(
							request, response);
		}
	}




}
