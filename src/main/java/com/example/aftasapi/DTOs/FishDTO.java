package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.LevelEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
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
