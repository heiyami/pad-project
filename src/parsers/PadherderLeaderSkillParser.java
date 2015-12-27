package parsers;

import json.JsonReader;
import model.LeaderSkill;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Julian on 2015-12-27.
 */
public class PadherderLeaderSkillParser {

    public static LeaderSkill parseLeaderSkillJson(String skillName) throws JSONException {
        JSONArray leaderSkillJson = JsonReader.readJsonArrayFromUrl("https://www.padherder.com/api/leader_skills/");
        LeaderSkill parseResult = null;

        for (int i=0; i<leaderSkillJson.length(); i++) {
            JSONObject thisLeaderSkill = leaderSkillJson.getJSONObject(i);

            if (thisLeaderSkill.getString("name").equals(skillName)) {
                String name = thisLeaderSkill.getString("name");
                String effect = thisLeaderSkill.getString("effect");

                parseResult = new LeaderSkill(name, effect);
            }
        }

        return parseResult;
    }
}
