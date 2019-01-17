package my.examples.jdbcboard.dao;

public class FreeBoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT id, name, title, content, regdate, readcount, family, level, sequence FROM freepost where id =?";
    public static final String SELECT_BY_PAGING =
            "SELECT id, name, title, content, regdate, readcount, family, level, sequence FROM freepost ORDER BY id DESC LIMIT ?, ?";
    public static final String INSERT =
            "INSERT INTO freepost(name, title, content) VALUES(?, ?, ?)";
    public static final String UPDATE =
            "UPDATE freepost SET readcount = readcount + 1 WHERE id = ?";
    public static final String DELETE =
            "DELETE FROM freepost WHERE id = ?";
}
