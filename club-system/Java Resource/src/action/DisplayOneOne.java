package action;

import com.google.gson.Gson;
import utils.JdbcUtils;
import utils.JsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "DisplayOneOne",urlPatterns = "/displayOneOne")
public class DisplayOneOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Integer page = Integer.valueOf(request.getParameter("page"));
         Integer rows = Integer.valueOf(request.getParameter("rows"));
         request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         int num=0;
         try {
             ResultSet resultSet = JdbcUtils.getConnection().createStatement().executeQuery("SELECT count(*) FROM tb_society");
             while (resultSet.next()){
                 num=resultSet.getInt(1);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         PrintWriter writer = response.getWriter();
         HashMap<String, Object> map = new HashMap<String, Object>();
         map.put("rows",JsonUtils.getJsonCarddata2("SELECT * FROM tb_society limit ?,?", (page-1)*rows, rows));
         map.put("total",num);
         Gson gson = new Gson();
         String s = gson.toJson(map);
         writer.print(s);
         System.out.println(s);
         writer.flush();
    }
}
