package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryUnitPagerTest extends APITest{
  @Test
  public void queryUnitPagerTest()  throws Exception {
	  
	  boolean apiResult=true;
		String[][] testMap=ReadExcelCase.getTestMap("/baseWS/queryUnitPager");
		for(int i=0;i<testMap.length;i++){
			
			  DBHelper db1=new DBHelper();
				db1.pst=db1.conn.prepareStatement("delete from goods_unit where tenant_id='243'");
				db1.pst.executeUpdate();
			  try {
				  for(int j=1;j<=12;j++){
					  String id= Integer.toString(8000+j);
					  String unitcode=Integer.toString(j);
					  String name="µ¥Î»"+Integer.toString(j);
					  db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`)VALUES('"+id+"','"+unitcode+"','"+name+"','243')");
					  db1.pst.executeUpdate(); 
				  }
				db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`)VALUES('8013','13','1234567890','243')");
				db1.pst.executeUpdate();  
				db1.pst=db1.conn.prepareStatement("update goods_unit set is_deleted='1' where id=8010");
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
