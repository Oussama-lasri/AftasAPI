package com.example.aftasapi.Controllers;

import com.example.aftasapi.BaseInterfaces.IBaseController;
import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.Requests.FishRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/fishes")
@CrossOrigin
public class FishController implements IBaseController<FishDTO,FishRequest> {
    @Override
    public ResponseEntity<FishDTO> create(FishRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<FishDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<FishDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<FishDTO> update(long id, FishRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return null;
    }
}
