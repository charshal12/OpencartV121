package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {
    WebDriver driver;

    String productName;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='row']//h4")
    List<WebElement> pList;

    @FindBy(xpath = "//div[@class=\"caption\"]/h4/a")
    List<WebElement> productList;

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement productQuantity;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('41', '1');\"]")
    WebElement addToCartiMacBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('43', '1');\"]")
    WebElement addToCartMacBookBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('44', '1');\"]")
    WebElement addToCartMacBookAirBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('45', '1');\"]")
    WebElement addToCartMacBookProBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('40', '1');\"]") ////*[contains(@onclick,"cart.add('40', '1');")]
    WebElement addToCartiPhoneBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('42', '2');\"]")
    WebElement addToCartAppleCinemaBtn;

    @FindBy(xpath = "//button[@onclick=\"cart.add('30', '1');\"]")
    WebElement addToCartCanonEQSBtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement confirmMsg;


    public boolean isProductExist(String productName){
        for(WebElement list: pList){
            System.out.println(list.getText());
        }

        if(pList.size() != 0 ) {
            if (pList.contains(productName));
            {return true;}
        }
        else {
            return false;
        }
    }

    public void selectProduct(String productName) {
        if(productList.size() != 0 ) {
            if (productList.contains(productName));
            {
                addToCartSearchPage(productName);
            }
        }
        else {
            System.out.println("Product is not in the list!!");
        }

    }

    public void setQuantity(String number) {
        productQuantity.clear();
        productQuantity.sendKeys(number);
    }

    public void addToCart() {
        addToCartBtn.click();
    }
    public void addToCartSearchPage(String productName) {
        switch (productName){
            case "iMac":
                addToCartiMacBtn.click();
                break;
            case "MacBook":
                addToCartMacBookBtn.click();
                break;
            case "MacBook Air":
                addToCartMacBookAirBtn.click();
                break;
            case "MacBook Pro":
                addToCartMacBookProBtn.click();
                break;
            case "iPhone":
                addToCartiPhoneBtn.click();
                break;
            case "Apple Cinema 30\"":
                addToCartAppleCinemaBtn.click();
                break;
            case "Canon EOS 5D":
                addToCartCanonEQSBtn.click();

            default:
                return;
        }
    }


    public boolean checkConfMsg() {
        try{ //This logic is to remove the close sign from the message while we fetch the message through webelement
            String message = confirmMsg.getText();
            String[] messageDisplayedArr = message.split("!");
            for (String m : messageDisplayedArr){
                System.out.println(m);
            }
            String messageDisplayed = messageDisplayedArr[0].trim();

            Assert.assertEquals(messageDisplayed+"!",
                    "Success: You have added "+ productName +" to your shopping cart!");
            return true;
        }catch (Exception e){
            Assert.fail();
            return false;
        }
    }
}

