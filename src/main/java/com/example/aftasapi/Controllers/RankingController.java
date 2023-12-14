//package com.example.aftasapi.Controllers;
//
//import com.example.aftasapi.DTOs.RankingDTO;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/rankings")
//public class RankingController {
//
//     private final RankingService rankingService ;
//     private final ModelMapper modelMapper ;
//     @Autowired
//     public RankingController(RankingService rankingService, ModelMapper modelMapper){
//         this.rankingService = rankingService ;
//         this.modelMapper = modelMapper;
//     }
//
//
//    @PostMapping
//    public ResponseEntity<RankingDTO> create(@RequestBody RankingRequest  rankingRequest){
//        RankingDTO rankingDTO = rankingService.create(rankingRequest,RankingDTO.class));
//        return ResponseEntity.status(HttpStatus.CREATED).body(rankingDTO);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<RankingDTO>> getAllRanking(){
//         List<RankingDTO> ListRanking = rankingService.getAll();
//         return ResponseEntity.status(HttpStatus.OK).body(ListRanking);
//    }
//
//    @GetMapping("{rankingId}")
//    public ResponseEntity<RankingDTO> getRanking(@PathVariable Long rankingId){
//         return ResponseEntity.status(HttpStatus.OK).body(rankingDTO);
//    }
//
//    @PutMapping("{rankingId}")
//    public ResponseEntity<RankingDTO> update(@PathVariable Long rankingId,@RequestBody RankingRequest rankingRequest){
//        RankingDTO rankingUpdated = rankingService.update(rankingId,modelMapper.map(rankingRequest,RankingDTO.class));
//         return ResponseEntity.status(HttpStatus.ACCEPTED).body(rankingUpdated);
//    }
//
//}
