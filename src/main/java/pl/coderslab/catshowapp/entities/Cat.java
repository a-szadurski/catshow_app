package pl.coderslab.catshowapp.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cats")
public class Cat {

    //    INSERT INTO catshow.cats (id, cat_name, sex, ems, classification)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Character sex;
    private String ems;
    private Integer classification;
    private String pedigree;
    private String breeder;
    private String mother;
    private String father;
    private LocalDate birthDate;


}
