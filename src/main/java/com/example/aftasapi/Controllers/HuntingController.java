package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.Errors.ErrorMessageHunting;
import com.example.aftasapi.Exceptions.HuntingException;
import com.example.aftasapi.Helpers.NumberValidator;
import com.example.aftasapi.Interfaces.IBaseController;
import com.example.aftasapi.Requests.CompetitionRequest;
import com.example.aftasapi.Requests.HuntingRequest;
import com.example.aftasapi.Services.IHuntingService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/huntings")
public class HuntingController implements IBaseController<HuntingDTO,HuntingRequest>  {

    private final NumberValidator numberValidator ;
    private final ModelMapper modelMapper;

    private final IHuntingService huntingService ;
     @Autowired
    public HuntingController(NumberValidator numberValidator,
                             ModelMapper modelMapper,
                             IHuntingService huntingService) {
        this.numberValidator = numberValidator;
         this.modelMapper = modelMapper;
         this.huntingService = huntingService;
     }



    @Override
    @PostMapping
    public ResponseEntity<HuntingDTO> create(@Valid @RequestBody HuntingRequest huntingRequest) {
        HuntingDTO huntingDTO = huntingService.create(modelMapper.map(huntingRequest,HuntingDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(huntingDTO);
    }

    @Override
    public ResponseEntity<List<HuntingDTO>> getAll() {
         List<HuntingDTO> huntingList  = huntingService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(huntingList);
    }

    @Override
    public ResponseEntity<HuntingDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<HuntingDTO> update(long id, HuntingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return null;
    }
}
