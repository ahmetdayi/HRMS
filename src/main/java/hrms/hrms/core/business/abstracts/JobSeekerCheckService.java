package hrms.hrms.core.business.abstracts;

import hrms.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
    boolean checkIfRealPerson(JobSeeker jobSeeker);
}
