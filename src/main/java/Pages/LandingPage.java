package Pages;

import org.junit.Assert;
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

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardTextOnLandingPage;

    public void clickAdmin(){
        adminButton.click();
    }

    public void validateSuccessfulLogin(String expectedText) throws InterruptedException {
        Thread.sleep(3000);
        String actualText = dashboardTextOnLandingPage.getText();
        Assert.assertEquals("Validate Sucessful Login", expectedText,actualText);

    }

}
