package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIdelVipTypeTest extends APITest{
	  @Test
	  public void delVipTypeTest() throws Exception {
		  
		  boolean apiResult=true;
			String[][] testMap=ReadExcelCase.getTestMap("/vipSettingWS/delVipType");
			for(int i=0;i<testMap.length;i++){
				
				  DBHelper db1=new DBHelper("saas-web");
				  try {
					  //商户243，删除所有会员
					  db1.pst=db1.conn.prepareStatement("delete from vip where tenant_id='243'");
					  db1.pst.executeUpdate();
					  
					  //商户243，添加5条会员类型数据，其中一条是被删除的
					  db1.pst=db1.conn.prepareStatement("delete from vip_type where tenant_id='243'");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("INSERT INTO vip_type (tenant_id, type_code, type_name, preferential_policy, points_factor,score_usage,mem_price_used, "
					  		+ "discount_rate, to_save_points, is_package_disc, is_promotion_disc, create_by, create_at, last_update_by, last_update_at, is_deleted,is_online_default)"
					  		+ "VALUES('243', '0000','金会员','2','1.00','1','1.000','1','1','1','1','admin',NOW(),'admin',NOW(),'0','0')");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("INSERT INTO vip_type (tenant_id, type_code, type_name, preferential_policy, points_factor,score_usage,mem_price_used, "
						  		+ "discount_rate, to_save_points, is_package_disc, is_promotion_disc, create_by, create_at, last_update_by, last_update_at, is_deleted,is_online_default)"
						  		+ "VALUES('243', '0001','银会员','2','1.00','1','1.000','1','1','1','1','admin',NOW(),'admin',NOW(),'0','0')");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("INSERT INTO vip_type (tenant_id, type_code, type_name, preferential_policy, points_factor,score_usage,mem_price_used, "
							  		+ "discount_rate, to_save_points, is_package_disc, is_promotion_disc, create_by, create_at, last_update_by, last_update_at, is_deleted,is_online_default)"
							  		+ "VALUES('243', '0002','普通会员','0','1.00','1','1.000','1','0','0','0','admin',NOW(),'admin',NOW(),'0','1')");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update vip_type set id=8000 where type_name='普通会员' and tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update vip_type set id=8001 where type_name='金会员' and tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update vip_type set id=9223372036854775807 where type_name='银会员' and tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("INSERT INTO vip_type (tenant_id, type_code, type_name, preferential_policy, points_factor,score_usage,mem_price_used, "
						  		+ "discount_rate, to_save_points, is_package_disc, is_promotion_disc, create_by, create_at, last_update_by, last_update_at, is_deleted,is_online_default)"
						  		+ "VALUES('243', '0003','会员','2','1.00','1','1.000','1','1','1','1','admin',NOW(),'admin',NOW(),'0','0')");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update vip_type set id=8002 where type_name='会员' and tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("INSERT INTO vip_type (tenant_id, type_code, type_name, preferential_policy, points_factor,score_usage,mem_price_used, "
							  		+ "discount_rate, to_save_points, is_package_disc, is_promotion_disc, create_by, create_at, last_update_by, last_update_at, is_deleted,is_online_default)"
							  		+ "VALUES('243', '0004','删除会员','2','10.00','10','1.000','1','1','1','1','admin',NOW(),'admin',NOW(),'1','0')");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update vip_type set id=8003 where type_name='删除会员' and tenant_id=243");
					  db1.pst.executeUpdate();
					  
					  //商户243，添加会员
					  db1.pst=db1.conn.prepareStatement("insert into vip (id,tenant_id,type_id,vip_code,vip_name,phone,is_deleted)VALUES(8000,243,8002,00016031801,'vip1',12345678901,0)");
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
