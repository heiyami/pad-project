package model;

/**
 * Created by Julian on 2015-12-23.
 */
public enum Type {


    /**
     * Types in the Padherder Monster API are represented as
     * { 0:Evo Material, 1:Balanced, 2:Physical, 3:Healer, 4:Dragon, 5:God, 6:Attacker, 7:Devil, 8:Machine,
     *   12:Awoken Skill Material, 13:Protected, 14:Enhance Material, 15:Vendor }.
     *
     * NOTES:
     *  - There are absolutely no instances of a Monster of Type 13 (Protected).
     *      Truth be told, I have no clue whatsoever as to what Protected could represent too.
     *  - Types 8:Machine and 15:Vendor are not explicitly stated in the API description
     *      but can be easily confirmed in the actual JSON.
     */
    ATTACKER,
    AWOKEN,
    BALANCED,
    DEVIL,
    DRAGON,
    ENHANCE_MATERIAL,
    EVO_MATERIAL,
    GOD,
    HEALER,
    MACHINE,
    PHYSICAL,
    PROTECTED,
    VENDOR;

    public static Type convertJsonToType(int t) {
        Type type = null;
        switch (t) {
            case 0: type = EVO_MATERIAL;
                break;
            case 1: type = BALANCED;
                break;
            case 2: type = PHYSICAL;
                break;
            case 3: type = HEALER;
                break;
            case 4: type = DRAGON;
                break;
            case 5: type = GOD;
                break;
            case 6: type = ATTACKER;
                break;
            case 7: type = DEVIL;
                break;
            case 8: type = MACHINE;
                break;
            case 12: type = AWOKEN;
                break;
            case 13: type = PROTECTED;
                break;
            case 14: type = ENHANCE_MATERIAL;
                break;
            case 15: type = VENDOR;
                break;
        }

        return type;
    }
}
