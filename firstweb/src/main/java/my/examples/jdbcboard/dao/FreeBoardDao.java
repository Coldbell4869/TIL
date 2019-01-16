package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.FreeBoard;

import java.util.List;

public interface FreeBoardDao {
    // DAO : Data Access Object
    public FreeBoard getFreeBoard(Long id);
    public List<FreeBoard> getFreeBoards(long start, long limit);

    void addBoard(FreeBoard freeboard);

    void deleteBoard(Long id);

    void updateReadCount(long id);

    void updateBoard(String name, String title, String content, long id);

}


