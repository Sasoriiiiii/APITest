package Testcase;

import java.sql.SQLException;

import Utils.DBHelper;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.PrepareSQL.java
 * @ClassName:    PrepareSQL
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��8�� ����4:57:30
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��8�� ����4:57:30 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class PrepareSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBHelper db1 = new DBHelper("saas-retail");
		try {
			// �̻�243ɾ��֧����ʽ�����֧����ʽ
			db1.pst = db1.conn.prepareStatement("delete from payment where tenant_id=243");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8000,'CSH','�ֽ�',0,1,0,243,13892,1)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8001,'CRD','���п�',0,1,0,243,13892,2)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8002,'ZFB','֧����',0,1,0,243,13892,3)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8003,'WX','΢֧��',0,1,0,243,13892,4)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8004,'DJQ','����ȯ',0,1,0,243,13892,5)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8005,'JF','����',0,1,0,243,13892,6)");
			db1.pst.executeUpdate();
			db1.pst = db1.conn.prepareStatement(
					"insert into payment (id,payment_code,payment_name,payment_status,currency_id,is_deleted,tenant_id,branch_id,payment_type)"
							+ "values(8006,'HYQB','��Ա��ֵ',0,1,0,243,13892,7)");
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
