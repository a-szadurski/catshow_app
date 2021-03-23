package pl.coderslab.catshowapp.entities;


import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotNull
    @Size(min=1, max=100)
    private String name;

    @NotNull
    @Size(min=1, max=1)
    private Character sex;

    @NotNull
    @Size(min=3, max = 50)
    private String ems;

    @NotNull
    @Size(min=1, max=50)
    private String pedigree;

    @NotNull
    @Size(min=1, max=100)
    private String breeder;

    @NotNull
    @Size(min=1, max=100)
    private String mother;

    @NotNull
    @Size(min=1, max=100)
    private String father;

    @Column(name = "birth_date")
    @NotNull
    @NotEmpty
    private LocalDate birthDate;


}
