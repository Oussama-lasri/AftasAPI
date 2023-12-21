package com.example.aftasapi.Helpers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class GenerateCode {
    public String codeCompetition(CompetitionDTO competitionDTO ){

        if(competitionDTO.getLocation() != null) {
            String cleanedLocation = competitionDTO.getLocation().replaceAll("\\s", "");
            return cleanedLocation.substring(0, 3) + "-" + competitionDTO.getDate();
        }
        return null ;
    }


}
