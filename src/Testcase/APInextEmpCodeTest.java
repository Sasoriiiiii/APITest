package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APInextEmpCodeTest extends APITest{
	  @Test
	  public void nextEmpCodeTest() throws Exception {
		  
		  boolean apiResult=true;
			String[][] testMap=ReadExcelCase.getTestMap("/baseWS/nextEmpCode");
			for(int i=0;i<testMap.length;i++){
				 DBHelper db1=new DBHelper("saas");
				  try {
					  //商户243删除用户角色关系、用户，新增用户、用户角色关系
					  db1.pst=db1.conn.prepareStatement("delete from s_user_role_r where role_id=959 or role_id=960");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("delete from s_user where tenant_id=243");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into s_user (id,login_name,login_pass,user_type,state,name,is_deleted,tenant_id)"
					  		+ "values(80000,61011098,'e10adc3949ba59abbe56e057f20f883e',1,1,123,0,243)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into s_user_role_r (user_id,role_id)values(80000,959)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("insert into s_user_role_r (user_id,role_id)values(80000,960)");
					  db1.pst.executeUpdate();
					  db1.pst=db1.conn.prepareStatement("update tenant set user_id=80000 where id=243");
					  db1.pst.executeUpdate();
					  
					  db1.pst = db1.conn.prepareStatement(
						"insert into s_user (id,login_name,login_pass,user_type,state,name,is_deleted,tenant_id)"
								+ "values(80001,'0001:61011098','21218cca77804d2ba1922c33e0151105',3,1,123,0,243)");
					  db1.pst.executeUpdate();
					  db1.pst = db1.conn.prepareStatement("insert into s_user_role_r (user_id,role_id)values(80001,959)");
					  db1.pst.executeUpdate();
					  db1.pst = db1.conn.prepareStatement(
						"insert into s_user (id,login_name,login_pass,user_type,state,name,is_deleted,tenant_id)"
								+ "values(80002,'0002:61011098','21218cca77804d2ba1922c33e0151105',3,2,123,0,243)");
					  db1.pst.executeUpdate();
					  db1.pst = db1.conn.prepareStatement("insert into s_user_role_r (user_id,role_id)values(80002,959)");
					  db1.pst.executeUpdate();
					  db1.pst = db1.conn.prepareStatement(
						"insert into s_user (id,login_name,login_pass,user_type,state,name,is_deleted,tenant_id)"
								+ "values(80003,'0003:61011098','21218cca77804d2ba1922c33e0151105',3,1,123,1,243)");
					  db1.pst.executeUpdate();
					  db1.pst = db1.conn.prepareStatement("insert into s_user_role_r (user_id,role_id)values(80003,959)");
					  db1.pst.executeUpdate();
					  

					db1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  DBHelper db2=new DBHelper("saas-retail");
				  try {
					  //商户243删除员工、新增员工
					  db2.pst=db2.conn.prepareStatement("delete from employee where tenant_id=243");
					  db2.pst.executeUpdate();
					  db2.pst=db2.conn.prepareStatement("insert into employee (id,tenant_id,branch_id,user_id,login_name,code,name,password_for_local,is_deleted)"
						  		+ "values(1000,243,13892,80000,'61011098','0000',123,'21218cca77804d2ba1922c33e0151105',0)");
					  db2.pst.executeUpdate();
					  db2.pst=db2.conn.prepareStatement("insert into employee (id,tenant_id,branch_id,user_id,login_name,code,name,password_for_local,is_deleted)"
					  		+ "values(1001,243,13892,80001,'0001:61011098','0001',123,'21218cca77804d2ba1922c33e0151105',0)");
					  db2.pst.executeUpdate();
					  db2.pst = db2.conn.prepareStatement(
						"insert into employee (id,tenant_id,branch_id,user_id,login_name,code,name,password_for_local,is_deleted)"
								+ "values(1002,243,13892,80002,'0002:61011098','0002',123,'21218cca77804d2ba1922c33e0151105',0)");
					  db2.pst.executeUpdate();
					  db2.pst = db2.conn.prepareStatement(
						"insert into employee (id,tenant_id,branch_id,user_id,login_name,code,name,password_for_local,is_deleted)"
								+ "values(1003,243,13892,80003,'0003:61011098','0003',123,'21218cca77804d2ba1922c33e0151105',1)");
					  db2.pst.executeUpdate();


					db2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
					CloseableHttpResponse response=super.runAPITest(testMap[i]);
//					System.out.println(EntityUtils.toString(response.getEntity()));
					boolean caseResult=super.assertTrue(testMap[i],response);
					apiResult=apiResult&&caseResult;
				}catch(Exception e){
					System.out.println(e.toString());
				}

				
			}
			Assert.assertTrue(apiResult, "+++");
	  }
}
