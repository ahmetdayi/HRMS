package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.concretes.ProgrammingLanguageAndTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageAndTechnologyDao extends JpaRepository<ProgrammingLanguageAndTechnology,Integer> {

    ProgrammingLanguageAndTechnology getById(int id);

    ProgrammingLanguageAndTechnology deleteById(int id);
}
