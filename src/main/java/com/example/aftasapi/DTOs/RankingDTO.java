package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
