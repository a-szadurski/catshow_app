package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contestants")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contestant_id")
    private Long id;
    private String rating;
    private Integer classification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_dates_id")
    private ShowDates showDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibitor_id")
    private Exhibitor exhibitor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "judge_id")
    private Judge judge;

}
