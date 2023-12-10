package com.example.aftasapi.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "huntings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuntingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false)
    private int numberOfFish ;

    @ManyToOne
    @JoinColumn(name = "fishes_id")
    private FishEntity fish ;

    @ManyToOne
    @JoinColumn(name = "competitions_id")
    private CompetitionEntity competition ;

    @ManyToOne
    @JoinColumn(name = "members_id")
    private MemberEntity member ;

}
