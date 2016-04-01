package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	public static final String databaseAddr="jdbc:mysql://192.168.0.50/";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";
	public static String database = databaseAddr+"saas-retail";

	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper(String sql,String db) {
		try {
			Class.forName(name);//ָ����������
			database=databaseAddr+db;
			conn = DriverManager.getConnection(database, user, password);//��ȡ����
			pst = conn.prepareStatement(sql);//׼��ִ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DBHelper(String db) {
		try {
			Class.forName(name);//ָ����������
			database=databaseAddr+db;
			conn = DriverManager.getConnection(database, user, password);//��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DBHelper(){
		try {
			Class.forName(name);//ָ����������
			conn = DriverManager.getConnection(database, user, password);//��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
