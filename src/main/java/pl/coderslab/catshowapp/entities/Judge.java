package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "judge_id")
    private Long id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "category01")
    private boolean isCategory01;
    @Column(name = "category02")
    private boolean isCategory02;
    @Column(name = "category03")
    private boolean isCategory03;
    @Column(name = "category04")
    private boolean isCategory04;

    @ManyToMany(mappedBy = "judges")
    private Set<ShowDates> showDates;
}
