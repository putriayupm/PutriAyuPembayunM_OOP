package com.putri.backend.controller;

import com.putri.backend.model.Score; //sesuaikan
import com.putri.backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<> createScore (@RequestBody Score score){
        try {
            scoreService.createScore(score);
            return ResponseEntity.status(HttpStatus.CREATED).body(createScore());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":" );
        }
    }

}
