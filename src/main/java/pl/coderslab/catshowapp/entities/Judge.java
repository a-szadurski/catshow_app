package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.catshowapp.validationcustom.AtLeastOneCategory;
import pl.coderslab.catshowapp.validationcustom.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AtLeastOneCategory
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "judge_id")
    private Long id;

    @NotNull
    @ValidEmail
    private String email;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @Column(name = "category01")
    @NotNull
    private boolean isCategory01;

    @Column(name = "category02")
    @NotNull
    private boolean isCategory02;

    @Column(name = "category03")
    @NotNull
    private boolean isCategory03;

    @Column(name = "category04")
    @NotNull
    private boolean isCategory04;

    @ManyToMany(mappedBy = "judges")
    private Set<ShowDates> showDates;
}
