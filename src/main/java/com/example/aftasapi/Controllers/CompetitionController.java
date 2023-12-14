package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.BaseInterfaces.IBaseController;
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
public class CompetitionController implements IBaseController<CompetitionDTO, CompetitionRequest> {

    private final ICompetitionService competitionService ;
    private final ModelMapper modelMapper ;

    public CompetitionController(ICompetitionService competitionService, ModelMapper modelMapper) {
        this.competitionService = competitionService;
        this.modelMapper = modelMapper;
    }



    @Override
    @PostMapping
    public ResponseEntity<CompetitionDTO> create(@Valid @RequestBody CompetitionRequest competitionRequest){
        CompetitionDTO competitionDTO = competitionService.create(modelMapper.map(competitionRequest,CompetitionDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(competitionDTO);
    }

    @Override
    public ResponseEntity<List<CompetitionDTO>> getAll() {
        List<CompetitionDTO> competitions = competitionService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(competitions);
    }

    @Override
    public ResponseEntity<CompetitionDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<CompetitionDTO> update(long id, CompetitionRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return null;
    }
}
