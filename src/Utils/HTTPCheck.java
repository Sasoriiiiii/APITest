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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��18�� ����5:40:37
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��18�� ����5:40:37 
 * @UpdateRemark: ˵�������޸�����  
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
				Reporter.log("ERROR--�ӿ� ����״̬�룺"+actualstatus+"�����쳣�����飡����");
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
				Reporter.log("ERROR--�ӿ� ��ȡ��Ӧ��Ϣ�����------"+"�����쳣�����飡����");
			}


	        if(!entity.startsWith("ApiRest")){
	        	
	        	JSONObject o=JSON.parseObject(entity);
	        	
	    		boolean istrue=o.getBoolean("isSuccess");//�ӷ��ص���Ϣ��ȡ��isSuccess��ֵ
	    		if(isSuccess.equalsIgnoreCase("true")){
	    			if(!istrue){
	    				b=false;
	    				Reporter.log("ERROR--�ӿ� ����isSuccess��"+"false"+"����isSuccess���󣡣���");
	    			}
	    		}else{
	    			if(istrue){
	    				b=false;
	    				Reporter.log("ERROR--�ӿ� ����isSuccess��"+"true"+"����isSuccess���󣡣���");
	    			}
	    		}

	//��ʱ����֤message��error����Ϊ��ͳһ��ȱ�ٹ淶
//	    		Reporter.log("++++++++messageΪ"+o.getString("message"));
//	    		if(!o.getString("message").equalsIgnoreCase(message)){
//	        		b=false;
//	        		Reporter.log("ERROR--�ӿ� ����message��"+o.getString("message")+"����message���󣡣���");
//	        		}
//	    		Reporter.log("++++++++errorΪ"+o.getString("error"));
//	    		if(!o.getString("error").equalsIgnoreCase(error)){
//	        		b=false;
//	        		Reporter.log("ERROR--�ӿ� ����error��"+o.getString("error")+"����error���󣡣���");
//	        		}

//	    	System.out.println(datacheck);
	    	if(!datacheck.equalsIgnoreCase("no")){
	    		try{
//	    		JSONObject obj = (JSONObject)o.get("data");
	    		String value=JsonPath.read(o,datacheck)+"";

	    		Reporter.log("====valueΪ"+value);
	    		if(!value.equalsIgnoreCase(data)){
	        		b=false;
	        		Reporter.log("ERROR--�ӿ� ����value��"+value+"����value���󣡣���");
	        		}
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    }
	        }else{
	        	Reporter.log("====�������ݸ�ʽΪApiRest");
	        }



	        
			return b;
		}catch(Exception e){
			Reporter.log(e.toString());
			return false;
		}

	}
	

}
