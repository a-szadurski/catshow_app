package pl.coderslab.catshowapp.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.catshowapp.validationcustom.AdvancedValidation;
import pl.coderslab.catshowapp.validationcustom.BasicValidation;
import pl.coderslab.catshowapp.validationcustom.ValidEms;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "cats")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@GroupSequence({BasicValidation.class, AdvancedValidation.class, Cat.class})
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    @Column(name = "cat_name")
    @NotNull(groups = AdvancedValidation.class)
    @Size(min = 1, max = 100, message = "{Size.cat.name}", groups = BasicValidation.class)
    private String name;

    @NotNull(groups = AdvancedValidation.class)
    @NotEmpty(message = "{Pattern.cat.sex}", groups = BasicValidation.class)
    @Size(min = 1, max = 1, groups = AdvancedValidation.class)
    @Pattern(regexp = "F|M", groups = AdvancedValidation.class)
    private String sex;

    @NotNull(groups = AdvancedValidation.class)
    @ValidEms(message = "{ValidEms.cat.ems}", groups = BasicValidation.class)
    private String ems;

    @NotNull(groups = AdvancedValidation.class)
    @Size(min = 1, max = 50, message = "{Size.cat.pedigree}", groups = BasicValidation.class)
    private String pedigree;

    @NotNull(groups = AdvancedValidation.class)
    @Size(min = 1, max = 100, message = "{Size.cat.breeder}", groups = BasicValidation.class)
    private String breeder;

    @NotNull(groups = AdvancedValidation.class)
    @Size(min = 1, max = 100, message = "{Size.cat.mother}", groups = BasicValidation.class)
    private String mother;

    @NotNull(groups = AdvancedValidation.class)
    @Size(min = 1, max = 100, message = "{Size.cat.father}", groups = BasicValidation.class)
    private String father;

    @Column(name = "birth_date")
    @NotNull(message = "{NotNull.LocalDate}", groups = BasicValidation.class)
    @Past(message = "{Past.LocalDate}", groups = AdvancedValidation.class)
    private LocalDate birthDate;


}
