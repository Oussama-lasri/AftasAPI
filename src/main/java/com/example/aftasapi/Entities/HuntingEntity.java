package com.example.aftasapi.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "huntings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
