package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.Services.IFishService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FishServiceImpl implements IFishService {
    @Override
    public FishDTO create(FishDTO fishDTO) {
        return null;
    }

    @Override
    public FishDTO update(long id, FishDTO fishDTO) {
        return null;
    }

    @Override
    public FishDTO findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<FishDTO> findAll() {
        return null;
    }
}
