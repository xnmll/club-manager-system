package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JdbcUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import dao.CardDao;

@WebServlet(name = "DeleteOneOne",urlPatterns = "/deleteOneOne")
public class DeleteOneOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String ids = request.getParameter("ids");
        JsonObject result = CardDao.deleteoneone(ids);
        System.out.println(ids);
        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("非法访问!!!");
    }
}
