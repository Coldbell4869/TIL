package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.FreeBoard;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardDaoImpl implements FreeBoardDao {
    @Override
    public FreeBoard getFreeBoard(Long idParam) {
        FreeBoard freeBoard = null; // return할 타입을 선언한다.

        Connection conn = ConnectionContextHolder.getConnection();
        try {
            // a. DB 연결 - Connection
            //    DB 연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId, DB User Password

            // b. SELECT SQL 준비 - Connection
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.SELECT_BY_ID);){
                // c. 바인딩 - PreparedStatement
                ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다.

                // d. SQL 실행 - PreparedStatement
//                String sql = "SELECT id, name, title, content, regdate, readcount, family, level, sequence FROM freepost where id =?";
                try (ResultSet rs = ps.executeQuery();) {  // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
                    // f. e에서 읽어오지 못하는 경우도 있다.

                    if (rs.next()) {
                        long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String title = rs.getString(3);
                        String content = rs.getString(4);
                        Date regdate = rs.getDate(5);
                        int readcount = rs.getInt(6);
                        int family = rs.getInt(7);
                        int level = rs.getInt(8);
                        int sequence = rs.getInt(9);

//                        freeBoard = new FreeBoard(id, name, title, content, regdate, readcount, family, level, sequence);
                        freeBoard = new FreeBoard(); // 기본 생성자?
                        freeBoard.setId(id);
                        freeBoard.setName(name);
                        freeBoard.setTitle(title);
                        freeBoard.setContent(content);
                        freeBoard.setRegdate(regdate);
                        freeBoard.setReadcount(readcount);
                        freeBoard.setFamily(family);
                        freeBoard.setLevel(level);
                        freeBoard.setSequence(sequence);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return freeBoard;
    }

    @Override
    public List<FreeBoard> getFreeBoards(long start, long limit) {
        List<FreeBoard> freeboards = new ArrayList<>();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Connection conn = ConnectionContextHolder.getConnection();
            // b. SELECT SQL 준비 - Connection
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.SELECT_BY_PAGING);){
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 start를,
            ps.setLong(2, limit); // 두번째 물음표에 limit를 바인딩한다.

            // d. SQL 실행 - PreparedStatement
            try(ResultSet rs = ps.executeQuery();){ // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            // id, name, title, content, regdate, readcount, family, level, sequence
                while (rs.next()) {   // 리스트는 while문으로.. // ResultSet의 next() 메소드.
                    long id = rs.getLong(1);
                    String name = rs.getString(2);
                    String title = rs.getString(3);
                    Date regdate = rs.getDate(4);
                    int readcount = rs.getInt(5);
                    int family = rs.getInt(6);
                    int level = rs.getInt(7);
                    int sequence = rs.getInt(8);

//                    FreeBoard freeBoard = new FreeBoard(id, name, title, content, regdate, readcount, family, level, sequence);

                    FreeBoard freeBoard = new FreeBoard(); // 기본 생성자?
                    freeBoard.setId(id);
                    freeBoard.setName(name);
                    freeBoard.setTitle(title);
                    freeBoard.setRegdate(regdate);
                    freeBoard.setReadcount(readcount);
                    freeBoard.setFamily(family);
                    freeBoard.setLevel(level);
                    freeBoard.setSequence(sequence);

                    freeboards.add(freeBoard);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return freeboards;
    }

    @Override
    public void addBoard(FreeBoard freeboard) {
        try{
        Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.INSERT);) {
                //name, title, content
                ps.setString(1, freeboard.getName());
                ps.setString(2, freeboard.getTitle());
                ps.setString(3, freeboard.getContent());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Long getLastInsertId() {
        Long lastId = 0L;

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.SELECT_LAST_INSERT_ID);) {
                try(ResultSet rs = ps.executeQuery();){
                    if (rs.next()) {
                        lastId = rs.getLong(1);
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lastId;
    }

    @Override
    public void updateLastInsertId(Long id){
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.UPDATE_LAST_INSERT_ID);) {
                ps.setLong(1, id);
                ps.setLong(2, id);
                ps.executeUpdate();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBoard(Long id) {
        try{
        Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.DELETE);) {
            ps.setLong(1, id);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateReadCount(long id) {
        try{
        Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(FreeBoardDaoSQL.UPDATE);){
                ps.setLong(1, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}