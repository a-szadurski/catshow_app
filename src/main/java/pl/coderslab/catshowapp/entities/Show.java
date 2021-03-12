package pl.coderslab.catshowapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String country;
    private String organizer;


}
