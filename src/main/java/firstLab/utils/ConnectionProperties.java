package firstLab.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConnectionProperties {

    private ConnectionProperties(){}

    static final Properties properties = new Properties();

    static {
        setProperties();
    }


    private static void setProperties () {
        try {
            BufferedInputStream readerProperties  = new BufferedInputStream(
                    new FileInputStream("src/main/resources/db.properties")
            );
            properties.load(readerProperties);
            readerProperties.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getByKeyProperties(String key){
        return properties.getProperty(key);
    }
}
