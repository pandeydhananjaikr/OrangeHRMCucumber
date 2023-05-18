package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this );
    }
    @FindBy(xpath = "//span[text()=\"Admin\"]")
    WebElement adminButton;

    public void clickAdmin(){
        adminButton.click();
    }

}
