package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropartyFile {
    static Properties prop;

    public static String readProperty(String propertyName) throws IOException {
        prop = new Properties();
        try {
//            FileInputStream file = new FileInputStream("src/main/resources/properties/Project_config.properties");

            FileInputStream file = new FileInputStream(System.getProperty("EnvironmentConfigFile"));
            prop.load(file);
            return prop.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
      return null;
    }
}