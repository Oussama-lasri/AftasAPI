package com.example.aftasapi.Requests;

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

    private Date date ;
    private Time startTime ;
    private Time endtTime ;
    private int numberOfParticipants ;
    private String location ;
    private float amount ;
}
