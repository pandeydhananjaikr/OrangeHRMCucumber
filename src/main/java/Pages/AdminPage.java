package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Utils.DriverManager.driver;

public class AdminPage {

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this );
    }
    @FindBy(xpath = "//button[text()=\" Add \"]")
    WebElement addButton;
    @FindBy(xpath = "//label[text()=\"User Role\"]/../../div[2]/div/div/div[1]")
    WebElement selectUserRole;
    @FindBy(xpath = "//label[text()=\"Status\"]/../../div[2]/div/div/div")
    WebElement selectStatus;
    @FindBy(xpath = "//label[text()='Employee Name']/../../div[2]/div/div/input")
    WebElement insertEmpName;
    @FindBy(xpath = "//label[text()=\"Username\"]/../../div[2]/input")
    WebElement insertUsername;
    @FindBy(xpath = "//label[text()=\"Password\"]/../../div[2]/input")
    WebElement insertPassword;
    @FindBy(xpath = "//label[text()=\"Confirm Password\"]/../../div[2]/input")
    WebElement insertConfPassword;
    @FindBy(xpath = "//button[text()=\" Save \"]")
    WebElement saveButton;

    @FindBy(xpath = "//button[text()=\" Yes, Delete \"]")
    WebElement yesDelete;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardTextOnLandingPage;

    public void clickAdd(){
        addButton.click();
    }

    public void validateSuccessfulLogin(String expectedText) throws InterruptedException {
        Thread.sleep(3000);
        String actualText = dashboardTextOnLandingPage.getText();
        Assert.assertEquals("Validate Sucessful Login", expectedText,actualText);

    }

    public void addUser(String userRole, String empName, String status,
                        String username, String password, String confirmPassword )
            throws InterruptedException, AWTException {

        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("document.getElementsByClassName('oxd-select-text-input').innerHTML="+ userRole);
//        js.executeScript("document.evaluate('(//div[@class='oxd-select-text-input'])[1]', document, null, 9, null)" +
//                ".singleNodeValue.innerHTML="+ userRole);

        selectUserRole.click();
        Thread.sleep(2000);
        Robot robot = new Robot();

        if (userRole.equalsIgnoreCase("Admin")){
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
        }
        else if (userRole.equalsIgnoreCase("ESS")){
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
        }

        Thread.sleep(2000);
        insertEmpName.sendKeys(empName);
        Thread.sleep(2000);

        Select addStatus = new Select(selectStatus);
        addStatus.selectByVisibleText(status);
        Thread.sleep(2000);
        insertUsername.sendKeys(username);
        Thread.sleep(2000);
        insertPassword.sendKeys(password);
        Thread.sleep(2000);
        insertConfPassword.sendKeys(confirmPassword);
        Thread.sleep(2000);
        saveButton.click();
    }

    public boolean userExists(String username){
        boolean bool = false;
        if (driver.getPageSource().contains(username)){
            bool = true;
        }
        return bool;
    }


    public void deleteExistingUser(String username) throws InterruptedException {
        WebElement deleteIcon = driver.findElement(By.xpath("//div[text()="+username+"]/../../div[6]/div/button[1]"));
        Thread.sleep(2000);
        deleteIcon.click();
    }


}
