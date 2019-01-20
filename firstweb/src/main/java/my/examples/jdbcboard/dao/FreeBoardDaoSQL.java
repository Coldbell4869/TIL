package my.examples.jdbcboard.dao;

public class FreeBoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT id, name, title, content, regdate, readcount, family, level, sequence FROM freepost where id =?";
    public static final String SELECT_BY_PAGING =
            "SELECT id, name, title, regdate, readcount, family, level, sequence FROM freepost ORDER BY id DESC LIMIT ?, ?";
    public static final String INSERT =
            "INSERT INTO freepost(name, title, content) " +
                    "VALUES(?, ?, ?)";
    public static final String SELECT_LAST_INSERT_ID =
            "SELECT LAST_INSERT_ID";    // MySQL의 기능임. 가장 마지막에 insert된 id를 가져옴.
    public static final String UPDATE_LAST_INSERT_ID =
            "UPDATE freepost SET family = ? where id =?";
    public static final String UPDATE =
            "UPDATE freepost SET readcount = readcount + 1 WHERE id = ?";
    public static final String DELETE =
            "DELETE FROM freepost WHERE id = ?";
}
