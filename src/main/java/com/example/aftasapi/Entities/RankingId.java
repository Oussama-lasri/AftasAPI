package com.example.aftasapi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankingId implements Serializable {

    @Column(nullable = false)
    private int rank ;

    @Column(nullable = false)
    private int score ;

}
