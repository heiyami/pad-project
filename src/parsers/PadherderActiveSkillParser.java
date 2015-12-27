package parsers;

import json.JsonReader;
import model.ActiveSkill;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Julian on 2015-12-27.
 */
public class PadherderActiveSkillParser {

    public static ActiveSkill parseActiveSkillJson(String skillName) throws JSONException {
        JSONArray activeSkillJson = JsonReader.readJsonArrayFromUrl("https://www.padherder.com/api/active_skills/");
        ActiveSkill parseResult = null;

        for (int i=0; i<activeSkillJson.length(); i++) {
            JSONObject thisActiveSkill = activeSkillJson.getJSONObject(i);

            if (thisActiveSkill.getString("name").equals(skillName)) {
                String name = thisActiveSkill.getString("name");
                String effect = thisActiveSkill.getString("effect");
                int skillLevelMin = thisActiveSkill.getInt("min_cooldown");
                int skillLevelMax = thisActiveSkill.getInt("max_cooldown");

                parseResult = new ActiveSkill(name, effect, skillLevelMin, skillLevelMax);
            }
        }

        return parseResult;
    }
}
