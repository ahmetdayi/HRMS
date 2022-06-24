package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.dtos.ProgrammingLanguageAndTechnologyDto;

import java.util.List;

public interface ProgrammingLanguageAndTechnologyService {

    DataResult<List<ProgrammingLanguageAndTechnologyDto>> getAll();
    DataResult<ProgrammingLanguageAndTechnologyDto> getByProgrammingLanguageAndTechnologyId(int programmingLanguageAndTechnologyId);
    Result add(ProgrammingLanguageAndTechnologyDto programmingLanguageAndTechnologyDto);
    Result delete(int programmingLanguageAndTechnologyId);

    Result addProgrammingLanguageAndTechnologyToCv(int cvId,int programmingLanguageAndTechnologyId );
}
