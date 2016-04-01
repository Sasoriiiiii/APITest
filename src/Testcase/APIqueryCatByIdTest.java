package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryCatByIdTest extends APITest{
  @Test
  public void queryCatByIdTest() throws IOException {
	  
		boolean apiResult=true;
		String[][] testMap=ReadExcelCase.getTestMap("/baseWS/queryCatById");
		for(int i=0;i<testMap.length;i++){
			
			  DBHelper db1=new DBHelper();
			  try {
				db1.pst=db1.conn.prepareStatement("delete from category where tenant_id='243'");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`mnemonics`)VALUES('1','243',\"01\",\"02\",'-1','1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`mnemonics`)VALUES('2','243',\"02\",\"分类03\",'-1','1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`mnemonics`)VALUES('3','243',\"0203\",\"分类03\",'2','1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`mnemonics`)VALUES('4','243',\"020304\",\"分类04\",'3','1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`is_deleted`,`mnemonics`)VALUES('5','243',\"03\",\"删除分类\",'-1','1','1')");
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
