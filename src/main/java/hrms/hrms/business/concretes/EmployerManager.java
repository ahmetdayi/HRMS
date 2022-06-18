package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstratcs.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobSeeker;
import hrms.hrms.entities.dtos.EmployerDto;
import hrms.hrms.entities.dtos.JobSeekerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private ModelMapper modelMapper;

    @Autowired
    public EmployerManager(EmployerDao employerDao, ModelMapper modelMapper) {
        this.employerDao = employerDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<EmployerDto>> getAll() {
        List<Employer> employers = this.employerDao.findAll();
        List<EmployerDto> dtos= employers.stream().map(employer -> modelMapper.map(employer,EmployerDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<EmployerDto>>(dtos,"data listed");
    }

    @Override
    public DataResult<EmployerDto> getByEmployerId(int employerId) {

        if(employerDao.getByEmployerId(employerId)!=null){
            Employer employer = this.employerDao.getByEmployerId(employerId);
            return new SuccessDataResult<EmployerDto>((modelMapper.map(employer,EmployerDto.class)),"data listed");
        }
        return new ErrorDataResult<EmployerDto>("employer Id doesn't exist");
    }

    @Override
    public Result add(EmployerDto employerDto) {
        Employer employer = modelMapper.map(employerDto, Employer.class);
        if((this.employerDao.getByEmployerName(employer.getEmployerName()) !=null)
                || (this.employerDao.getByTelephoneNumber(employer.getTelephoneNumber()) != null)
                || (this.employerDao.getByWebSite(employer.getWebSite()) != null)){
            return new ErrorResult(" Employer already exist ");
        }

        modelMapper.map(this.employerDao.save(employer), EmployerDto.class);
        return new SuccessResult("Employer added");
    }

    @Override
    public Result update(EmployerDto employerDto) {
        return null;
    }

    @Override
    public Result delete(int employerId) {
        if(employerDao.getByEmployerId(employerId)!=null){
            employerDao.deleteById(employerId);
            return new SuccessResult("employer deleted");
        }
        return new ErrorResult("employer Id doesn't exist");

    }
}
