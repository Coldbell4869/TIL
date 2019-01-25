package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

import static my.examples.springjdbc.dao.BoardDaoSqls.*;

@Repository
public class BoardDaoImpl implements BoardDao{
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardDaoImpl(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                           .withTableName("board")
                           .usingGeneratedKeyColumns("id");
    }

    @Override
    public Board getBoard(Long id) {
        Board board = null;
        try{
            Map<String, Object> paramMap =
                    Collections.singletonMap("id", id);
            board = jdbc.queryForObject(SELECT_BY_ID, paramMap, rowMapper);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        return null;
    }

    @Override
    public int addBoard(Board board) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", board.getTitle());
        paramMap.put("user_id", board.getUserId());
        paramMap.put("nickname", board.getNickname());
        paramMap.put("content", board.getContent());
        paramMap.put("group_no", board.getGroupNo());
        paramMap.put("group_seq", board.getGroupSeq());
        paramMap.put("group_depth", board.getGroupDepth());
        Number number = simpleJdbcInsert.executeAndReturnKey(paramMap);
        return number.intValue();    }
    //            "insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) " +
    //                    "values( :title, :userId, :nickname, :content ,  0 , 0, 0 )";

    @Override
    public Long getLastInsertId() {
        return null;
    }

    @Override
    public void updateLastInsertId(Long id) {

    }

    @Override
    public void deleteBoard(Long id) {

    }

    @Override
    public void updateReadCount(long id) {

    }

    @Override
    public void updateGroupSeqGt(int groupNo, int groupSeq) {

    }

    @Override
    public void addReBoard(Board board) {

    }

    @Override
    public int getBoardCount() {
        Map emptyMap = Collections.emptyMap();
        int count = jdbc.queryForObject(TOTAL_BOARD_POSTS, emptyMap, Integer.class);
        return count;
    }
}
