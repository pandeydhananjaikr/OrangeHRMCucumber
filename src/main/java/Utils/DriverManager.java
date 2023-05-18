package Utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver drv) {
        driver = drv;
    }






}
