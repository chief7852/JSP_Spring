package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	private static String driverClassName;
	private static String url;
	private static String user;
	private static String password;
	private static String connectionMessage;
	private static DataSource ds;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.mybatis.dbinfo");
		driverClassName = bundle.getString("driverClassName");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		connectionMessage = bundle.getString("connectionMessage");

		int initialSize = Integer.parseInt(bundle.getString("initialSize"));
		int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
		long maxWait = Long.parseLong(bundle.getString("maxWait"));

		ds = new BasicDataSource();
		((BasicDataSource) ds).setDriverClassName(driverClassName);
		((BasicDataSource) ds).setUrl(url);
		((BasicDataSource) ds).setUsername(user);
		((BasicDataSource) ds).setPassword(password);

		((BasicDataSource) ds).setMaxTotal(maxTotal);
		((BasicDataSource) ds).setInitialSize(initialSize);
		((BasicDataSource) ds).setMaxWaitMillis(maxWait);
	}

	public static Connection getConnection() throws SQLException {
		System.out.println(connectionMessage);
		return ds.getConnection();
	}

}
