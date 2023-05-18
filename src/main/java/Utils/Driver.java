package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Driver {
    public static WebDriver globalDriver;
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        globalDriver = new ChromeDriver(options);
        DriverManager.setDriver(globalDriver);
    }
    public static void tearDown(){
        DriverManager.getDriver().quit();
    }
}
