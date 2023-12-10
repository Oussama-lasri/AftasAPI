package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.LevelEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FishDTO {

    private long code;

    private String name ;

    private double averageWeight ;

    private LevelDTO level ;

    private List<HuntingDTO> huntingList ;
}
