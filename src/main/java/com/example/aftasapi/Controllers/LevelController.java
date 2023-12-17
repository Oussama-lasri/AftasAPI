package com.example.aftasapi.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/levels")
@CrossOrigin
public class LevelController {

    @PostMapping
    public ResponseEntity<?> createLevel(){
        return null ;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateLevel(){
        return null ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLevel(){
        return null ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLevel(){
        return null ;
    }

    @GetMapping
    public ResponseEntity<List<?>> getLevels(){
        return null ;
    }
}
