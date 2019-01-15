package my.examples.jdbcboard.exam;

import my.examples.firstweb.FreeBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardDaoImpl implements FreeBoardDao {
    @Override
    public FreeBoard getFreeBoard(long idParam) {
        FreeBoard freeBoard = null; // return할 타입을 선언한다.

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB 연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId, DB User Password

            // >> HikariCP에 맞도록 conn 변경
            conn = DBUtil.getInstance().getConnection();

//            conn = DBUtil.getConnection();

            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT id, title, uname, content, regdate, readcount, family, level, sequence FROM freepost LEFT JOIN freeuser ON freeuser.uname = freepost.name where id =?";
            ps = conn.prepareStatement(sql);

            // c. 바인딩 - PreparedStatement
            ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다.

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            if (rs.next()) {
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                String content = rs.getString(4);
                Date regdate = rs.getDate(5);
                int readcount = rs.getInt(6);
                int family = rs.getInt(7);
                int level = rs.getInt(8);
                int sequence = rs.getInt(9);

                freeBoard = new FreeBoard(id, title, name, content, regdate, readcount, family, level, sequence);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close한다.
            DBUtil.close(rs, ps, conn);
        }
        return freeBoard;
    }

    @Override
    public List<FreeBoard> getFreeBoards(long start, long limit) {
        List<FreeBoard> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password

            // >> HikariCP에 맞도록 conn 변경
            conn = DBUtil.getInstance().getConnection();

//            conn = DBUtil.getConnection();

            if (conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT id, title, uname, content, regdate, readcount, family, level, sequence FROM freepost LEFT JOIN freeuser ON freeuser.uname = freepost.name ORDER BY id DESC LIMIT ?, ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 start를,
            ps.setLong(2, limit); // 두번째 물음표에 limit를 바인딩한다.

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while (rs.next()) {   // 리스트는 while문으로.. // ResultSet의 next() 메소드.
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                String content = rs.getString(4);
                Date regdate = rs.getDate(5);
                int readcount = rs.getInt(6);
                int family = rs.getInt(7);
                int level = rs.getInt(8);
                int sequence = rs.getInt(9);

                FreeBoard freeBoard = new FreeBoard(id, title, name, content, regdate, readcount, family, level, sequence);

                list.add(freeBoard);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            DBUtil.close(rs,ps,conn);
        }
        return list;
    }
}
