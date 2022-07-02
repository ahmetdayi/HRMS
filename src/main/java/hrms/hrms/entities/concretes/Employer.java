package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employerId",referencedColumnName = "id")
public class Employer extends User {


    @Column(name = "employerName",nullable = false,unique = true)
    private String employerName;

    @Column(name = "webSite",nullable = false,unique = true)
    private String webSite;

    @Column(name = "telephoneNumber",nullable = false,length = 11,unique = true)
    private String telephoneNumber;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="employer")
    private List<JobAdvertisement> jobAdvertisements;


}
