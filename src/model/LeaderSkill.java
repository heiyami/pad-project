package model;

/**
 * Created by Julian on 2015-12-23.
 */
public class LeaderSkill extends Skill {

    /**
     * From Padherder API:
     *
     * The "data" field contains the data PADherder users to calculate multipliers for leader skills.
     * The format is [HP multiplier, AKT multiplier, RCV multiplier, constraint1, ..., constraintN].
     * Constraints consist of an attribute specifier
     *   ( "elem" for monster element, "type" for monster type) and 1 or more value checks.
     * The example here is '[1, 2, 1, ["type", 2]]'
     *   which translates to 1x HP/2x ATK/1x RCV for monsters with type 2 (Physical).
     *
     *
     * Here's an interesting example to think about: Eshchamali (ID:2591).
     * Her leader skill is as follows:
     *   "Machine type cards ATK x1.5, RCV x1.5.
     *    Matched attribute ATK x4 when matching exactly 5 connected orbs with at least 1 enhanced orb."
     *
     * This means that she has two constraints, one of which is type:8 and the other cannot be represented in the API.
     * How would you represent her "data" component?
     * I would like to have this data in the app (it helps people search for relevant rooms) but I'm not sure how.
     */
    private Double atkMultiplier;
    private Double hpMultiplier;
    private Double rcvMultiplier;

    public LeaderSkill(String name) {
        this.skillName = name;
    }

    public LeaderSkill(String name, String effect) {
        this.skillName = name;
        this.skillEffect = effect;
    }
}
