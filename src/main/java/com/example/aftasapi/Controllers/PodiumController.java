package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.Services.IPodiumService;
import com.example.aftasapi.Services.Impl.PodiumServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PodiumController {

        private final PodiumServiceImpl podiumService ;

    public PodiumController(PodiumServiceImpl podiumService) {
        this.podiumService = podiumService;
    }

    @GetMapping("/competitions/{code}/podium")
    public ResponseEntity<?> displayPodiumCompetition(@PathVariable String code){
        List<RankingDTO> rankingDTOList = podiumService.displayAllRankings(code);
        if (!rankingDTOList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(rankingDTOList);
        else
            return ResponseEntity.status(HttpStatus.OK).body("this competition dont have any ranking ");

    }

}
