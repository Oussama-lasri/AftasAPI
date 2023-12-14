package com.example.aftasapi.DTOs.hunting;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.DTOs.MemberDTO;
import com.example.aftasapi.Requests.FishRequest;

public class HuntingDTORes {
    private int id ;

    private int numberOfFish ;
    private FishDTO fish ;
    private CompetitionDTO competition ;
    private MemberDTO member ;
}
