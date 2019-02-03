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
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("start", start);
        paramMap.put("limit", limit);
        return jdbc.query(SELECT_BY_PAGING, paramMap,rowMapper);
    }

    @Override
    public void addBoard(Board board) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", board.getTitle());
//        paramMap.put("user_id", board.getUserId());
        paramMap.put("nickname", board.getNickname());
        paramMap.put("content", board.getContent());
        paramMap.put("group_no", board.getGroupNo());
        paramMap.put("group_seq", board.getGroupSeq());
        paramMap.put("group_depth", board.getGroupDepth());
        jdbc.update(INSERT, paramMap);
//        return number.longValue();
    }
    //            "insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) " +
    //                    "values( :title, :userId, :nickname, :content ,  0 , 0, 0 )";

    @Override
    public Long getLastInsertId() {
        Long lastId = 0L;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("lastID", lastId);
        jdbc.query(SELECT_LAST_INSERT_ID, paramMap, rowMapper);
        return lastId;
    }

    @Override
    public void updateLastInsertId(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("group_no", getBoard(id).getGroupNo());
        paramMap.put("id", getBoard(id).getId());
        jdbc.update(UPDATE_LAST_INSERT_ID, paramMap);
    }

    @Override
    public void deleteBoard(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbc.update(DELETE, paramMap);
    }

    @Override
    public void updateReadCount(long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        jdbc.update(UPDATE_READ_COUNT, paramMap);
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
