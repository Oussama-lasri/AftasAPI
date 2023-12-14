package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.MemberEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingDTO {
    private Long id;
    private int rank ;
    private int score ;
    @JsonBackReference
    private MemberDTO member;
    @JsonBackReference
    private CompetitionDTO competition;
}
