package pl.coderslab.catshowapp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "shows")
@Getter
@Setter
@ToString
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;
    @Column(name = "show_name")
    private String name;
    private String city;
    private String country;
    private String organizer;


}
