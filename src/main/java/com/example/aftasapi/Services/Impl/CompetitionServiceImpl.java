package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Helpers.GenerateCode;
import com.example.aftasapi.Repositories.CompetitionRepository;
import com.example.aftasapi.Services.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements ICompetitionService {

    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;
    private final GenerateCode generateCode;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository, ModelMapper modelMapper, GenerateCode generateCode) {
        this.competitionRepository = competitionRepository;
        this.modelMapper = modelMapper;
        this.generateCode = generateCode;
    }

    @Override
    public CompetitionDTO create(CompetitionDTO competitionDTO) {


        CompetitionEntity competition = modelMapper.map(competitionDTO, CompetitionEntity.class);
        competition.setCode(generateCode.codeCompetition(competitionDTO));


        CompetitionEntity competitionCreated;
        try {
            competitionCreated = competitionRepository.save(competition);
        } catch (Exception e) {
            throw new RuntimeException("Error saving competition : ", e);
        }

        CompetitionDTO competitionDTO1 = modelMapper.map(competitionCreated, CompetitionDTO.class);

        // use log
        // ...........
        return competitionDTO1;
    }

    @Override
    public CompetitionDTO upadte(long competition_id, CompetitionDTO competitionDTO) {
        return null;
    }

    @Override
    public CompetitionDTO findCompetitionById(long id) {
        return null;
    }

    @Override
    public void delete(CompetitionDTO competitionDTO) {

    }

    @Override
    public List<CompetitionDTO> findAll() {
        List<CompetitionEntity> competitionEntityList = competitionRepository.findAll();
        List<CompetitionDTO> competitionDTOList = competitionEntityList.stream().map(competition -> modelMapper.map(competition, CompetitionDTO.class)).collect(Collectors.toList());
        return competitionDTOList;
    }
}

