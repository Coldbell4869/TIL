package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            // 여러개의 SQL이 실행
            String sql = "insert into freepost (name, title, content) values ('이름', '타이틀', '내용내용')";
            try(PreparedStatement ps = conn.prepareStatement(sql);){
                ps.executeQuery();
                ps.clearParameters();
                if (1 == 1) throw new RuntimeException("-_-;");
                ps.executeUpdate();
                ps.clearParameters();
            }
            conn.commit();
        }catch(Exception ex){
            try{ conn.rollback(); }catch(Exception ignore){}
        }finally{
            DBUtil.close(conn);
        }
    }
}
