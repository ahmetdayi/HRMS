package hrms.hrms.dataAccess.abstratcs;

import hrms.hrms.entities.concretes.JobPosition;
import hrms.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {

    JobSeeker getByJobSeekerId(int jobSeekerId);
    JobSeeker deleteByJobSeekerId(int jobSeekerId);


}
