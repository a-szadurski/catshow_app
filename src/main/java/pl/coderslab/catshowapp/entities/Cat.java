package pl.coderslab.catshowapp.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cats")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;
    @Column(name = "cat_name")
    private String name;
    private Character sex;
    private String ems;
    private Integer classification;
    private String pedigree;
    private String breeder;
    private String mother;
    private String father;
    @Column(name = "birth_date")
    private LocalDate birthDate;


}
