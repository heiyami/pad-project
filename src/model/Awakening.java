package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 2015-12-26.
 */
public enum Awakening {

    ENHANCE_ATK, ENHANCE_HP, ENHANCE_RCV,
    REDUCE_FIRE, REDUCE_WATER, REDUCE_WOOD, REDUCE_LIGHT, REDUCE_DARK,
    ENHANCE_ORB_FIRE, ENHANCE_ORB_WATER, ENHANCE_ORB_WOOD, ENHANCE_ORB_LIGHT, ENHANCE_ORB_DARK,ENHANCE_ORB_HEART,
    ENHANCE_ROW_FIRE, ENHANCE_ROW_WATER, ENHANCE_ROW_WOOD, ENHANCE_ROW_LIGHT, ENHANCE_ROW_DARK,
    AUTO_RCV,
    RCV_BIND,
    EXTEND_TIME,
    SKILL_BOOST,
    TWO_PRONG_ATK,
    RESIST_BIND, RESIST_DARK, RESIST_JAMMER, RESIST_POISON, RESIST_SKILL_BIND;

    public static Awakening convertJsonToAwakening(int a) {
        Awakening awakening = null;

        switch (a) {
            case 1: awakening = ENHANCE_HP;
                break;
            case 2: awakening = ENHANCE_ATK;
                break;
            case 3: awakening = ENHANCE_RCV;
                break;
            case 4: awakening = REDUCE_FIRE;
                break;
            case 5: awakening = REDUCE_WATER;
                break;
            case 6: awakening = REDUCE_WOOD;
                break;
            case 7: awakening = REDUCE_LIGHT;
                break;
            case 8: awakening = REDUCE_DARK;
                break;
            case 9: awakening = AUTO_RCV;
                break;
            case 10: awakening = RESIST_BIND;
                break;
            case 11: awakening = RESIST_DARK;
                break;
            case 12: awakening = RESIST_JAMMER;
                break;
            case 13: awakening = RESIST_POISON;
                break;
            case 14: awakening = ENHANCE_ORB_FIRE;
                break;
            case 15: awakening = ENHANCE_ORB_WATER;
                break;
            case 16: awakening = ENHANCE_ORB_WOOD;
                break;
            case 17: awakening = ENHANCE_ORB_LIGHT;
                break;
            case 18: awakening = ENHANCE_ORB_DARK;
                break;
            case 19: awakening = EXTEND_TIME;
                break;
            case 20: awakening = RCV_BIND;
                break;
            case 21: awakening = SKILL_BOOST;
                break;
            case 22: awakening = ENHANCE_ROW_FIRE;
                break;
            case 23: awakening = ENHANCE_ROW_WATER;
                break;
            case 24: awakening = ENHANCE_ROW_WOOD;
                break;
            case 25: awakening = ENHANCE_ROW_LIGHT;
                break;
            case 26: awakening = ENHANCE_ROW_DARK;
                break;
            case 27: awakening = TWO_PRONG_ATK;
                break;
            case 28: awakening = RESIST_SKILL_BIND;
                break;
            case 29: awakening = ENHANCE_ORB_HEART;
                break;
        }

        return awakening;
    }

    public static List<Awakening> convertJsonToAwakenings(int[] ints) {
        List<Awakening> awakenings = new ArrayList<Awakening>();

        for (int i : ints) {
            Awakening thisAwakening = convertJsonToAwakening(i);
            awakenings.add(thisAwakening);
        }

        return awakenings;
    }
}
