package Testcase;

import java.sql.SQLException;

import Utils.DBHelper;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.PrepareSQL.java
 * @ClassName:    PrepareSQL
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月8日 下午4:57:30
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月8日 下午4:57:30 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class PrepareSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type, is_score,fix_value,fix_num,is_voucher)"
							+ "values(8007,'ZDY_0001','zf1',0,1,0,243,13892,1,1,5,2,1)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type, is_score)"
							+ "values(8008,'ZDY_0002','zf2',1,1,0,243,13892,1,0)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8009,'ZDY_0003','zfchf',0,1,0,243,13892,1)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8010,'ZDY_0004','zfshch',1,1,1,243,13892,1)");
			db1.pst.executeUpdate();
			db1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
