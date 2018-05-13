package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

		
		private static Connection connection;
		
		public static Connection getConnection(){
			try {
				if(connection==null){
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/society", "root", "123123");
				}
			} catch (Exception e) {
				throw new RuntimeException("get connection error");
			}
			return connection;
		}
		

    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null && !con.isClosed()) {
                con.close();
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void closeAll2(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getData(String sql,int start,int end){
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,end);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    


}

	
