package Framework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class Locators {

    private static JSONObject allLocators;

    public static HashMap<String, String> get(String locatorName) {
        HashMap<String, String> locatorMap = new HashMap<>();
        JSONObject locatorData = (JSONObject) allLocators.get(locatorName);
        locatorMap.put("criteria", (String) locatorData.get("criteria"));
        locatorMap.put("locator", (String) locatorData.get("locator"));
        return locatorMap;
    }

    public static void loadLocators () {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("locators.json"));
            allLocators = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
