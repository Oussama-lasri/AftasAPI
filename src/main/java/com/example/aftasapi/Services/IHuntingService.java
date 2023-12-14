package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.BaseInterfaces.IBaseService;
import com.example.aftasapi.Requests.HuntingRequest;

public interface IHuntingService extends IBaseService<HuntingDTO> {
    public HuntingDTO createHunting(HuntingRequest huntingRequest);

}
