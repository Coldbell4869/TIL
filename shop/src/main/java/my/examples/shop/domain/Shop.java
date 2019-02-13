package my.examples.shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "shop")
@Setter
@Getter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String title;
    @Column(length = 255)
    private String url;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

//    @OneToMany(mappedBy = "shop")
//    private List<Locale.Category> categoryList;

//    public Shop(){
//        categoryList = new ArrayList<>();
//    }
}
