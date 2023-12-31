package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.RankingEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDTO {

    private String code ;
    private Date date ;
    private Time startTime ;
    private Time endtTime ;
    private int numberOfParticipants ;
    private String location ;
    private float amount ;
    //private int etat ;
    @JsonManagedReference
    private List<HuntingDTO> huntingList ;
    @JsonManagedReference
    private List<RankingDTO> rankingList ;
}
