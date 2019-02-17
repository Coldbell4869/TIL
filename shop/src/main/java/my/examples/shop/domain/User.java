package my.examples.shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String pswd;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "nick_name", length = 20)
    private String nickName;

//    @Column @OneToOne @OneToMany @ManyToOne @ManyToMany

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
            (
            name = "usr_lvl",
            joinColumns = {@JoinColumn(name = "usr_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "lvl_id", referencedColumnName = "id")}
            )

    private Set<Level> lvl;

    public User(){
        createDate = new Date();
        lvl = new HashSet<>();
    }
}
