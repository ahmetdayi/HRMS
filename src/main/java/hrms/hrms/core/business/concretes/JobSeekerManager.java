package hrms.hrms.core.business.concretes;

import hrms.hrms.core.business.abstracts.JobSeekerCheckService;
import hrms.hrms.entities.concretes.JobSeeker;

public class JobSeekerManager implements JobSeekerCheckService {
    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return false;
    }
}
