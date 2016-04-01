package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryGoodsLibraryTest extends APITest {
  @Test
	public void queryGoodsLibraryTest() throws IOException {
	  
	boolean apiResult=true;
	String[][] testMap=ReadExcelCase.getTestMap("/publicWS/queryGoodsLibrary");
	for(int i=0;i<testMap.length;i++){
		
		  DBHelper db1=new DBHelper();
		  try {
			db1.pst=db1.conn.prepareStatement("delete from goods_library where photo='/cws/'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods_library (`id`,`goods_name`,`spec`,`bar_code`,`photo`)"
					+ "VALUES('3333','3333','250','2000000000033','/cws/')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods_library (`id`,`goods_name`,`spec`,`bar_code`,`photo`,`is_deleted`)"
					+ "VALUES('3334','3334','251','2000000000034','/cws/','1')");
			db1.pst.executeUpdate();	
	
			db1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpResponse response=super.runAPITest(testMap[i]);
//		System.out.println(EntityUtils.toString(response.getEntity()));
		boolean caseResult=super.assertTrue(testMap[i],response);
		apiResult=apiResult&&caseResult;
		
	}
	Assert.assertTrue(apiResult, "+++");
}
}
