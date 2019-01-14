package my.examples.jdbcboard.exam;

import my.examples.firstweb.Board;
import my.examples.firstweb.FreeBoard;

import java.util.List;

public interface FreeBoardDao {
    // DAO : Data Access Object
        public FreeBoard getFreeBoard(long id);
        public List<FreeBoard> getFreeBoards(long start, long limit);
}
