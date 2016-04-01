package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIbarCreatorTest extends APITest{
  @Test
	public void barCreatorTest() throws IOException {
	  
	boolean apiResult=true;
	String[][] testMap=ReadExcelCase.getTestMap("/publicWS/barCreator");
	for(int i=0;i<testMap.length;i++){
		
		CloseableHttpResponse response=super.runAPITest(testMap[i]);
//		System.out.println(EntityUtils.toString(response.getEntity()));
		boolean caseResult=super.assertTrue(testMap[i],response);
		apiResult=apiResult&&caseResult;
		
	}
	Assert.assertTrue(apiResult, "+++");
}
}
