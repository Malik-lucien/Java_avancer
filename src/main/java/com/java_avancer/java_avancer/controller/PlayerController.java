package com.java_avancer.java_avancer.controller;
//import all i need to work

import com.java_avancer.java_avancer.caracters.Player;
import com.java_avancer.java_avancer.dao.PlayerDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Api(description = "Gestion des personnages")

/*if id in uri generate error code if problem*/
@RestController
//i create my class controller
public class PlayerController {
    // i do the mapping url with a method get
    @Autowired
    private PlayerDao playerDao;
    @ApiOperation("Récupère et afficher tous les joueur créer")
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    // i creat a array list with players and his method type is public
    public List<Player> playerList() {
        return playerDao.findAll();
    }
    @ApiOperation("recupere un personnage grace et son id et le supprime de la bdd")
    @DeleteMapping(value = "player/{id}")
    /*A Quoi serv lanotion avant le int id*/
    public Player deletePlayer(@PathVariable int id) {
        return playerDao.delete(id);
    }
    @ApiOperation("permet de récupérer et d'afficher un personnage grace a son id  ")
    @GetMapping(value = "player/{id}")
    public Player showPlayer(@PathVariable int id) {
        return playerDao.findById(id);
    }
    @ApiOperation("permet de créer un nouveau personnage")
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

    //pumMapping
    @ApiOperation("permet de modifier un personnage deja créer")
    @PutMapping(path = "/update")
    public String updatePlayer(@RequestBody Player player) {
        Player player1 = playerDao.update(player);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player1.getId())
                .toUri();

        return ResponseEntity.created(location).build() + "upDated";
    }

}



