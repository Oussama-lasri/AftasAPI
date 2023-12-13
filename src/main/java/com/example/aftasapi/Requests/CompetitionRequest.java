package com.example.aftasapi.Requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionRequest {
    @NotNull(message = "not null")

    private Date date ;
    @NotNull(message = "not null")

    private Time startTime ;
    @NotNull(message = "not null")

    private Time endtTime ;
    @NotNull(message = "not null")

    private int numberOfParticipants ;
    @NotNull(message = "not null")
    @Min(value = 3,message = "location must be more than 3 characters")
    @NotBlank(message = "location must be not blank")
    private String location ;
    @NotNull(message = "not null")
    private float amount ;
}
