package kr.or.ddit.db.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Factory Object[Method] Pattern
 *  : 객체 생성을 전담하는 개체를 운영하는 구조
 *
 */
public class ConnectionFactory {
   private static String driverClassName;
   private static String url;
   private static String user;
   private static String password;
   private static String connectionMessage;
   private static DataSource ds;
   static {
//      Properties properties = new Properties();
//      try(
//         InputStream is = ConnectionFactory.class.getResourceAsStream("dbInfo.properties");
//      ) {
//         properties.load(is);
	   
	   // class인것처럼 받아오기때문에 퀄러파일네임을 /이아니라 .으로 받아온다
	   ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo",Locale.KOREA);
	   	
        // 받아오는형식 bundle.getString(key);
	   // 기존 properties.getProperty
	   	driverClassName = bundle.getString("driverClassName");
         url = bundle.getString("url");
         user = bundle.getString("user");
         password = bundle.getString("password");
         connectionMessage = bundle.getString("connectionMessage");
         
         
         int initialSize = Integer.parseInt(bundle.getString("initialSize"));
         int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
         long maxWait = Long.parseLong(bundle.getString("maxWait"));
         
         ds = new BasicDataSource();
         ((BasicDataSource)ds).setDriverClassName(driverClassName);
         ((BasicDataSource)ds).setUrl(url);
         ((BasicDataSource)ds).setUsername(user);
         ((BasicDataSource)ds).setPassword(password);
         
         // 미리 만들어 놓은 conn 객체 생성을 최대 7개까지만 만듦
         ((BasicDataSource)ds).setMaxTotal(maxTotal);
         // 대기시간(대기 시간 동안 반납이 되면 괜찮음 하지만, 그 사이 반납되는 값이 없을 경우 하나 더 만듦)
         ((BasicDataSource)ds).setInitialSize(initialSize);
         // 최대 200까지 정책시킴
         ((BasicDataSource)ds).setMaxWaitMillis(maxWait);
         
         // 폴링 작업
//         ds = new OracleDataSource();
//         ((OracleDataSource) ds).setURL(url);
//         ((OracleDataSource) ds).setUser(user);
//         ((OracleDataSource) ds).setPassword(password);
         
         // 타입 안정성이 존재하지 않음
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//      } catch (IOException e) {
//         throw new RuntimeException(e);
//      }
   }
   
   public static Connection getConnection() throws SQLException {      
//      return DriverManager.getConnection(url, user, password);
	   System.out.println(connectionMessage);
      return ds.getConnection();
   }
   
}