package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.dtos.JobSeekerDto;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();
    DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId);
    Result add(JobSeekerDto jobSeekerDto);
    Result update(JobSeekerDto jobSeekerDto);
    Result delete(int jobSeekerId);
}
