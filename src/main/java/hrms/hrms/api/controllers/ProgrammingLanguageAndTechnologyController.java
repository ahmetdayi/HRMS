package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.ProgrammingLanguageAndTechnologyService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.dtos.ProgrammingLanguageAndTechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguageAndTechnology")
public class ProgrammingLanguageAndTechnologyController {

    private ProgrammingLanguageAndTechnologyService programmingLanguageAndTechnologyService;

    @Autowired
    public ProgrammingLanguageAndTechnologyController(ProgrammingLanguageAndTechnologyService programmingLanguageAndTechnologyService) {
        this.programmingLanguageAndTechnologyService = programmingLanguageAndTechnologyService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<ProgrammingLanguageAndTechnologyDto>>> getAll() {
        DataResult<List<ProgrammingLanguageAndTechnologyDto>> programmingLanguageAndTechnologies = programmingLanguageAndTechnologyService.getAll();
        return ResponseEntity.ok(programmingLanguageAndTechnologies);
    }

    @GetMapping("/getByProgrammingLanguageAndTechnologyId")
    public ResponseEntity<DataResult<ProgrammingLanguageAndTechnologyDto>> getByJobPositionId(@RequestParam int id) {
        DataResult<ProgrammingLanguageAndTechnologyDto> programmingLanguageAndTechnologies = programmingLanguageAndTechnologyService.getByProgrammingLanguageAndTechnologyId(id);
        return ResponseEntity.ok(programmingLanguageAndTechnologies);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ProgrammingLanguageAndTechnologyDto programmingLanguageAndTechnologyDto) {
        Result res = this.programmingLanguageAndTechnologyService.add(programmingLanguageAndTechnologyDto);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id) {
        Result status = programmingLanguageAndTechnologyService.delete(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{cvId}/programmingLanguageAndTechnologies/{programmingLanguageAndTechnologyId}")
    public ResponseEntity<?> addProgrammingLanguageAndTechnologyToCv(@PathVariable int cvId, @PathVariable int programmingLanguageAndTechnologyId){
        Result res = this.programmingLanguageAndTechnologyService.addProgrammingLanguageAndTechnologyToCv(cvId,programmingLanguageAndTechnologyId);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }
}
