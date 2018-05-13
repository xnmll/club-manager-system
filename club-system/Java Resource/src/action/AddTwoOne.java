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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddTwoOne",urlPatterns = "/addTwoOne")
public class AddTwoOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回的消息
        String result="";
        //设置编码格式，防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        
        
        Integer ab_id = Integer.valueOf(request.getParameter("ab_id"));
        String ab_content=request.getParameter("ab_content");
        String ab_time=request.getParameter("ab_time");
        Timestamp date = Timestamp.valueOf(ab_time); 
        
        
        
        JsonObject json = CardDao.addtwoone(ab_id,ab_content,date);
        writer.print(json);
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("禁止非法访问");
    }
}
