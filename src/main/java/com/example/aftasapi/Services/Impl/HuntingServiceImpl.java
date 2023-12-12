package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.Repositories.HuntingRepository;
import com.example.aftasapi.Services.IHuntingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HuntingServiceImpl implements IHuntingService {

    private final HuntingRepository huntingRepository ;


    public HuntingServiceImpl(HuntingRepository huntingRepository) {
        this.huntingRepository = huntingRepository;
    }

    @Override
    public HuntingDTO create(HuntingDTO huntingDTO) {
        return null;
    }

    @Override
    public HuntingDTO upadte(long hunting_id, HuntingDTO huntingDTO) {
        return null;
    }

    @Override
    public HuntingDTO findHuntingById(long id) {
        return null;
    }

    @Override
    public void delete(HuntingDTO huntingDTO) {

    }

    @Override
    public List<HuntingDTO> findAll() {
        return null;
    }



}
