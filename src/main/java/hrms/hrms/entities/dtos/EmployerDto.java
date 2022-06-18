package hrms.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
