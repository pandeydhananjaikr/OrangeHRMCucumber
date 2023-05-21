package Pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    AdminPage adminPage;
    LoginPage loginPage;
    LandingPage landingPage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }



    public AdminPage getAdminPage(){

        return (adminPage == null) ? adminPage = new AdminPage(driver) : adminPage;

    }

    public LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }

    public LandingPage getLandingPage(){
        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
    }



}
