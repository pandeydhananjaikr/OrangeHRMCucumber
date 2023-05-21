package Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    public static Properties prop ;
    public static FileInputStream fis;
    public static String readConfigFile(String key) throws IOException {
        String value = "";
        prop = new Properties();
        System.out.println(System.getProperty("user.dir") + "src/test/resources/Config.properties");
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
        prop.load(fis);
        value = prop.getProperty(key);
        return value;
    }
}