package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.Errors.ErrorMessageHunting;
import com.example.aftasapi.Exceptions.HuntingException;
import com.example.aftasapi.Helpers.NumberValidator;
import com.example.aftasapi.Requests.HuntingRequest;
import com.example.aftasapi.Services.IHuntingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/huntings")
public class HuntingController {

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


    @PostMapping
    public ResponseEntity<HuntingDTO> createHunting(@RequestBody HuntingRequest huntingRequest){

        if(huntingRequest.getCompetition_code().isEmpty()  || numberValidator.isNonZeroNonNull(huntingRequest.getFish_id()) || numberValidator.isNonZeroNonNull(huntingRequest.getMember_num())){
            throw new HuntingException(ErrorMessageHunting.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        HuntingDTO huntingDTO = huntingService.create(modelMapper.map(huntingRequest,HuntingDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(huntingDTO);
    }
}
