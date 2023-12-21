package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.MemberDTO;
import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.DTOs.Requests.RankingRequest;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.MemberEntity;
import com.example.aftasapi.Entities.RankingEntity;
import com.example.aftasapi.Errors.ErrorMessageHunting;
import com.example.aftasapi.Exceptions.CompetitionException;
import com.example.aftasapi.Exceptions.MemberException;
import com.example.aftasapi.Repositories.CompetitionRepository;
import com.example.aftasapi.Repositories.MemberRepository;
import com.example.aftasapi.Repositories.RankingRepository;
import com.example.aftasapi.Services.IRankingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RankingServiceImpl implements IRankingService {

    private final RankingRepository rankingRepository ;

    private final CompetitionRepository competitionRepository ;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper ;
    @Autowired
    public RankingServiceImpl(RankingRepository rankingRepository, CompetitionRepository competitionRepository, MemberRepository memberRepository, ModelMapper modelMapper){
        this.rankingRepository = rankingRepository ;
        this.competitionRepository = competitionRepository;
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    // add member to competition
    public RankingDTO createRanking(RankingRequest rankingRequest,String code) {
        CompetitionEntity competitionEntity = competitionRepository.findByCode(code).
                orElseThrow(()->
                new CompetitionException(ErrorMessageHunting.NO_COMPETITION_FOUND.getErrorMessage()));
        MemberEntity memberEntity = memberRepository.findByNum(rankingRequest.getMemberId()).orElseThrow(
                ()-> new MemberException(ErrorMessageHunting.NO_MEMBER_FOUND.getErrorMessage())
        );
        // verify date
        if (!isPossibleInscription(competitionEntity.getDate())){
            throw new MemberException("Cannot inscrire in this competition before 24 hours to start ");
        }

        // find member if exist in this competition
       Optional<RankingEntity> rankingCheck =  rankingRepository.findByCompetitionAndMember(competitionEntity,memberEntity);
         if (rankingCheck.isPresent()){
             throw new CompetitionException("this member already exist in this competition");
         }

        RankingEntity ranking = RankingEntity
                .builder()
                .competition(competitionEntity)
                .member(memberEntity)
                .score(0)
                .rank(0)
                .build();
        RankingEntity rankingCreated ;

        try{
            rankingCreated = rankingRepository.save(ranking);
        }catch (Exception ex){
            throw  new  CompetitionException(ex.getMessage());
        }

        return modelMapper.map(rankingCreated,RankingDTO.class);
    }


    @Override
    public RankingDTO update(long id, RankingDTO rankingDTO) {
        return null;
    }

    @Override
    public RankingDTO findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<RankingDTO> findAll() {
        return null;
    }

    @Override
    public RankingDTO create(RankingDTO rankingDTO) {


        return null;
    }

    public Boolean isPossibleInscription(Date dateCompetition){

        //LocalDateTime debutCompetitionLocalDate = LocalDateTime.ofInstant(dateCompetition.toInstant(), java.time.ZoneId.systemDefault());
        LocalDateTime debutCompetitionLocalDate =dateCompetition.toLocalDate().atStartOfDay();
        System.out.println(debutCompetitionLocalDate);
        LocalDateTime dateLimiteInscription = debutCompetitionLocalDate.minusDays(1);
        System.out.println(dateLimiteInscription);
        return  LocalDateTime.now().isBefore(dateLimiteInscription);

    }

    public List<RankingDTO> getRankings(String code) {
        CompetitionEntity competition = competitionRepository.findByCode(code).orElseThrow(()->{
            throw new CompetitionException(ErrorMessageHunting.NO_COMPETITION_FOUND.getErrorMessage());
        });
        List<RankingEntity> rankingsEntity = rankingRepository.findByCompetition(competition);
        List<RankingDTO> rankingsDTO = rankingsEntity.stream()
                .map(rankingEntity ->{
                    return RankingDTO.builder()
                            .id(rankingEntity.getId())
                            .member(modelMapper.map(rankingEntity.getMember(), MemberDTO.class))
                            .rank(rankingEntity.getRank())
                            .score(rankingEntity.getScore())
                            .build() ;
                } )
                .toList();
        return rankingsDTO ;
    }



}
