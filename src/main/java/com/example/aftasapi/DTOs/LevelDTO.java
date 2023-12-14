package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.FishEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelDTO {

    private long code ;

    private String description ;

    private int points ;
    @JsonManagedReference
    private List<FishDTO> fiches ;
}
