package RandomPractice;
import Utils.Driver;
import Utils.DriverManager;
import org.openqa.selenium.By;
import java.util.Set;
import static Utils.DriverManager.driver;
public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        Driver.initDriver();
        DriverManager.getDriver();
        driver.get("https://demoqa.com/browser-windows");

        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(5000);

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        for (String window: allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(window)){
                driver.switchTo().window(window);
            }
        }
    }
}