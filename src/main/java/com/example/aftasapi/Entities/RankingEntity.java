package com.example.aftasapi.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Rankings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingEntity {

    // use EmbeddedId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rank ;

    @Column(nullable = false)
    private int score ;

    @ManyToOne
    @JoinColumn(name = "members_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "competitions_id")
    private  CompetitionEntity competition;
}
