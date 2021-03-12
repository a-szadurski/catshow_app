package pl.coderslab.catshowapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "judges")
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean category01;
    private boolean category02;
    private boolean category03;
    private boolean category04;

    @OneToOne
    private User userId;

}
