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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��8�� ����9:47:11
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��8�� ����9:47:11 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class ReadJson {
	
	public static String readJson(JSONObject obj,String datacheck){
		
		
		String data=JsonPath.read(obj, datacheck);
		return data;
	} 

}
