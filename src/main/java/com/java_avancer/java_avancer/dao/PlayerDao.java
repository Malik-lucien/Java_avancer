package com.java_avancer.java_avancer.dao;

import com.java_avancer.java_avancer.caracters.Player;

import java.util.List;

public interface PlayerDao {
    // ATTENTION CA ETRE METHODE !!!!!!!!!
    public List<Player> findAll();

    public Player findById(int id);

    public Player save(Player player);

    public Player update(Player player);

    public Player delete(int id);


}
