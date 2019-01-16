package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.FreeBoard;

import java.util.List;

public interface FreeBoardService {
    // page에 해당하는 목록을 읽어온다
    // 전체 건수를 읽어온다.
    // 글을 읽어온다. (글 읽기 + 조회수 증가)
    // 글을 삭제한다.
    // 글을 쓴다.
    // 글 내용을 불러와서 수정한다
    // 수정한 내용으로 기존 내용을 갈아치운다.

    public List<FreeBoard> getFreeBoards(int page);
    public FreeBoard getFreeBoard(Long id);
    public void deleteFreeBoard(Long id);
    public void addFreeBoard(FreeBoard freeBoard);
//    public void updateReadCount(long id);
//    public void updateBoard(String name, String title, String content, long id);

}
