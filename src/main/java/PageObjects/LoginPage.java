package PageObjects;

import Drivers.HybridWebDriverExample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;

   @FindBy(id = "ap_email")
    private WebElement email;

   @FindBy(id="continue")
    private WebElement continueButton;

    public LoginPage() {
        this.driver = HybridWebDriverExample.getDriver();
        PageFactory.initElements(driver, this);
    }



 public void setEmailorPhoneNumber(String text)
 {
     email.sendKeys(text);
 }

 public String getText()
 {
     return email.getText();
 }

 public void continueButton()
    {
        continueButton.click();
    }

    public void clearText()
    {
        email.clear();
    }

}
