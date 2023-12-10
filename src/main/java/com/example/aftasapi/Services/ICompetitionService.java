package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.CompetitionDTO;

import java.util.List;

public interface ICompetitionService {

    public CompetitionDTO create(CompetitionDTO competitionDTO);
    public CompetitionDTO upadte(long competition_id,CompetitionDTO competitionDTO);
    public CompetitionDTO findCompetitionById(long id);
    public void delete(CompetitionDTO competitionDTO);
    public List<CompetitionDTO> findAll();
}
