package Testcase;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIsaveGoodsTest extends APITest{
  @Test
	public void saveGoodsTest() throws IOException {
	  
	boolean apiResult=true;
	String[][] testMap=ReadExcelCase.getTestMap("/baseWS/saveGoods");
	for(int i=0;i<testMap.length;i++){
		
		  DBHelper db1=new DBHelper();
		  try {
			db1.pst=db1.conn.prepareStatement("delete from category where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('1','243',\"01\",\"分类1\",'-1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('2','243',\"02\",\"分类2\",'-1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('3','243',\"0201\",\"分类3\",'2')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`,`is_deleted`)VALUES('4','243',\"03\",\"分类4\",'-1','1')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("delete from goods where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`,`bar_code`)VALUES('8888','4','商品','243','2000000000022')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("delete from goods_unit where tenant_id='243'");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`)VALUES('8001','001','单位','243')");
			db1.pst.executeUpdate();
			db1.pst=db1.conn.prepareStatement("insert into goods_unit (`id`,`unit_code`,`unit_name`,`tenant_id`,`is_deleted`)VALUES('8002','002','删除单位','243','1')");
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
