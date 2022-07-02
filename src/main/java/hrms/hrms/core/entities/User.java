package hrms.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.hrms.entities.concretes.Authority;
import hrms.hrms.entities.concretes.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Authority authority;



}
