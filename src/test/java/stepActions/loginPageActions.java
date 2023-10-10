package stepActions;


import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class loginPageActions {

    //WebDriver driver;
    LoginPage loginPage;

    public loginPageActions(WebDriver driver) {
        loginPage = new LoginPage();
    }


    public void setMail(String text)
    {
        loginPage.setEmailorPhoneNumber(text);
    }

    public void clickCont()
    {
        loginPage.continueButton();
    }
}

