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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��19�� ����10:48:46
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��19�� ����10:48:46 
 * @UpdateRemark: ˵�������޸�����  
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
