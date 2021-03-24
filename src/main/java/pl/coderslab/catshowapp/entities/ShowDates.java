package pl.coderslab.catshowapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "show_dates")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ShowDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_date_id")
    private Long id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "shows_judges",
            joinColumns = @JoinColumn(name = "show_dates_id"),
            inverseJoinColumns = @JoinColumn(name = "judge_id")
    )
    private Set<Judge> judges;
}