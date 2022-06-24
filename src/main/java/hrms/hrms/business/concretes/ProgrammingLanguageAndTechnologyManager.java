package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.ProgrammingLanguageAndTechnologyService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.CvDao;
import hrms.hrms.dataAccess.abstracts.ProgrammingLanguageAndTechnologyDao;
import hrms.hrms.entities.concretes.Cv;
import hrms.hrms.entities.concretes.JobExperience;
import hrms.hrms.entities.concretes.ProgrammingLanguageAndTechnology;
import hrms.hrms.entities.dtos.ProgrammingLanguageAndTechnologyDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgrammingLanguageAndTechnologyManager implements ProgrammingLanguageAndTechnologyService {

    private ProgrammingLanguageAndTechnologyDao programmingLanguageAndTechnologyDao;
    private ModelMapper modelMapper;
    private CvDao cvDao;

    @Autowired
    public ProgrammingLanguageAndTechnologyManager(ProgrammingLanguageAndTechnologyDao programmingLanguageAndTechnologyDao, ModelMapper modelMapper, CvDao cvDao) {
        this.programmingLanguageAndTechnologyDao = programmingLanguageAndTechnologyDao;
        this.modelMapper = modelMapper;
        this.cvDao=cvDao;
    }

    @Override
    public DataResult<List<ProgrammingLanguageAndTechnologyDto>> getAll() {
        List<ProgrammingLanguageAndTechnology> programmingLanguageAndTechnologies = this.programmingLanguageAndTechnologyDao.findAll();
        List<ProgrammingLanguageAndTechnologyDto> dtos= programmingLanguageAndTechnologies.stream().
                map(programmingLanguageAndTechnology -> modelMapper.map
                        (programmingLanguageAndTechnology,ProgrammingLanguageAndTechnologyDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ProgrammingLanguageAndTechnologyDto>>(dtos,"Data listed");
    }

    @Override
    public DataResult<ProgrammingLanguageAndTechnologyDto> getByProgrammingLanguageAndTechnologyId(int programmingLanguageAndTechnologyId) {
        if(programmingLanguageAndTechnologyDao.getById(programmingLanguageAndTechnologyId)!=null){
            ProgrammingLanguageAndTechnology programmingLanguageAndTechnology = this.programmingLanguageAndTechnologyDao.getById(programmingLanguageAndTechnologyId);
            return new SuccessDataResult<ProgrammingLanguageAndTechnologyDto>((modelMapper.map(programmingLanguageAndTechnology,ProgrammingLanguageAndTechnologyDto.class)),"Data listed");
        }
        return new ErrorDataResult<ProgrammingLanguageAndTechnologyDto>("ProgrammingLanguageAndTechnology Id doesn't exist");
    }

    @Override
    public Result add(ProgrammingLanguageAndTechnologyDto programmingLanguageAndTechnologyDto) {
        ProgrammingLanguageAndTechnology programmingLanguageAndTechnology = modelMapper.map(programmingLanguageAndTechnologyDto, ProgrammingLanguageAndTechnology.class);

        modelMapper.map(this.programmingLanguageAndTechnologyDao.save(programmingLanguageAndTechnology), ProgrammingLanguageAndTechnologyDto.class);
        return new SuccessResult("ProgrammingLanguageAndTechnology added");
    }

    @Override
    public Result delete(int programmingLanguageAndTechnologyId) {
        if(programmingLanguageAndTechnologyDao.getById(programmingLanguageAndTechnologyId)!=null){
            programmingLanguageAndTechnologyDao.deleteById(programmingLanguageAndTechnologyId);
            return new SuccessResult("ProgrammingLanguageAndTechnology deleted");
        }
        return new ErrorResult("ProgrammingLanguageAndTechnology Id doesn't exist");
    }

    @Override
    public Result addProgrammingLanguageAndTechnologyToCv(int cvId, int programmingLanguageAndTechnologyId) {
        Cv cv = cvDao.getByCvId(cvId);
        ProgrammingLanguageAndTechnology programmingLanguageAndTechnology = programmingLanguageAndTechnologyDao.getById(programmingLanguageAndTechnologyId);
        programmingLanguageAndTechnology.addProgrammingLanguageAndTechnologytoCv(cv);
        cvDao.save(cv);
        return new SuccessResult("Cv added by Programming Language and Technology.");
    }
}
