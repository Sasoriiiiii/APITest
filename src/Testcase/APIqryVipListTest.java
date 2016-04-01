package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIqryVipListTest extends APITest{
	  @Test
	  public void qryVipListTest() throws Exception {
		  
		  boolean apiResult=true;
			String[][] testMap=ReadExcelCase.getTestMap("/vipSettingWS/qryVipList");
			for(int i=0;i<testMap.length;i++){
				
				  DBHelper db1=new DBHelper("saas-web");
				  try {
					  //商户243、283、287，删除所有会员储值规则和明细
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule_details where rule_id=(select id from vip_store_rule where tenant_id=243)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule_details where rule_id=(select id from vip_store_rule where tenant_id=283)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule_details where rule_id=(select id from vip_store_rule where tenant_id=287)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule where tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule where tenant_id=283");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip_store_rule where tenant_id=287");
					  db1.pst.executeUpdate();				  
					  //商户243添加储值规则和明细
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule (id,tenant_id,branch_id,is_off,dead_type,is_deleted)values(102,243,13892,0,0,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule_details (id,rule_id,pay_limit,present_limit,is_deleted)values(8001,102,50,1,0)");
					  db1.pst.executeUpdate();
					  //删除所有会员，添加会员
					  db1.pst=db1.conn.prepareStatement("delete from vip where tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from vip where id>=8000");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,branch_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8000,243,13892,8001,'00016031901','vip1',12345678901,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,branch_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8001,243,13892,8001,'00016031902','vip2',12345678902,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,branch_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8002,243,13892,8001,'10016031903','vip3',12345678903,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,branch_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8003,243,13892,8001,'00016031904','vip4',10016031903,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,branch_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8004,243,13892,8001,'00016031905','vip5',12345678901,1)");
					  db1.pst.executeUpdate();
					db1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CloseableHttpResponse response=super.runAPITest(testMap[i]);
//				System.out.println(EntityUtils.toString(response.getEntity()));
				boolean caseResult=super.assertTrue(testMap[i],response);
				apiResult=apiResult&&caseResult;
				
			}
			Assert.assertTrue(apiResult, "+++");
	  }
}
