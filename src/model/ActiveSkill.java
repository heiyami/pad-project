package model;

/**
 * Created by Julian on 2015-12-23.
 */
public class ActiveSkill extends Skill {

    private String name;
    private String description;
    private int cooldown;

    public ActiveSkill(String name, int cooldown, String desc) {
        this.name = name;
        this.cooldown = cooldown;
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void decrementCooldown() {
        this.cooldown -= 1;
    }

    public void increaseCooldown(int n) {
        this.cooldown += n;
    }


}
