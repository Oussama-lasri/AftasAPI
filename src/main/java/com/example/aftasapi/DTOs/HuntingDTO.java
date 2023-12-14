package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.FishEntity;
import com.example.aftasapi.Entities.MemberEntity;
import com.example.aftasapi.Requests.FishRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HuntingDTO {

    private int id ;

    private int numberOfFish ;
    @JsonBackReference
    private FishDTO fish ;
    @JsonBackReference
    private CompetitionDTO competition ;
    @JsonBackReference
    private MemberDTO member ;
}
