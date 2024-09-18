package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /***
     * "//input[@id='input-email']"
     * "//input[@id='input-password']"
     * "//input[@value='Login']"
     * **/
    @FindBy(xpath ="//input[@id='input-email']")
    WebElement emailTxt;

    @FindBy(xpath ="//input[@id='input-password']")
    WebElement pwdTxt;

    @FindBy(xpath ="//input[@value='Login']")
    WebElement loginBtn;


    public void setEmailTxt(String email) {
        emailTxt.sendKeys(email);
    }

    public void setPwdTxt(String pwd) {
        pwdTxt.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
