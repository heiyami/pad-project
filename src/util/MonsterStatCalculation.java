package util;

/**
 * Created by Julian on 2015-12-26.
 */
public class MonsterStatCalculation {

    /**
     * Stat calculation formula taken from
     * http://pad.wikia.com/wiki/Game_Mechanics#Monster_Stat_Calculation
     *
     * @param min          the minimum stat value of the monster
     * @param max          the maximum stat value of the monster
     * @param lvlCurrent   the current level of the monster
     * @param lvlMax       the maximum level of the monster
     * @param scale        the scaling on the stat of the monster
     * @return             the stat value of monster at its current level
     */
    public static int calculateCurrentStat(int min, int max, int lvlCurrent, int lvlMax, Double scale) {
        int a = (max - min);
        int b = (lvlCurrent - 1);
        int c = (lvlMax - 1);
        int d = b/c;
        int e = (int) Math.pow(d,scale);
        return min + b*e;
    }
}
