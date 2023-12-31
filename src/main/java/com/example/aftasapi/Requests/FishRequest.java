package com.example.aftasapi.Requests;

import com.example.aftasapi.DTOs.LevelDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FishRequest {

    @NotBlank
    @NotNull
    private String name ;

    @Positive(message = "Average weight must be positive")
    private double averageWeight ;


    private long level_code ;
}
