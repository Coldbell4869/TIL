package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardDao {
    public Board getBoard(Long id);

    public List<Board> getBoards(int start, int limit);

    void addBoard(Board board);

    Long getLastInsertId();

    void updateLastInsertId(Long id);

    void deleteBoard(Long id);

    void updateReadCount(long id);

    void updateGroupSeqGt(int groupNo, int groupSeq);

    void addReBoard(Board board);

    public int getBoardCount();
}