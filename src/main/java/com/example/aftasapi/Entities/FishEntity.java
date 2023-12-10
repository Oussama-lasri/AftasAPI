package com.example.aftasapi.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "fishes")
@Data
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
    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL)
    private List<HuntingEntity> huntingList ;
}
