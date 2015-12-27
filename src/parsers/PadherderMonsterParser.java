package parsers;

import json.JsonReader;
import model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import parsers.exception.PadherderMonsterDataMissing;

import java.util.List;

/**
 * Created by Julian on 2015-12-23.
 */
public class PadherderMonsterParser {

    /** NOTES:
     *
     *  - In Padherder's Monster API, a Monster's ID is one greater than its position in the array.
     *      e.g. Monster with ID 656, "Loki, the Finisher", is the 655th element.
     *    Exploit this so as to not traverse over the entire JSONArray of Monsters.
     *
     *  - Padherder's Monster API also includes a type3 key for every monster. However, it is always null.
     *
     *  WARNING: THIS PATTERN DOES NOT HOLD TRUE FOR ANY POSITION IN THE ARRAY GREATER THAN 1338.
     *
     *  OBJECT 1339 CORRESPONDS TO ID 1342 (CURRENT JUMP 2, NET JUMP 2)
     *  OBJECT 1464 CORRESPONDS TO ID 1468 (CURRENT JUMP 1, NET JUMP 3)
     *  OBJECT 1466 CORRESPONDS TO ID 1471 (CURRENT JUMP 1, NET JUMP 4)
     *  OBJECT 1703 CORRESPONDS TO ID 1710 (CURRENT JUMP 2, NET JUMP 6)
     *  OBJECT 1831 CORRESPONDS TO ID 1840 (CURRENT JUMP 2, NET JUMP 8)
     *  OBJECT 1833 CORRESPONDS TO ID 1844 (CURRENT JUMP 2, NET JUMP 10)
     *  OBJECT 1881 CORRESPONDS TO ID 1896 (CURRENT JUMP 4, NET JUMP 14)
     *  OBJECT 2487 CORRESPONDS TO ID 2503 (CURRENT JUMP 1, NET JUMP 15)
     *  OBJECT 2488 CORRESPONDS TO ID 2505 (CURRENT JUMP 1, NET JUMP 16)
     *  OBJECT 2489 CORRESPONDS TO ID 2508 (CURRENT JUMP 2, NET JUMP 18)
     *  OBJECT 2504 CORRESPONDS TO ID 2548 (CURRENT JUMP 25, NET JUMP 43)
     *  OBJECT 2506 CORRESPONDS TO ID 2562 (CURRENT JUMP 12, NET JUMP 55)
     *  OBJECT 2512 CORRESPONDS TO ID 2572 (CURRENT JUMP 4, NET JUMP 59)
     *  OBJECT 2513 CORRESPONDS TO ID 2591 (CURRENT JUMP 18, NET JUMP 77)
     *
     *  ID - 1 = OBJECT_NUMBER - NET_JUMP
     *  e.g. id:1851 - 1 = object:1840 + net_jump(1833,1881):10
     */
    public static Monster parseMonsterJsonById(String id) throws JSONException, PadherderMonsterDataMissing {
        JSONArray monsterJson = JsonReader.readJsonArrayFromUrl("https://www.padherder.com/api/monsters/");
        Monster parseResult = null;

        for (int i=0; i<monsterJson.length(); i++) {
            JSONObject thisMonster = monsterJson.getJSONObject(i);

            if (thisMonster.getString("id").equals(id)) {
                String monsterId = thisMonster.getString("id");
                String monsterName = thisMonster.getString("name");
                int atkMax = thisMonster.getInt("atk_max");
                int hpMax = thisMonster.getInt("hp_max");
                int rcvMax = thisMonster.getInt("rcv_max");
                int lvlMax = thisMonster.getInt("max_level");
                int atkMin = thisMonster.getInt("atk_min");
                int hpMin = thisMonster.getInt("hp_min");
                int rcvMin = thisMonster.getInt("rcv_min");
                Double atkScale = thisMonster.getDouble("atk_scale");
                Double hpScale = thisMonster.getDouble("hp_scale");
                Double rcvScale = thisMonster.getDouble("rcv_scale");
                int lvlCurrent = thisMonster.getInt("id");
                int rarity = thisMonster.getInt("rarity");
                int cost = thisMonster.getInt("team_cost");
                Element mainElement = Element.convertJsonToAttribute(thisMonster.getInt("element"));
                Element subElement = Element.convertJsonToAttribute(thisMonster.getInt("element2"));
                Type mainType = Type.convertJsonToType(thisMonster.getInt("type"));
                Type subType = Type.convertJsonToType(thisMonster.getInt("type2"));
                Skill activeSkill = new ActiveSkill(thisMonster.getString("active_skill"));
                Skill leaderSkill = new LeaderSkill(thisMonster.getString("leader_skill"));
                int[] ints = new int[thisMonster.getJSONArray("awoken_skills").length()];
                List<Awakening> awakenings = Awakening.convertJsonToAwakenings(ints);
                boolean bindResistant = false; //stub

                parseResult = new Monster(monsterId, monsterName, rarity, cost,
                        atkMax, hpMax, rcvMax, lvlMax, atkMin, hpMin, rcvMin, atkScale, hpScale, rcvScale, lvlCurrent,
                        mainElement, subElement, mainType, subType, activeSkill, leaderSkill, awakenings, bindResistant);
            }
        }

        // This should never come out as null. If it did, then the ID simply doesn't exist (user input error).
        return parseResult;
    }
}
