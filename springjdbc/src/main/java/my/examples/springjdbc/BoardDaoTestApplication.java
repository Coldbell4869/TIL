package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardDaoTestApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        BoardDao boardDao = applicationContext.getBean(BoardDao.class);
//        int boardCount = boardDao.getBoardCount();
//        System.out.println(boardCount);

        Board board =
                boardDao.getBoard(2L);
        System.out.println(board);

        int count = boardDao.getBoardCount();
        System.out.println(count);



        //            "insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) " +
        //                    "values( :title, :userId, :nickname, :content ,  0 , 0, 0 )";
    }
}
