package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath ="//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(linkText ="Login")
    WebElement lnkLogin;

    @FindBy(name="search")
    WebElement searchText;

    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement searchBtn;

    public void clickMyAccount(){
        lnkMyAccount.click();
    }

    public void clickRegister(){
        lnkRegister.click();
    }

    public void clickLogin(){
        lnkLogin.click();
    }

    public void enterProductName(String pName){
        searchText.sendKeys(pName);
    }

    public void clickSearch(){
        searchBtn.click();
    }

}

