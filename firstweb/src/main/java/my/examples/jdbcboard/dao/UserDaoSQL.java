package my.examples.jdbcboard.dao;

public class UserDaoSQL {
    public static final String INSERT = "INSERT INTO user (user_name, user_email, user_passwd) VALUES (?, ?, ?)";
//    public static final String SELECT_BY_EMAIL = "SELECT passwd FROM user WHERE email = ?";
    public static final String  SELECT_BY_EMAIL = "SELECT user_id, user_name, user_email, user_passwd, user_regdate FROM user WHERE user_email =?";
}

