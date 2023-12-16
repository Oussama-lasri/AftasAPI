package com.example.aftasapi.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Date cannot be null")
    private Date date ;

    @NotNull(message = "Start time cannot be null")
    private Time startTime ;

    @NotNull(message = "End time cannot be null")
    private Time endtTime ;

    @NotNull(message = "Number of participants cannot be null")
    private int numberOfParticipants ;

    @NotNull(message = "Location cannot be null")
    @Size(min = 3, message = "Location must be at least 3 characters")
    @NotBlank(message = "Location must not be blank")
    private String location ;

    @NotNull(message = "not null")
    @Positive
    private float amount ;
}
