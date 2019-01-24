package my.examples.reflection;

import java.util.Date;

public class BoardService {
    public Board getBoard(Long id){
        Board board = new Board();
        board.setId(id);
        board.setTitle("hello");
        board.setContent("world");
        board.setName("kim");
        board.setReadCount(0);
        board.setRegdate(new Date());
        return board;
    }

    public void addBoard(Board board){
        System.out.println(board);
    }
}
