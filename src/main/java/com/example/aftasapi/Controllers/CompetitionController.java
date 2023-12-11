package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.Requests.CompetitionRequest;
import com.example.aftasapi.Services.ICompetitionService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final ICompetitionService competitionService ;
    private final ModelMapper modelMapper ;

    public CompetitionController(ICompetitionService competitionService, ModelMapper modelMapper) {
        this.competitionService = competitionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CompetitionDTO> createCompetition(@Valid @RequestBody CompetitionRequest competitionRequest){
        CompetitionDTO competitionDTO = competitionService.create(modelMapper.map(competitionRequest,CompetitionDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(competitionDTO);
    }

    @GetMapping
    public ResponseEntity<List<CompetitionDTO>> getAllCompetition(){
        List<CompetitionDTO> competitions = competitionService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(competitions);
    }


}
