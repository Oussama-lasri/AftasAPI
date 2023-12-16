package com.example.aftasapi.DTOs.Requests;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.MemberDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingRequest {

    @Positive(message = "Rank must be a positive number")
    private int rank;
    @Positive(message = "Score must be a positive number")
    private int score;
    @Positive(message = "Member ID must be a positive number")
    private long memberId;
    @NotBlank(message = "Competition ID must be not null")
    private String competitionId;
}




