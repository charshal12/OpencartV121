package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class Product extends BasePage {

    private WebElement productNameXpath;
    private WebElement productPriceXpath;
    private WebElement productQuantityXpath;
    private WebElement addToCartBtnXpath;
    private int count =0;


    public Product(WebDriver driver, WebElement productNameXpath, WebElement productPriceXpath,WebElement productQuantityXpath, WebElement addToCartBtnXpath) {
        super(driver);
        this.productNameXpath = productNameXpath;
        this.productPriceXpath = productPriceXpath;
        this.productQuantityXpath = productQuantityXpath;
        this.addToCartBtnXpath =addToCartBtnXpath;
    }

    public void setProductNameXpath(WebElement productNameXpath) {
        this.productNameXpath = productNameXpath;
    }

    public void setProductPriceXpath(WebElement productPriceXpath) {
        this.productPriceXpath = productPriceXpath;
    }

    public void setProductQuantityXpath(WebElement productQuantityXpath) {
        this.productQuantityXpath = productQuantityXpath;
    }

    public void setAddToCartBtnXpath(WebElement addToCartBtnXpath) {
        this.addToCartBtnXpath = addToCartBtnXpath;
    }

    public WebElement getProductNameXpath() {
        return productNameXpath;
    }

    public WebElement getProductPriceXpath() {
        return productPriceXpath;
    }
    public WebElement getAddToCartBtnXpath() {
        return addToCartBtnXpath;
    }

    public WebElement getProductQuantityXpath() {
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

  public String getNameOfProduct(){
        return this.productNameXpath.getText();
  }

    public String getPriceOfProduct(){
        return this.productPriceXpath.getText();
    }

    public void clickOnAddToCart(){
        this.addToCartBtnXpath.click();
        this.count++;
    }

    public int getCountOfProduct(){
        return this.count;
    }


}

