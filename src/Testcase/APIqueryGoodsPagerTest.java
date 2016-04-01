package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqueryGoodsPagerTest extends APITest{
  @Test
	public void queryGoodsPagerTest() throws IOException {
	  
	boolean apiResult=true;
	String[][] testMap=ReadExcelCase.getTestMap("/baseWS/queryGoodsPager");
	for(int i=0;i<testMap.length;i++){
		
		  DBHelper db1=new DBHelper();
		  try {
			db1.pst=db1.conn.prepareStatement("delete from goods where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("delete from category where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('8000','243',\"01\",\"分类1\",'-1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`supplier_id`,`short_name`,`mnemonic`)"
					+ "VALUES('8886','8000','商品1','243','2000000000022','0','sp1','sp1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`supplier_id`,`short_name`,`mnemonic`)"
					+ "VALUES('8887','8000','商品2','243','2000000000033','0','sp2','sp2')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`supplier_id`,`short_name`,`mnemonic`)"
					+ "VALUES('8888','8000','商品3','243','2000000000044','0','sp3','sp3')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`,`is_deleted`,`short_name`,`mnemonic`)"
					+ "VALUES('8889','8000','商品4','243','2000000000055','1','sp4','sp4')");
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
