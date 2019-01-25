package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    //    @Autowired
    private BoardDao boardDao;

    // BoardServiceImpl객체를 생성하려고 BoardDaoImpl 객체를 주입한다.
    public BoardServiceImpl(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    // 서비스 메소드는 트랜젝션 단위로 동작한다.
    // 트랜젝션 단위로 동작하려면 @Transactional 어노테이션이 붙는다.
    // RuntimeException이 발생하면 자동 rollback한다.
    // 성공하면 commit한다.

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int page) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        boardDao.updateReadCount(id);
        return boardDao.getBoard(id);
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) {

    }

    @Override
    @Transactional
    public void addBoard(Board board) {

    }

    @Override
    @Transactional
    public void addReBoard(Board board) {

    }
}
