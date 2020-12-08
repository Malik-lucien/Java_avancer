package com.java_avancer.java_avancer.controller;

import com.java_avancer.java_avancer.caracters.Player;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlayerController {
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public ArrayList<Player> players() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(1, new String("agride"), new String("mage")));
        players.add(new Player(2, new String("jin.Sakail"), new String("warrior")));
        players.add(new Player(3, new String("fu.Mullan"), new String("warrior")));
        players.add(new Player(4, new String("albusse.D"), new String("mage")));
        players.add(new Player(5, new String("demonia"), new String("mage")));
        players.add(new Player(6, new String("notorious"), new String("warrior")));
        players.add(new Player(7, new String("M.Bisping"), new String("warrior")));
        players.add(new Player(8, new String("theEagle"), new String("warrior")));
        return players;
    }

}



