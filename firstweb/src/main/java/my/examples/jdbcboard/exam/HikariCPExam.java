package my.examples.jdbcboard.exam;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import my.examples.jdbcboard.dto.FreeBoard;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HikariCPExam {
    public static void main(String[] args){
        // src/main/resources 아래에 datasource.properties를 위치시킨다.
        // src/main/resources 이 경로도 CLASSPATH
        // classpath에 있는 자원을 읽어들이려면 / 로 시작한다.
        String configFile = "/datasource.properties";
        HikariConfig config = new HikariConfig(configFile);

//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=UTF-8");
//        config.setUsername("connect");
//        config.setPassword("connect");

        DataSource ds;
        ds = new HikariDataSource(config);

        int start = 0;
        int limit = 3;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();

            if (conn != null)
                System.out.println("connection is ok");

            String sql = "SELECT id, user_id, user_name, title, regdate, readcount, family, level, sequence FROM freepost LEFT JOIN user ON user.user_name = freepost.user_name ORDER BY id DESC LIMIT ?, ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
            ps.setInt(2, limit);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while(rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                Date regdate = rs.getDate(4);
                int readcount = rs.getInt(5);
//                int family = rs.getInt(7);
//                int level = rs.getInt(8);
//                int sequence = rs.getInt(9);
//                Long id, String user_name, String title, String content, Date regdate, int readcount
                FreeBoard freeBoard = new FreeBoard(id, title, content, regdate, readcount);
                System.out.println(freeBoard);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            try{
                rs.close();
            }catch(Exception ignore){}
            try{
                ps.close();
            }catch(Exception ignore){}
            try{
                conn.close();
            }catch(Exception ignore){}
        }

    }
}
