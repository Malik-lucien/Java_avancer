package com.java_avancer.java_avancer.dao;

import com.java_avancer.java_avancer.caracters.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImplement implements PlayerDao {
    public static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player(1, new String("agride"), new String("mage"), new String("death")));
        players.add(new Player(2, new String("jin.Sakail"), new String("warrior"), new String("grappler")));
        players.add(new Player(3, new String("fu.Mullan"), new String("warrior"), new String("clinch")));
        players.add(new Player(4, new String("albusse.D"), new String("mage"), new String("fire")));
        players.add(new Player(5, new String("demonia"), new String("mage"), new String("snow")));
        players.add(new Player(6, new String("notorious"), new String("warrior"), new String("muai-thai")));
        players.add(new Player(7, new String("M.Bisping"), new String("warrior"), new String("letwey")));
        players.add(new Player(8, new String("theEagle"), new String("warrior"), new String("jjb")));
    }
    public PlayerDaoImplement() {
        super();
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public Player findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }
    private int counter = 9;

    @Override
    public Player save(Player player) {
        Player hero = this.findById(player.getId());
                if (hero == null){
                    player.setId(counter);
                    counter ++;
                    players.add(player);
                }else{
                    hero.setName("frodon queqet");
                    hero.setType("a la pourssite de l anneau");
                }
                return player;
    }
//        players.add(player); /*faire en sorte d'avoire un id unique spring*/
//        counter ++;
//        return player;

    @Override
    public Player update(Player player) {
        Player hero =this.findById(player.getId());
        hero.setName(player.getName());
        hero.setType(player.getType());

        return hero;
    }

    @Override
    public Player delete(int id) {
//        for (Player player : players) {
//            if (player.getId()==id){
//                 players.remove(player);
//            }
//        }
        //players is a list of player
        players.removeIf(player -> player.getId() == id);
        return null;

    }

}
