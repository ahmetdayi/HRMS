package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.config.ModelMapperConfig;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstratcs.JobPositionDao;
import hrms.hrms.entities.concretes.JobPosition;
import hrms.hrms.entities.dtos.JobPositionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao, ModelMapper modelMapper) {
        this.jobPositionDao = jobPositionDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobPositionDto>> getAll() {
        List<JobPosition> jobPositions = this.jobPositionDao.findAll();
        List<JobPositionDto> dtos= jobPositions.stream().map(jobPosition -> modelMapper.map(jobPosition,JobPositionDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<JobPositionDto>>(dtos,"data listed");
    }

    @Override
    public DataResult<JobPositionDto> getByJobPositionId(int jobPositionId) {

        if(jobPositionDao.getByJobPositionId(jobPositionId)!=null){
        JobPosition jobPosition = this.jobPositionDao.getByJobPositionId(jobPositionId);
        return new SuccessDataResult<JobPositionDto>((modelMapper.map(jobPosition,JobPositionDto.class)),"data listed");
        }
        return new ErrorDataResult<JobPositionDto>("jobPosition Id doesn't exist");
    }

    @Override
    public Result add(JobPositionDto jobPositionDto) {
        JobPosition jobPosition = modelMapper.map(jobPositionDto, JobPosition.class);
        if(this.jobPositionDao.getByJobPositionName(jobPosition.getJobPositionName()) !=null){
            return new ErrorResult(" jobPosition already exist ");
        }


        modelMapper.map(this.jobPositionDao.save(jobPosition), JobPositionDto.class);
        return new SuccessResult("JobPosition added");

    }

    @Override
    public Result update(JobPositionDto jobPositionDto) {
        return null;
    }

    @Override
    public Result delete(int jobPositionId) {
        if(jobPositionDao.getByJobPositionId(jobPositionId)!=null){
            jobPositionDao.deleteById(jobPositionId);
            return new SuccessResult("jobPosition deleted");
        }
        return new ErrorResult("jobPosition Id doesn't exist");

    }
}
