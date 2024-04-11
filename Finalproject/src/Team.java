package Finalproject.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Double> positionPriorities;
    private List<Player> roster;

    public Team(String name) {
        this.name = name;
        this.positionPriorities = new HashMap<>();
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setPositionPriority(String position, double priority) {
        positionPriorities.put(position, priority);
    }

    public double getPositionPriority(String position) {
        return positionPriorities.getOrDefault(position, 1.0);
    }

    public void addPlayer(Player player) {
        roster.add(player);
    }

    public void printRoster() {
        for (Player player : roster) {
            System.out.println(player);
        }
    }
}
