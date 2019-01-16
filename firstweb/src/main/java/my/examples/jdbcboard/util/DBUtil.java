package my.examples.jdbcboard.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    private static HikariConfig config = null;
    private static DataSource ds = null;
    private static DBUtil instance = new DBUtil();

//    private static final String driverClassname = "com.mysql.cj.jdbc.Driver"; // driver class이름도 JDBC Driver에 달라다.
//    private static final String driverURL = "jdbc:mysql://localhost:3306/freeboard?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"; // driver URL형식 Database마다 다르다.
//    private static final String dbUserId = "boardadmin";
//    private static final String dbUserPassword = "admin";


    // HikariCP에 맞도록 생성자 추가
    private DBUtil() {
        String configFile = "/datasource.properties";
        HikariConfig config = new HikariConfig(configFile);

        ds = new HikariDataSource(config);
    }

    // static DBUtil getInstance()메소드 추가
    public static DBUtil getInstance(){
        return instance;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();   // 로그를 남기는 코드가 있어야 한다.
            throw new RuntimeException("DB연결을 할 수 없습니다.");
        }
        return conn;
    }
//        Connection conn = null;
//        try {
//            Class.forName(driverClassname); // driver class가 로딩.
//            conn = DriverManager.getConnection(driverURL, dbUserId, dbUserPassword);
//        }catch(Exception ex){
//            ex.printStackTrace(); // 로그를 남기는 코드가 있어야 한다.
//            throw new RuntimeException("DB연결을 할 수 없습니다.");
//        }
//        return conn;

    public static void rollback(Connection conn){
        try{ conn.rollback(); } catch(Exception ignore){}
    }

    public static void close(Connection conn){
        try{ conn.close();} catch(Exception ignore){}
    }

    public static void close(ResultSet rs, PreparedStatement ps){
        try{ rs.close(); } catch(Exception ignore){}
        close(ps);
    }

    public static void close(PreparedStatement ps){
        try{ ps.close(); } catch(Exception ignore){}
    }
}
