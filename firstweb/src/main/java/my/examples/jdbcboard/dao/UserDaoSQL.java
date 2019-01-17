package my.examples.jdbcboard.dao;

public class UserDaoSQL {
    public static final String INSERT = "INSERT INTO user (name, email, passwd) VALUES (?, ?, ?, ?)";
    public static final String SELECT_BY_EMAIL = "SELECT passwd FROM user WHERE email = ?";
}