package com.putri.backend.controller;

import com.putri.backend.model.Player;
import com.putri.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<List<Player>> getPlayerById(@PathVariable UUID playerId){
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()){
            return ResponseEntity.ok(Collections.singletonList(player.get()));
        }
        else {
            return (ResponseEntity<List<Player>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Player>> getPlayerByUsername(@PathVariable String username){
        Optional<Player> player = playerService.getPlayerByUsername(username);
        if (player.isPresent()){
            return ResponseEntity.ok(Collections.singletonList(player.get()));
        }
        else {
            return (ResponseEntity<List<Player>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/check-username/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        return ResponseEntity.ok(playerService.isUsernameExists(username));
    }
}
