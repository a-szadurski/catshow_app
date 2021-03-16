package pl.coderslab.catshowapp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contestants")
@Getter
@Setter
@ToString
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contestant_id")
    private Long id;
    private String rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_dates_id")
    private ShowDates showDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @ManyToOne
    @JoinColumn(name = "exhibitor_id")
    private Exhibitor exhibitor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "judge_id")
    private Judge judge;

}
