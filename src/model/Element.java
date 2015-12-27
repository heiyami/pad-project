package model;

/**
 * Created by Julian on 2015-12-23.
 */
public enum Element {

    /**
     * Elements in the Padherder Monster API are represented as:
     * { 0:Fire, 1:Water, 2:Wood, 3:Light, 4:Dark }
     */
    FIRE,
    WATER,
    WOOD,
    LIGHT,
    DARK,
    HEAL,
    JAMMER,
    POISON,
    MORTAL_POISON;

    /**
     * Takes an integer value from 0 to 5, obtained from the Padherder Monster API,
     * and converts to its respective Element value
     *
     * @param e   the value obtained from the API
     */
    public static Element convertJsonToAttribute(int e) {
        Element element = null;

        switch (e) {
            case 0: element = Element.FIRE;
                break;
            case 1: element = Element.WATER;
                break;
            case 2: element = Element.WOOD;
                break;
            case 3: element = Element.LIGHT;
                break;
            case 4: element = Element.DARK;
                break;
        }
        return element;
    }
}
