package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private static UserDao instance = new UserDaoImpl();
    private UserDaoImpl(){}
    public static UserDao getInstance(){
        return instance;
    }

    @Override
    public void addUser(User user) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            // user_name, user_email, user_passwd
            try(PreparedStatement ps = conn.prepareStatement(UserDaoSQL.INSERT);) {
                ps.setString(1, user.getUser_name());
                ps.setString(2, user.getUser_email());
                ps.setString(3, user.getUser_passwd());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserByEmail(String user_email){
        User user = null; // return 할 타입을 선언한다.

        Connection conn = ConnectionContextHolder.getConnection();
        try{

            try(PreparedStatement ps = conn.prepareStatement(UserDaoSQL.SELECT_BY_EMAIL);) {
                ps.setString(1, user_email);

                try(ResultSet rs = ps.executeQuery();){ // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    if (rs.next()) {
                        user = new User();
                        // SELECT_BY_EMAIL = "SELECT user_id, user_name, user_email, user_passwd, user_regdate FROM user WHERE user_email =?";
                        user.setUser_id(rs.getLong(1));
                        user.setUser_name(rs.getString(2));
                        user.setUser_email(rs.getString(3));
                        user.setUser_passwd(rs.getString(4));
                        user.setUser_regdate(rs.getDate(5));
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

//        return passwd;
        return user;
    }
}
