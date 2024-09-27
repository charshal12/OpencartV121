package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductList extends BasePage{
    private Product macbook;
    private Product iPhone;
    private Product appleCinema;
    private Product cannonEqs;


    //MacBook WebElements
    @FindBy(xpath = "//*[@id='content']/div[2]/div[1]//h4/a[@href]")
    WebElement productMacBook;
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
    WebElement productiPhone;
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
    WebElement productAppleCinema;
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
    WebElement productCanonEQS;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]//p[@class='price'][contains(text(),'$')]")
    WebElement priceCanonEQS;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]//div[3]/button[1]/span[contains(text(),'Add to Cart')]")
    WebElement addToCartCanonEQSBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]/div/div[3]/button[2]")
    WebElement addToWishListtCanonEQSBtn;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[4]/div/div[3]/button[3]")
    WebElement compareCanonEQSBtn;



    public ProductList(WebDriver driver) {
        super(driver);
    }

    public void getMacBookProduct(){
        this.macbook = new Product(driver,productMacBook,priceMacBook,null,addToCartMacBookBtn);
    }

    public void getiPhoneProduct(){
        this.iPhone = new Product(driver,productiPhone,priceiPhone,null,addToCartiPhoneBtn);
    }

    public void getAppleCinemaProduct(){
        this.appleCinema = new Product(driver,productAppleCinema,priceAppleCinema,null,addToCartAppleCinemaBtn);
    }

    public void getCanonEQSProduct(){
        this.cannonEqs = new Product(driver,productCanonEQS,priceCanonEQS,null,addToCartCanonEQSBtn);
    }

}
