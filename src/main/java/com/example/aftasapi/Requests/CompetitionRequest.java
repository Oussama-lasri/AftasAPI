package com.example.aftasapi.Requests;

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
    @NotNull
    private Date date ;
    @NotNull
    private Time startTime ;
    @NotNull
    private Time endtTime ;
    @NotNull
    private int numberOfParticipants ;
    @NotNull
    @NotBlank
    private String location ;
    @NotNull
    private float amount ;
}
