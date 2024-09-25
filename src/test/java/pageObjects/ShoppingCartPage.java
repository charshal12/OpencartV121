package pageObjects;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BaseClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class=\"caption\"]/h4")
    List<WebElement> productNamesList;



    @FindBy (xpath = "//div[@id='cart']/button")
    WebElement cartBtn;

    @FindBy(xpath="//strong[normalize-space()='View Cart']")
    WebElement viewCartBtn;

    @FindBy(xpath = "//table[@class='table table-bordered']//tr[4]/td/strong[contains(text(),'Total:')]")
    WebElement cartTotalPrice;

    @FindBy(xpath="//div[@class='buttons clearfix']//div[@class='pull-right']/a[(contains(text(),'Checkout'))]")
    WebElement checkOutBtn;

    @FindBy (xpath = "//table[@class='table table-striped']//tr/td[2]/a")
    ArrayList<WebElement> prodListInCart;

    @FindBy (xpath = "//table[@class='table table-striped']//tr/td[3]")
    List<WebElement> prodPriceListInCart;


    public void getProductInfo(){
        System.out.println("Total Products on the page: "+ productNamesList.size());
        System.out.println("Product List : ");
        for (WebElement p:productNamesList){
            System.out.println(p);
        }
        System.out.println("Product Price List ");
    }

//    public void clickItemsToNavigateToCart(String productName) {
//        switch (productName){
//            case "MacBook":
//                addToCartMacBookBtn.click();
//                break;
//            case "iPhone":
//                addToCartiPhoneBtn.click();
//                break;
//            case "Apple Cinema 30\"":
//                addToCartAppleCinemaBtn.click();
//                break;
//            case "Canon EOS 5D":
//                addToCartCanonEQSBtn.click();
//
//            default:
//                return;
//        }
//    }

//    public void getProductAndQuantityDataInCart(String productName){
//        Map<Integer,WebElement> prodMapInCart = new HashMap<>();
//        MapUtils.populateMap(prodMapInCart, prodListInCart, WebElement::);
//    }

    public void clickViewCart() {
        cartBtn.click();
        viewCartBtn.click();
    }

    public void calculateTotalPrice() throws InterruptedException {
    cartBtn.click();
    Thread.sleep(3000);

    }

    public String getTotalPrice() {
        String totalPriceofCart=cartTotalPrice.getText();
        return totalPriceofCart;
    }

    public void clickOnCheckout() {
        checkOutBtn.click();
    }
}
