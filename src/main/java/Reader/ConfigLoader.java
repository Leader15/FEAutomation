package Reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE_NAME = "config.properties";

    public static Properties loadConfig() {
        Properties properties = new Properties();
        try {
            // Use the ClassLoader to load the resource
            InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);

            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                System.err.println("Failed to load config.properties. Make sure it exists in the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

