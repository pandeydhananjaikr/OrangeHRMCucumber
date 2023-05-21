package StepDefinitions;
import Pages.AdminPage;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.PageObjectManager;
import Utils.ConfigReader;
import Utils.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Step1 {
    WebDriver driver = DriverManager.getDriver();
//    LoginPage loginPage = new LoginPage(driver);
//    LandingPage landingPage = new LandingPage(driver);
//    AdminPage adminPage = new AdminPage(driver);


    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    AdminPage adminPage = pageObjectManager.getAdminPage();
    LoginPage loginPage = pageObjectManager.getLoginPage();
    LandingPage landingPage = pageObjectManager.getLandingPage();
    @Given("User is on OrangeHRM login page")
    public void user_is_on_orange_hrm_login_page() throws IOException {
    driver.get(ConfigReader.readConfigFile("url"));
//    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @When("User enters username and password")
    public void user_enters_username_and_password(DataTable dataTable) throws InterruptedException {
        List<Map<String, String >> detail = dataTable.asMaps(String.class, String.class);
        String username = detail.get(0).get("username");
        String password = detail.get(0).get("password");
        loginPage.insertDetails(username, password);
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.clickLogin();
    }
    @Then("User should able to login and navigate to the landing page")
    public void user_should_able_to_login_and_navigate_to_the_landing_page() throws InterruptedException {
        Thread.sleep(2000);
        landingPage.validateSuccessfulLogin("Dashboard");
    }
    @When("User clicks on add user's button under admin tab")
    public void user_clicks_on_add_user_s_button_under_admin_tab() throws InterruptedException {
        Thread.sleep(2000);
        landingPage.clickAdmin();
        Thread.sleep(2000);
        adminPage.clickAdd();
    }
    @When("User create new user with given data")
    public void user_create_new_user_with_given_data(DataTable dataTable) throws InterruptedException, AWTException {
        Thread.sleep(2000);
        List<Map<String, String >> data = dataTable.asMaps(String.class, String.class);
        String userRole = data.get(0).get("User Role");
        String empName = data.get(0).get("Employee Name");
        String status = data.get(0).get("status");
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");
        String confPassword = data.get(0).get("confPassword");
        adminPage.addUser(userRole, empName, status, username, password, confPassword);
        Thread.sleep(3000);
    }

    @Then("Verify that created user with given username is present in the page")
    public void verify_that_created_user_with_given_username_is_present_in_the_page(DataTable dataTable) throws InterruptedException {
        Thread.sleep(5000);
        List<Map<String, String >> dataPresent = dataTable.asMaps(String.class, String.class);
        String username1 = dataPresent.get(0).get("UserName");
        adminPage.validateUserExists(username1);

    }

    @When("User delete the above created user")
    public void user_delete_the_above_created_user(DataTable dataTable) throws InterruptedException {
        Thread.sleep(5000);
        List<Map<String, String >> userDelete = dataTable.asMaps(String.class, String.class);
        String user = userDelete.get(0).get("Username");
        adminPage.deleteExistingUser(user);
    }
    @Then("Verify that user should able to delete the user entry")
    public void verify_that_user_should_able_to_delete_the_user_entry(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);
        List<Map<String, String >> entry = dataTable.asMaps(String.class, String.class);
        String deletedUSer = entry.get(0).get("username");
        adminPage.validateUserDeleted(deletedUSer);

//      for loop iterate over all the elemts for i = size of elements
//      /html/body/div/div[1]/div[2]/div[2]/div/
    }


}
