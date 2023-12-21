package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.Entities.FishEntity;
import com.example.aftasapi.Repositories.FishRepository;
import com.example.aftasapi.Services.IFishService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FishServiceImpl implements IFishService {

    private final FishRepository fishRepository ;
    private final ModelMapper modelMapper ;
    public FishServiceImpl(FishRepository fishRepository, ModelMapper modelMapper) {
        this.fishRepository = fishRepository;
        this.modelMapper = modelMapper;
    }

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
        List<FishEntity> fishes = fishRepository.findAll();
        return fishes.stream().map(fish -> modelMapper.map(fish,FishDTO.class)).toList();
    }
}
