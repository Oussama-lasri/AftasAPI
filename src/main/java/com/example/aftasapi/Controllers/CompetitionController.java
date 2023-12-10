package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.Requests.CompetitionRequest;
import com.example.aftasapi.Services.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> createLevel(@RequestBody CompetitionRequest competitionRequest){   
        CompetitionDTO competitionDTO = competitionService.create(modelMapper.map(competitionRequest,CompetitionDTO.class));
        return ResponseEntity.ok().body("created " + competitionDTO.getCode()) ;
    }


}
