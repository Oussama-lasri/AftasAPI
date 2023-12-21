package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.RankingEntity;
import com.example.aftasapi.Errors.ErrorMessageHunting;
import com.example.aftasapi.Exceptions.CompetitionException;
import com.example.aftasapi.Repositories.CompetitionRepository;
import com.example.aftasapi.Repositories.HuntingRepository;
import com.example.aftasapi.Repositories.MemberRepository;
import com.example.aftasapi.Repositories.RankingRepository;
import com.example.aftasapi.Services.IPodiumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PodiumServiceImpl implements IPodiumService {

    private final RankingRepository rankingRepository ;
    private final MemberRepository memberRepository ;
    private final CompetitionRepository competitionRepository ;
    private final ModelMapper modelMapper ;
    private final HuntingRepository huntingRepository ;
    @Autowired
    public PodiumServiceImpl(RankingRepository rankingRepository, MemberRepository memberRepository, CompetitionRepository competitionRepository, ModelMapper modelMapper, HuntingRepository huntingRepository) {
        this.rankingRepository = rankingRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
        this.modelMapper = modelMapper;
        this.huntingRepository = huntingRepository;
    }

    public List<RankingDTO> displayAllRankings(String code){




       // List<CompetitionEntity> competitionEntityList = competitionRepository.findAll();
        CompetitionEntity competition = competitionRepository.findByCode(code).orElseThrow(
                () -> new CompetitionException(ErrorMessageHunting.NO_COMPETITION_FOUND.getErrorMessage()));
        List<RankingDTO> rankingDTOList = new ArrayList<>(competition.getRankingList().stream()
                .map(ranking -> {
                    ranking.setScore(0);
                    // find all hunting of members in specific competition
                    List<HuntingEntity> huntingListIncludeInCompetition = huntingRepository.findAllByCompetitionAndMember(ranking.getCompetition(), ranking.getMember());
                    huntingListIncludeInCompetition.forEach((hunting -> {
                        ranking.setScore(ranking.getScore() + (hunting.getNumberOfFish() * hunting.getFish().getLevel().getPoints()));
                    }));
                    RankingEntity rankingUpdated = rankingRepository.save(ranking);
                    return modelMapper.map(rankingUpdated, RankingDTO.class);
                })
                .toList());
//        List<CompetitionDTO> competitionDTOList = competitionEntityList.stream().map(competition -> {
//            CompetitionDTO competitionDTO = modelMapper.map(competition,CompetitionDTO.class);
//            List<RankingDTO> rankingDTOList = competition.getRankingList().stream().map(rankingEntity -> {
//                return modelMapper.map(competition.getRankingList(),RankingDTO.class);
//            }).toList();
//            competitionDTO.setRankingList(rankingDTOList);
//            return competitionDTO;
//        }).toList();
        rankingDTOList.sort(Comparator.comparingInt(RankingDTO::getScore).reversed());
        return rankingDTOList;

    }
    public List<RankingDTO> generateRanking(String code){
        CompetitionEntity competition = competitionRepository.findByCode(code).orElseThrow(
                () -> new CompetitionException(ErrorMessageHunting.NO_COMPETITION_FOUND.getErrorMessage()));
        Sort sort = Sort.by(Sort.Direction.ASC, "score");
        return null  ;
    }
}
