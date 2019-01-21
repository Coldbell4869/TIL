package my.examples.jdbcboard.dto;

import java.util.Date;

public class User {
    private Long user_id;
    private String user_name;
    private String user_email;
    private String user_passwd;
    private Date user_regdate;

    public User(){

    }

    public User(String user_name, String user_email, String user_passwd) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_passwd = user_passwd;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public Date getUser_regdate() {
        return user_regdate;
    }

    public void setUser_regdate(Date user_regdate) {
        this.user_regdate = user_regdate;
    }
}

/*
CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `user_regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
 */