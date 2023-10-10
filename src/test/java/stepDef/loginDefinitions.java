package stepDef;


import Drivers.HybridWebDriverExample;
import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import stepActions.loginPageActions;


public class loginDefinitions {

     private WebDriver driver;
     private LoginPage loginPage;
     private loginPageActions loginPageActions;
     private HybridWebDriverExample driverExample;


     @Before
     public void init()
     {
         driverExample = HybridWebDriverExample.getInstance();
         // Get the WebDriver instance
         driver = driverExample.getDriver();
         //ThreadLocalDriverManager.initializeDriver("chrome");
         driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_custrec_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D9672229444264200990%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9061990%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
     }


    @Given("customer already have an account")
    public void customer_already_have_an_account() throws Exception {
        loginPage = new LoginPage();
        loginPageActions = new loginPageActions(driver);
        loginPageActions.setMail("HI");
    }
    @When("data is entered")
    public void data_is_entered() {
        loginPageActions.clickCont();

    }
    @Then("login should happen")
    public void login_should_happen() {

        HybridWebDriverExample.quitDriver();
    }

}
