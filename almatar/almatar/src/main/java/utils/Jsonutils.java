package utils;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Jsonutils {
    static FileInputStream fis;
    static JSONObject jsonObject;

    public static JSONObject getObjectLocatorAndValuefromJson(String fileName, String node) {
        String jsonTxt;
        try {
            fis = new FileInputStream("Test.json");
            jsonTxt = IOUtils.toString(fis);
            jsonObject = new JSONObject(jsonTxt);
            return jsonObject.getJSONObject(node);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getLocatorAndValuefromJson(String jsonFileName, String locatorPath) {
        try {
//            Path path = Paths.get("");
            String json = new String(Files.readAllBytes(Paths.get("jsonFileName")));
            String value = JsonPath.read(json, "$." + locatorPath).toString();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}