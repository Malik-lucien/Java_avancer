package com.java_avancer.java_avancer.controller;
//import all i need to work

import com.java_avancer.java_avancer.caracters.Player;
import com.java_avancer.java_avancer.dao.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.ServiceConfigurationError;
/*if id in uri generate error code if problem*/
@RestController
//i create my class controller
public class PlayerController {
    // i do the mapping url with a method get
    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    // i creat a array list with players and his method type is public
    public List<Player> playerList() {
        return playerDao.findAll();
    }

    @DeleteMapping(value = "player/{id}")
    public Player deletePlayer(@PathVariable int id) {
        return playerDao.delete(id);
    }

    @GetMapping(value = "player/{id}")
    public Player showPlayer(@PathVariable int id) {
        return playerDao.findById(id);
    }

    @PostMapping(value = "/player")
    public ResponseEntity addPlayer(@RequestBody Player player) {
        Player player1 = playerDao.save(player);
        if (player == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}



