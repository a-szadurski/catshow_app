package pl.coderslab.catshowapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "contestants")
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rating;

    @ManyToOne
    private ShowDates showDate;

    @ManyToOne
    private Judge judge;

    @ManyToOne
    private Cat cat;

    @ManyToOne
    private Owner owner;

}
