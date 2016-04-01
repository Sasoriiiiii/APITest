package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.ReadJson.java
 * @ClassName:    ReadJson
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月8日 上午9:47:11
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月8日 上午9:47:11 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class ReadJson {
	
	public static String readJson(JSONObject obj,String datacheck){
		
		
		String data=JsonPath.read(obj, datacheck);
		return data;
	} 

}
