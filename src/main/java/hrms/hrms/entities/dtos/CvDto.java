package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private List<SkillDto> skills;
}
