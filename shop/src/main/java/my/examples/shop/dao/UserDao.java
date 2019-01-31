package my.examples.shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    NamedParameterJdbcTemplate jdbc;
//    public UserDao(NamedParameterJdbcTemplate jdbc){
//        this.jdbc = jdbc;
//    }

    public int getCount(){
        int userCount = jdbc.queryForObject("select count(*) from user", (Map)null, Integer.class);
        return userCount;
    }
}
