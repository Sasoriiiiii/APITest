package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryUnitByIdTest extends APITest{
  @Test
  public void queryUnitByIdTest()  throws Exception {
	  
	  boolean apiResult=true;
		String[][] testMap=ReadExcelCase.getTestMap("/baseWS/queryUnitById");
		for(int i=0;i<testMap.length;i++){
			
			  DBHelper db1=new DBHelper();
			  try {
				db1.pst=db1.conn.prepareStatement("delete from goods_unit where tenant_id='243'");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`)VALUES('8001','001','ÖØ¸´','243')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`,`is_deleted`)VALUES('8002','002','1234567890','243','1')");
				db1.pst.executeUpdate();
				db1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CloseableHttpResponse response=super.runAPITest(testMap[i]);
//			System.out.println(EntityUtils.toString(response.getEntity()));
			boolean caseResult=super.assertTrue(testMap[i],response);
			apiResult=apiResult&&caseResult;
			
		}
		Assert.assertTrue(apiResult, "+++");
  }
}
