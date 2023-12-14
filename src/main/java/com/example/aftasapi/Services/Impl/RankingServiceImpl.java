package com.example.aftasapi.Services.Impl;

import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.Repositories.RankingRepository;
import com.example.aftasapi.Services.IRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RankingServiceImpl implements IRankingService {

    private final RankingRepository rankingRepository ;
    @Autowired
    public RankingServiceImpl(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository ;
    }
    @Override
    public RankingDTO create(RankingDTO rankingDTO) {
        return null;
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
}
