package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("adminName");
        String servletpath = req.getServletPath();
        if ((servletpath.equals("/login.jsp"))
        		|| (servletpath.equals("/loginCheckAction"))
				||(servletpath.contains(".css"))
				||servletpath.contains(".jpg")||servletpath.contains(".png")){
            chain.doFilter(req, resp);
        }else  if (username != null && !"".equals(username)){
            chain.doFilter(req, resp);
        } 
         else {
        	response.sendRedirect("login.jsp");
		}
	}

	public void destroy() {
		
	}
}
