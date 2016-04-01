package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Reporter;


/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.SQLCheck.java
 * @ClassName:    SQLCheck
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��18�� ����5:40:52
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��18�� ����5:40:52 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class SQLCheck {

	public static boolean sqlCheck(String db,String sqlcheck,String sqlvalue){
			boolean b=false;
//			sqlcheck = "desc goods";//SQL���
//			sqlcheck="select count(*) from goods where goods_name='���' and is_deleted='0'";
			DBHelper db1 = new DBHelper(sqlcheck,db);//����DBHelper����
			try {
				ResultSet ret = db1.pst.executeQuery();//ִ����䣬�õ������		
				while(ret.next()){
					String result = ret.getString(1);
//					System.out.println(result);
					if(result.equals(sqlvalue)){
						b=true;
					}else{
						Reporter.log("ERROR--���ݿ������------"+"result��"+result);
					}
				}

				ret.close();
				db1.close();//�ر�����
			} catch (SQLException e) {
				Reporter.log("ERROR--���ݿ��쳣��������Ի���������");
			}
		
		return b;
	}
}
