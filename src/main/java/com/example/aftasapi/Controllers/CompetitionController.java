package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.BaseInterfaces.IBaseController;
import com.example.aftasapi.DTOs.Response.CompetitionResponse;
import com.example.aftasapi.Requests.CompetitionRequest;
import com.example.aftasapi.Services.ICompetitionService;
import com.example.aftasapi.Services.Impl.CompetitionServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
@CrossOrigin
public class CompetitionController {

    private final CompetitionServiceImpl competitionService ;
    private final ModelMapper modelMapper ;

    public CompetitionController(CompetitionServiceImpl competitionService, ModelMapper modelMapper) {
        this.competitionService = competitionService;
        this.modelMapper = modelMapper;
    }




    @PostMapping
    public ResponseEntity<CompetitionDTO> create(@Valid @RequestBody CompetitionRequest competitionRequest){
        CompetitionDTO competitionDTO = competitionService.create(modelMapper.map(competitionRequest,CompetitionDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(competitionDTO);
    }


    @GetMapping
    public ResponseEntity<CompetitionResponse>  getAll( @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) int pageNumber,
                                                        @RequestParam(value = "pageSize" , defaultValue = "10" , required = false) int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(competitionService.allCompetitionWithPagination(pageNumber,pageSize)) ;
    }


    @GetMapping("/{competition_id}")
    public ResponseEntity<CompetitionDTO> getById(@PathVariable String competition_id) {
        CompetitionDTO competition = competitionService.findByCode(competition_id);
        return ResponseEntity.status(HttpStatus.OK).body(competition);
    }


    public ResponseEntity<CompetitionDTO> update(long id, CompetitionRequest request) {
        return null;
    }


    public ResponseEntity<?> delete(long id) {
        return null;
    }

}
