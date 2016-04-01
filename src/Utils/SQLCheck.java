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
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午5:40:52
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午5:40:52 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class SQLCheck {

	public static boolean sqlCheck(String db,String sqlcheck,String sqlvalue){
			boolean b=false;
//			sqlcheck = "desc goods";//SQL语句
//			sqlcheck="select count(*) from goods where goods_name='测测' and is_deleted='0'";
			DBHelper db1 = new DBHelper(sqlcheck,db);//创建DBHelper对象
			try {
				ResultSet ret = db1.pst.executeQuery();//执行语句，得到结果集		
				while(ret.next()){
					String result = ret.getString(1);
//					System.out.println(result);
					if(result.equals(sqlvalue)){
						b=true;
					}else{
						Reporter.log("ERROR--数据库检测错误------"+"result："+result);
					}
				}

				ret.close();
				db1.close();//关闭连接
			} catch (SQLException e) {
				Reporter.log("ERROR--数据库异常，请检查测试环境！！！");
			}
		
		return b;
	}
}
