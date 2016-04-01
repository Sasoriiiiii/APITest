package Testcase;

import java.io.IOException;

import Utils.HTTPRequest;
import Utils.ReadExcelCase;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.TestHttp.java
 * @ClassName:    TestHttp
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月19日 上午10:48:46
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月19日 上午10:48:46 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class TestHttp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[][] testMap=ReadExcelCase.getTestMap("userLogin");
		for(int i=0;i<testMap.length;i++){

			String data=testMap[i][8];
			HTTPRequest.HTTPPost("http://test.smartpos.top/portal/login/userLogin","",data);
		}

	}

}
