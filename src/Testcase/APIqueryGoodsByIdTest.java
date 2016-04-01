package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryGoodsByIdTest extends APITest{
  @Test
	public void queryGoodsByIdTest() throws IOException {
	  
	boolean apiResult=true;
	String[][] testMap=ReadExcelCase.getTestMap("/baseWS/queryGoodsById");
	for(int i=0;i<testMap.length;i++){
		
		  DBHelper db1=new DBHelper();
		  try {
			db1.pst=db1.conn.prepareStatement("delete from category where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('1','243',\"01\",\"分类1\",'-1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("delete from goods where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`supplier_id`)VALUES('8888','1','商品','243','2000000000022','0')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`is_deleted`)VALUES('8889','1','商品','243','2000000000022','1')");
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
