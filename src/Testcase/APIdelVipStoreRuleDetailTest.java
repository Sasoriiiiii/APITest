package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIdelVipStoreRuleDetailTest extends APITest{
	  @Test
	  public void delVipStoreRuleDetailTest() throws Exception {
		  
		  boolean apiResult=true;
			String[][] testMap=ReadExcelCase.getTestMap("/vipSettingWS/delVipStoreRuleDetail");
			for(int i=0;i<testMap.length;i++){
				
				  DBHelper db1=new DBHelper("saas-web");
				  try {
					  //�̻�243��283��287��ɾ�����л�Ա��ֵ�������ϸ
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
//					  //�̻�283�����ɾ���Ĵ�ֵ����
//					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule (id,tenant_id,branch_id,is_off,dead_type,is_deleted)values(100,283,13895,0,0,1)");
//					  db1.pst.executeUpdate();
					  //�̻�287���δɾ���ĹرյĴ�ֵ�������ϸ
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule (id,tenant_id,branch_id,is_off,dead_type,is_deleted)values(101,287,13897,1,0,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule_details (id,rule_id,pay_limit,present_limit,is_deleted)values(8000,101,50,1,0)");
					  db1.pst.executeUpdate();					  
					  //�̻�243���δɾ����δ�رյĴ�ֵ�������ϸ
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule (id,tenant_id,branch_id,is_off,dead_type,is_deleted)values(102,243,13892,0,0,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule_details (id,rule_id,pay_limit,present_limit,is_deleted)values(8001,102,50,1,0)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into vip_store_rule_details (id,rule_id,pay_limit,present_limit,is_deleted)values(8002,102,200,5,1)");
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
