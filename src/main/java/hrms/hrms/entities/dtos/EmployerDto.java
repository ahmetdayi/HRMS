package hrms.hrms.entities.dtos;


import hrms.hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {

    private String employerName;

    private String webSite;

    private String email;

    private String password;

    private String telephoneNumber;

}
