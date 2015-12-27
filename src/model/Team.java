package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 2015-12-23.
 */
public class Team {

    private List<String> playstyles; //Playstyle should be something like: Combo, Rainbow, Wood, TPA...
    private ArrayList<Monster> monsters;
    private List<Awakening> totalAwakenings;
    private int totalCost;
    private int totalAtkFire;
    private int totalAtkWater;
    private int totalAtkWood;
    private int totalAtkLight;
    private int totalAtkDark;
    private int totalHp;
    private int totalRcv;
    private int totalDarkResist;
    private int totalJammerResist;
    private int totalPoisonResist;
    private int totalSkillBindResist;


    public Team() {
        monsters = new ArrayList<Monster>();
        totalCost = 0;
        totalDarkResist = 0;
        totalJammerResist = 0;
        totalPoisonResist = 0;
        totalSkillBindResist = 0;
    }

    public void addMonster(Monster m) {
        monsters.add(m);
        totalCost += m.getCost();
        totalAwakenings.addAll(m.getAwakenings());
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
