package Utils;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Reporter;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.APITest.java
 * @ClassName:    APITest
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午1:53:22
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午1:53:22 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class APITest {
	

	public static CloseableHttpResponse runAPITest(String[] test) throws IOException{
		
		CloseableHttpResponse response=null;
		
		if(test.length!=18){
    	   System.out.println("---------dataError");
    	   Reporter.log("---------dataError");
		}
    	   String apiname=test[1];
    	   String apidescription=test[2];
    	   String apihost=test[4];
    	   String apiurl=test[5];
    	   String requestmethod=test[6];
    	   String datatype=test[7];
    	   String data=test[8];
    	   String url=apihost+apiurl;
    	   Reporter.log("------------Run "+apidescription+apiname+"-----------------------");
//    	   System.out.println("------------Run "+apidescription+apiname+"-----------------------");
    	   Reporter.log("====data:"+data);
    	   if(requestmethod.equals("POST")){
//    			   System.out.println("---------"+"run http post request");
            	   response=HTTPRequest.HTTPPost(url, datatype, data);
    		   }
    	   if(requestmethod.equals("GET")){
//        		   System.out.println("---------"+"run http get request");
            	   response=HTTPRequest.HTTPGet(url, datatype, data);
    		   }

       
       return response;
	}
	
	public static boolean assertTrue(String[] test,CloseableHttpResponse response){
		
		boolean b=true;
		if(test.length!=18){
	    	   System.out.println("---------dataError");
	    	   Reporter.log("---------dataError");
		}
	    	   String httpstatus=test[9];
	    	   String isSuccess=test[10];
	    	   String message=test[11];
	    	   String error=test[12];
	    	   String datacheck=test[13];
	    	   String data=test[14];
	    	   String db=test[15];
	    	   String sqlcheck=test[16];
	    	   String sqlvalue=test[17];
	    	   Reporter.log("---------------------httpStatusCheck-------------------------");
//	    	   System.out.println("---------------------httpStatusCheck");
	    	   if(!HTTPCheck.httpStatusCheck(response, httpstatus)){ 
	    		   b=false;
	    	   }
	    	   Reporter.log("-------------------------------------------------------------");
	    	   Reporter.log("---------------------httpBodyCheck-------------------------");
//		    	 System.out.println("---------------------httpBodyCheck");
	    	   if(!HTTPCheck.httpBodyCheck(response, isSuccess, message,error,datacheck,data)){
		    		   b=false;
		    	   }
	    	   Reporter.log("-----------------------------------------------------------");

	    	   
	    	   if(!sqlcheck.equalsIgnoreCase("No")){
	    		   Reporter.log("---------------------sqlCheck-------------------------");
//	    		   System.out.println("---------------------sqlCheck");
	    		   if(!SQLCheck.sqlCheck(db,sqlcheck, sqlvalue)){
	    			   b=false;
	    		   }
	    		   Reporter.log("------------------------------------------------------");
	    	   }
		return b;
	}
 
}
