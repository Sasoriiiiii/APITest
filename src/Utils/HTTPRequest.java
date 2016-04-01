package Utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.HTTPRequest.java
 * @ClassName:    HTTPRequest
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午5:39:37
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午5:39:37 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class HTTPRequest {
	
	static CloseableHttpClient httpclient;
	/**
	 * @param url
	 * @param datatype
	 * @param data
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static CloseableHttpResponse HTTPPost(String url,String datatype,String data) throws IOException{
		
		HTTPRequest.initHttpClient();
		HttpPost httppost=new HttpPost(url);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        JSONObject o = JSON.parseObject(data);
        Iterator<String> iterator = o.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            String val = (String) o.get(name);
            formparams.add(new BasicNameValuePair(name, val));
//            System.out.println("name="+name+",val=" + val);
        }
//		if(!url.endsWith("userLogin")){
//			HTTPRequest.initSession();
//		}	
        UrlEncodedFormEntity uefEntity; 
        uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(uefEntity);
		CloseableHttpResponse response = httpclient.execute(httppost);
//		HTTPRequest.stopHttpClient();
		return response;
	}
	
	/**
	 * @param url
	 * @param datatype
	 * @param data
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static CloseableHttpResponse HTTPGet(String url, String datatype, String data) throws IOException {
		
		HTTPRequest.initHttpClient();
		if(datatype.equalsIgnoreCase("JSON")){
			String[] str1=data.split("\\{", 2);
			String[] str2=str1[1].split("\\}", 2);
			data=str1[0]+URLEncoder.encode(("{"+str2[0]+"}"),"UTF-8")+str2[1];
		}
//		System.out.println(url+data);
		HttpGet httpget=new HttpGet(url+data);
//		if(!url.endsWith("userLogin")){
//			HTTPRequest.initSession();
//		}	

		CloseableHttpResponse response = httpclient.execute(httpget);
//		HTTPRequest.stopHttpClient();
		return response;
	} 
	
	/**
	 * @throws IOException
	 */
	public static void initSession() throws IOException{
		
		String JSESSIONID="";
		HttpPost httppostLogin=new HttpPost("http://192.168.0.51/portal/login/userLogin");
		List<NameValuePair> formparamsLogin = new ArrayList<NameValuePair>();  
        formparamsLogin.add(new BasicNameValuePair("loginName", "61011098"));  
        formparamsLogin.add(new BasicNameValuePair("loginPwd", "123456"));  
        UrlEncodedFormEntity uefEntityLogin;
        uefEntityLogin = new UrlEncodedFormEntity(formparamsLogin, "UTF-8");  
        httppostLogin.setEntity(uefEntityLogin);    
        CloseableHttpResponse responseLogin=httpclient.execute(httppostLogin);
        HeaderElementIterator it = new BasicHeaderElementIterator(responseLogin.headerIterator("Set-Cookie"));
        while(it.hasNext()){
        	HeaderElement elem=it.nextElement();
        	if(elem.getName().equals("JSESSIONID")){
        		JSESSIONID =elem.getValue();
//      			System.out.println(JSESSIONID);
      	}
      }
        responseLogin.close();     
        HttpGet httpGet=new HttpGet("http://192.168.0.51/erp/home/initLogin?sessionId="+JSESSIONID);
        CloseableHttpResponse responseInit=httpclient.execute(httpGet);
        responseInit.close();
	}
	
	/**
	 * 
	 */
	public static void initHttpClient(){
		httpclient=HttpClients.createDefault(); 
	}
	/**
	 * @throws IOException
	 */
	public static void stopHttpClient() throws IOException{
		httpclient.close();
	}


}
