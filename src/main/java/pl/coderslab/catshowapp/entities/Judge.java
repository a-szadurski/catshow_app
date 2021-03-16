package pl.coderslab.catshowapp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "judge_id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="category01")
    private boolean isCategory01;
    @Column(name="category02")
    private boolean isCategory02;
    @Column(name="category03")
    private boolean isCategory03;
    @Column(name="category04")
    private boolean isCategory04;
}
