package pageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@class='table table-striped']//tr[1]")
   static ArrayList<WebElement> prodListInCart;

    @FindBy (xpath = "//table[@class='table table-striped']//tr/td[3]")
    List<WebElement> prodPriceListInCart;
    //Map<Integer, WebElement> ProductMap=

 /*   public static void main(String[] args) {
        ShoppingCartPage scp = new ShoppingCartPage(driver);
                scp.clickViewCart();
        System.out.println(prodListInCart);
    }*/

}
