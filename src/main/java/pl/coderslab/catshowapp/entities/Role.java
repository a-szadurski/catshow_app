package pl.coderslab.catshowapp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role_name")
    private String name;


}
