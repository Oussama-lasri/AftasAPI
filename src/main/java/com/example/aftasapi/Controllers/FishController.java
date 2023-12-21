package com.example.aftasapi.Controllers;

import com.example.aftasapi.BaseInterfaces.IBaseController;
import com.example.aftasapi.DTOs.FishDTO;
import com.example.aftasapi.Requests.FishRequest;
import com.example.aftasapi.Services.IFishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/fishes")
@CrossOrigin
public class FishController implements IBaseController<FishDTO,FishRequest> {

    private final IFishService fishService ;
    @Autowired
    FishController(IFishService fishService){
        this.fishService = fishService ;
    }
    @Override
    public ResponseEntity<FishDTO> create(FishRequest request) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<FishDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(fishService.findAll());
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
