package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.MemberEntity;
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
    private MemberDTO member;
    private CompetitionDTO competition;
}
