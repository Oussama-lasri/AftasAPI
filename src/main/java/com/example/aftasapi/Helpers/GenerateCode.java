package com.example.aftasapi.Helpers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

@Configuration
public class GenerateCode {
    @Bean
    public String codeCompetition(CompetitionDTO competitionDTO ){
        if(competitionDTO.getLocation() != null)
            return competitionDTO.getLocation().trim()+":"+competitionDTO.getLocation().substring(0,3)+"-"+competitionDTO.getDate() ;
        return null ;
    }


}
