package com.example.aftasapi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="competitions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CompetitionEntity {
    @Id
    private String code ;

    @Column(nullable = false)
    private Date date ;

    @Column(nullable = false)
    private Time startTime ;

    @Column(nullable = false)
    private Time endtTime ;

    @Column(nullable = false)
    private int numberOfParticipants ;

    @Column(nullable = false)
    private String location ;

    @Column(nullable = false)
    private float amount ;

    @OneToMany(mappedBy = "competition",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<HuntingEntity> huntingList ;


//    @ManyToMany(mappedBy = "competitions")
//    private List<MemberEntity> memebers ;

    @OneToMany(mappedBy = "competition",fetch = FetchType.LAZY)
    private List<RankingEntity> rankingList ;




}
