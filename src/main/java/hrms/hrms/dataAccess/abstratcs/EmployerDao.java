package hrms.hrms.dataAccess.abstratcs;

import hrms.hrms.entities.concretes.Employer;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployerDao extends JpaRepository<Employer,Integer> {
    Employer getByEmployerId(int employerId);
    Employer deleteByEmployerId(int employerId);
}
