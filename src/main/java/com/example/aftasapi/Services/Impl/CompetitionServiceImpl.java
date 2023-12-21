package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.Response.CompetitionResponse;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Errors.ErrorMessageGeneral;
import com.example.aftasapi.Exceptions.CompetitionException;
import com.example.aftasapi.Helpers.GenerateCode;
import com.example.aftasapi.Repositories.CompetitionRepository;
import com.example.aftasapi.Services.ICompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        Optional<CompetitionEntity> competitionCheck = competitionRepository.findByDate(competitionDTO.getDate());
        if (competitionCheck.isPresent()){
            throw  new CompetitionException(ErrorMessageGeneral.RECORD_ALREADY_EXISTS.getErrorMessage()+"with this date : "+competitionCheck.get().getDate());
        }

        if (competitionDTO.getDate().before(new Date())){
            throw new CompetitionException("Invalid competition date. Please enter a date in the future.");
        }

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
    public CompetitionDTO update(long competition_id, CompetitionDTO competitionDTO) {
        return null;
    }

    public CompetitionDTO findByCode(String code) {
        CompetitionEntity competition = competitionRepository.findByCode(code).orElseThrow(()->
                new CompetitionException("competitions not found")
        );
        return modelMapper.map(competition,CompetitionDTO.class);
    }

    @Override
    public void delete(long competition_id) {

    }

    @Override
    public List<CompetitionDTO> findAll() {
        List<CompetitionEntity> competitionEntityList = competitionRepository.findAll();
        List<CompetitionDTO> competitionDTOList = competitionEntityList.stream().map(competition -> modelMapper.map(competition, CompetitionDTO.class)).collect(Collectors.toList());
        return competitionDTOList;
    }
    @Override
    public CompetitionResponse allCompetitionWithPagination(int pageNumber , int pageSize) {
        Pageable pageable =  PageRequest.of(pageNumber,pageSize);
        Page<CompetitionEntity> competitions = competitionRepository.findAll(pageable);
        List<CompetitionDTO> competitionDTOList = competitions.getContent().stream().map(competition -> modelMapper.map(competition, CompetitionDTO.class)).collect(Collectors.toList());
        CompetitionResponse competitionResponse = CompetitionResponse.builder()
                .competitions(competitionDTOList)
                .pageSize(competitions.getSize())
                .totalPage(competitions.getTotalPages())
                .totalElement(competitions.getTotalElements())
                .last(competitions.isLast())
                .pageNumber(competitions.getNumber())
                .build();
        return competitionResponse;
    }

    @Override
    public CompetitionDTO findById(long code) {
        return null;
    }
}

