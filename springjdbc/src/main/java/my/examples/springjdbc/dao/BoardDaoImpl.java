package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static my.examples.springjdbc.dao.BoardDaoSqls.*;

@Repository
public class BoardDaoImpl implements BoardDao{
    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardDaoImpl(DataSource dataSource){
        jdbc = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
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
    public void addBoard(Board board) {

    }

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
        int count = jdbc.queryForObject("select count(*) from board", emptyMap, Integer.class);
        return count;
    }
}
