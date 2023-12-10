package com.example.aftasapi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "levels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code ;

    @Column(nullable = false)
    private String description ;
    @Column(nullable = false)
    private int points ;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<FishEntity> fiches ;




}
