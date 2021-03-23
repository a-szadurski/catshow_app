package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.catshowapp.validationcustom.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "exhibitors")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Exhibitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibitor_id")
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min=1, max=100)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min=1, max=100)
    private String lastName;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @Size(min=9, max=30)
    private String phone;
}
