package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.DTOs.Requests.RankingRequest;
import com.example.aftasapi.Services.IRankingService;
import com.example.aftasapi.Services.Impl.RankingServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class RankingController {

     private final RankingServiceImpl rankingService ;
     private final ModelMapper modelMapper ;
     @Autowired
     public RankingController(RankingServiceImpl rankingService, ModelMapper modelMapper){
         this.rankingService = rankingService ;
         this.modelMapper = modelMapper;
     }
    @GetMapping("competitions/{code}/members")
    public ResponseEntity<List<RankingDTO>> getRankingsCompetition(@PathVariable String code){
        List<RankingDTO> rankings = rankingService.getRankings(code);
        return ResponseEntity.status(HttpStatus.CREATED).body(rankings);
    }

    @PostMapping("competitions/{code}/members")
    public ResponseEntity<RankingDTO> create(@PathVariable String code,@RequestBody RankingRequest rankingRequest){
        RankingDTO rankingDTO = rankingService.createRanking(rankingRequest,code);
        return ResponseEntity.status(HttpStatus.CREATED).body(rankingDTO);
    }

    @GetMapping
    public ResponseEntity<List<RankingDTO>> getAllRanking(){
         List<RankingDTO> ListRanking = rankingService.findAll();
         return ResponseEntity.status(HttpStatus.OK).body(ListRanking);
    }

    @GetMapping("{rankingId}")
    public ResponseEntity<?> getRanking(@PathVariable Long rankingId){
         return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PutMapping("{rankingId}")
    public ResponseEntity<RankingDTO> update(@PathVariable Long rankingId,@RequestBody RankingRequest rankingRequest){
        RankingDTO rankingUpdated = rankingService.update(rankingId,modelMapper.map(rankingRequest,RankingDTO.class));
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(rankingUpdated);
    }

}
