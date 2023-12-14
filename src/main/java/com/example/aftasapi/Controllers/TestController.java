package com.example.aftasapi.Controllers;

import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.BaseInterfaces.IBaseController;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TestController implements IBaseController<RankingDTO,RankingDTO> {
    @Override
    public ResponseEntity<RankingDTO> create(RankingDTO request) {
        return null;
    }

    @Override
    public ResponseEntity<List<RankingDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<RankingDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<RankingDTO> update(long id, RankingDTO request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return null;
    }
}
