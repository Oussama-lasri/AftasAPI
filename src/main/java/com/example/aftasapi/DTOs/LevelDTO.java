package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.FishEntity;
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
public class LevelDTO {

    private long code ;

    private String description ;

    private int points ;

    private List<FishDTO> fiches ;
}
