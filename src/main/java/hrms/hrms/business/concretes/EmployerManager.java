package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.dtos.EmployerDto;

import java.util.List;

public class EmployerManager implements EmployerService {
    @Override
    public DataResult<List<Employer>> getAll() {
        return null;
    }

    @Override
    public DataResult<Employer> getByEmployerId(int employerId) {
        return null;
    }

    @Override
    public Result add(EmployerDto employerDto) {
        return null;
    }

    @Override
    public Result update(EmployerDto employerDto) {
        return null;
    }

    @Override
    public Result delete(int employerId) {
        return null;
    }
}
