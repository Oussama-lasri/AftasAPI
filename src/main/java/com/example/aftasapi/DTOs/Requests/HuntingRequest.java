package com.example.aftasapi.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class HuntingRequest {
    @Positive(message = "Number of fish must be not null or not negative")
    private int numberOfFish ;

    @Positive(message = "fish must be not null")
    private long fish_id ;

    @NotNull(message = "competition code must be not null")
    @NotBlank(message = "Competition must be not blank")
    private String competition_code ;

    @Positive(message = "member num must be not null or not negative")
    private long member_num ;
}
