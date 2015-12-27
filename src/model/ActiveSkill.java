package model;

import parsers.PadherderActiveSkillParser;

/**
 * Created by Julian on 2015-12-23.
 */
public class ActiveSkill extends Skill {

    private int skillLevelMin;
    private int skillLevelMax;

    public ActiveSkill(String name) {
        //TODO: Figure out how to handle the exception
        PadherderActiveSkillParser.parseActiveSkillJson(name);
    }

    public ActiveSkill(String name, String effect, int skillLevelMin, int skillLevelMax) {
        skillName = name;
        skillEffect = effect;
        this.skillLevelMin = skillLevelMin;
        this.skillLevelMax = skillLevelMax;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public int getSkillLevelMin() {
        return skillLevelMin;
    }

    public int getSkillLevelMax() {
        return skillLevelMax;
    }
}
