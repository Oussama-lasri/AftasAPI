package com.example.aftasapi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "fishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @Column(nullable = false,unique = true)
    private String name ;
    @Column(nullable = false)
    private double averageWeight ;
    @ManyToOne
    @JoinColumn(name = "levels_id")
    private LevelEntity level ;

    // liaison between object fish in HuntingEntity for map
    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<HuntingEntity> huntingList ;
}
