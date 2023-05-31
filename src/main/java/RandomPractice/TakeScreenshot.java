package RandomPractice;

import Utils.Driver;
import Utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static Utils.DriverManager.driver;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        Driver.initDriver();
        DriverManager.getDriver();
        driver.get("https://www.google.com");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\dhana\\IdeaProjects\\OrangeHRMCucumber\\target\\aa.png"));
    }
}
