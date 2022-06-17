package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.dtos.JobSeekerDto;

import java.util.List;

public class JobSeekerManager implements JobSeekerService {
    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId) {
        return null;
    }

    @Override
    public Result add(JobSeekerDto jobSeekerDto) {
        return null;
    }

    @Override
    public Result update(JobSeekerDto jobSeekerDto) {
        return null;
    }

    @Override
    public Result delete(int jobSeekerId) {
        return null;
    }
}
