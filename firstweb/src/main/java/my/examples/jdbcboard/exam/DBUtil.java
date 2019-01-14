package my.examples.jdbcboard.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    private static final String driverClassname = "com.mysql.cj.jdbc.Driver"; // driver class이름도 JDBC Driver에 달라다.
    private static final String driverURL = "jdbc:mysql://localhost:3306/freeboard?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"; // driver URL형식 Database마다 다르다.
    private static final String dbUserId = "boardadmin";
    private static final String dbUserPassword = "admin";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driverClassname); // driver class가 로딩.
            conn = DriverManager.getConnection(driverURL, dbUserId, dbUserPassword);
        }catch(Exception ex){
            ex.printStackTrace(); // 로그를 남기는 코드가 있어야 한다.
            throw new RuntimeException("DB연결을 할 수 없습니다.");
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try{ rs.close(); } catch(Exception ignore){}
        close(ps, conn);
    }

    public static void close(PreparedStatement ps, Connection conn){
        try{ ps.close(); } catch(Exception ignore){}
        try{ conn.close(); } catch(Exception ignore){}
    }
}
