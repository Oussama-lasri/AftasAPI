package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.Helpers.NumberValidator;
import com.example.aftasapi.BaseInterfaces.IBaseController;
import com.example.aftasapi.Requests.HuntingRequest;
import com.example.aftasapi.Services.IHuntingService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        HuntingDTO huntingDTO = huntingService.createHunting(huntingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(huntingDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<HuntingDTO>> getAll() {
         List<HuntingDTO> huntingList  = huntingService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(huntingList);
    }

    @Override
    @GetMapping("{huntingId}")
    public ResponseEntity<HuntingDTO> getById(@PathVariable long huntingId) {
        return null;
    }

    @Override
    @PutMapping("{huntingId}")
    public ResponseEntity<HuntingDTO> update(@PathVariable long huntingId,@Valid @RequestBody  HuntingRequest huntingRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{huntingId}")
    public ResponseEntity<?> delete(@PathVariable long huntingId) {
        return null;
    }
}
