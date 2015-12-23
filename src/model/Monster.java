package model;

import parsers.PadherderMonsterParser;

/**
 * Created by Julian on 2015-12-23.
 */
public class Monster {

    private String monsterId;
    private String monsterName;
    private int atkMax;
    private int hpMax;
    private int rcvMax;
    private int lvlMax;
    private int atkMin;
    private int hpMin;
    private int rcvMin;
    private int lvlMin;
    private int atkScale;
    private int hpScale;
    private int rcvScale;
    private int lvlCurrent;
    private int rarity;
    private int cost;
    private Element mainElement;
    private Element subElement;
    private Type mainType;
    private Type subType;
    private Skill activeSkill;
    private Skill leaderSkill;

    /**
     * Create a monster based on its unique ID by passing it to PadherderMonsterParser.
     */
    public Monster(String id) {
        monsterId = id;
    }

    public int getCost() {
        return cost;
    }
}
