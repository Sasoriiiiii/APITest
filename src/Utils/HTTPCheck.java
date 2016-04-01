package Utils;

import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.HTTPCheck.java
 * @ClassName:    HTTPCheck
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午5:40:37
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午5:40:37 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class HTTPCheck {
	
	public static boolean httpStatusCheck(CloseableHttpResponse response,String httpstatus){
		try{
			int actualstatus=response.getStatusLine().getStatusCode();
			int respectstatus=Integer.valueOf(httpstatus).intValue();
			if(actualstatus==respectstatus){
				
				return true;
			}else{
				Reporter.log("ERROR--接口 返回状态码："+actualstatus+"请求异常，请检查！！！");
			return false;
			}
		}catch(Exception e){
			Reporter.log(e.toString());
			return false;
		}

	}
	
	public static boolean httpBodyCheck(CloseableHttpResponse response,String isSuccess,String message,String error,String datacheck,String data){
		try{
			boolean b=true;
			String entity="";
			try {
				entity = EntityUtils.toString(response.getEntity());
				System.out.println("====entity:"+entity);
				Reporter.log("====entity:"+entity);
			} catch (ParseException | IOException e) {
				Reporter.log("ERROR--接口 获取响应消息体错误------"+"请求异常，请检查！！！");
			}


	        if(!entity.startsWith("ApiRest")){
	        	
	        	JSONObject o=JSON.parseObject(entity);
	        	
	    		boolean istrue=o.getBoolean("isSuccess");//从返回的消息中取到isSuccess的值
	    		if(isSuccess.equalsIgnoreCase("true")){
	    			if(!istrue){
	    				b=false;
	    				Reporter.log("ERROR--接口 返回isSuccess："+"false"+"返回isSuccess错误！！！");
	    			}
	    		}else{
	    			if(istrue){
	    				b=false;
	    				Reporter.log("ERROR--接口 返回isSuccess："+"true"+"返回isSuccess错误！！！");
	    			}
	    		}

	//暂时不验证message和error，因为不统一，缺少规范
//	    		Reporter.log("++++++++message为"+o.getString("message"));
//	    		if(!o.getString("message").equalsIgnoreCase(message)){
//	        		b=false;
//	        		Reporter.log("ERROR--接口 返回message："+o.getString("message")+"返回message错误！！！");
//	        		}
//	    		Reporter.log("++++++++error为"+o.getString("error"));
//	    		if(!o.getString("error").equalsIgnoreCase(error)){
//	        		b=false;
//	        		Reporter.log("ERROR--接口 返回error："+o.getString("error")+"返回error错误！！！");
//	        		}

//	    	System.out.println(datacheck);
	    	if(!datacheck.equalsIgnoreCase("no")){
	    		try{
//	    		JSONObject obj = (JSONObject)o.get("data");
	    		String value=JsonPath.read(o,datacheck)+"";

	    		Reporter.log("====value为"+value);
	    		if(!value.equalsIgnoreCase(data)){
	        		b=false;
	        		Reporter.log("ERROR--接口 返回value："+value+"返回value错误！！！");
	        		}
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    }
	        }else{
	        	Reporter.log("====返回数据格式为ApiRest");
	        }



	        
			return b;
		}catch(Exception e){
			Reporter.log(e.toString());
			return false;
		}

	}
	

}
