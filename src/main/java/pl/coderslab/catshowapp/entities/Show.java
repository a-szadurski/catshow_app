package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shows")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;

    @Column(name = "show_name")
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 100)
    private String city;

    @NotNull
    @Size(min = 1, max = 100)
    private String country;

    @NotNull
    @Size(min = 1, max = 150)
    private String organizer;

    @Column(columnDefinition = "boolean default false")
    @NotNull
    private boolean concluded;

    @Column(columnDefinition = "boolean default false")
    @NotNull
    private boolean published;


}
