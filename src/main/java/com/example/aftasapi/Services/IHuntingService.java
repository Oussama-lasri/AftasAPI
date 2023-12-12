package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.Entities.HuntingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHuntingService  {
    public HuntingDTO create(HuntingDTO huntingDTO);
    public HuntingDTO upadte(long hunting_id,HuntingDTO huntingDTO);
    public HuntingDTO findHuntingById(long id);
    public void delete(HuntingDTO huntingDTO);
    public List<HuntingDTO> findAll();
}
