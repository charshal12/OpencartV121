package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class Product extends BasePage {

    private String productNameXpath;
    private Double productPriceXpath;
    private int productQuantityXpath;
    private String addToCartBtnXpath;

    //MacBook WebElements
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]//h4/a[@href]")
    WebElement productMacBookBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]//p[@class='price'][contains(text(),'$')]")
    WebElement priceMacBook;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]//div[3]/button[1]/span[contains(text(),'Add to Cart')]")
    WebElement addToCartMacBookBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]/div/div[3]/button[2]")
    WebElement addToWishListtMacBookBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]/div/div[3]/button[3]")
    WebElement compareMacBookBtn;

    //iPhone WebElements
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]//h4/a[@href]")
    WebElement productiPhoneBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]//p[@class='price'][contains(text(),'$')]")
    WebElement priceiPhone;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]//div[3]/button[1]/span[contains(text(),'Add to Cart')]")
    WebElement addToCartiPhoneBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]/div/div[3]/button[2]")
    WebElement addToWishListtiPhoneBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]/div/div[3]/button[3]")
    WebElement compareiPhoneBtn;


    //AppleCinema WebElements
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]//h4/a[@href]")
    WebElement productAppleCinemaBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]//p[@class='price'][contains(text(),'$')]")
    WebElement priceAppleCinema;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]//div[3]/button[1]/span[contains(text(),'Add to Cart')]")
    WebElement addToCartAppleCinemaBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]/div/div[3]/button[2]")
    WebElement addToWishListtAppleCinemaBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]/div/div[3]/button[3]")
    WebElement compareAppleCinemaBtn;


    //CanonEQS WebElements
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]//h4/a[@href]")
    WebElement productCanonEQSBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]//p[@class='price'][contains(text(),'$')]")
    WebElement priceCanonEQS;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]//div[3]/button[1]/span[contains(text(),'Add to Cart')]")
    WebElement addToCartCanonEQSBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]/div/div[3]/button[2]")
    WebElement addToWishListtCanonEQSBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]/div/div[3]/button[3]")
    WebElement compareCanonEQSBtn;


    public Product(WebDriver driver, String productNameXpath, Double productPriceXpath, int productQuantityXpath, String addToCartBtnXpath) {
        super(driver);
        this.productNameXpath = productNameXpath;
        this.productPriceXpath = productPriceXpath;
        this.productQuantityXpath = productQuantityXpath;
        this.addToCartBtnXpath =addToCartBtnXpath;
    }

    public void setProductNameXpath(String productNameXpath) {
        this.productNameXpath = productNameXpath;
    }

    public void setProductPriceXpath(Double productPriceXpath) {
        this.productPriceXpath = productPriceXpath;
    }

    public void setProductQuantityXpath(int productQuantityXpath) {
        this.productQuantityXpath = productQuantityXpath;
    }

    public void setAddToCartBtnXpath(String addToCartBtnXpath) {
        this.addToCartBtnXpath = addToCartBtnXpath;
    }

    public String getProductNameXpath() {
        return productNameXpath;
    }

    public Double getProductPriceXpath() {
        return productPriceXpath;
    }
    public String getAddToCartBtnXpath() {
        return addToCartBtnXpath;
    }

    public int getProductQuantityXpath() {
        return productQuantityXpath;
    }

    @Override
    public String toString() {
        return "ProductPage{" +
                "productName='" + productNameXpath + '\'' +
                ", productPrice=" + productPriceXpath +
                ", productQuantity=" + productQuantityXpath +
                ", addToCartBtn=" + addToCartBtnXpath + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(productNameXpath, that.productNameXpath);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productNameXpath);
    }

}
