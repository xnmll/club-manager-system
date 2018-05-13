package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
public class JsonUtils {


	public static JsonObject getResult(String sql, int total, Object... object) {
		try {

			PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(sql);
			for (int i = 0; i < object.length; i++) {
				preparedStatement.setObject(i + 1, object[i]);
			}
			preparedStatement.execute();
			JsonObject jsonObject = new JsonObject();
			jsonObject.add("success", new JsonPrimitive(true));
			return jsonObject;
		} catch (SQLException e) {
			e.printStackTrace();
			JsonObject jsonObject = new JsonObject();
			jsonObject.add("errorMsg", new JsonPrimitive("出错了"));
			return jsonObject;
		}
	}

	/**
	 * @param sql
	 *            要执行的SQL语句
	 * @param total
	 *            指定要设置参数个数
	 * @param object
	 *            传入要设置的参数值
	 * @return JsonObject
	 */
	public static void getResultWithoutReturn(String sql, int total, Object... object) {
		try {

			PreparedStatement preparedStatement = JdbcUtils.getConnection()
					.prepareStatement(sql);

			for (int i = 0; i < object.length; i++) {
				preparedStatement.setObject(i + 1, object[i]);
			}

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param sql
	 *            要执行的SQL语句
	 * @param total
	 *            指定要设置参数个数
	 * @param object
	 *            传入要设置的参数值
	 * @return JsonObject
	 */
	public static int getCurrentPointResult(String sql, int total,
			Object... object) {
		int point = 0;
		try {
			// get preparedstatement
			PreparedStatement preparedStatement = JdbcUtils.getConnection()
					.prepareStatement(sql);
			for (int i = 0; i < object.length; i++) {
				preparedStatement.setObject(i + 1, object[i]);
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				point = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return point;
	}

	/**
	 * @param sql
	 *            要执行的SQL语句
	 * @param total
	 *            指定要设置参数个数
	 * @param object
	 *            传入要设置的参数值
	 * @return JsonObject
	 */
	public static boolean getCheckCardNumberResult(String sql, int total,
			Object... object) {
		try {
			// get preparedstatement
			PreparedStatement preparedStatement = JdbcUtils.getConnection()
					.prepareStatement(sql);
			for (int i = 0; i < object.length; i++) {
				preparedStatement.setObject(i + 1, object[i]);
			}

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	

	/**
	 * 
	 * 
	 * @param sql
	 * @param start
	 * @param end
	 * @return
	 * @throws SQLException
	
	 */

	public static JsonArray getJsonCarddata2(String sql, int start, int end) {
		ResultSet data = JdbcUtils.getData(sql, start, end);
		JsonArray jsonArray = new JsonArray();

		try {
			while (data.next()) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.add("s_id",new JsonPrimitive(data.getInt("s_id")));
				jsonObject.add("s_name",new JsonPrimitive(data.getString("s_name")));
				jsonObject.add("s_president",new JsonPrimitive(data.getInt("s_president")));
				jsonObject.add("s_introduction",new JsonPrimitive(data.getString("s_introduction")));
				jsonArray.add(jsonObject);
			}
			System.out.println(jsonArray);
			return jsonArray;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	

	public static JsonArray getJsonCarddata(String sql, int start, int end) {
		ResultSet data = JdbcUtils.getData(sql, start, end);
		JsonArray jsonArray = new JsonArray();

		try {
			while (data.next()) {
				JsonObject jsonObject = new JsonObject();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String ab_time = format.format(data.getTimestamp("ab_time"));
				jsonObject.add("ab_id",new JsonPrimitive(data.getInt("ab_id")));
				jsonObject.add("ab_content",new JsonPrimitive(data.getString("ab_content")));
				jsonObject.add("ab_time", new JsonPrimitive(ab_time));
				jsonArray.add(jsonObject);
			}
			System.out.println(jsonArray);
			return jsonArray;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

}
