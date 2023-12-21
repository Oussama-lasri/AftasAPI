package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.BaseInterfaces.IBaseService;
import com.example.aftasapi.Requests.HuntingRequest;
import org.springframework.http.ResponseEntity;

public interface IHuntingService extends IBaseService<HuntingDTO> {
    public ResponseEntity<HuntingDTO> createHunting(HuntingRequest huntingRequest,String code);

}
