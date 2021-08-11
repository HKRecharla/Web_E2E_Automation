package commonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {


    // Reading properties
    public static Properties readProperty(String fileName) {
        InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName);
        Properties prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
