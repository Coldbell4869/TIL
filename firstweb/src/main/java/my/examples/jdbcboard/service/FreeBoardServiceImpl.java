package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.FreeBoard;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;
import my.examples.jdbcboard.dao.FreeBoardDao;
import my.examples.jdbcboard.dao.FreeBoardDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardServiceImpl implements FreeBoardService{
    public static final int SIZE = 3;

    @Override
    public List<FreeBoard> getFreeBoards(int page) {
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        int start = page * SIZE - SIZE;
        int limit = SIZE;

        List<FreeBoard> freeBoards = new ArrayList<>();
        Connection conn = null;

        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            freeBoards = freeBoardDao.getFreeBoards(start, limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
        return freeBoards;
    }

    @Override
    public FreeBoard getFreeBoard(Long id) {
        FreeBoard freeboard = null;
        Connection conn = null;
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            freeboard = freeBoardDao.getFreeBoard(id);
            freeBoardDao.updateReadCount(id);
            conn.commit();  // 트랜잭션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn); // 해당 트랜잭션에 대한 rollback
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
        return freeboard;
    }

    @Override
    public void deleteFreeBoard(Long id) {
        Connection conn = null;
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            freeBoardDao.deleteBoard(id);
            conn.commit(); // 트랜젝션 커밋
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }

    @Override
    public void addFreeBoard(FreeBoard freeBoard) {
        Connection conn = null;
        FreeBoardDao freeBoardDao = new FreeBoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            freeBoardDao.addBoard(freeBoard);
            conn.commit();
        } catch (Exception ex) {
            DBUtil.rollback(conn);
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }
}
