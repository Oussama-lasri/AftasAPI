package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Helpers.GenerateCode;
import com.example.aftasapi.Repositories.CompetitionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompetitionServiceImplTest {
    @MockBean
    private CompetitionRepository competitionRepository ;

    @MockBean
    private  ModelMapper modelMapper;

    @MockBean
    private GenerateCode generateCode;
    @InjectMocks
    private CompetitionServiceImpl competitionService;
    private CompetitionDTO competitionDTO ;
    private CompetitionEntity competitionEntity ;

    @BeforeEach
    public void init(){
        competitionDTO = CompetitionDTO.builder()
                .amount(1000F)
                .date(Date.valueOf("2023-12-14"))
                .startTime(Time.valueOf("09:00:00"))
                .endtTime(Time.valueOf("19:00:00"))
                .location("Safi")
                .code(Mockito.anyString())
                .build();

        competitionEntity = CompetitionEntity.builder()
                .amount(1000F)
                .date(Date.valueOf("2023-12-14"))
                .startTime(Time.valueOf("09:00:00"))
                .endtTime(Time.valueOf("19:00:00"))
                .location("Safi")
                .code(Mockito.anyString())
                .build();
    }


    @Test
    void competitionTest_createCompetition_ReturnCompetitionDTO() {

        //Optional<CompetitionDTO> competitionDTO = Optional.of(this.competitionDTO);
        //Optional<CompetitionEntity> competitionEntity = Optional.of(this.competitionEntity);


        //Mockito.when(competitionRepository.findByDate(Mockito.any())).thenReturn(competitionEntity);

        Mockito.when(competitionRepository.findByDate(this.competitionDTO.getDate())).thenReturn(Optional.empty());

        Mockito.when(modelMapper.map(Mockito.eq(competitionDTO), Mockito.eq(CompetitionEntity.class))).thenReturn(competitionEntity);
        Mockito.when(generateCode.codeCompetition(Mockito.eq(competitionDTO))).thenReturn("generatedCode");
        Mockito.when(competitionRepository.save(Mockito.eq(competitionEntity))).thenReturn(competitionEntity);

        // Act
        CompetitionDTO result = competitionService.create(competitionDTO);

        // Assert
        assertNotNull(result);



    }
}