package Testcase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.APIsaveCatTest.java
 * @ClassName:    APIsaveCatTest
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��2�� ����2:20:02
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��2�� ����2:20:02 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class APIsaveCatTest extends APITest{
	  @Test
		public void saveCatTest() throws IOException {
		  
		boolean apiResult=true;
		String[][] testMap=ReadExcelCase.getTestMap("/baseWS/saveCat");
		for(int i=0;i<testMap.length;i++){
			
			  DBHelper db1=new DBHelper();
			  try {
				db1.pst=db1.conn.prepareStatement("delete from category where tenant_id='243'");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('1','243',\"01\",\"1������\",'-1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('2','243',\"0101\",\"2������\",'1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('3','243',\"010101\",\"3������\",'2')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into category (`id`,`tenant_id`,`cat_code`,`cat_name`,`parent_id`)VALUES('4','243',\"02\",\"��Ʒ����\",'-1')");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("delete from goods where tenant_id='243'");
				db1.pst.executeUpdate();
				db1.pst=db1.conn.prepareStatement("insert into goods (`id`,`category_id`,`goods_name`,`tenant_id`)VALUES('8888','4','������Ʒ','243')");
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
