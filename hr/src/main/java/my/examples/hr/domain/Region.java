package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "regions")
@Setter
@Getter
public class Region {
    @Id
    private Long regionId;
    private String regionName;
    @OneToMany(mappedBy="region")
    private Set<Country> countries;

    public Region(){
        countries = new HashSet<>();
    }

}

