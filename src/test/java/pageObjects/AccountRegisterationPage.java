package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage{
    public AccountRegisterationPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * "//input[@id='input-firstname']"
     * "//input[@id='input-lastname']"
     * "//input[@id='input-email']"
     * "//input[@id='input-telephone']"
     * "//input[@id='input-password']"
     * "//input[@id='input-confirm']"
     * "//input[@name='agree']"
     * "//input[@value='Continue']"
     * "//a[normalize-space()='Continue']"*/
    @FindBy(xpath ="//input[@id='input-firstname']")
    WebElement txtFirstName;
    @FindBy(xpath ="//input[@id='input-lastname']")
    WebElement txtLastName;
    @FindBy(xpath ="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath ="//input[@id='input-telephone']")
    WebElement txtTelephone;
    @FindBy(xpath ="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath ="//input[@id='input-confirm']")
    WebElement txtConfirmPassword;
    @FindBy(xpath ="//input[@name='agree']")
    WebElement chkdPolicy;
    @FindBy(xpath ="//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setTxtFirstName(String fname) {
      txtFirstName.sendKeys(fname);
    }
    public void setTxtLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setTxtEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTxtTelephone(String tel) {
        txtTelephone.sendKeys(tel);
    }

    public void setTxtPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setTxtConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy(){
        chkdPolicy.click();
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public String getConfirmationMsg(){
        try{
            return(msgConfirmation.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }


}
