package action;

import dao.CardDao;

import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddOneOne",urlPatterns = "/addOneOne")
public class AddOneOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        Integer s_id = Integer.valueOf(request.getParameter("s_id"));
        String s_name=request.getParameter("s_name");
        String s_introduction=request.getParameter("s_introduction");
        Integer s_president = Integer.valueOf(request.getParameter("s_president"));
        JsonObject json = CardDao.addoneone(s_id,s_name,s_introduction,s_president);
        writer.print(json);
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("禁止非法访问");
    }
}



