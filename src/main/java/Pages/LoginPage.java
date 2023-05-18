package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this );
    }
    @FindBy(name = "username")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement passWord;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;

    public void insertDetails(String username, String password ) throws InterruptedException {
        Thread.sleep(2000);
        userName.sendKeys(username);
        passWord.sendKeys(password);
    }
    public void clickLogin(){
        loginButton.click();
    }

}
