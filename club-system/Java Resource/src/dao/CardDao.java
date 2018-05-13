package dao;

import java.sql.Timestamp;
import utils.JsonUtils;
import com.google.gson.JsonObject;


public class CardDao {

	 //club add one one
    public static JsonObject addoneone(int s_id,String s_name,String s_introduction,int s_president){
        return JsonUtils.getResult("insert into tb_society (s_id,s_name,s_introduction,s_president) values (?,?,?,?)",4,s_id,s_name,s_introduction,s_president);
    }
	
	 //club add two one
    public static JsonObject addtwoone(int ab_id,String ab_content,Timestamp date){
        return JsonUtils.getResult("insert into tb_admin_bulletin (ab_id,ab_content,ab_time) values (?,?,?)",3,ab_id,ab_content,date);
    }
    
    //club delete two one
    public static JsonObject deletetwoone(String ids){
        return JsonUtils.getResult("delete from tb_admin_bulletin where ab_id in(" + ids + ")",0);
    }
	
    //club delete one one
    public static JsonObject deleteoneone(String ids){
        return JsonUtils.getResult("delete from tb_society where s_id in(" + ids + ")",0);
    }
  
}
