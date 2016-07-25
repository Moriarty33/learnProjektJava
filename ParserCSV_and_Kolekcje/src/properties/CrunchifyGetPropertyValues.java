package properties;

/**
 * Created by jamin on 21.11.2015.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author Crunchify.com
 *
 */

public class CrunchifyGetPropertyValues {
    InputStream inputStream;

    public String getPropValues(String name) throws IOException {

        Properties prop = new Properties();
        String propFileName = "resources/config.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }


        prop.getProperty(name);
        return prop.getProperty(name);
    }
}