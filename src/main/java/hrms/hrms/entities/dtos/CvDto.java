package hrms.hrms.entities.dtos;

import hrms.hrms.entities.concretes.Education;
import hrms.hrms.entities.concretes.ForeignLanguage;
import hrms.hrms.entities.concretes.JobExperience;
import hrms.hrms.entities.concretes.ProgrammingLanguageAndTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

    private JobSeekerDto jobSeeker;

    private String photo;

    private String githubLink;

    private String linkedInLink;

    private String description;

    private List<EducationDto> educations;

    private List<ForeignLanguageDto> foreignLanguages;

    private List<JobExperienceDto> jobExperiences;

    private List<ProgrammingLanguageAndTechnologyDto> programmingLanguageAndTechnologies;



}
