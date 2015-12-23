package model;

import java.util.ArrayList;

/**
 * Created by Julian on 2015-12-23.
 */
public class Team {

    private ArrayList<Monster> monsters;
    private int totalCost;

    public Team() {
        monsters = new ArrayList<Monster>();
        totalCost = 0;
    }

    public void addMonster(Monster m) {
        monsters.add(m);
        totalCost += m.getCost();
    }

    public void removeMonster(int i) {
        monsters.remove(i);
        totalCost -= monsters.get(i).getCost();
    }

    public void clearTeam() {
        for (int i=0; i<monsters.size(); i++) {
            monsters.remove(i);
        }
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
