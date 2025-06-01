package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Config dosyası bulunamadı!");
        }
    }

    //  config dosyasındaki değeri döner
    //  public static String get(String key)
    //  {  return properties.getProperty(key);
    //  }

    public static String get(String keyName) {
        // Önce sistem property kontrol edilir (mvn test -Dbrowser=edge gibi)
        String systemValue = System.getProperty(keyName);
        if (systemValue != null) {
            return systemValue;
        }
        // Yoksa config dosyasındaki değeri döner
        return properties.getProperty(keyName);
    }
}
