package Testcase;

import java.sql.SQLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.APITest;
import Utils.DBHelper;
import Utils.ReadExcelCase;

public class APIpaymentListTest extends APITest {
	@Test
	public void paymentListTest() throws Exception {

		boolean apiResult = true;
		String[][] testMap = ReadExcelCase.getTestMap("/baseWS/paymentList");
		for (int i = 0; i < testMap.length; i++) {
			DBHelper db1 = new DBHelper("saas-retail");
			try {
				// 商户243删除支付方式，添加支付方式
				db1.pst = db1.conn.prepareStatement("delete from payment where tenant_id=243");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8000,'CSH','现金',0,1,0,243,13892,1)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8001,'CRD','银行卡',0,1,0,243,13892,2)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8002,'ZFB','支付宝',0,1,0,243,13892,3)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8003,'WX','微支付',0,1,0,243,13892,4)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8004,'DJQ','代金券',0,1,0,243,13892,5)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8005,'JF','积分',0,1,0,243,13892,6)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8006,'HYQB','会员储值',0,1,0,243,13892,7)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8007,'ZDY_0001','zf1',0,1,0,243,13892,1)");
				db1.pst.executeUpdate();
				db1.pst = db1.conn.prepareStatement(
						"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
								+ "values(8008,'ZDY_0001','删除',0,1,1,243,13892,1)");
				db1.pst.executeUpdate();
				db1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				CloseableHttpResponse response = super.runAPITest(testMap[i]);
				// System.out.println(EntityUtils.toString(response.getEntity()));
				boolean caseResult = super.assertTrue(testMap[i], response);
				apiResult = apiResult && caseResult;
			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}
		Assert.assertTrue(apiResult, "+++");
	}
}
