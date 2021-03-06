package my.examples.springjdbc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String passwd;
    private Date regdate;

    public User(){
        regdate = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
