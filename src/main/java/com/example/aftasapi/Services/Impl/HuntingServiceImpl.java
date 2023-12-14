package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.DTOs.MemberDTO;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.FishEntity;
import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.MemberEntity;
import com.example.aftasapi.Errors.ErrorMessageHunting;
import com.example.aftasapi.Exceptions.HuntingException;
import com.example.aftasapi.Repositories.CompetitionRepository;
import com.example.aftasapi.Repositories.FishRepository;
import com.example.aftasapi.Repositories.HuntingRepository;
import com.example.aftasapi.Repositories.MemberRepository;
import com.example.aftasapi.Requests.HuntingRequest;
import com.example.aftasapi.Services.IHuntingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HuntingServiceImpl implements IHuntingService {

    private final HuntingRepository huntingRepository ;
    private final CompetitionRepository competitionRepository ;
    private final FishRepository fishRepository ;
    private  final MemberRepository memberRepository ;
    private final ModelMapper modelMapper ;

@Autowired
    public HuntingServiceImpl(HuntingRepository huntingRepository, CompetitionRepository competitionRepository, FishRepository fishRepository, MemberRepository memberRepository, ModelMapper modelMapper) {
        this.huntingRepository = huntingRepository;
        this.competitionRepository = competitionRepository;
    this.fishRepository = fishRepository;
    this.memberRepository = memberRepository;
    this.modelMapper = modelMapper;
}
    @Override

    public HuntingDTO createHunting(HuntingRequest huntingRequest)  {
        CompetitionEntity competition = competitionRepository.findByCode(huntingRequest.getCompetition_code())
                .orElseThrow(()-> new HuntingException(ErrorMessageHunting.NO_COMPETITION_FOUND.getErrorMessage()));


        FishEntity fish = fishRepository.findById(huntingRequest.getFish_id())
                .orElseThrow(()->new HuntingException(ErrorMessageHunting.NO_FISH_FOUND.getErrorMessage()));
//        if (fish.isEmpty()){
//            throw new HuntingException(ErrorMessageHunting.NO_FISH_FOUND.getErrorMessage());
//        }
        MemberEntity member = memberRepository.findByNum(huntingRequest.getMember_num())
                .orElseThrow(()-> new HuntingException(ErrorMessageHunting.NO_MEMBER_FOUND.getErrorMessage()));

//        if (member.isEmpty()){
//            throw new HuntingException(ErrorMessageHunting.NO_MEMBER_FOUND.getErrorMessage());
//        }
        huntingRepository.findByCompetitionAndMember(competition,member).ifPresent(huntingEntity -> {
            throw new HuntingException(ErrorMessageHunting.RECORD_ALREADY_EXISTS.getErrorMessage());
        });


        HuntingEntity hunting = HuntingEntity.builder()
                .competition(competition)
                .fish(fish)
                .member(member)
                .numberOfFish(huntingRequest.getNumberOfFish())
                .build();
        HuntingEntity huntingCreated ;
        try{
            huntingCreated = huntingRepository.save(hunting);
        }catch(Exception ex){
            throw new HuntingException(ex.getMessage());
        }
        HuntingDTO huntingDTO = HuntingDTO.builder()
                .id(huntingCreated.getId())
                .numberOfFish(huntingCreated.getNumberOfFish())
                .member(modelMapper.map(huntingCreated.getMember(), MemberDTO.class))
                .fish(modelMapper.map(huntingCreated.getFish(), FishDTO.class))
                .competition(modelMapper.map(huntingCreated.getCompetition(), CompetitionDTO.class))
                .build();
        return huntingDTO;
    }

    @Override
    public HuntingDTO update(long hunting_id, HuntingDTO huntingDTO) {
        return null;
    }

    @Override
    public HuntingDTO findById(long hunting_id) {
        return null;
    }

    @Override
    public void delete(long hunting_id) {

    }

    @Override
    public List<HuntingDTO> findAll() {
        return null;
    }

    @Override
    public HuntingDTO create(HuntingDTO huntingDTO) {


        return null;
    }

}
