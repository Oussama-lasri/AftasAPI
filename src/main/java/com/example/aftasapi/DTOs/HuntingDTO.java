package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.FishEntity;
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
public class HuntingDTO {

    private int id ;

    private int numberOfFish ;

    private FishDTO fish ;

    private CompetitionDTO competition ;
    private MemberDTO member ;
}
