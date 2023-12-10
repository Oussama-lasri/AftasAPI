package com.example.aftasapi.Responses;

import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.RankingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class CompetitionResponse {

    private String code ;

    private Date date ;

    private Time startTime ;

    private Time endtTime ;

    private int numberOfParticipants ;

    private String location ;

    private float amount ;

    private List<HuntingEntity> huntingList ;

    private List<RankingEntity> rankingList ;
}
