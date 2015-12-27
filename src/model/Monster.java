package model;

import parsers.PadherderMonsterParser;
import util.MonsterStatCalculation;

import java.util.List;

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
    private List<Awakening> awakenings;
    private boolean bindResistant;

    /**
     * Create a monster based on its unique ID by passing it to PadherderMonsterParser.
     */
    public Monster(String id) {
        monsterId = id;
    }

    public String getMonsterId() {
        return monsterId;
    }

    public int getCost() {
        return cost;
    }

    public List<Awakening> getAwakenings() {
        return awakenings;
    }

    public int getAtkCurrent() {
        return MonsterStatCalculation.calculateCurrentStat(atkMin, atkMax, lvlCurrent, lvlMax, atkScale);
    }

    public int getHpCurrent() {
        return MonsterStatCalculation.calculateCurrentStat(hpMin, hpMax, lvlCurrent, lvlMax, hpScale);
    }

    public int getRcvCurrent() {
        return MonsterStatCalculation.calculateCurrentStat(rcvMin, rcvMax, lvlCurrent, lvlMax, rcvScale);
    }

    public void setLvlCurrent(int lvl) {
        lvlCurrent = lvl;
    }
}
