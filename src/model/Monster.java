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
    private Double atkScale;
    private Double hpScale;
    private Double rcvScale;
    private int lvlCurrent;
    private int awokenLvl;
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
        //TODO: Figure out how to handle the exception
        PadherderMonsterParser.parseMonsterJsonById(id);
    }

    public String getMonsterId() {
        return monsterId;
    }

    public Monster(String monsterId, String monsterName,
                   int rarity, int cost,
                   int atkMax, int hpMax, int rcvMax, int lvlMax,
                   int atkMin, int hpMin, int rcvMin,
                   Double atkScale, Double hpScale, Double rcvScale,
                   int lvlCurrent,
                   Element mainElement, Element subElement,
                   Type mainType, Type subType,
                   Skill activeSkill, Skill leaderSkill,
                   List<Awakening> awakenings,
                   boolean bindResistant) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.atkMax = atkMax;
        this.hpMax = hpMax;
        this.rcvMax = rcvMax;
        this.lvlMax = lvlMax;
        this.atkMin = atkMin;
        this.hpMin = hpMin;
        this.rcvMin = rcvMin;
        this.atkScale = atkScale;
        this.hpScale = hpScale;
        this.rcvScale = rcvScale;
        this.lvlCurrent = lvlCurrent;
        this.rarity = rarity;
        this.cost = cost;
        this.mainElement = mainElement;
        this.subElement = subElement;
        this.mainType = mainType;
        this.subType = subType;
        this.activeSkill = activeSkill;
        this.leaderSkill = leaderSkill;
        this.awakenings = awakenings;
        this.bindResistant = bindResistant;
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

    public void setAwokenLvl(int lvl) {
        awokenLvl = lvl;
    }

    //TODO: Create a method that returns true if a monster is 100% bind-resistant
}
