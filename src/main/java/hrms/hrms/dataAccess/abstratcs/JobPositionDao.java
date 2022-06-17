package hrms.hrms.dataAccess.abstratcs;

import hrms.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    JobPosition getByJobPositionId(int jobPositionId);
    JobPosition getByJobPositionName(String jobPositionName);
    JobPosition deleteByJobPositionId(int jobPositionId);
}
